/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public interface DbConnection {
    
    
    /*
     *  create a connection to database
     */
    public Connection createConnection() throws SQLException;

    /*
     *   register driver for database
     */
    public void registerDriver() throws ClassNotFoundException;
            
}
