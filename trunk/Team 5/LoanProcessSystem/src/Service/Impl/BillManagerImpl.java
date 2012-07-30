/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Service.BillManager;
import java.util.Vector;
import Beans.Account;
import DbConnection.MSSQLDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author THU
 */
public class BillManagerImpl implements BillManager{

    MSSQLDbConnection msssqlConnection;
    
    public BillManagerImpl()
    {
         msssqlConnection= new MSSQLDbConnection();
    }
    @Override
    public Vector getAll() {
        Vector listBill = new Vector();
        try {

            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            Statement cs = cn.createStatement();
            ResultSet rs = cs.executeQuery("select Bill.*, BillType.TypeName as Type from Bill,BillType where Bill.TypeID = BillType.TypeID order by Bill.Datetime desc");
            if (rs != null) {
                while (rs.next()) {
                    Vector bill = new Vector();
                    bill.add(rs.getString("AccountNo"));
                    bill.add(rs.getString("Type"));
                    bill.add(rs.getDate("Datetime"));
                    bill.add(rs.getString("Description"));

                    listBill.add(bill);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data null!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error occurs :"+ex.getMessage());
        }
        return listBill;
    }

    @Override
    public Vector search(String key) {
        Vector listBill = new Vector();
        try {

            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "select Bill.*, BillType.TypeName as Type from Bill,BillType where Bill.TypeID = BillType.TypeID and ( ";
            sql += "[AccountNo] like '%" + key + "%' ";
            sql += "or BillType.TypeName like '%" + key + "%' ";
            sql += "or [Datetime] like '%" + key + "%' ";
            sql += "or [Description] like '%" + key + "%' )";

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector bill = new Vector();
                    bill.add(rs.getString("AccountNo"));
                    bill.add(rs.getString("Type"));
                    bill.add(rs.getDate("Datetime"));
                    bill.add(rs.getString("Description"));

                    listBill.add(bill);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Could not found any results!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error occurs :"+ex.getMessage());
        }
        return listBill;
    }
    
}
