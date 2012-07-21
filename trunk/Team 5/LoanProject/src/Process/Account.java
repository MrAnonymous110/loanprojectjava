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
public class Account {

    private String AccountNo;
    private String Password;
    private String Name;
    private Date Birthday;
    private String Organization;
    private String Address;
    private String Email;
    private String Phone;
    private int Salary;
    private Date RegisterDate;

    public Account() {
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Date getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(Date RegisterDate) {
        this.RegisterDate = RegisterDate;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public boolean isExisted() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();

            String sql = "{call sp_Account_SelectRow(?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, this.getAccountNo());
            ResultSet rs = cs.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean register() {
        if (!this.isExisted()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();

                String sql = "{call sp_Account_Insert(?,?,?,?,?,?,?,?,?,?)}";
                CallableStatement stm = cn.prepareCall(sql);
                stm.setString(1, this.getAccountNo());
                stm.setString(2, this.getPassword());
                stm.setString(3, this.getName());
                stm.setDate(4, this.getBirthday());
                stm.setString(5, this.getOrganization());
                stm.setString(6, this.getAddress());
                stm.setString(7, this.getEmail());
                stm.setString(8, this.getPhone());
                stm.setInt(9, this.getSalary());
                stm.setDate(10, this.getRegisterDate());
                stm.execute();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account is existed!");
            return false;
        }
    }

    public static Vector getList() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();

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
                listAccount.addElement(account);
            }
            return listAccount;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    public static Vector search(String key) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();

            String sql = "select * from [Account] where ";
            sql += "[AccountNo] like '%" + key + "%' ";
            sql += "or [Name] like '%" + key + "%' ";
            sql += "or [Organization] like '%" + key + "%' ";
            sql += "or [Address] like '%" + key + "%' ";
            sql += "or [Email] like '%" + key + "%' ";
            sql += "or [Phone] like '%" + key + "%' ";
            sql += "or [RegisterDate] like '%" + key + "%' ";
            sql += "or [BirthDay] like '%" + key + "%' ";

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
                listAccount.addElement(account);
            }
            return listAccount;
        } catch (SQLException ex) {
           return new Vector();
        }
    }

    public boolean update() {
        if (this.isExisted()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();

                String sql = "{call sp_Account_Update(?,?,?,?,?,?,?,?,?,?)}";
                CallableStatement stm = cn.prepareCall(sql);
                stm.setString(1, this.getAccountNo());
                stm.setString(2, this.getPassword());
                stm.setString(3, this.getName());
                stm.setDate(4, this.getBirthday());
                stm.setString(5, this.getOrganization());
                stm.setString(6, this.getAddress());
                stm.setString(7, this.getEmail());
                stm.setString(8, this.getPhone());
                stm.setInt(9, this.getSalary());
                stm.setDate(10, this.getRegisterDate());
                stm.execute();
                return true;
            } catch (SQLException ex) {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account is not existed!");
            return false;
        }
    }

    public boolean remove() {
        if (this.isExisted()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();
                String sql = "{call sp_Account_DeleteRow(?)}";
                CallableStatement cs = cn.prepareCall(sql);
                cs.setString(1, this.getAccountNo());
                cs.execute();
                return true;
            } catch (SQLException ex) {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account is not extisted!");
            return false;
        }
    }
}
