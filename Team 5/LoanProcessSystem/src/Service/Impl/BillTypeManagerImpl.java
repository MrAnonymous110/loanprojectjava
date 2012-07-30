/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import DbConnection.MSSQLDbConnection;
import Service.BillTypeManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author THU
 */
public class BillTypeManagerImpl implements BillTypeManager {

    private final MSSQLDbConnection msssqlConnection;

    public BillTypeManagerImpl() {
        msssqlConnection = new MSSQLDbConnection();
    }

    @Override
    public Vector getAll() {
        Vector listLoanType = new Vector();
        try {

            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            CallableStatement cs = cn.prepareCall("{call sp_BillType_SelectAll()}");
            ResultSet rs = cs.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector LoanType = new Vector();
                    LoanType.add(rs.getInt("TypeID"));
                    LoanType.add(rs.getString("TypeName"));

                    listLoanType.add(LoanType);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data null");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error occurs :"+ex.getMessage());
        }
        return listLoanType;
    }

    @Override
    public Vector search(String key) {
        Vector listBillType = new Vector();
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();

            String sql = "select * from [BillType] where ";
            sql += "[TypeID] like '%" + key + "%' ";
            sql += "or [TypeName] like '%" + key + "%' ";

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                Vector billType = new Vector();
                billType.addElement(rs.getInt("TypeID"));
                billType.addElement(rs.getString("TypeName"));
                listBillType.addElement(billType);
            }
            } else {
                JOptionPane.showMessageDialog(null, "Could not found any results!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error occurs :"+ex.getMessage());
        }
        return listBillType;
    }
}
