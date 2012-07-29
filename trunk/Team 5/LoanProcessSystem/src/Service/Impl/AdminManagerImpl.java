/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.Admin;
import DbConnection.MSSQLDbConnection;
import Service.AdminManager;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class AdminManagerImpl implements AdminManager{

    MSSQLDbConnection msssqlConnection;
    
    public AdminManagerImpl()
    {
       msssqlConnection = new MSSQLDbConnection();
    }
    
    @Override
    public boolean isExisted(String username, String password) {
        try {
            msssqlConnection.registerDriver();
            Connection cn= msssqlConnection.createConnection();     
            if(cn!=null)
            {
               String sql = "{call sp_Admin_SelectRowHasPass(?,?)}";
               CallableStatement cs= cn.prepareCall(sql);
               cs.setString(1,username);
               cs.setString(2, password);
               ResultSet rs = cs.executeQuery();
               return rs.next();
           }
           else{
               return false;
           }
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public void insertRow(Admin user) {
        try {
            msssqlConnection.registerDriver();
            Connection cn= msssqlConnection.createConnection();
            
            String sql="INSERT INTO Admin (Username,Password,Fullname) values (?,?,?)";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1,user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3,user.getFullname());
            stm.setString(4,user.getAddress());
            stm.setString(5,user.getEmail());
            stm.setString(6,user.getPhone());
            boolean isOK= stm.execute();
            if(isOK)
                JOptionPane.showMessageDialog(null,"Register successful! Please login!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Register fail!");
        }
    }

    @Override
    public Admin selectRow(String username) {
        try {
            msssqlConnection.registerDriver();
            Connection cn= msssqlConnection.createConnection();     
            if(cn!=null)
            {
               String sql = "{call sp_Admin_SelectRow(?)}";
               CallableStatement cs= cn.prepareCall(sql);
               cs.setString(1,username);
               ResultSet rs = cs.executeQuery();
               Admin admin= new Admin();
               if(rs.next())
               {
                   admin.setUsername(username);
                   admin.setPassword(rs.getString("Password"));
                   admin.setFullname(rs.getString("Fullname"));
                   admin.setAddress(rs.getString("Address"));
                   admin.setEmail(rs.getString("Email"));
                   admin.setPhone(rs.getString("Phone"));
               }
              
               return admin;
               
           }
           else{
               return new Admin();
           }
        } catch (SQLException ex) {
            return new Admin();
        }
    }

    @Override
    public Vector getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vector search(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateRow(Admin user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
