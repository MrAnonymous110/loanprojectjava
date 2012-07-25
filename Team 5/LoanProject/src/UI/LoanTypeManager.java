
import Process.LoanType;
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
                String[] philosopher = {"", "", ""};
                model.addRow(philosopher);
            }
        });
        
        JButton removeButton = new JButton("Remove Selected Loan Type");

        removeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                try {
                    int confirm = JOptionPane.showConfirmDialog(null, "confirm delete?", "delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        rs.first();
                        if (LT.DelLoanType(rs.getInt(1))) {
                            JOptionPane.showMessageDialog(null, "delete done");
                        }
                    }
//                    else if (confirm == JOptionPane.NO_OPTION) {
//                            
//                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                loadData();
            }
        });
        
        JButton updateButton = new JButton("Update Loan Type");
        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(updateButton);
        
        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.SOUTH);
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(w/3, h/3);
        setLocation((w-w/3)/2, (h-h/3)/2);
        setTitle("Loan Types");
        setVisible(true);
        setResizable(false);
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
        table = new JTable(model);
    }

    public static void main(String args[]) {
        LoanTypeManager loanTypeManager = new LoanTypeManager();
    }
}
