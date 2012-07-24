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
import javax.swing.JTable;

/**
 *
 * @author Administrator
 */
public class Branches {

    private String BranchesID;
    private String Name;
    private String Address;
    private String Email;
    private String Phone;
    private int Block;

    public Branches() {
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBranchesID() {
        return BranchesID;
    }

    public void setBranchesID(String BranchesID) {
        this.BranchesID = BranchesID;
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

    public void setBlock(int block) {
        this.Block = block;
    }

    public int getBlock() {
        return Block;
    }

    public boolean insert() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            String sql = "Insert into [Branches] (Name,Address,Email,Phone,Block) values (?,?,?,?,?)";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, this.getName());
            stm.setString(2, this.getAddress());
            stm.setString(3, this.getEmail());
            stm.setString(4, this.getPhone());
            stm.setInt(5, 0);
            int count = stm.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean update() {
        if (this.isExist()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();
                String sql = "Update Branches set Name=?,Address=?,Email=?,Phone=? where BranchesID=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, this.getName());
                stm.setString(2, this.getAddress());
                stm.setString(3, this.getEmail());
                stm.setString(4, this.getPhone());
                stm.setString(5, this.getBranchesID());
                int count = stm.executeUpdate();
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateBlock() {
        if (this.isExist()) {
            try {
                LoanConnection.registerDriver();
                Connection cn = LoanConnection.createConnection();
                String sql = "Update [Branches] Set [Block]=? where [BranchesID]=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, this.getBlock());
                stm.setString(2, this.getBranchesID());
                int count = stm.executeUpdate();
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
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
                String sql = "Delete from Branches where BranchesID=" + this.getBranchesID();
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
            String sql = "Select * from [Branches] where BranchesID=" + this.getBranchesID();
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
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector branch = new Vector();
                branch.addElement(rs.getString("BranchesID"));
                branch.addElement(rs.getString("Name"));
                branch.addElement(rs.getString("Address"));
                branch.addElement(rs.getString("Email"));
                branch.addElement(rs.getString("Phone"));
                branch.addElement(rs.getInt("Block"));
                list.addElement(branch);
            }
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    public Vector SelectColumn() {
        Connection cn;
        try {
            LoanConnection.registerDriver();
            cn = LoanConnection.createConnection();
            String sql = "Select [Name] From [Branches]";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Name = new Vector();
                Name.addElement(rs.getString("Name"));
                list.addElement(Name);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static Vector Search(String search, int index) {
        String sql;
        if (index == 0) {
            sql = "Select * From [Branches] Where [BranchesID] Like '%" + search + "%'";
            Vector dataSearch = getList(sql);
            return dataSearch;
        } else {
            if (index == 1) {
                sql = "Select * From [Branches] Where [Name] Like '%" + search + "%'";
                Vector dataSearch = getList(sql);
                return dataSearch;
            } else {
                return null;
            }
        }
    }

    public static Object GetData(JTable table, int RowIndex, int ColIndex) {
        return table.getModel().getValueAt(RowIndex, ColIndex);
    }
}
