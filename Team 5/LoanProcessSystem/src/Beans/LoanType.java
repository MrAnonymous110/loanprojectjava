/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class LoanType {

    private int TypeCode;
    private String TypeName;
    private float InterestRate;
    private String Description;

    public LoanType() {
 
    }

    public LoanType(int TypeCode, String TypeName, float InterestRate, String Description) {
        this.TypeCode = TypeCode;
        this.TypeName = TypeName;
        this.InterestRate = InterestRate;
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(float InterestRate) {
        this.InterestRate = InterestRate;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
    
    
}