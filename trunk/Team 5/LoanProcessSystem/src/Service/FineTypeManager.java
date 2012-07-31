/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.FineType;
import java.util.Vector;

/**
 *
 * @author babman92
 */
public interface FineTypeManager {
    public Vector GetDataFromTable(int finType);
    public boolean Insert(FineType fineType);
    public boolean Update(FineType fineType);
    public Vector GetDataFromColumn(String ColName);
}
