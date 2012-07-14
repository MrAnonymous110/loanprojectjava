/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Administrator
 */
public class LoanType {
    private String TypeCode;
    private String TypeName;
    private int InterestRate;
    private String Description;
    
    public LoanType(){}

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(int InterestRate) {
        this.InterestRate = InterestRate;
    }

    public String getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(String TypeCode) {
        this.TypeCode = TypeCode;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
    
    
}
