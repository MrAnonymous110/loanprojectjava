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
public class FineType {

    private int TypeCode;
    private int Fine;
    private String Description;

    public FineType() {
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getFine() {
        return Fine;
    }

    public void setFine(int Fine) {
        this.Fine = Fine;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;
    }

    public Vector getList(String sql) {
        Connection cn;
        try {
            LoanConnection.registerDriver();
            cn = LoanConnection.createConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Vector list = new Vector();
            while(rs.next())
            {
                Vector fineType = new Vector();
                fineType.addElement(rs.getInt("TypeID"));
                fineType.addElement(rs.getInt("Fine"));
                fineType.addElement(rs.getString("Description"));
                list.addElement(fineType);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
    
        public Vector SelectColumn() {
        Connection cn;
        try {
            LoanConnection.registerDriver();
            cn = LoanConnection.createConnection();
            String sql = "Select [Description] From [FineType]";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Vector list = new Vector();
            while(rs.next())
            {
                Vector fineType = new Vector();
//                fineType.addElement(rs.getInt("TypeID"));
//                fineType.addElement(rs.getInt("Fine"));
                fineType.addElement(rs.getString("Description"));
                list.addElement(fineType);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
