/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.InstallmentMonthly;
import DbConnection.MSSQLDbConnection;
import Service.InstallmentMonthlyManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author babman92
 */
public class InstallmentMonthlyManagerImpl implements InstallmentMonthlyManager {

    MSSQLDbConnection msssqlConnection;
    InstallmentMonthly IstMonthly;
    
    public InstallmentMonthlyManagerImpl() {
        msssqlConnection = new MSSQLDbConnection();
        IstMonthly = new InstallmentMonthly();
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
            cn.close();
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean Insert() {
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
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
}
