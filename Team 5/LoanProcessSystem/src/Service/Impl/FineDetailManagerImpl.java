/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Beans.FineDetails;
import DbConnection.MSSQLDbConnection;
import Service.FineDetailManager;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sun.io.Converters;

/**
 *
 * @author babman92
 */
public class FineDetailManagerImpl implements FineDetailManager {

    MSSQLDbConnection msssqlConnection;
    InstallmentMonthlyManagerImpl InsMonthlyImpl;
    FineDetails fine;

    public FineDetailManagerImpl() {
        msssqlConnection = new MSSQLDbConnection();
        fine = new FineDetails();
    }

    @Override
    public boolean Insert(FineDetails fine) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            //String sql = "call sp_FineDetails_Insert(?,?,?,?,?)";
            String sql = "Insert into [FineDetails] ([AccountNo],[TypeID],[Money],[Description],[Datetime],[State]) Values(?,?,?,?,?,?)";
            CallableStatement cs = cn.prepareCall(sql);
            String datetime = GetDateTimeNow();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateUtil = null;
            try {
                dateUtil = format.parse(datetime);
            } catch (ParseException ex) {
                Logger.getLogger(FineDetailManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date dateSql = new Date(dateUtil.getTime());
            cs.setString(1, fine.getAccountNo());
            cs.setInt(2, fine.getTypeCode());
            cs.setFloat(3, fine.getMoney());
            cs.setString(4, fine.getDescription());
            cs.setDate(5, dateSql);
            cs.setInt(6, 0);
            int count = cs.executeUpdate();
            cs.close();
            cn.close();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Vector GetListFromTable(String sql) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
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
                fine.addElement(rs.getInt("State"));
                list.addElement(fine);
            }
            cn.close();
            return list;
        } catch (SQLException ex) {
            return new Vector();
        }
    }

    @Override
    public int CalCountMonthOfLoan(int[] datetimeBegin, int[] datetimeFinish) {
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

    @Override
    public void CalFine() {
        InsMonthlyImpl = new InstallmentMonthlyManagerImpl();
        Vector CustomerID = GetDataFromColumn("AccountNo");
        boolean ok = false;
        for (int j = 0; j < CustomerID.size(); j++) {
            int[] datetimeCurrent = GetDateFromString(GetDateTimeNow());
            String sql = "Select TOP 1 * from [InstallmentMonthly] Where [State]=0 And [CustomerID] ='" + CustomerID.get(j).toString().trim() + "'";
            Vector InstallmentMonthly = InsMonthlyImpl.GetListFromTable(sql);
            Float FineRate = null;
            String PayDate;
            int TypeCode = 0;
            String Account;
            for (int i = 0; i < InstallmentMonthly.size(); i++) {
                PayDate = ((Vector) InstallmentMonthly.elementAt(i)).elementAt(4).toString();
                Account = ((Vector) InstallmentMonthly.elementAt(i)).elementAt(0).toString();
                int[] PayDateArr = new int[3];
                PayDateArr = GetDateFromString(PayDate);
//                JOptionPane.showMessageDialog(null, PayDate +" "+ Account);
                if (PayDateArr[2] == datetimeCurrent[2]) {
                    //JOptionPane.showMessageDialog(null, PayDateArr[2]);
                    if (PayDateArr[1] == datetimeCurrent[1]) {
                        //JOptionPane.showMessageDialog(null, PayDateArr[1] +" "+ datetimeCurrent[1]);
                        if (datetimeCurrent[0] > PayDateArr[0]) {
                            Float total = Float.parseFloat(((Vector) InstallmentMonthly.elementAt(i)).elementAt(3).toString());
                            if (total > 1 && total < 5000) {
                                FineRate = new Float(0.02);
                                TypeCode = 2;
                            }
                            if (total > 5001 && total < 20000) {
                                FineRate = new Float(0.05);
                                TypeCode = 3;
                            }
                            if (total > 20001) {
                                FineRate = new Float(0.08);
                                TypeCode = 4;
                            }
                            fine.setAccountNo(Account);
                            fine.setDatetime(Date.valueOf(GetDateTimeNow()));
                            fine.setDescription("Fine in: " + PayDate);
                            fine.setMoney(FineRate * total);
                            fine.setTypeCode(TypeCode);
                            ok = Insert(fine);
                        }
                    }
                }
            }
        }
        if (ok) {
            JOptionPane.showMessageDialog(null, "Generate Fine Sucessfuly.");
        } else {
            JOptionPane.showMessageDialog(null, "Generate Fine Fail.");
        }

    }

    @Override
    public int[] GetDateFromString(String date) {
        int[] DateTime;
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datetime = null;
        try {
            datetime = Format.parse(date);
        } catch (ParseException ex) {
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(datetime);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        DateTime = new int[]{day, month, year};
        return DateTime;
    }

    @Override
    public String GetDateTimeNow() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarCurrent = Calendar.getInstance();
        String DateNow = formatDate.format(calendarCurrent.getTime());
        return DateNow;
    }

    @Override
    public Vector GetListLoanDetail(String sql) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
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
            rs.close();
            cn.close();
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Vector GetDataFromColumn(String ColName) {
        try {
            msssqlConnection.registerDriver();
            Connection cn = msssqlConnection.createConnection();
            String sql = "Select [" + ColName + "] From [LoanDetails]";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Vector list = new Vector();
            while (rs.next()) {
                //Vector fineType = new Vector();
                list.addElement(rs.getString(ColName));
                //list.addElement(fineType);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Vector Search(String CustomerID, int TypeID) {
        String sql = "Select * From [FineDetails] Where [AccountNo] LIKE '%" + CustomerID + "%' And [TypeID] = " + TypeID + "";
        Vector ResultSearch = GetListFromTable(sql);
        return ResultSearch;
    }
}
