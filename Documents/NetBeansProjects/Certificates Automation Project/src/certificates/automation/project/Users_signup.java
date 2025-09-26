
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
public class Users_signup extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,lm,labelfname;
    JTextField tf1,tf3,tf4,tfname;
    JButton b1,b2;
    String name;
    JPasswordField tf2;
    Users_signup()
    {
        Container c=getContentPane();
        c.setLayout(null);
        Color c1=new Color(204,231,191);
        getContentPane().setBackground(c1);

        Font f1=new Font("Times New Roman",Font.BOLD,50);
        Font f2=new Font("Arial Black",Font.BOLD,15);


        lm=new JLabel("Sign in");
        labelfname=new JLabel("Enter Full Name:");
        tfname=new JTextField(30);
        l1=new JLabel("Enter Enrollment No:");
        tf1=new JTextField(30);
        tf1.setToolTipText("Enter your Enrollment No");
        l2=new JLabel("Enter Password:");
        tf2=new JPasswordField(30);
        tf2.setToolTipText("Enter Your password");
        tf2.setEchoChar('*');
        b1=new JButton("Submit");
        b1.setToolTipText("click Submit");
        b2=new JButton("Cancel");
        b2.setToolTipText("cancel");
        lm.setFont(f1);
        c.setFont(f2);

      
        c.add(lm);
        c.add(labelfname);
        c.add(tfname);
        c.add(l1);
        c.add(tf1);
        c.add(l2);
        c.add(tf2);
        c.add(b1);c.add(b2);

        lm.setBounds(170,50,400,60);
        labelfname.setBounds(100,150,120,40);
        tfname.setBounds(230,150,150,40);
        l1.setBounds(100,230,120,40);
        l2.setBounds(100,310,120,40);
        tf1.setBounds(230,230,150,40);
        tf2.setBounds(230,310,150,40);
        b1.setBounds(100,390,100,40);
        b2.setBounds(250,390,100,40);
        b1.addActionListener(this);
        b2.addActionListener(this);
  
        setVisible(true);
	setTitle("Sign Up");
	setSize(500,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600,100);
        setTitle("Bonafide Certificate Automation");
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String name=tfname.getText();
                String enrollment=tf1.getText();
                String password=tf2.getText();
                Conn c=new Conn();
                String query="select * from userslogin where first_second_name='"+name+"' and enrollment='"+enrollment+"' and password='"+password+"'"; 
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Welcome! Successfully Signed up!");
                    setVisible(false);
                    new User_dashboard();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Cardentials!");
                    setVisible(false);
                    new user_login();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b2)
        {
            setVisible(false);
            new user_login();
        }
    }
    public static void main(String args[])
    {
        new Users_signup();
    }
}
