/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import DbConnection.MSSQLDbConnection;
import Service.LoanType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Minh
 */
public class LoanTypeImp implements LoanType {

    MSSQLDbConnection msssqlConnection;
    public LoanTypeImp(){
        msssqlConnection = new MSSQLDbConnection();
    }
    @Override
    public ResultSet getAllLoanType() throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanType_SelectAll}";
            CallableStatement calStat = cn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return calStat.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getLoanTypeByID(int ID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanType_SelectRow(?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, ID);
            ResultSet rs = calStat.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean DelLoanType(int ID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanType_DeleteRow(?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, ID);
            calStat.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean InsertLoanType(String TypeName, float InterestRate, String Des) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanType_Insert(?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setString(1, TypeName);
            calStat.setFloat(2, InterestRate);
            calStat.setString(3, Des);
            return calStat.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean changeLoanType(int ID, String TypeName, float InterestRate, String Des) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanType_Update(?,?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, ID);
            calStat.setString(2, TypeName);
            calStat.setFloat(3, InterestRate);
            calStat.setString(4, Des);
            return calStat.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public int countLoanDetailByLoanTypeID(int ID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_count_LoanDetailsByLoanTypeID(?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, ID);
            ResultSet rs = calStat.executeQuery();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    public static void main(String[] args) {
        LoanTypeImp l = new LoanTypeImp();
        ResultSet r;
        try {
            r = l.getAllLoanType();
        while(r.next()){
            System.out.println(r.getObject(1)+ "\t"+ r.getObject(2)+ "\t"+ r.getObject(3)+ "\t"+r.getObject(4));
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
