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
    public boolean isExisted(String username) {
        try {
            msssqlConnection.registerDriver();
            Connection cn= msssqlConnection.createConnection();     
            if(cn!=null)
            {
               String sql = "{call sp_Admin_SelectRow(?)}";
               CallableStatement cs= cn.prepareCall(sql);
               cs.setString(1,username);
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
    public boolean insertRow(Admin user) {
        try {
            msssqlConnection.registerDriver();
            Connection cn= msssqlConnection.createConnection();
            
            if(cn!=null)
            {
                String sql = "{call sp_Admin_Insert(?,?,?,?,?,?)}";
                CallableStatement cs= cn.prepareCall(sql); 
                cs.setString(1,user.getUsername());
                cs.setString(2,user.getPassword());
                cs.setString(3,user.getFullname());
                cs.setString(4,user.getAddress());
                cs.setString(5,user.getEmail());
                cs.setString(6,user.getPhone());
                cs.execute();
                return true;
            }
            return false;
        } catch (SQLException ex) {
           return false;
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
    public boolean updateRow(Admin user) {
        try {
                msssqlConnection.registerDriver();
                Connection cn = msssqlConnection.createConnection();
                if(cn!= null)
                {
                    String sql = "{call sp_Admin_Update(?,?,?,?,?,?)}";
                    CallableStatement stm = cn.prepareCall(sql);
                    stm.setString(1, user.getUsername());
                    stm.setString(2, user.getPassword());
                    stm.setString(3, user.getFullname());
                    stm.setString(4, user.getAddress());
                    stm.setString(5, user.getEmail());
                    stm.setString(6, user.getPhone());       
                    stm.execute();
                    return true;
                }
                return false;
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Can not update.Has error process update!");
               return false;
            }
        
    }
    
}
