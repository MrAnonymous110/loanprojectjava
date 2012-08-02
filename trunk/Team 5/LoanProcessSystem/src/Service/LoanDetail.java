/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.BitSet;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Minh
 */
public interface LoanDetail {

    public ResultSet getAllLoanDetail() throws SQLException;

    public ResultSet getLoanDetailByID(int ID) throws SQLException;

    public boolean DelLoanDetail(int ID) throws SQLException;

    public boolean InsertLoanDetail(String AccountNo, float LoanMoney, float Current, int TypeID, Date BeginTime, Date EndTime, int BranchID) throws SQLException;

    public boolean changeLoanDetail(int LoanID,String AccountNo,float LoanMoney,float Current,int TypeID,Date BeginTime,Date EndTime,int BranchID) throws SQLException;
}
