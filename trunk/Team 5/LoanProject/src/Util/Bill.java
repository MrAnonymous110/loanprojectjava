/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Bill {
    private int ID;
    private String AccountNo;
    private Date Datetime;
    private int TypeCode;
    private String Description;

    public Bill(){}
    
    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public Date getDatetime() {
        return Datetime;
    }

    public void setDatetime(Date Datetime) {
        this.Datetime = Datetime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;
    }
    
    
}
