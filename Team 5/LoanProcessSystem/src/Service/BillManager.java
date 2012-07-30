/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.Vector;

/**
 *
 * 
 */
public interface BillManager {
    /**
     * 
     * @return Vector are stored list all Bill 
     */
    public Vector getAll();
    
    /**
     * 
     * @param key
     * @return Vector are stored list bill
     */
    public Vector search(String key);
}
