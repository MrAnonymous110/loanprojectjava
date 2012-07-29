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

    @Override
    public Connection createConnection(){
        try {
            Connection cn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Databasename=LoanProcess;user=sa;password=1234567");
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
