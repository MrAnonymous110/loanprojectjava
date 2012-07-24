/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.datatype.Duration;

/**
 *
 * @author Administrator
 */
public class FineDetails {

    private int ID;
    private int TypeCode;
    private String AccountNo;
    private double Money;
    private String Description;
    private Date Datetime;

    public FineDetails() {
    }

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

    public double getMoney() {
        return Money;
    }

    public void setMoney(double Money) {
        this.Money = Money;
    }

    public int getTypeCode() {
        return TypeCode;
    }

    public void setTypeCode(int TypeCode) {
        this.TypeCode = TypeCode;

    }

    public boolean insert() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            String sql = "call sp_FineDetails_Insert(?,?,?,?,?)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, this.getAccountNo());
            cs.setInt(2, this.getTypeCode());
            cs.setDouble(3, this.getMoney());
            cs.setString(4, getDescription());
            cs.setDate(5, getDatetime());
            int count = cs.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean Update() {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            String sql = "call sp_FineDetails_Update(?,?,?,?,?,?)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, getID());
            cs.setString(2, getAccountNo());
            cs.setInt(3, this.getTypeCode());
            cs.setDouble(4, this.getMoney());
            cs.setString(5, this.getDescription());
            cs.setDate(6, this.getDatetime());
            if (cs.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }

    public static Vector getList(String sql) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector fine = new Vector();
                fine.addElement(rs.getInt("FineID"));
                fine.addElement(rs.getString("AccountNo"));
                fine.addElement(rs.getInt("TypeID"));
                fine.addElement(rs.getFloat("Money"));
                fine.addElement(rs.getString("Description"));
                fine.addElement(rs.getDate("Datetime"));
                list.addElement(fine);
            }
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    public static Vector getListLoanDetails(String sql) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector Duration = new Vector();
                Duration.addElement(rs.getDate("BeginTime"));
                Duration.addElement(rs.getDate("EndTime"));
                Duration.addElement(rs.getFloat("LoanMoney"));
                Duration.addElement(rs.getFloat("CurentMoney"));
                list.addElement(Duration);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    private static int CalCountMonth(int[] datetimeBegin, int[] datetimeFinish) {
        int MonthBegin = datetimeBegin[1];
        int YearBegin = datetimeBegin[2];
        int MonthFinish = datetimeFinish[1];
        int YearFinish = datetimeFinish[2];
        int countMonth = 0;
        if (MonthFinish > MonthBegin) {
            if (YearFinish - YearBegin == 0) {
                countMonth = MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 1) {
                countMonth = 12 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 2) {
                countMonth = 24 + MonthFinish - MonthBegin;
            }

            if (YearFinish - YearBegin == 3) {
                countMonth = 36 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 4) {
                countMonth = 48 + MonthFinish - MonthBegin;
            }

            if (YearFinish - YearBegin == 5) {
                countMonth = 60 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 6) {
                countMonth = 72 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 7) {
                countMonth = 84 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 8) {
                countMonth = 96 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 9) {
                countMonth = 108 + MonthFinish - MonthBegin;
            }
            if (YearFinish - YearBegin == 10) {
                countMonth = 120 + MonthFinish - MonthBegin;
            }
        } else {
            if (MonthFinish < MonthBegin) {
                if (YearFinish - YearBegin == 1) {
                    countMonth = (12 - MonthBegin) + MonthFinish;
                }
                if (YearFinish - YearBegin == 2) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 12;
                }
                if (YearFinish - YearBegin == 3) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 24;
                }
                if (YearFinish - YearBegin == 4) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 36;
                }
                if (YearFinish - YearBegin == 5) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 48;
                }
                if (YearFinish - YearBegin == 6) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 60;
                }
                if (YearFinish - YearBegin == 7) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 72;
                }
                if (YearFinish - YearBegin == 8) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 84;
                }
                if (YearFinish - YearBegin == 9) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 96;
                }
                if (YearFinish - YearBegin == 10) {
                    countMonth = (12 - MonthBegin) + MonthFinish + 108;
                }
            }
        }
        return countMonth;
    }

    private static Float[] CalMonthlyAllInstallment(int CountMonth, Float Rate, Float LoanMoney, Float CurrentMoney) {
        Float MonthlyInstallment = LoanMoney / CountMonth;
        Float[] Result = new Float[CountMonth];
        for (int i = 0; i < CountMonth; i++) {
            Result[i] = MonthlyInstallment + CalMonthlyRate(Rate, CurrentMoney);
        }
        return Result;
    }

    private static Float CalMonthlyRate(Float Rate, Float CurrentMoney) {
        return CurrentMoney * Rate;
    }

    public static void CalFine() {
        Vector Duration = getListLoanDetails("Select [BeginTime], [EndTime],[LoanMoney],[CurentMoney] From [LoanDetails]");
        String BeginDateStr = ((Vector) Duration.elementAt(0)).get(0).toString();
        String FinishDateStr = ((Vector) Duration.elementAt(0)).get(1).toString();
        Float LoanMoney = Float.parseFloat(((Vector) Duration.elementAt(0)).get(2).toString());
        Float CurrentMoney = Float.parseFloat(((Vector) Duration.elementAt(0)).get(3).toString());
        int[] datetimeBegin = GetDateFromString(BeginDateStr);
        int[] datetimeFinish = GetDateFromString(FinishDateStr);
        int[] datetimeCurrent = GetDateFromString(GetDateTimeNow());
        int countMonth = CalCountMonth(datetimeBegin, datetimeFinish);
        Double RateDouble = 0.1;
        Float Rate = Float.parseFloat(RateDouble.toString());
        Float[] MonthlyAllInstallment = CalMonthlyAllInstallment(countMonth, Rate, LoanMoney, CurrentMoney);
        
        //Float CurrentMonthlyRate = CalMonthlyRate(Rate, CurrentMoney);
//        
//        for (int i = 0; i < countMonth; i++) {
//            System.out.println("So tien phai tra thang thu " + 1 + ": " + MonthlyAllInstallment[i] + "\n");
//        }
        //        JOptionPane.showMessageDialog(null, LoanMoney +", "+CurrentMoney);
    }

    private static Vector GetFineType(int FineType) {
        try {
            LoanConnection.registerDriver();
            Connection cn = LoanConnection.createConnection();
            PreparedStatement stm = cn.prepareStatement("Select [Fine] From [FineType] Where [TypeID]={" + FineType + "}");
            ResultSet rs = stm.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                Vector fine = new Vector();
                fine.addElement(rs.getFloat("Fine"));
                list.addElement(fine);
            }
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    public static int[] GetDateFromString(String date) {
        int[] DateTime;
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datetime = null;
        try {
            datetime = Format.parse(date);
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

    private static String GetDateTimeNow() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarCurrent = Calendar.getInstance();
        String DateNow = formatDate.format(calendarCurrent.getTime());
        return DateNow;
    }
}
