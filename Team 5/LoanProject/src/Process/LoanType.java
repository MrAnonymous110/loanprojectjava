/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class LoanType {

    private int TypeCode;
    private String TypeName;
    private int InterestRate;
    private String Description;

    public LoanType() {
    }

    public LoanType(int TypeCode, String TypeName, int InterestRate, String Description) {
        this.TypeCode = TypeCode;
        this.TypeName = TypeName;
        this.InterestRate = InterestRate;
        this.Description = Description;
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(int InterestRate) {
        this.InterestRate = InterestRate;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public ResultSet getAllLoanType() {
        LoanConnection.registerDriver();
        try {
            Connection cn = LoanConnection.createConnection();
            String sql = "{call sp_LoanType_SelectAll}";
            CallableStatement calStat = cn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            return calStat.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public ResultSet getLoanTypeByID() {
        LoanConnection.registerDriver();
        try {
            Connection cn = LoanConnection.createConnection();
            String sql = "{call sp_LoanType_SelectRow(?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, getTypeCode());
            ResultSet rs = calStat.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean DelLoanType(int ID) {
                LoanConnection.registerDriver();
        try {
            Connection cn = LoanConnection.createConnection();
            String sql = "{call sp_LoanType_DeleteRow(?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, getTypeCode());
            calStat.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public boolean InsertLoanType() {
        LoanConnection.registerDriver();
        try {
            Connection cn = LoanConnection.createConnection();
            String sql = "{call sp_LoanType_Insert(?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setString(1, getTypeName());
            calStat.setFloat(2, getInterestRate());
            calStat.setString(3, getDescription());
            calStat.executeQuery();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public boolean changeLoanType() {
        LoanConnection.registerDriver();
        try {
            Connection cn = LoanConnection.createConnection();
            String sql = "{call sp_LoanType_Update(?,?,?,?)}";
            CallableStatement calStat = cn.prepareCall(sql);
            calStat.setInt(1, getTypeCode());
            calStat.setString(2, getTypeName());
            calStat.setFloat(3, getInterestRate());
            calStat.setString(4, getDescription());
            ResultSet rs = calStat.executeQuery();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}
