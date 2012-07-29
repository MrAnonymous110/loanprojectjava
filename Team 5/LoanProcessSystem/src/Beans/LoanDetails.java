/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class LoanDetails {
    private int id;
    private String accountNo;
    private int loanMoney;
    private int curentMoney;
    private String typeCode;
    private Date beginTime;
    private Date endTime;
    private String branchesCode;
    
    public LoanDetails(){}

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getBranchesCode() {
        return branchesCode;
    }

    public void setBranchesCode(String branchesCode) {
        this.branchesCode = branchesCode;
    }

    public int getCurentMoney() {
        return curentMoney;
    }

    public void setCurentMoney(int curentMoney) {
        this.curentMoney = curentMoney;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(int loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    
    
}