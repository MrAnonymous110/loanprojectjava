/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.FineType;
import DbConnection.MSSQLDbConnection;
import Service.FineTypeManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author babman92
 */
public class FineTypeManagerImpl implements FineTypeManager {

    MSSQLDbConnection msssqlConnection;

    public FineTypeManagerImpl() {
        msssqlConnection = new MSSQLDbConnection();
    }

    @Override
    public Vector GetDataFromTable(int fineType) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement("Select [Fine] From [FineType] Where [TypeID]={" + fineType + "}");
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector fine = new Vector();
                fine.addElement(rs.getFloat("Fine"));
                list.addElement(fine);
            }
            cn.close();
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    @Override
    public boolean Insert(FineType fineType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Update(FineType fineType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vector GetDataFromColumn(String ColName) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Select ["+ColName+"] From [FineType]";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                //Vector fineType = new Vector();
                list.addElement(rs.getString(ColName));
               ///list.addElement(fineType);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
