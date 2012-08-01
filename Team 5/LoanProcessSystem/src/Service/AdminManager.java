/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Admin;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public interface AdminManager {
    
   /*
    *  check for login
    * return boolean 
    */   
    public boolean isExisted(String username, String password);    
   
    /*
     *  Insert new Account to database
     */   
    public boolean  insertRow(Admin user);   
    
    /*
     *  select a Account from database
     *  return a Account
     */      
    public Admin selectRow(String username);
    
    /*
     *  return list Account from database to Vector
     */    
    public Vector getAll();
    
    /*
     * Search Account has key.
     * return Vector is a list Account
     */  
    public Vector search(String key);
    
    /*
     * update information for Account
     */  
    public boolean updateRow(Admin user);
}
