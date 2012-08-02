package UI;

import Service.Impl.LoanTypeImp;
import com.sun.corba.se.impl.io.TypeMismatchException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LoanTypeManagerFrm extends JFrame {

    private JTable table;
    private LoanTypeImp LT;
    private ResultSet rs;

    public LoanTypeManagerFrm() {
        super();
        loadData();
        initComponent();
    }

    private void initComponent() {
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        JButton addButton = new JButton("Add Loan Type");
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                btnAddLoan_actionPerform();
            }
        });

        JButton removeButton = new JButton("Delete Selected Loan Type");
        removeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                btnDeleteLoan_actionPerform();
            }
        });

        JButton updateButton = new JButton("Update Loan Type");
        updateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                btnUpdateLoanType_Actionperform();
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(updateButton);
        inputPanel.add(btnCancel);

        JScrollPane jsTable = new JScrollPane(table);
        Container container = getContentPane();
        container.add(jsTable, BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.SOUTH);
        table.setAutoCreateRowSorter(false);



        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(w * 3 / 4, h * 4 / 5);
        setLocation((w - w * 3 / 4) / 2, (h - h * 4 / 5) / 2);
        setTitle("Loan Types");
        setVisible(true);
        setResizable(true);
    }

    private void btnDeleteLoan_actionPerform() throws HeadlessException {
        int i = table.getSelectedRow();
        if (i >= 0) {
            try {
                int confirm = JOptionPane.showConfirmDialog(null, "confirm delete?", "delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    rs.absolute(i + 1);
                    if (LT.DelLoanType(rs.getInt("TypeID"))) {
                        JOptionPane.showMessageDialog(null, "delete done");
                    }
                }
                new LoanTypeManagerFrm().setVisible(true);
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose one row.");
        }

    }

    private void btnUpdateLoanType_Actionperform() throws HeadlessException, NumberFormatException {
        int i = table.getSelectedRow();
        int ID;
        if (i >= 0) {
            try {
                rs.absolute(i + 1);
                ID = rs.getInt("TypeID");
                JTextField txtTypeName = new JTextField(10);
                txtTypeName.setText(table.getValueAt(i, 0).toString());
                JTextField txtInterestRate = new JTextField(4);
                txtInterestRate.setText(table.getValueAt(i, 1).toString());
                JTextField txtDescription = new JTextField(20);
                txtDescription.setText(table.getValueAt(i, 2).toString());

                JPanel inputPan = new JPanel();
                inputPan.add(new JLabel("Name Loan Type:"));
                inputPan.add(txtTypeName);
                inputPan.add(Box.createHorizontalStrut(15));
                inputPan.add(new JLabel("Interest rate:"));
                inputPan.add(txtInterestRate);
                inputPan.add(Box.createHorizontalStrut(15));
                inputPan.add(new JLabel("Description:"));
                inputPan.add(txtDescription);
                int result = JOptionPane.showConfirmDialog(null, inputPan, "input new value", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    float rate = Float.valueOf(txtInterestRate.getText());
                    LT.changeLoanType(ID, txtTypeName.getText(), rate, txtDescription.getText());
                    JOptionPane.showMessageDialog(null, "update success");
                    new LoanTypeManagerFrm().setVisible(true);
                    dispose();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose one row.");
        }
    }

    private void btnAddLoan_actionPerform() throws HeadlessException {
        JTextField txtTypeName = new JTextField(10);
        JTextField txtInterestRate = new JTextField(5);
        JTextField txtDescription = new JTextField(20);
        JPanel inputPan = new JPanel();
        inputPan.add(new JLabel("Name of new Loan Type:"));
        inputPan.add(txtTypeName);
        inputPan.add(Box.createHorizontalStrut(15));
        inputPan.add(new JLabel("Interest rate:"));
        inputPan.add(txtInterestRate);
        inputPan.add(Box.createHorizontalStrut(15));
        inputPan.add(new JLabel("Description:"));
        inputPan.add(txtDescription);
        int result = JOptionPane.showConfirmDialog(null, inputPan, "enter new Loan Type", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                float rate = Float.valueOf(txtInterestRate.getText());
                LT.InsertLoanType(txtTypeName.getText(), rate, txtDescription.getText());
                JOptionPane.showMessageDialog(null, "add success");
//                String[] newType = {txtTypeName.getText(), txtInterestRate.getText(), txtDescription.getText()};
                new LoanTypeManagerFrm().setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "wrong type input");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private void loadData() throws HeadlessException {
        LT = new LoanTypeImp();
        try {
            rs = LT.getAllLoanType();
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData RSmetaData = rs.getMetaData();
            int colNum = RSmetaData.getColumnCount();
            for (int i = 2; i < colNum + 1; i++) {
                String comName = RSmetaData.getColumnName(i);
                model.addColumn(comName);
            }
            Object[] row = new Object[colNum];
            while (rs.next()) {
                for (int j = 2; j < colNum + 1; j++) {
                    row[j - 2] = rs.getObject(j);
                }
                model.addRow(row);
            }
            table = new JTable() {

                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            table.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void main(String args[]) {
        LoanTypeManagerFrm loanTypeManager = new LoanTypeManagerFrm();
    }
}
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosed(java.awt.event.WindowEvent evt) {
//                loadParrent(evt);
//            }
//
//            private void loadParrent(WindowEvent evt) {
//                new  LoanTypeManagerFrm().setVisible(true);
//            }
//        });