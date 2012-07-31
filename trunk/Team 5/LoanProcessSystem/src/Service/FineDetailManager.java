/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.FineDetails;
import java.util.Vector;

/**
 *
 * @author babman92
 */
public interface FineDetailManager {
    
    // Insert Into Table FineDetails
    public boolean Insert(FineDetails fine);
    
    // Get Data From Table FineDetails
    public Vector GetListFromTable(String sql);
    
    // Calculate Count Month Of Loan
    public int CalCountMonthOfLoan(int[] datetimeBegin, int[] datetimeFinish);
    
    // Calculate Fine
    public void CalFine();
    
    // Get Date From String Format
    public int[] GetDateFromString(String date);
    
    // Get DateTime Now
    public String GetDateTimeNow();
    
    // Get Data From LoansDetails
    public Vector GetListLoanDetail(String sql);
    
}
