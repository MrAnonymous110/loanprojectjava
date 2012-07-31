/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.Branches;
import DbConnection.MSSQLDbConnection;
import Service.BranchesManager;
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
 * @author babman92
 */
public class BranchesManagerImpl implements BranchesManager {

    MSSQLDbConnection msssqlConnection;

    public BranchesManagerImpl() {
        msssqlConnection = new MSSQLDbConnection();
    }

    @Override
    public boolean Insert(Branches branche) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Insert into [Branches] (Name,Address,Email,Phone,Block) values (?,?,?,?,?)";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, branche.getName());
            stm.setString(2, branche.getAddress());
            stm.setString(3, branche.getEmail());
            stm.setString(4, branche.getPhone());
            stm.setInt(5, 0);
            int count = stm.executeUpdate();
            cn.close();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean UpdateTable(Branches branche) {
        msssqlConnection.registerDriver();
        Connection cn = msssqlConnection.createConnection();
        String sql = "Update Branches set Name=?,Address=?,Email=?,Phone=? where BranchesID=?";
        PreparedStatement stm;
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, branche.getName());
            stm.setString(2, branche.getAddress());
            stm.setString(3, branche.getEmail());
            stm.setString(4, branche.getPhone());
            stm.setString(5, branche.getBranchesID());
            int count = stm.executeUpdate();
            cn.close();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean UpdateBlock(Branches branche) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Update [Branches] Set [Block]=? where [BranchesID]=?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setInt(1, branche.getBlock());
            stm.setString(2, branche.getBranchesID());
            int count = stm.executeUpdate();
            cn.close();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Vector GetListFromTable(String sql) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
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

    @Override
    public Vector GetColumnFromTable(String ColName) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Select ["+ColName+"] From [Branches]";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Name = new Vector();
                Name.addElement(rs.getString(ColName));
                list.addElement(Name);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Vector Search(String searchStr, int index) {
        String sql;
        if (index == 0) {
            sql = "Select * From [Branches] Where [BranchesID] Like '%" + searchStr + "%'";
            Vector dataSearch = GetListFromTable(sql);
            return dataSearch;
        } else {
            if (index == 1) {
                sql = "Select * From [Branches] Where [Name] Like '%" + searchStr + "%'";
                Vector dataSearch = GetListFromTable(sql);
                return dataSearch;
            } else {
                return null;
            }
        }
    }

    @Override
    public boolean IsExit(Branches branche) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Select * From [Branches] where [Name]=" + branche.getName();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Object GetDataAtCellInTable(JTable table, int RowIndex, int ColIndex) {
        return table.getModel().getValueAt(RowIndex, ColIndex);
    }
}
