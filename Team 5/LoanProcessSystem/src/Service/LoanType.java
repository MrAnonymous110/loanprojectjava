/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hoang Minh
 */
public interface LoanType {
    public ResultSet getAllLoanType() throws SQLException;
    public ResultSet getLoanTypeByID(int ID) throws SQLException;
    public boolean DelLoanType(int ID) throws SQLException;
    public boolean InsertLoanType(String TypeName, float InterestRate, String Des) throws SQLException;
    public boolean changeLoanType(int ID, String TypeName, float InterestRate, String Des) throws SQLException;
    public int countLoanDetailByLoanTypeID(int ID) throws SQLException;
}
