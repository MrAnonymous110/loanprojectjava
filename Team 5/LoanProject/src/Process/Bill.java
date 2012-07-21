/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Bill {

    private int ID;
    private String AccountNo;
    private Date Datetime;
    private int TypeCode;
    private String Description;

    public Bill() {
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public Date getDatetime() {
        return Datetime;
    }

    public void setDatetime(Date Datetime) {
        this.Datetime = Datetime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;
    }
    
    /**
     * Method used to search list Bill from AccountNo
     * 
     * return a set of vector stored Bill detail 
     */
    public Vector searchAccountNo() {
        Vector listBill = new Vector();
        try {

            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            CallableStatement cs = cn.prepareCall("{call sp_TypeBill_SelectOne(?)}");
            cs.setString(1, this.getAccountNo());
            ResultSet rs = cs.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector LoanType = new Vector();
                    LoanType.add(rs.getString("AccountNo"));
                    LoanType.add(rs.getInt("TypeID"));
                    LoanType.add(rs.getDate("Datetime"));
                    LoanType.add(rs.getString("Description"));

                    listBill.add(LoanType);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Could not find any results!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBill;
    }
    
    public Vector searchType() {
        Vector listBill = new Vector();
        try {

            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            CallableStatement cs = cn.prepareCall("{call sp_TypeBill_SelectOne(?)}");
            cs.setString(1, this.getAccountNo());
            ResultSet rs = cs.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector LoanType = new Vector();
                    LoanType.add(rs.getString("AccountNo"));
                    LoanType.add(rs.getInt("TypeID"));
                    LoanType.add(rs.getDate("Datetime"));
                    LoanType.add(rs.getString("Description"));

                    listBill.add(LoanType);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Could not find any results!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBill;
    }
    
    public Vector searchBill() {
        Vector listBill = new Vector();
        try {

            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            CallableStatement cs = cn.prepareCall("{call sp_TypeBill_SelectOne(?)}");
            cs.setString(1, this.getAccountNo());
            ResultSet rs = cs.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector LoanType = new Vector();
                    LoanType.add(rs.getString("AccountNo"));
                    LoanType.add(rs.getInt("TypeID"));
                    LoanType.add(rs.getDate("Datetime"));
                    LoanType.add(rs.getString("Description"));

                    listBill.add(LoanType);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Could not find any results!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBill;
    }
}
