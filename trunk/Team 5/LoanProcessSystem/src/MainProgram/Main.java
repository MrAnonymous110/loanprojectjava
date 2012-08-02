/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import UI.AccountDetailsFrm;
import UI.Home;
import UI.LoginFrm;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               Home homeForm= new Home(); 
               AccountDetailsFrm accForm= new AccountDetailsFrm();
               LoginFrm loginFrm = new LoginFrm(homeForm, accForm);
               
               loginFrm.setVisible(true);
               loginFrm.setLocationRelativeTo(null);
            }
        });
    }
}
