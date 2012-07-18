/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Process.Admin;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Administrator
 */
public class Home extends javax.swing.JFrame {
    Admin admin;
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnLoans = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnAccount = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnBill = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnHelp = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnBranches = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnExit = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbHello = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(647, 473));
        setMinimumSize(new java.awt.Dimension(647, 473));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Loan Process System");
        jPanel1.add(jLabel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnLoans.setBackground(new java.awt.Color(255, 51, 51));
        pnLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnLoansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnLoansMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Loans Manager");

        javax.swing.GroupLayout pnLoansLayout = new javax.swing.GroupLayout(pnLoans);
        pnLoans.setLayout(pnLoansLayout);
        pnLoansLayout.setHorizontalGroup(
            pnLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoansLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(24, 24, 24))
        );
        pnLoansLayout.setVerticalGroup(
            pnLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoansLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnAccount.setBackground(new java.awt.Color(255, 255, 51));
        pnAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnAccountMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Account Manager");

        javax.swing.GroupLayout pnAccountLayout = new javax.swing.GroupLayout(pnAccount);
        pnAccount.setLayout(pnAccountLayout);
        pnAccountLayout.setHorizontalGroup(
            pnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(21, 21, 21))
        );
        pnAccountLayout.setVerticalGroup(
            pnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnBill.setBackground(new java.awt.Color(0, 255, 255));
        pnBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnBillMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Bill Manager");

        javax.swing.GroupLayout pnBillLayout = new javax.swing.GroupLayout(pnBill);
        pnBill.setLayout(pnBillLayout);
        pnBillLayout.setHorizontalGroup(
            pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBillLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(32, 32, 32))
        );
        pnBillLayout.setVerticalGroup(
            pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBillLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnHelp.setBackground(new java.awt.Color(255, 204, 204));
        pnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnHelpMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Help");

        javax.swing.GroupLayout pnHelpLayout = new javax.swing.GroupLayout(pnHelp);
        pnHelp.setLayout(pnHelpLayout);
        pnHelpLayout.setHorizontalGroup(
            pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(53, 53, 53))
        );
        pnHelpLayout.setVerticalGroup(
            pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnBranches.setBackground(new java.awt.Color(102, 255, 102));
        pnBranches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnBranchesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnBranchesMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Branches Manager");

        javax.swing.GroupLayout pnBranchesLayout = new javax.swing.GroupLayout(pnBranches);
        pnBranches.setLayout(pnBranchesLayout);
        pnBranchesLayout.setHorizontalGroup(
            pnBranchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBranchesLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(21, 21, 21))
        );
        pnBranchesLayout.setVerticalGroup(
            pnBranchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBranchesLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnExit.setBackground(new java.awt.Color(153, 153, 0));
        pnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnExitMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Exit");

        javax.swing.GroupLayout pnExitLayout = new javax.swing.GroupLayout(pnExit);
        pnExit.setLayout(pnExitLayout);
        pnExitLayout.setHorizontalGroup(
            pnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnExitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        pnExitLayout.setVerticalGroup(
            pnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnExitLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbHello.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHello.setForeground(new java.awt.Color(51, 51, 255));
        lbHello.setText("Welcome Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnLoans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHello)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnBranches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHello)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBranches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        lbHello.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_pnExitMouseClicked

    private void pnLoansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLoansMouseEntered
        // TODO add your handling code here:
        pnLoans.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnLoansMouseEntered

    private void pnLoansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLoansMouseExited
        // TODO add your handling code here:
        pnLoans.setBorder(null);
    }//GEN-LAST:event_pnLoansMouseExited

    private void pnAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAccountMouseEntered
        // TODO add your handling code here:
        pnAccount.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnAccountMouseEntered

    private void pnAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAccountMouseExited
        // TODO add your handling code here:
        pnAccount.setBorder(null);
    }//GEN-LAST:event_pnAccountMouseExited

    private void pnBranchesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBranchesMouseEntered
        // TODO add your handling code here:
        pnBranches.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnBranchesMouseEntered

    private void pnBranchesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBranchesMouseExited
        // TODO add your handling code here:
        pnBranches.setBorder(null);
    }//GEN-LAST:event_pnBranchesMouseExited

    private void pnBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBillMouseEntered
        // TODO add your handling code here:
        pnBill.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnBillMouseEntered

    private void pnBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBillMouseExited
        // TODO add your handling code here:
        pnBill.setBorder(null);
    }//GEN-LAST:event_pnBillMouseExited

    private void pnHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHelpMouseEntered
        // TODO add your handling code here:
        pnHelp.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnHelpMouseEntered

    private void pnHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHelpMouseExited
        // TODO add your handling code here:
        pnHelp.setBorder(null);
    }//GEN-LAST:event_pnHelpMouseExited

    private void pnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnExitMouseEntered
        // TODO add your handling code here:
        pnExit.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnExitMouseEntered

    private void pnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnExitMouseExited
        // TODO add your handling code here:
        pnExit.setBorder(null);
    }//GEN-LAST:event_pnExitMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
         lbHello.setText("Welcome, "+admin.getFullname().toUpperCase()+"!");
    }//GEN-LAST:event_formWindowActivated

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbHello;
    private javax.swing.JPanel pnAccount;
    private javax.swing.JPanel pnBill;
    private javax.swing.JPanel pnBranches;
    private javax.swing.JPanel pnExit;
    private javax.swing.JPanel pnHelp;
    private javax.swing.JPanel pnLoans;
    // End of variables declaration//GEN-END:variables
}
