/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class MSSQLDbConnection  implements DbConnection{
    String serverName;
    String port;
    String dbName;
    String user;
    String password;
    
    public MSSQLDbConnection()
    {
        try {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("connect.txt"));
            serverName = reader.readLine();
            port= reader.readLine();
            dbName= reader.readLine();
            user=reader.readLine();
            password=reader.readLine();
         }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public MSSQLDbConnection(String serverName, String port, String dbName, String user, String password) {
        this.serverName = serverName;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }
    
    
    
    @Override
    public Connection createConnection(){
        try {
            String connect="jdbc:sqlserver://"+serverName+":"+port+";Databasename="+dbName+";user="+user+";password="+password;
            Connection cn = DriverManager.getConnection(connect);
            return cn;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Can'nt connect database!");
            return null;
        }
    }

    @Override
    public void registerDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"programs lack of driver library!");
        }
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

 
    
    
}
