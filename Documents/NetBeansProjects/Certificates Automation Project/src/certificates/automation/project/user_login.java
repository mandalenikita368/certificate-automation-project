
package certificates.automation.project;


import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class user_login extends JFrame implements ActionListener {

    JDateChooser dcob, dcob1;
    JComboBox cbeducation;
    JLabel heading, labelname, labeldob, labesalary, labeaddress, labelphone, labelemail, labeleducation, labeldesignation, labelaadhar, labelempid, lblempid;
    JTextField tfname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfaadhar;
    JPasswordField lblempidtf;
    JButton addb, backb, signup;
    JFileChooser f1;

    user_login() {
        Color c = new Color(204, 231, 191);
        getContentPane().setBackground(c);
        setLayout(null);

        heading = new JLabel("Student Registration");
        heading.setBounds(245, 30, 900, 50);
        heading.setFont(new Font("san_serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        add(heading);

        labelname = new JLabel("Enter Your Full Name");
        labelname.setBounds(10, 120, 500, 50);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setToolTipText("Enter Your Full Name here...");
        tfname.setBounds(210, 135, 150, 30);
        add(tfname);

        labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 170, 500, 50);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcob = new JDateChooser();
        dcob.setToolTipText("Enter Date of birth");
        dcob.setBounds(210, 185, 150, 30);
        add(dcob);

        labesalary = new JLabel("Enrollment No.");
        labesalary.setBounds(400, 120, 500, 50);
        labesalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labesalary);

        tfsalary = new JTextField();
        tfsalary.setToolTipText("Enter Enrollment No here");
        tfsalary.setBounds(560, 135, 150, 30);
        add(tfsalary);

        labeaddress = new JLabel("Address");
        labeaddress.setBounds(50, 220, 500, 50);
        labeaddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeaddress);

        tfaddress = new JTextField();
        tfaddress.setToolTipText("Enter your Address");
        tfaddress.setBounds(210, 235, 150, 30);
        add(tfaddress);

        labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 175, 500, 50);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setToolTipText("Enter your phone No");
        tfphone.setBounds(560, 185, 150, 30);
        add(tfphone);

        labelemail = new JLabel("Email");
        labelemail.setBounds(50, 270, 500, 50);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setToolTipText("Enter your Email");
        tfemail.setBounds(210, 285, 150, 30);
        add(tfemail);

        labeleducation = new JLabel("Enter your class");
        labeleducation.setBounds(400, 220, 500, 50);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = {"CE", "EE", "IF", "ME", "MU", "PG"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(560, 235, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        labeldesignation = new JLabel("Date");
        labeldesignation.setBounds(50, 320, 500, 50);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        dcob1 = new JDateChooser();
        dcob1.setToolTipText("Enter Date");
        dcob1.setBounds(210, 335, 150, 30);
        add(dcob1);

        labelaadhar = new JLabel("Fees Receipt");
        labelaadhar.setBounds(400, 275, 500, 50);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        f1 = new JFileChooser();
        f1.setBounds(550, 285, 300, 300);
        add(f1);

        labelempid = new JLabel("Enter Password");
        labelempid.setBounds(50, 365, 500, 50);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);

        lblempidtf = new JPasswordField();
        lblempidtf.setToolTipText("Enter Password");
        lblempidtf.setEchoChar('*');
        lblempidtf.setBounds(210, 385, 150, 30);
        add(lblempidtf);

        addb = new JButton("Register here");
        addb.setToolTipText("Register here...");
        addb.setBounds(210, 450, 150, 40);
        addb.addActionListener(this);
        add(addb);

        signup = new JButton("Sign in");
        signup.setToolTipText("sign in here");
        signup.setBounds(210, 510, 150, 40);
        signup.addActionListener(this);
        add(signup);

        backb = new JButton("Cancel");
        backb.setToolTipText("cancel here");
        backb.setBounds(210, 570, 150, 40);
        backb.addActionListener(this);
        add(backb);

        setSize(900, 700);
        setVisible(true);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bonafide Certificate Automation");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addb) {
            try {
                String name = tfname.getText();
                String dob = ((JTextField) dcob.getDateEditor().getUiComponent()).getText();
                String enroll = tfsalary.getText();
                String password = lblempidtf.getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                String classbr = (String) cbeducation.getSelectedItem();
                String date = ((JTextField) dcob1.getDateEditor().getUiComponent()).getText();
                String filePath = "";

                int result = f1.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile= f1.getSelectedFile();
                    filePath = selectedFile.getAbsolutePath();
                }

                if (name.isEmpty() && enroll.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields are empty");
                    return;
                }

                String query = "SELECT * FROM userslogin WHERE enrollment = ? AND password = ? AND first_second_name = ?";
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificateautomationproject", "root", "7406");
                     PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, enroll);
                    pstmt.setString(2, password);
                    pstmt.setString(3, name);

                    try (ResultSet rs = pstmt.executeQuery()){
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "User already exists");
                            return;
                        }
                    }

                }

                query = "INSERT INTO userslogin (first_second_name, dob, enrollment, address, phone, email, class, date, file_path, password) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificateautomationproject",
                        "root", "7406"); PreparedStatement pstmt = conn.prepareStatement(query)) {

                    pstmt.setString(1, name);
                    pstmt.setString(2, dob);
                    pstmt.setString(3, enroll);
                    pstmt.setString(4, address);
                    pstmt.setString(5, phone);
                    pstmt.setString(6, email);
                    pstmt.setString(7, classbr);
                    pstmt.setString(8, date);
                    pstmt.setString(9, filePath);
                    pstmt.setString(10, password);

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registered successfully!");
                    setVisible(false);
                    new Users_signup();

                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (ae.getSource() == backb) {
            setVisible(false);
            new Identification();
        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            new Users_signup();
        }
        else {
            JOptionPane.showMessageDialog(null, "Something went wrong there!");
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new user_login();
    }
}

