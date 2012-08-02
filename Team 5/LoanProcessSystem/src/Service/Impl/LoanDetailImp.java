/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import DbConnection.MSSQLDbConnection;
import Service.LoanDetail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Minh
 */
public class LoanDetailImp implements LoanDetail {

    MSSQLDbConnection msssqlConnection;

    public LoanDetailImp() {
        msssqlConnection = new MSSQLDbConnection();
    }

    @Override
    public ResultSet getAllLoanDetail() throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_Loan_Account_Branch_Type_SelectAll}";
            CallableStatement calStat = cn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return calStat.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getLoanDetailByID(int ID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanDetails_SelectRow(?)}";
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
    public boolean DelLoanDetail(int ID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanDetails_DeleteRow(?)}";
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
    public boolean InsertLoanDetail(String AccountNo, float LoanMoney, float Current, int TypeID, Date BeginTime, Date EndTime, int BranchID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanDetails_Insert(?,?,?,?,?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setString(1, AccountNo);
            calStat.setFloat(2, LoanMoney);
            calStat.setFloat(3, Current);
            calStat.setInt(4, TypeID);
            calStat.setDate(5, BeginTime);
            calStat.setDate(6, EndTime);
            calStat.setInt(7, BranchID);
            calStat.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean changeLoanDetail(int LoanID, String AccountNo, float LoanMoney, float Current, int TypeID, Date BeginTime, Date EndTime, int BranchID) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanDetails_Update(?,?,?,?,?,?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, LoanID);
            calStat.setString(2, AccountNo);
            calStat.setFloat(3, LoanMoney);
            calStat.setFloat(4, Current);
            calStat.setInt(5, TypeID);
            calStat.setDate(6, BeginTime);
            calStat.setDate(7, EndTime);
            calStat.setInt(8, BranchID);
            calStat.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }

    }

    public static void main(String[] args) {
        try {
            LoanDetailImp LD = new LoanDetailImp();
            ResultSet rs = LD.getAllLoanDetail();
            while (rs.next()) {
                System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t" + rs.getObject(3) + "\t" + rs.getObject(4) + "\t" + rs.getObject(5) + "\t" + rs.getObject(6) + "\t" + rs.getObject(7) + "\t" + rs.getObject(8));
            }
            LD.InsertLoanDetail("C1011L0011          ", Float.valueOf("3.5534"), Float.valueOf("4324"), 2, Date.valueOf("2012-11-11"), Date.valueOf("2100-11-23"), 2);
            rs.beforeFirst();
            System.out.println("");
            while (rs.next()) {
                System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t" + rs.getObject(3) + "\t" + rs.getObject(4) + "\t" + rs.getObject(5) + "\t" + rs.getObject(6) + "\t" + rs.getObject(7) + "\t" + rs.getObject(8));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }
}
