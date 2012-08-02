/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

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
        serverName = "localhost";
        port= "1433";
        dbName= "LoanProcess";
        user="sa";
        password="1234567";
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

 
    
}
