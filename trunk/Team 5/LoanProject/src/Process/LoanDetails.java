/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class LoanDetails {
    private int ID;
    private String AccountNo;
    private int LoanMoney;
    private int CurentMoney;
    private String TypeCode;
    private Date BeginTime;
    private Date EndTime;
    private String BranchesCode;
    
    public LoanDetails(){}

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public Date getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(Date BeginTime) {
        this.BeginTime = BeginTime;
    }

    public String getBranchesCode() {
        return BranchesCode;
    }

    public void setBranchesCode(String BranchesCode) {
        this.BranchesCode = BranchesCode;
    }

    public int getCurentMoney() {
        return CurentMoney;
    }

    public void setCurentMoney(int CurentMoney) {
        this.CurentMoney = CurentMoney;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date EndTime) {
        this.EndTime = EndTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLoanMoney() {
        return LoanMoney;
    }

    public void setLoanMoney(int LoanMoney) {
        this.LoanMoney = LoanMoney;
    }

    public String getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(String TypeCode) {
        this.TypeCode = TypeCode;
    }
    
    
}
