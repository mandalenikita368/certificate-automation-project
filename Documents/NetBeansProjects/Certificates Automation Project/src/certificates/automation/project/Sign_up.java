
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
public class Sign_up extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,lm;
    JTextField tf1,tf3,tf4;
    JButton b1,b2;
    String name;
    JPasswordField tf2;
    Sign_up()
    {
        Container c=getContentPane();
        c.setLayout(null);
        Color c1=new Color(204,231,191);
        c.setBackground(c1);
        Font f1=new Font("Times New Roman",Font.BOLD,50);
        Font f2=new Font("Arial Black",Font.BOLD,15);


        lm=new JLabel("Sign in");
        l1=new JLabel("Enter Username:");
        tf1=new JTextField(30);
        tf1.setToolTipText("Enter Username");
        l2=new JLabel("Enter Password:");
        tf2=new JPasswordField(30);
        tf2.setToolTipText("Enter Your Password");
        tf2.setEchoChar('*');
        b1=new JButton("Submit");
        b1.setToolTipText("click submit");
        b2=new JButton("Back");
        b2.setToolTipText("Go back");
        lm.setFont(f1);
        c.setFont(f2);

      
        c.add(lm);
        c.add(l1);
        c.add(tf1);
        c.add(l2);
        c.add(tf2);
        c.add(b1);c.add(b2);

        lm.setBounds(170,50,400,60);
        l1.setBounds(100,150,120,40);
        l2.setBounds(100,230,120,40);
        tf1.setBounds(230,150,150,40);
        tf2.setBounds(230,230,150,40);
        b1.setBounds(100,310,100,40);
        b2.setBounds(250,310,100,40);
        b1.addActionListener(this);
        b2.addActionListener(this);
  
        setVisible(true);
	setTitle("Bonafide Certificate Automation");
	setSize(500,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600,100);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String uname=tf1.getText();
                String key=tf2.getText();
                Conn c=new Conn();
                String query="select * from adminlogin where admin_name='"+uname+"' and private_key='"+key+"'"; 
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Signed in Successfully!");
                    setVisible(false);
                    new admin_dashboard();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Cardentials!");
                    setVisible(false);
                    new Identification();
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
            new Identification();
        }
    }
    public static void main(String args[])
    {
        new Sign_up();
    }
}
