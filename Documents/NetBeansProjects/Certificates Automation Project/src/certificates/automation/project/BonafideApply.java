package certificates.automation.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BonafideApply extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, lm, labelfile;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tfEnrollment, tfPassword;
    JComboBox<String> jcb1, jcb2;
    JButton b1, b2, fileButton;
    String name, year, dob, address, semester, branch, enrollment, password;
    String selectedFilePath;

    BonafideApply() {
        Container c = getContentPane();
        c.setLayout(null);
        Color c1 = new Color(204, 231, 191);
        c.setBackground(c1);
        Font f1 = new Font("Times New Roman", Font.BOLD, 45);
        Font f2 = new Font("Arial Black", Font.BOLD, 25);

        lm = new JLabel("Apply For Bonafide");
        l1 = new JLabel("Full Name Of Student:");
        tf1 = new JTextField(30);
        tf1.setToolTipText("Enter Your Full name");
        l2 = new JLabel("Academic Year:");
        tf2 = new JTextField(30);
        tf2.setToolTipText("Enter academic year");
        l3 = new JLabel("Date Of Birth:");
        tf3 = new JTextField(30);
        tf3.setToolTipText("Enter Date of Birth");
        l4 = new JLabel("Residential Address:");
        tf4 = new JTextField(30);
        tf4.setToolTipText("Enter Your address");
        l5 = new JLabel("Enter Semester:");
        jcb1 = new JComboBox<>();
        jcb1.addItem("I");
        jcb1.addItem("II");
        jcb1.addItem("III");
        jcb1.addItem("IV");
        jcb1.addItem("V");
        jcb1.addItem("VI");
        l6 = new JLabel("Enter Branch:");
        jcb2 = new JComboBox<>();
        jcb2.addItem("CE");
        jcb2.addItem("EE");
        jcb2.addItem("ME");
        jcb2.addItem("IF");
        jcb2.addItem("PG");
        jcb2.addItem("MU");
        jcb2.addItem("CE(SS)");
        jcb2.addItem("ME(SS)");
        l7 = new JLabel("Enrollment Number:");
        tfEnrollment = new JTextField(30);
        tfEnrollment.setToolTipText("Enter Your Enrollment Number");
        l8 = new JLabel("Password:");
        tfPassword = new JTextField(30);
        tfPassword.setToolTipText("Enter Your Password");

        labelfile = new JLabel("Upload File");
        labelfile.setBounds(100, 620, 100, 30);

        fileButton = new JButton("Select File");
        fileButton.setBounds(250, 620, 150, 40);
        fileButton.addActionListener(this);
        c.add(fileButton);

        b1 = new JButton("Submit");
        b1.setToolTipText("Submit here");
        b2 = new JButton("Cancel");
        b2.setToolTipText("cancel");
        lm.setFont(f1);
        c.setFont(f2);
        lm.setForeground(Color.red);

        c.add(lm);
        c.add(l1);
        c.add(tf1);
        c.add(l2);
        c.add(tf2);
        c.add(l3);
        c.add(tf3);
        c.add(l4);
        c.add(tf4);
        c.add(l5);
        c.add(jcb1);
        c.add(l6);
        c.add(labelfile);
        c.add(jcb2);
        c.add(l7);
        c.add(tfEnrollment);
        c.add(l8);
        c.add(tfPassword);
        c.add(b1);
        c.add(b2);

        lm.setBounds(180, 50, 400, 45);
        l1.setBounds(100, 140, 140, 40);
        l2.setBounds(100, 200, 120, 40);
        l3.setBounds(100, 260, 120, 40);
        l4.setBounds(100, 320, 120, 40);
        l5.setBounds(100, 380, 120, 40);
        l6.setBounds(100, 440, 120, 40);
        l7.setBounds(100, 500, 120, 40);
        l8.setBounds(100, 560, 120, 40);
        tf1.setBounds(250, 140, 300, 40);
        tf2.setBounds(250, 200, 300, 40);
        tf3.setBounds(250, 260, 300, 40);
        tf4.setBounds(250, 320, 300, 40);
        jcb1.setBounds(250, 380, 150, 30);
        jcb2.setBounds(250, 440, 150, 30);
        tfEnrollment.setBounds(250, 500, 300, 40);
        tfPassword.setBounds(250, 560, 300, 40);

        b1.setBounds(130, 700, 150, 40);
        b1.addActionListener(this);
        b2.setBounds(380, 700, 150, 40);
        b2.addActionListener(this);

        setVisible(true);
        setSize(900, 900);
        setTitle("Bonafide Certificate Automation");
        setLocation(300, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                name = tf1.getText();
                year = tf2.getText();
                dob = tf3.getText();
                address = tf4.getText();
                semester = (String) jcb1.getSelectedItem();
                branch = (String) jcb2.getSelectedItem();
                enrollment = tfEnrollment.getText();
                password = tfPassword.getText();

                if (!validateUser(enrollment, password,name)) {
                    JOptionPane.showMessageDialog(null, "Invalid Enrollment Number or Password or name", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedFilePath == null) {
                    JOptionPane.showMessageDialog(null, "Please select a file.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                File file = new File(selectedFilePath);
                FileInputStream fis = new FileInputStream(file);

                String insertQuery = "INSERT INTO viewrequeste1 (name, year, dob, address, semester, branch, fees_receipt) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificateautomationproject", "root", "7406");
                     PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                    pstmt.setString(1, name);
                    pstmt.setString(2, year);
                    pstmt.setString(3, dob);
                    pstmt.setString(4, address);
                    pstmt.setString(5, semester);
                    pstmt.setString(6, branch);
                    pstmt.setBinaryStream(7, fis);

                    pstmt.executeUpdate();
                    setVisible(false);
                    new BonafideCertificate(name, year, dob, address, semester, branch);
                    JOptionPane.showMessageDialog(null, "Submitted successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
            else if (ae.getSource() == fileButton) 
            {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) 
                {
                    File selectedFile = fileChooser.getSelectedFile();
                    selectedFilePath = selectedFile.getAbsolutePath();
                    labelfile.setText(selectedFile.getName());
                }
            } 
            else if (ae.getSource() == b2) 
            {
                setVisible(false);
                new user_login();
            } 
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    } 
    private boolean validateUser(String enrollment, String password,String first_second_name) 
    {
        if (enrollment.isEmpty() || password.isEmpty()||first_second_name.isEmpty()) 
        {
            return false;
        }

        String query = "SELECT * FROM userslogin WHERE enrollment = ? AND password=? AND first_second_name=?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificateautomationproject", "root", "7406");
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
            pstmt.setString(1, enrollment);
            pstmt.setString(2, password);
            pstmt.setString(3, first_second_name);

            try (ResultSet rs = pstmt.executeQuery()) 
            {
                return rs.next(); // Returns true if the query returns at least one row
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) 
    {
        new BonafideApply();
    }
}

// Method to validate user based on enrollment number and password
