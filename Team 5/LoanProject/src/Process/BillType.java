/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrator
 */
public class BillType {

    private int TypeCode;
    private String TypeName;

    public BillType() {
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

    public static Vector getAll() {
        Vector listLoanType = new Vector();
        try {
            
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            CallableStatement cs = cn.prepareCall("{call sp_TypeBill_SelectAll()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Vector LoanType = new Vector();
                LoanType.add(rs.getInt("TypeCode"));
                LoanType.add(rs.getString("TypeName"));
                
                listLoanType.add(LoanType);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BillType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLoanType;
    }
   public static Vector getOne()
   {
       Vector listLoanType = new Vector();
        try {
            
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            CallableStatement cs = cn.prepareCall("{call sp_TypeBill_SelectOne(?)}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Vector LoanType = new Vector();
                LoanType.add(rs.getInt("TypeCode"));
                LoanType.add(rs.getString("TypeName"));
                
                listLoanType.add(LoanType);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BillType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLoanType;
   }
}
