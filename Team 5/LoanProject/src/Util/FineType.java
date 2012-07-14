/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Administrator
 */
public class FineType {
    private int TypeCode;
    private int Fine;
    private String Description;
    
    public FineType(){}

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getFine() {
        return Fine;
    }

    public void setFine(int Fine) {
        this.Fine = Fine;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;
    }
    
    
}
