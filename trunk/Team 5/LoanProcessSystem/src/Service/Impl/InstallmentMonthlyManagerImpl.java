/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.InstallmentMonthly;
import DbConnection.MSSQLDbConnection;
import Service.InstallmentMonthlyManager;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import sun.security.action.GetLongAction;

/**
 *
 * @author babman92
 */
public class InstallmentMonthlyManagerImpl extends FineDetailManagerImpl implements InstallmentMonthlyManager {

    MSSQLDbConnection msssqlConnection;

    public InstallmentMonthlyManagerImpl() {
        msssqlConnection = new MSSQLDbConnection();
    }

    @Override
    public Vector GetListFromTable(String sql) {
        msssqlConnection.registerDriver();
        Connection cn = msssqlConnection.createConnection();
        try {
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Duration = new Vector();
                Duration.addElement(rs.getString("CustomerID"));
                Duration.addElement(rs.getFloat("RateInterestMoney"));
                Duration.addElement(rs.getFloat("MoneyRoot"));
                Duration.addElement(rs.getFloat("Total"));
                Duration.addElement(rs.getDate("PayDate"));
                Duration.addElement(rs.getInt("State"));
                list.addElement(Duration);
            }
            rs.close();
            cn.close();
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean InsertBasic(InstallmentMonthly IstMonthly) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Insert into [InstallmentMonthly]([CustomerID],[RateInterestMoney],[MoneyRoot],[Total],[PayDate],[State]) Values(?,?,?,?,?,?) ";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, IstMonthly.getCustomerID());
            stm.setDouble(2, IstMonthly.getRateInterestMonney());
            stm.setDouble(3, IstMonthly.getMoneyRoot());
            stm.setDouble(4, IstMonthly.getTotal());
            stm.setDate(5, IstMonthly.getPayDate());
            stm.setInt(6, IstMonthly.getState());
            int count = stm.executeUpdate();
            stm.close();
            cn.close();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public void InsertInstallmentMonthly(String CustomerID, Float Rate) {
        Vector Duration = GetListLoanDetail("Select [BeginTime], [EndTime],[LoanMoney],[CurentMoney],[AccountNo] From [LoanDetails] Where [AccountNo] = '"+CustomerID+"'");
        String BeginDateStr = ((Vector) Duration.elementAt(0)).get(0).toString();
        String FinishDateStr = ((Vector) Duration.elementAt(0)).get(1).toString();
        Float LoanMoney = Float.parseFloat(((Vector) Duration.elementAt(0)).get(2).toString());
        int[] datetimeBegin = GetDateFromString(BeginDateStr);
        int[] datetimeFinish = GetDateFromString(FinishDateStr);
        int[] datetimeNow = GetDateFromString(GetDateTimeNow());
        int[] LastPayDate = GetDateFromString(GetLastPayDate(CustomerID));
        boolean flag = true;
        if (LastPayDate[2] > datetimeNow[2]) {
            flag = false;
        }
        int countMonth = CalCountMonthOfLoan(datetimeBegin, datetimeFinish);
        Date[] payDate = new Date[countMonth];
        int MonthBegin = datetimeBegin[1];
        int[] Count = new int[countMonth];
        for (int i = 0; i < countMonth; i++) {
            Count[i] = MonthBegin + i + 1;
            if (Count[i] == 13) {
                Count[i] = 1;
                datetimeBegin[2] += 1;
                MonthBegin = 0 - i;
            }
            payDate[i] = Date.valueOf(datetimeBegin[2] + "-" + Count[i] + "-" + datetimeBegin[0]);
        }
        //Float[] MonthlyAllInstallment = CalMonthlyAllInstallment(countMonth, Rate, LoanMoney);
        Float[] MonthlyRate = CalMonthlyRateMoney(countMonth, Rate, LoanMoney);
        Float MoneyRoot = LoanMoney / countMonth;
        InstallmentMonthly IstMonthly = new InstallmentMonthly();
        if (flag) {
            for (int i = 0; i < countMonth; i++) {
                IstMonthly.setCustomerID(CustomerID);
                IstMonthly.setMoneyRoot(MoneyRoot);
                IstMonthly.setPayDate(payDate[i]);
                IstMonthly.setRateInterestMonney(MonthlyRate[i]);
                IstMonthly.setTotal(IstMonthly.getMoneyRoot() + IstMonthly.getRateInterestMonney());
                IstMonthly.setState(0);
                InsertBasic(IstMonthly);
            }
        }
    }

    @Override
    public String GetLastPayDate(String CustomerID) {
        String sql = "SELECT TOP 1 PayDate FROM [InstallmentMonthly] Where [State] = 0 And [CustomerID] = '"+CustomerID+"' Order by [ID] desc";
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Duration = new Vector();
                Duration.addElement(rs.getDate("PayDate"));
                list.addElement(Duration);
            }
            stm.close();
            cn.close();
            if (list.isEmpty()) {
                return "1900-01-01";
            }
            String LastPayDate = list.elementAt(0).toString().replace("[", "").replace("]", "");
            return LastPayDate;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Float[] CalMonthlyRateMoney(int CountMonth, Float Rate, Float LoanMoney) {
        Float[] RateMonthly = new Float[CountMonth];
        Float MonthlyRoot = LoanMoney / CountMonth;
        Float CurrentMoney = LoanMoney;
        for (int i = 0; i < CountMonth; i++) {
            RateMonthly[i] = (CurrentMoney) * Rate;
            CurrentMoney = CurrentMoney - MonthlyRoot;
        }
        return RateMonthly;
    }

}
