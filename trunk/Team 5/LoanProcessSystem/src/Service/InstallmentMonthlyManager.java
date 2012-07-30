/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.Vector;

/**
 *
 * @author babman92
 */
public interface InstallmentMonthlyManager {
    public Vector GetListFromTable(String sql);
    public boolean Insert();
}
