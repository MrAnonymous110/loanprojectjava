/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.InstallmentMonthly;
import java.util.Vector;

/**
 *
 * @author babman92
 */
public interface InstallmentMonthlyManager {
    public Vector GetListFromTable(String sql);
    public boolean InsertBasic(InstallmentMonthly IstMonthly);
    public void InsertInstallmentMonthly(String CustomerID, Float Rate);
    public String GetLastPayDate(String CustomerID);
    public Float[] CalMonthlyRateMoney(int CountMonth, Float Rate, Float LoanMoney);
}
