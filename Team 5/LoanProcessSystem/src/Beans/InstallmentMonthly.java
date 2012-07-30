/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author babman92
 */
public class InstallmentMonthly {
    private String ID;
    private String CustomerID;
    private float RateInterestMonney;
    private float MoneyRoot;
    private float Total;
    private Date PayDate;
    private int State;
    
    public InstallmentMonthly(){}

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getMoneyRoot() {
        return MoneyRoot;
    }

    public void setMoneyRoot(float MoneyRoot) {
        this.MoneyRoot = MoneyRoot;
    }

    public Date getPayDate() {
        return PayDate;
    }

    public void setPayDate(Date PayDate) {
        this.PayDate = PayDate;
    }

    public float getRateInterestMonney() {
        return RateInterestMonney;
    }

    public void setRateInterestMonney(float RateInterestMonney) {
        this.RateInterestMonney = RateInterestMonney;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
}
