/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Administrator
 */
public interface Validate {
    
    /*
     * validate email
     * return true or false
     */
    public boolean isEmail(String email);
   
    /*
     * validate Date
     * return true or false
     */
    public boolean isDate(String date);
    
    /*
     * validate phone number
     * return true or false
     */
    public boolean isPhone(String phone);
    
    /*
     * validate number
     */
    public boolean isNumber(String str);
    
    /*
     * check for String
     */
    public boolean isMatches(String str,String regex);
}
