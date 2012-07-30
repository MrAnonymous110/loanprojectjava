/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Beans.Branches;
import java.util.Vector;
import javax.swing.JTable;
/**
 *
 * @author babman92
 */
public interface BranchesManager {
    
    // Insert into Branches table
    public boolean Insert(Branches branche);
    
    // Update table Branches
    public boolean UpdateTable(Branches branche);
    
    // Update Column Block in Table Branches
    public boolean UpdateBlock(Branches branche);
    
    // Get List Data From Table Branches
    public Vector GetListFromTable(String sql);
    
    //Get One Column From Table
    public Vector GetColumnFromTable();
    
    // Search Record From Table Branches
    public Vector Search(String searchStr, int index);
    
    // Get Data At Cell In Table
    public Object GetDataAtCellInTable(JTable table, int RowIndex, int ColIndex);
    
    // Check Branche Exit?
    public boolean IsExit(Branches branche);  
}
