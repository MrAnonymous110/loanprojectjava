/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class LoanConnection {
    public static java.sql.Connection createConnection() throws SQLException {
        java.sql.Connection cn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Databasename=LoanProcess;user=sa;password=1234567");
        return cn;
    }
    
    public static void registerDriver()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver error");
        }
    }
    
}
