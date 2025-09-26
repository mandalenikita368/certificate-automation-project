package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class remove_request extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, lm;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JComboBox jcb1, jcb2;
    JButton b1, b2, removeButton;  // Add removeButton
    String name;
    String year;
    String dob;
    String address;
    String semester;
    String branch;
    JTable table;
    String requestId;

    remove_request() {
        Color c1 = new Color(204, 231, 191);
        getContentPane().setBackground(c1);
        setLayout(null);

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from viewrequeste1");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 10, 900, 650);

        add(jsp);

        b1=new JButton("Cancel");
        b1.addActionListener(this);
        b1.setBounds(950, 50, 100, 30);
        add(b1);
        removeButton = new JButton("Remove");
        removeButton.setBounds(950, 10, 100, 30);
        removeButton.addActionListener(this);
        add(removeButton);

        setVisible(true);
        setTitle("Bonafide Certificate Automation");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 50);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == removeButton) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                try {
                    Conn c = new Conn();
                   String name = table.getValueAt(selectedRow, table.getColumn("name").getModelIndex()).toString();

                    // Execute DELETE query to remove the record from the database
                    String deleteQuery = "DELETE FROM viewrequeste1 WHERE name = '" + name + "'";
                    c.s.executeUpdate(deleteQuery);


                    // Remove the selected row from the JTable
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "Request removed successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error removing request");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a request to remove");
            }
        }
        else if(ae.getSource()==b1){
              setVisible(false);
            new admin_dashboard();
            
        }
    }
    

    public static void main(String args[]) {
        new remove_request();
    }
}
