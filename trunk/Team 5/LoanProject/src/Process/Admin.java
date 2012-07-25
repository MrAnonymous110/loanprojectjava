/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Admin {
    //Property of Admin
    private String Username;
    private String password;
    private String Fullname;
    //Contructor default
    public Admin(){}
    //set,get method
    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    //user for login
    public boolean isExisted()
     {
        try {
            LoanConnection.registerDriver();
            Connection cn= LoanConnection.createConnection();     
            if(cn!=null)
            {
               String sql = "{call sp_Admin_SelectRow(?,?)}";
               CallableStatement cs= cn.prepareCall(sql);
               cs.setString(1,this.getUsername());
               cs.setString(2, this.getPassword());
               cs.setString(1,this.getUsername()); 
               cs.setString(2,this.getPassword()); 
               ResultSet rs = cs.executeQuery();
               if(rs.next())
               {
                  this.setFullname(rs.getString("FullName"));
                  return true;
               }
               return false;
           }
           else{
               JOptionPane.showMessageDialog(null, "Can'not connect database");
               return false;
           }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
     //Register new Admin
     public void register(){
        try {
            LoanConnection.registerDriver();
            Connection cn= LoanConnection.createConnection();
            
            String sql="INSERT INTO Admin (Username,Password,Fullname) values (?,?,?)";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1,this.getUsername());
            stm.setString(2, this.getPassword());
            stm.setString(3,this.getFullname());
            boolean isOK= stm.execute();
            if(isOK)
                JOptionPane.showMessageDialog(null,"Register successful! Please login!");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    //Change password
     public boolean changePassword(String newPass)
     {
        try {
            LoanConnection.registerDriver();
            Connection cn= LoanConnection.createConnection();
            
            String sql="Update Admin set Password=? where Username=?";
            PreparedStatement stm= cn.prepareStatement(sql);
            stm.setString(1,newPass);
            stm.setString(2,this.getUsername());
            boolean isOK= stm.execute();
            return isOK;
        } catch (SQLException ex) {
            return false;
        }
     }
     
     
}
