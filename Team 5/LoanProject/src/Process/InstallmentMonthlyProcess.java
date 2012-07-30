/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author babman92
 */
public class InstallmentMonthlyProcess {

    String CustomerID;
    Float Money;
    Float RateInterestMoney;
    Double RateDouble;
    Float Total;
    Date PayDate;
    boolean State;

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setMoney(Float Money) {
        this.Money = Money;
    }

    public Float getMoney() {
        return Money;
    }

    public void setRateInterestMoney(Float RateInterestMoney) {
        this.RateInterestMoney = RateInterestMoney;
    }

    public Float getRateInterestMoney() {
        return RateInterestMoney;
    }

    public void setRateDouble(Double RateDouble) {
        this.RateDouble = RateDouble;
    }

    public Double getRateDouble() {
        return RateDouble;
    }

    public void setPayDate(Date PayDate) {
        this.PayDate = PayDate;
    }

    public Date getPayDate() {
        return PayDate;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    public boolean getState() {
        return State;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }

    public Float getTotal() {
        return Total;
    }

    public boolean insert() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            String sql = "Insert into [InstallmentMonthly]([CustomerID],[RateInterestMoney],[MoneyRoot],[Total],[PayDate],[State]) Values(?,?,?,?,?,?) ";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, this.getCustomerID());
            stm.setDouble(2, this.getRateInterestMoney());
            stm.setDouble(3, this.getMoney());
            stm.setDouble(4, this.getTotal());
            stm.setDate(5, this.getPayDate());
            stm.setBoolean(6, this.getState());
            int count = stm.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    private static int CalCountMonth(int[] datetimeBegin, int[] datetimeFinish) {
        int MonthBegin = datetimeBegin[1];
        int YearBegin = datetimeBegin[2];
        int MonthFinish = datetimeFinish[1];
        int YearFinish = datetimeFinish[2];
        int countMonth = 0;
        if (MonthFinish > MonthBegin) {
            if (YearFinish - YearBegin == 0) {
                countMonth = MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 1) {
                countMonth = 12 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 2) {
                countMonth = 24 + MonthFinish - MonthBegin;
            }

            if (YearFinish - YearBegin == 3) {
                countMonth = 36 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 4) {
                countMonth = 48 + MonthFinish - MonthBegin;
            }

            if (YearFinish - YearBegin == 5) {
                countMonth = 60 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 6) {
                countMonth = 72 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 7) {
                countMonth = 84 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 8) {
                countMonth = 96 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 9) {
                countMonth = 108 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 10) {
                countMonth = 120 + MonthFinish - MonthBegin;
            }
        } else {
            if (MonthFinish < MonthBegin) {
                if (YearFinish - YearBegin == 1) {
                    countMonth = (12 - MonthBegin) + MonthFinish;
                }
                if (YearFinish - YearBegin == 2) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 12;
                }
                if (YearFinish - YearBegin == 3) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 24;
                }
                if (YearFinish - YearBegin == 4) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 36;
                }
                if (YearFinish - YearBegin == 5) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 48;
                }
                if (YearFinish - YearBegin == 6) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 60;
                }
                if (YearFinish - YearBegin == 7) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 72;
                }
                if (YearFinish - YearBegin == 8) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 84;
                }
                if (YearFinish - YearBegin == 9) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 96;
                }
                if (YearFinish - YearBegin == 10) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 108;
                }
            }
        }
        return countMonth;
    }

    public static int[] GetDateFromString(String date) {
        int[] DateTime;
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datetime = null;
        try {
            datetime = Format.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(TestDateTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(datetime);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        DateTime = new int[]{day, month, year};
        return DateTime;
    }

    private static Float[] CalMonthlyAllInstallment(int CountMonth, Float Rate, Float LoanMoney) {
        Float MonthlyRoot = LoanMoney / CountMonth;
        Float[] Result = new Float[CountMonth];
        for (int i = 0; i < CountMonth; i++) {
            Result[i] = MonthlyRoot + CalMonthlyRate(CountMonth, Rate, LoanMoney)[i];
        }
        return Result;
    }

    private static Float[] CalMonthlyRate(int CountMonth, Float Rate, Float LoanMoney) {
        Float[] RateMonthly = new Float[CountMonth];
        Float MonthlyRoot = LoanMoney / CountMonth;
        Float CurrentMoney = LoanMoney;
        for (int i = 0; i < CountMonth; i++) {
            RateMonthly[i] = (CurrentMoney) * Rate;
            CurrentMoney = CurrentMoney - MonthlyRoot;
        }
        return RateMonthly;
    }

    public String GetLastPayDate() {
        for (int i = 0; i < 10; i++) {
            
        }
        String sql = "SELECT TOP 1 PayDate FROM [InstallmentMonthly] Where [State] = 0 Order by [ID] desc";
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Duration = new Vector();
                Duration.addElement(rs.getDate("PayDate"));
                list.addElement(Duration);
            }
            if (list.isEmpty()) {
                return "1900-01-01";
            } 
            String LastPayDate = list.elementAt(0).toString().replace("[", "").replace("]", "");
            return LastPayDate;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void InsertInstallmentMonthly() {
        Vector Duration = getListLoanDetails("Select [BeginTime], [EndTime],[LoanMoney],[CurentMoney] From [LoanDetails]");
        String BeginDateStr = ((Vector) Duration.elementAt(0)).get(0).toString();
        String FinishDateStr = ((Vector) Duration.elementAt(0)).get(1).toString();
        Float LoanMoney = Float.parseFloat(((Vector) Duration.elementAt(0)).get(2).toString());
        int[] datetimeBegin = GetDateFromString(BeginDateStr);
        int[] datetimeFinish = GetDateFromString(FinishDateStr);
        int[] datetimeNow = GetDateFromString(GetDateTimeNow());
        int[] LastPayDate = GetDateFromString(GetLastPayDate());
        boolean flag = true;
        if (LastPayDate[2] > datetimeNow[2]) {
                flag = false;
        }
        JOptionPane.showMessageDialog(null, flag);
        int countMonth = CalCountMonth(datetimeBegin, datetimeFinish);
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
        setRateDouble(0.08);
        Float Rate = Float.parseFloat(RateDouble.toString());
        //Float[] MonthlyAllInstallment = CalMonthlyAllInstallment(countMonth, Rate, LoanMoney);
        Float[] MonthlyRate = CalMonthlyRate(countMonth, Rate, LoanMoney);
        Float MoneyRoot = LoanMoney / countMonth;
        if (flag) {
            for (int i = 0; i < countMonth; i++) {
                setCustomerID("C1011L0011");
                setMoney(MoneyRoot);
                setPayDate(payDate[i]);
                setRateInterestMoney(MonthlyRate[i]);
                setTotal(getMoney() + getRateInterestMoney());
                setState(false);
                insert();
            }
        }
    }

    public static Vector getListLoanDetails(String sql) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Duration = new Vector();
                Duration.addElement(rs.getDate("BeginTime"));
                Duration.addElement(rs.getDate("EndTime"));
                Duration.addElement(rs.getFloat("LoanMoney"));
                Duration.addElement(rs.getFloat("CurentMoney"));
                list.addElement(Duration);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static Vector getList(String Account) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            String sql = "SELECT [CustomerID],[RateInterestMoney],[MoneyRoot],[Total],[PayDate],[State] FROM [InstallmentMonthly] Where [CustomerID] LIKE '%" + Account + "%'";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Installment = new Vector();
                Installment.addElement(rs.getString("CustomerID"));
                Installment.addElement(rs.getFloat("RateInterestMoney"));
                Installment.addElement(rs.getFloat("MoneyRoot"));
                Installment.addElement(rs.getFloat("Total"));
                Installment.addElement(rs.getDate("PayDate"));
                Installment.addElement(rs.getInt("State"));
                list.addElement(Installment);
            }
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    private String GetDateTimeNow() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarCurrent = Calendar.getInstance();
        String DateNow = formatDate.format(calendarCurrent.getTime());
        return DateNow;
    }
}
