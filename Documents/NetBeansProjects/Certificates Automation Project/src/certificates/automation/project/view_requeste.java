package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class view_requeste extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, lm;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JComboBox jcb1, jcb2;
    JButton b1, b2;
    String name;
    String year;
    String dob;
    String address;
    String semester;
    String branch;
    JTable table;

    view_requeste() {
        Color c1 = new Color(204, 231, 191);
        getContentPane().setBackground(c1);
        setLayout(null);

        b1 = new JButton("Cancel");
        b1.setBounds(50, 670, 200, 30);
        b1.addActionListener(this);
        add(b1);

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM viewrequeste1");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            // Customize rendering for the 'fees_receipt' column
            table.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 10, 900, 650);

        add(jsp);

        setVisible(true);
        setTitle("Bonafide Certificate Automation");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 50);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new admin_dashboard();
        }
    }

    public static void main(String args[]) {
        new view_requeste();
    }

    // Custom TableCellRenderer to render images from fees_receipt column
    class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof byte[]) {
            byte[] imageData = (byte[]) value;
            ImageIcon icon = new ImageIcon(imageData);
            lbl.setIcon(icon);
        } else {
            lbl.setText("No Image");
        }
        return lbl;
    }
   }
}
