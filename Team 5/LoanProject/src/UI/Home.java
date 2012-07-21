/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Process.Admin;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Administrator
 */
public class Home extends javax.swing.JFrame {
    Admin admin ;
    AccountManager accManager;
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();    
        accManager = new AccountManager();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnLoans = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnAdmin = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnBranches = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnFines = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnExit = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnHelp = new javax.swing.JPanel();
        lbHelp = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pnBills = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pnAccount = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(647, 473));
        setMinimumSize(new java.awt.Dimension(647, 473));

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font(".VnAristoteH", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Loan Process System");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        pnLoans.setBackground(new java.awt.Color(255, 51, 51));
        pnLoans.setPreferredSize(new java.awt.Dimension(204, 217));
        pnLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnLoansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnLoansMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Loans Manager");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loan-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnLoansLayout = new javax.swing.GroupLayout(pnLoans);
        pnLoans.setLayout(pnLoansLayout);
        pnLoansLayout.setHorizontalGroup(
            pnLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoansLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLoansLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoansLayout.createSequentialGroup()
                        .addGap(0, 56, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(57, 57, 57))))
        );
        pnLoansLayout.setVerticalGroup(
            pnLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoansLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnAdmin.setBackground(new java.awt.Color(255, 51, 51));
        pnAdmin.setPreferredSize(new java.awt.Dimension(204, 217));
        pnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnAdminMouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Welcome Admin");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnAdminLayout = new javax.swing.GroupLayout(pnAdmin);
        pnAdmin.setLayout(pnAdminLayout);
        pnAdminLayout.setHorizontalGroup(
            pnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAdminLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAdminLayout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(57, 57, 57))))
        );
        pnAdminLayout.setVerticalGroup(
            pnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnBranches.setBackground(new java.awt.Color(255, 51, 51));
        pnBranches.setPreferredSize(new java.awt.Dimension(204, 217));
        pnBranches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnBranchesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnBranchesMouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Branches Manager");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bank-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnBranchesLayout = new javax.swing.GroupLayout(pnBranches);
        pnBranches.setLayout(pnBranchesLayout);
        pnBranchesLayout.setHorizontalGroup(
            pnBranchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBranchesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBranchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBranchesLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBranchesLayout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(57, 57, 57))))
        );
        pnBranchesLayout.setVerticalGroup(
            pnBranchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBranchesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnFines.setBackground(new java.awt.Color(255, 51, 51));
        pnFines.setPreferredSize(new java.awt.Dimension(204, 217));
        pnFines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnFinesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnFinesMouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Fines Manager");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fines-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnFinesLayout = new javax.swing.GroupLayout(pnFines);
        pnFines.setLayout(pnFinesLayout);
        pnFinesLayout.setHorizontalGroup(
            pnFinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFinesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFinesLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFinesLayout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(57, 57, 57))))
        );
        pnFinesLayout.setVerticalGroup(
            pnFinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFinesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnExit.setBackground(new java.awt.Color(255, 51, 51));
        pnExit.setPreferredSize(new java.awt.Dimension(204, 217));
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

        lbExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbExit.setForeground(new java.awt.Color(255, 255, 255));
        lbExit.setText("Exit");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnExitLayout = new javax.swing.GroupLayout(pnExit);
        pnExit.setLayout(pnExitLayout);
        pnExitLayout.setHorizontalGroup(
            pnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnExitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnExitLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnExitLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbExit)
                        .addGap(94, 94, 94))))
        );
        pnExitLayout.setVerticalGroup(
            pnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnExitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnHelp.setBackground(new java.awt.Color(255, 51, 51));
        pnHelp.setPreferredSize(new java.awt.Dimension(204, 217));
        pnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnHelpMouseExited(evt);
            }
        });

        lbHelp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHelp.setForeground(new java.awt.Color(255, 255, 255));
        lbHelp.setText("Help");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnHelpLayout = new javax.swing.GroupLayout(pnHelp);
        pnHelp.setLayout(pnHelpLayout);
        pnHelpLayout.setHorizontalGroup(
            pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHelpLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        pnHelpLayout.setVerticalGroup(
            pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnBills.setBackground(new java.awt.Color(255, 51, 51));
        pnBills.setPreferredSize(new java.awt.Dimension(204, 217));
        pnBills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnBillsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnBillsMouseExited(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Bills Manager");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnBillsLayout = new javax.swing.GroupLayout(pnBills);
        pnBills.setLayout(pnBillsLayout);
        pnBillsLayout.setHorizontalGroup(
            pnBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBillsLayout.createSequentialGroup()
                .addGroup(pnBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBillsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(pnBillsLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnBillsLayout.setVerticalGroup(
            pnBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBillsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnAccount.setBackground(new java.awt.Color(255, 51, 51));
        pnAccount.setPreferredSize(new java.awt.Dimension(204, 217));
        pnAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnAccountMouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Account Manager");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customer-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout pnAccountLayout = new javax.swing.GroupLayout(pnAccount);
        pnAccount.setLayout(pnAccountLayout);
        pnAccountLayout.setHorizontalGroup(
            pnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAccountLayout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountLayout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(57, 57, 57))))
        );
        pnAccountLayout.setVerticalGroup(
            pnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnBills, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnFines, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBranches, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(pnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(733, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnBranches, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnFines, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnBills, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(pnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnLoansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLoansMouseEntered
        // TODO add your handling code here:
        pnLoans.setBorder(BorderFactory.createEtchedBorder());
        pnLoans.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnLoansMouseEntered

    private void pnLoansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLoansMouseExited
        // TODO add your handling code here:
        pnLoans.setBorder(null);
        pnLoans.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnLoansMouseExited

    private void pnAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAdminMouseEntered
        // TODO add your handling code here:
         pnAdmin.setBorder(BorderFactory.createEtchedBorder());
         pnAdmin.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnAdminMouseEntered

    private void pnAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAdminMouseExited
        // TODO add your handling code here:
        pnAdmin.setBorder(null);
        pnAdmin.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnAdminMouseExited

    private void pnBranchesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBranchesMouseEntered
        // TODO add your handling code here:
         pnBranches.setBorder(BorderFactory.createEtchedBorder());
         pnBranches.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnBranchesMouseEntered

    private void pnBranchesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBranchesMouseExited
        // TODO add your handling code here:
        pnBranches.setBorder(null);
        pnBranches.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnBranchesMouseExited

    private void pnFinesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnFinesMouseEntered
        // TODO add your handling code here:
         pnFines.setBorder(BorderFactory.createEtchedBorder());
         pnFines.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnFinesMouseEntered

    private void pnFinesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnFinesMouseExited
        // TODO add your handling code here:
         pnFines.setBorder(null);
         pnFines.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnFinesMouseExited

    private void pnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnExitMouseEntered
        // TODO add your handling code here:
         pnExit.setBorder(BorderFactory.createEtchedBorder());
         pnExit.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnExitMouseEntered

    private void pnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnExitMouseExited
        // TODO add your handling code here:
         pnExit.setBorder(null);
         pnExit.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnExitMouseExited

    private void pnHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHelpMouseEntered
        // TODO add your handling code here:
         pnHelp.setBorder(BorderFactory.createEtchedBorder());
         pnHelp.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnHelpMouseEntered

    private void pnHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHelpMouseExited
        // TODO add your handling code here:
         pnHelp.setBorder(null);
         pnHelp.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnHelpMouseExited

    private void pnBillsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBillsMouseEntered
        // TODO add your handling code here:
         pnBills.setBorder(BorderFactory.createEtchedBorder());
         pnBills.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnBillsMouseEntered

    private void pnBillsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBillsMouseExited
        // TODO add your handling code here:
         pnBills.setBorder(null);
         pnBills.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnBillsMouseExited

    private void pnAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAccountMouseEntered
        // TODO add your handling code here:
         pnAccount.setBorder(BorderFactory.createEtchedBorder());
         pnAccount.setBackground(new Color(255, 153, 10));
    }//GEN-LAST:event_pnAccountMouseEntered

    private void pnAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAccountMouseExited
        // TODO add your handling code here:
         pnAccount.setBorder(null);
         pnAccount.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_pnAccountMouseExited

    private void pnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_pnExitMouseClicked

    private void pnAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAccountMouseClicked
        // TODO add your handling code here:
        accManager.setVisible(true);
        accManager.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        accManager.setLocationRelativeTo(null);
    }//GEN-LAST:event_pnAccountMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbHelp;
    private javax.swing.JPanel pnAccount;
    private javax.swing.JPanel pnAdmin;
    private javax.swing.JPanel pnBills;
    private javax.swing.JPanel pnBranches;
    private javax.swing.JPanel pnExit;
    private javax.swing.JPanel pnFines;
    private javax.swing.JPanel pnHelp;
    private javax.swing.JPanel pnLoans;
    // End of variables declaration//GEN-END:variables
}
