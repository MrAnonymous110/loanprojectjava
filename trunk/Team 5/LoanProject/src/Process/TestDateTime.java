/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author babman92
 */
public class TestDateTime {

    public void testDate() {
        //Calendar cal = Calendar.getInstance();
        SimpleDateFormat Format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = Format.parse("22-07-2012");
        } catch (ParseException ex) {
            Logger.getLogger(TestDateTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("Current Date: " + cal.getTime());
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        System.out.println("Day of Week: " + dow);
        System.out.println("Day of Month: " + dom);
        System.out.println("Day of Year: " + doy);
    }

    public void testDate1() {
        Calendar mydate = new GregorianCalendar();
        String mystring = "22-7-2012";
        Date thedate = null;
        try {
            thedate = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE).parse(mystring);


        } catch (ParseException ex) {
            Logger.getLogger(TestDateTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        mydate.setTime(thedate);
//breakdown
        System.out.println("mydate -> " + mydate);
        System.out.println("year   -> " + mydate.get(Calendar.YEAR));
        System.out.println("month  -> " + mydate.get(Calendar.MONTH));
        System.out.println("dom    -> " + mydate.get(Calendar.DAY_OF_MONTH));
        System.out.println("dow    -> " + mydate.get(Calendar.DAY_OF_WEEK));
        System.out.println("hour   -> " + mydate.get(Calendar.HOUR));
        System.out.println("minute -> " + mydate.get(Calendar.MINUTE));
        System.out.println("second -> " + mydate.get(Calendar.SECOND));
        System.out.println("milli  -> " + mydate.get(Calendar.MILLISECOND));
        System.out.println("ampm   -> " + mydate.get(Calendar.AM_PM));
        System.out.println("hod    -> " + mydate.get(Calendar.HOUR_OF_DAY));
    }

    public int[] testDate2() {
        int[] DateTime;
        SimpleDateFormat Format = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date datetime = null;
        try {
            datetime = Format.parse("22-07-2012");
        } catch (ParseException ex) {
            Logger.getLogger(TestDateTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(datetime);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        DateTime = new int[]{day, month, year};
        return DateTime;
    }

    public static void main(String[] args) {
//        TestDateTime testDateTime = new TestDateTime();
//        int[] result = testDateTime.testDate2();
//        System.out.println("Day: "+result[0]+" Month:"+result[1]+" Year:"+result[2]);
        
    }
}
