/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Service.Validate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class ValidateImpl implements Validate {

    @Override
    public boolean isEmail(String email) {
       String regex= "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       if(!isMatches(email, regex)){
           return false;
       }  
       return true;
    }

    @Override
    public boolean isDate(String date) {
       SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
       if (date.length() != dateFormat.toPattern().length()){
           return false;
       }
        dateFormat.setLenient(false);
    
       try {
           //parse the inDate parameter
            dateFormat.parse(date.trim());
            return true;
       }
       catch (ParseException pe) {
            return false;
       }
    }

    @Override
    public boolean isPhone(String phone) {
       if(!isNumber(phone) || phone.length()<10 || phone.length()>12)
       {
           return false;
       }
       return true;
    }

    @Override
    public boolean isNumber(String str) {
       String regex="\\d+";
       if(!isMatches(str, regex))
       {
           return false;
       }
       return true;
    }

    @Override
    public boolean isMatches(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
}
