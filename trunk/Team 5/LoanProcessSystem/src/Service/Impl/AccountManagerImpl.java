/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.Account;
import DbConnection.MSSQLDbConnection;
import Service.AccountManager;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class AccountManagerImpl implements AccountManager {
    MSSQLDbConnection msssqlConnection;
    
    public AccountManagerImpl()
    {
         msssqlConnection= new MSSQLDbConnection();
    }
    
    @Override
    public boolean isExisted(String AccountNo, String Password) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();

            String sql = "{call sp_Account_SelectRowHasPass(?,?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, AccountNo);
            cs.setString(2, Password);
            ResultSet rs = cs.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertRow(Account acc) {     
            try {
                msssqlConnection.registerDriver();
                Connection cn = msssqlConnection.createConnection();
                if(cn!=null)
                {
                    String sql = "{call sp_Account_Insert(?,?,?,?,?,?,?,?,?,?,?)}";
                    CallableStatement stm = cn.prepareCall(sql);
                    stm.setString(1, acc.getAccountNo());
                    stm.setString(2, acc.getPassword());
                    stm.setString(3, acc.getName());
                    stm.setDate(4, acc.getBirthday());
                    stm.setString(5, acc.getOrganization());
                    stm.setString(6, acc.getAddress());
                    stm.setString(7, acc.getEmail());
                    stm.setString(8, acc.getPhone());
                    stm.setInt(9, acc.getSalary());
                    stm.setDate(10, acc.getRegisterDate());
                    stm.setBoolean(11,false);
                    stm.execute();
                    return true;
                }
                return false;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Has error in process update.Can not Update!");     
                return false;
            }
    }

    @Override
    public Account selectRow(String AccountNo) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();

           if(cn!=null)
           {
                String sql = "{call sp_Account_SelectRow(?)}";
                CallableStatement cs = cn.prepareCall(sql);
                cs.setString(1, AccountNo);
                ResultSet rs = cs.executeQuery();
                Account acc= new Account();
                if( rs.next()){
                    acc.setAccountNo(AccountNo);
                    acc.setPassword(rs.getString("Password"));
                    acc.setName(rs.getString("Name"));
                    acc.setAddress(rs.getString("Address"));
                    acc.setOrganization(rs.getString("Organization"));
                    acc.setEmail(rs.getString("Email"));
                    acc.setBirthday(rs.getDate("BirthDay"));
                    acc.setPhone(rs.getString("Phone"));
                    acc.setSalary(rs.getInt("Salary"));
                    acc.setRegisterDate(rs.getDate("RegisterDate"));
                    acc.setStatus(rs.getBoolean("Status"));        
                 }
                 return acc;
           }
           else{
               return new Account();
           }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Has error Select");
             return new Account();
        }
    }

    @Override
    public Vector getAll() {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();

            String sql = "{call sp_Account_SelectAll()}";
            CallableStatement stm = cn.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            Vector listAccount = new Vector();
            while (rs.next()) {
                Vector account = new Vector();
                account.addElement(rs.getString("AccountNo"));
                account.addElement(rs.getString("Password"));
                account.addElement(rs.getString("Name"));
                account.addElement(rs.getDate("BirthDay"));
                account.addElement(rs.getString("Organization"));
                account.addElement(rs.getString("Address"));
                account.addElement(rs.getString("Email"));
                account.addElement(rs.getString("Phone"));
                account.addElement(rs.getInt("Salary"));
                account.addElement(rs.getDate("RegisterDate"));
                account.addElement(rs.getBoolean("Status"));
                listAccount.addElement(account);
            }
            return listAccount;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    @Override
    public Vector search(String key) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ValidateImpl valid= new ValidateImpl();
            String sql = "select * from [Account] where ";   
            if(valid.isDate(key)){                  
                 sql += " [RegisterDate] ='"+key+"'";
                 sql += " or [BirthDay]='"+key+"'";      
            }
            else
            {
                sql += " [AccountNo] like '%" + key + "%' ";
                sql += " or [Name] like '%" + key + "%' ";
                sql += " or [Organization] like '%" + key + "%' ";
                sql += " or [Address] like '%" + key + "%' ";
                sql += " or [Email] like '%" + key + "%' ";
                sql += " or [Phone] like '%" + key + "%' ";
            }
            JOptionPane.showMessageDialog(null,sql);
            
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Vector listAccount = new Vector();
            while (rs.next()) {
                Vector account = new Vector();
                account.addElement(rs.getString("AccountNo"));
                account.addElement(rs.getString("Password"));
                account.addElement(rs.getString("Name"));
                account.addElement(rs.getDate("BirthDay"));
                account.addElement(rs.getString("Organization"));
                account.addElement(rs.getString("Address"));
                account.addElement(rs.getString("Email"));
                account.addElement(rs.getString("Phone"));
                account.addElement(rs.getInt("Salary"));
                account.addElement(rs.getDate("RegisterDate"));
                account.addElement(rs.getBoolean("Status"));
                listAccount.addElement(account);
            }
            rs.close();
            ps.close();
            cn.close();
            return listAccount;
        } catch (SQLException ex) {
           return new Vector();
        }
    }

    @Override
    public boolean updateRow(Account acc) {
            try {
                msssqlConnection.registerDriver();
                Connection cn = msssqlConnection.createConnection();
                if(cn!= null)
                {
                    String sql = "{call sp_Account_Update(?,?,?,?,?,?,?,?,?,?,?)}";
                    CallableStatement stm = cn.prepareCall(sql);
                    stm.setString(1, acc.getAccountNo());
                    stm.setString(2, acc.getPassword());
                    stm.setString(3, acc.getName());
                    stm.setDate(4, acc.getBirthday());
                    stm.setString(5, acc.getOrganization());
                    stm.setString(6, acc.getAddress());
                    stm.setString(7, acc.getEmail());
                    stm.setString(8, acc.getPhone());
                    stm.setInt(9, acc.getSalary());
                    stm.setDate(10, acc.getRegisterDate());
                    stm.setBoolean(11, acc.isStatus());
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
