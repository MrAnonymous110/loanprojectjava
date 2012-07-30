/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.Vector;

/**
 *
 * @author THU
 */
public interface BillTypeManager {

    /**
     * 
     * @return Vector are stored list all BillType
     */
    public Vector getAll();
    
    /**
     * 
     * @param key
     * @return Vector are stored list Bill which is found exist key
     */
    public Vector search(String key);
}
