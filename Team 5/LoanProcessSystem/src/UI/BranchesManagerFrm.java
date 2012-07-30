/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Beans.Branches;
import Service.Impl.BranchesManagerImpl;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author babman92
 */
public class BranchesManagerFrm extends javax.swing.JFrame {

    /**
     * Creates new form BranchesManagerFrm
     */
    int flag = 1;
    JPopupMenu popMenu;
    JMenuItem menuItem;
    BranchesManagerImpl brancheImpl;

    public BranchesManagerFrm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        brancheImpl = new BranchesManagerImpl();
        Vector data = brancheImpl.GetListFromTable("Select * From [Branches]");
        ShowDataIntoTable(data);
    }

    private void ShowDataIntoTable(Vector data) {
        Vector column = new Vector();
        column.addElement("BranchesID");
        column.addElement("Name");
        column.addElement("Address");
        column.addElement("Email");
        column.addElement("Phone");
        column.addElement("Block");
        TableModel model = new DefaultTableModel(data, column);
        tblBranches.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        txfID = new javax.swing.JTextField();
        txfName = new javax.swing.JTextField();
        txfPhone = new javax.swing.JTextField();
        txfAddress = new javax.swing.JTextField();
        txfEmail = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rdSearchName = new javax.swing.JRadioButton();
        rdSearchID = new javax.swing.JRadioButton();
        txfSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBranches = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "New - Update"));
        jPanel2.setPreferredSize(new java.awt.Dimension(330, 424));

        lbID.setText("ID");

        lbName.setText("Name");

        lbAddress.setText("Address");

        lbPhone.setText("Phone");

        lbEmail.setText("Email");

        txfID.setEditable(false);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAddress)
                    .addComponent(txfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhone)
                    .addComponent(txfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSubmit))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Cotrol"));

        buttonGroup1.add(rdSearchName);
        rdSearchName.setText("Search By Name");

        buttonGroup1.add(rdSearchID);
        rdSearchID.setSelected(true);
        rdSearchID.setText("Search By ID");

        txfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(rdSearchName)
                .addGap(18, 18, 18)
                .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(884, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(rdSearchID)
                    .addContainerGap(1231, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(37, Short.MAX_VALUE)
                    .addComponent(rdSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Data"));
        jPanel4.setPreferredSize(new java.awt.Dimension(1030, 424));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tblBranches.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        tblBranches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBranches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBranchesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBranches);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setPopupMenu(final int RowIndex) {
        popMenu = new JPopupMenu();
        menuItem = new JMenuItem("Block");
        popMenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String ID = tblBranches.getModel().getValueAt(RowIndex, 0).toString();
                Branches branche = new Branches();
                BranchesManagerImpl brancheImpl = new BranchesManagerImpl();
                branche.setBranchesID(ID);
                branche.setBlock(1);
                boolean ok = brancheImpl.UpdateBlock(branche);
                if (ok) {
                    Vector data = brancheImpl.GetListFromTable("Select * From [Branches]");
                    ShowDataIntoTable(data);
                } else {
                    JOptionPane.showConfirmDialog(null, "Fail");
                }
            }
        });
        tblBranches.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    popMenu.show(me.getComponent(), me.getX(), me.getY());
                }
            }

            public void mouseReleased(MouseEvent Me) {
                if (Me.isPopupTrigger()) {
                    popMenu.show(Me.getComponent(), Me.getX(), Me.getY());
                }
            }
        });

    }

    private void tblBranchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBranchesMouseClicked
        // TODO add your handling code here:
        flag = 0;
        int RowIndex = tblBranches.getSelectedRow();
        setPopupMenu(RowIndex);
        String ID = (String) tblBranches.getModel().getValueAt(RowIndex, 0);
        String Name = (String) tblBranches.getModel().getValueAt(RowIndex, 1);
        String Address = (String) tblBranches.getModel().getValueAt(RowIndex, 2);
        String Email = (String) tblBranches.getModel().getValueAt(RowIndex, 3);
        String Phone = (String) tblBranches.getModel().getValueAt(RowIndex, 4);
        txfID.setText(ID);
        txfAddress.setText(Address);
        txfEmail.setText(Email);
        txfPhone.setText(Phone);
        txfName.setText(Name);
    }//GEN-LAST:event_tblBranchesMouseClicked

    private void txfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSearchKeyPressed
        // TODO add your handling code here:
        String search = txfSearch.getText();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            {
                if (rdSearchID.isSelected()) {
                    Vector dataSearch = brancheImpl.Search(search, 0);
                    ShowDataIntoTable(dataSearch);
                } else {
                    if (rdSearchName.isSelected()) {
                        Vector dataSearch = brancheImpl.Search(search, 1);
                        ShowDataIntoTable(dataSearch);
                    }
                }
            }
        }
    }//GEN-LAST:event_txfSearchKeyPressed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        flag = 1;
        txfEmail.setText(null);
        txfAddress.setText(null);
        txfID.setText(null);
        txfPhone.setText(null);
        txfName.setText(null);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String Code = txfID.getText();
        String Name = txfName.getText();
        String Address = txfAddress.getText();
        String Email = txfEmail.getText();
        String Phone = txfPhone.getText();
        Branches branches = new Branches();
        branches.setAddress(Address);
        branches.setEmail(Email);
        branches.setName(Name);
        branches.setPhone(Phone);
        branches.setBranchesID(Code);
        if (flag == 1) {
            boolean ok = brancheImpl.Insert(branches);
            if (ok) {
                Vector data = brancheImpl.GetListFromTable("Select * From [Branches]");
                ShowDataIntoTable(data);
            } else {
                JOptionPane.showConfirmDialog(null, "Fail");
            }
        } else {
            if (flag == 0) {
                boolean ok = brancheImpl.UpdateTable(branches);
                if (ok) {
                    Vector data = brancheImpl.GetListFromTable("Select * From [Branches]");
                    ShowDataIntoTable(data);
                } else {
                    JOptionPane.showConfirmDialog(null, "Fail");
                }
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BranchesManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BranchesManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BranchesManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchesManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BranchesManagerFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JRadioButton rdSearchID;
    private javax.swing.JRadioButton rdSearchName;
    private javax.swing.JTable tblBranches;
    private javax.swing.JTextField txfAddress;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfID;
    private javax.swing.JTextField txfName;
    private javax.swing.JTextField txfPhone;
    private javax.swing.JTextField txfSearch;
    // End of variables declaration//GEN-END:variables
}
