/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Account;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public interface AccountManager {
    
   /*
    *  check for login
    * return boolean 
    */   
    public boolean isExisted(String AccountNo, String Password);    
   
    /*
     *  Insert new Account to database
     */   
    public boolean insertRow(Account acc);   
    
    /*
     *  select a Account from database
     *  return a Account
     */      
    public Account selectRow(String AccountNo);
    
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
    public boolean updateRow(Account acc);
    
    /*
     * Auto generate AccountNo for Customer
     */
    public String generateAccountNo();
    
}
