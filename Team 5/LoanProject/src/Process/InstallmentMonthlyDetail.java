/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author babman92
 */
public class InstallmentMonthlyDetail {

    String CusID;
    String RateMoney;
    String RootMoney;
    String Total;
    String State;
    String PayDate;

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getPayDate() {
        return PayDate;
    }

    public void setPayDate(String PayDate) {
        this.PayDate = PayDate;
    }

    public String getRateMoney() {
        return RateMoney;
    }

    public void setRateMoney(String RateMoney) {
        this.RateMoney = RateMoney;
    }

    public String getRootMoney() {
        return RootMoney;
    }

    public void setRootMoney(String RootMoney) {
        this.RootMoney = RootMoney;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public static Vector getListInstallmentMonthly(String sql) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
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
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
