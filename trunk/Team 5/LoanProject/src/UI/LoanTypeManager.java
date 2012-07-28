
import Process.LoanType;
import com.sun.corba.se.impl.io.TypeMismatchException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor;

public class LoanTypeManager extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private LoanType LT;
    private ResultSet rs;

    public LoanTypeManager() {
        super();
        loadData();
        initComponent();
    }

    private void initComponent() {

        JButton addButton = new JButton("Add Loan Type");
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
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
                int result = JOptionPane.showConfirmDialog(null, inputPan, "enter new Laon Type", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        float rate = Float.valueOf(txtInterestRate.getText());
                        LT.InsertLoanType(txtTypeName.getText(), rate, txtDescription.getText());
                        JOptionPane.showMessageDialog(null, "add success");
                        String[] newType = {txtTypeName.getText(), txtInterestRate.getText(), txtDescription.getText()};
                        model.addRow(newType);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "wrong type input");
                    }
                }
            }
        });

        JButton removeButton = new JButton("Delete Selected Loan Type");
        removeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                try {
                    int i = table.getSelectedRow();
                    int confirm = JOptionPane.showConfirmDialog(null, "confirm delete?", "delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        rs.absolute(i + 1);
                        if (LT.DelLoanType(rs.getInt("TypeID"))) {
                            JOptionPane.showMessageDialog(null, "delete done");
                        }
                        model.removeRow(i);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                loadData();
            }
        });

        JButton updateButton = new JButton("Update Loan Type");
        updateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                int i = table.getSelectedRow();
                int ID;
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
                        String[] newType = {txtTypeName.getText(), txtInterestRate.getText(), txtDescription.getText()};
                        model.addRow(newType);
                        model.removeRow(i);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database error :(");
                }

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

//        JTextField txtLoanType = new JTextField("", 20);

//        JPanel searchPanel = new JPanel();
//        searchPanel.add(txtLoanType);

        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.SOUTH);
//        container.add(searchPanel, BorderLayout.NORTH);

        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(w / 3 + 150, h / 3);
        setLocation((w - w / 3) / 2, (h - h / 3) / 2);
        setTitle("Loan Types");
        setVisible(true);
        setResizable(true);
    }

    private void loadData() throws HeadlessException {
        LT = new LoanType();
        rs = LT.getAllLoanType();
        model = new DefaultTableModel();
        try {
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        table = new JTable(model) {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
    }

    public static void main(String args[]) {
        LoanTypeManager loanTypeManager = new LoanTypeManager();
    }
}
