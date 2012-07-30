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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.sql.Date;
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
            String sql = "{call sp_LoanDetails_SelectAll}";
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
    public boolean InsertLoanDetail(int LoanID, String AccountNo, float LoanMoney, float Current, int TypeID, Date BeginTime, Date EndTime, int BranchID, Boolean Status) throws SQLException {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "{call sp_LoanDetails_Insert(?,?,?,?,?,?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, LoanID);
            calStat.setString(2, AccountNo);
            calStat.setFloat(3, LoanMoney);
            calStat.setFloat(4, Current);
            calStat.setInt(5, TypeID);
            calStat.setDate(6,BeginTime );
            calStat.setDate(7, EndTime);
            calStat.setInt(8, BranchID);
            calStat.setBoolean(8, Status);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean changeLoanDetail(int LoanID, String AccountNo, float LoanMoney, float Current, int TypeID, Date BeginTime, Date EndTime, int BranchID, Boolean Status) throws SQLException {
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
            calStat.setDate(6,BeginTime );
            calStat.setDate(7, EndTime);
            calStat.setInt(8, BranchID);
            calStat.setBoolean(8, Status);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}
