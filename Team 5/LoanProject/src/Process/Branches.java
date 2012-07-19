/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Branches {

    private String BranchesCode;
    private String Name;
    private String Address;
    private String Email;
    private String Phone;
    
    public Branches() {
    }
    
    public String getAddress() {
        return Address;
    }
    
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public String getBranchesCode() {
        return BranchesCode;
    }
    
    public void setBranchesCode(String BranchesCode) {
        this.BranchesCode = BranchesCode;
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
    
    public String getPhone() {
        return Phone;
    }
    
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    public boolean insert() {
        if (!this.isExist()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();
                String sql = "insert into Branches (BranchesCode,Name,Address,Email,Phone) values (?,?,?,?,?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, this.getBranchesCode());
                stm.setString(2, this.getName());
                stm.setString(3, this.getAddress());
                stm.setString(4, this.getEmail());
                stm.setString(5, this.getPhone());
                boolean isOK = stm.execute();
                return isOK;
            } catch (SQLException ex) {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean update() {
        if (this.isExist()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();
                String sql = "update Branches set Name=?,Address=?,Email=?,Phone=? where BranchesCode=?";
                PreparedStatement stm = cn.prepareStatement(sql);                
                stm.setString(1, this.getName());
                stm.setString(2, this.getAddress());
                stm.setString(3, this.getEmail());
                stm.setString(4, this.getPhone());
                stm.setString(5, this.getBranchesCode());
                boolean isOK = stm.execute();
                return isOK;
            } catch (SQLException ex) {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean delete() {
        if (this.isExist()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();
                String sql = "delete from Branches where BranchesCode=" + this.getBranchesCode();
                PreparedStatement stm = cn.prepareStatement(sql);                
                boolean isOK = stm.execute();
                return isOK;
            } catch (SQLException ex) {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean isExist() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            
            String sql = "select * from Branches where BranchesCode=" + this.getBranchesCode();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static Vector getList(String sql) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            //String sql = "select * from Branches";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector branch = new Vector();
                branch.addElement(rs.getString("BranchesCode"));
                branch.addElement(rs.getString("Name"));
                branch.addElement(rs.getString("Address"));
                branch.addElement(rs.getString("Email"));
                branch.addElement(rs.getString("Phone"));
                list.addElement(branch);
            }
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }
    
    public static Vector Search(String search, int index) {
        String sql;
        if (index == 0) {
            sql =  "Select * From [Branches] Where [BranchesCode] Like '%{" +search +"}%'";
            Vector dataSearch = getList(sql);
            return dataSearch;
        }
        else
        {
            if (index == 1)
            {
                sql="Select * From [Branches] Where [Name] Like '%{" +search +"}%'";
                Vector dataSearch = getList(sql);
                return dataSearch;
            }
            else
                return null;
        }
    }
}
