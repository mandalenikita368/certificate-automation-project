
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Admin_login extends JFrame implements ActionListener
{
        JTextField tf1,tf3,tf4,tf5,tf6,tf7;
	JLabel L1,L2,L3,L4,L5,L6,L7,L9;
	JButton b1,b2,b3;
        JPasswordField tf2;
        
        Admin_login()
        {
            Color c=new Color(204,231,191);
            getContentPane().setBackground(c);
            setLayout(null);
		setBackground(Color.cyan);
		setForeground(Color.red);
		Font f1=new Font("Times New Roman",Font.BOLD,40);
		Font f2=new Font("Times New Roman",Font.BOLD,30);
                Font f3=new Font("Times New Roman",Font.BOLD,20);
			
		L1=new JLabel("Admin Login Form");
		L1.setFont(f1);
                L1.setForeground(Color.red);
		setFont(f2);
		L2=new JLabel("Enter Your Name :",Label.RIGHT);
		L3=new JLabel("Enter Secret Password:",Label.RIGHT);
		L4=new JLabel("Enter your Email-ID:",Label.RIGHT);
		L5=new JLabel("Enter Mobile No:",Label.RIGHT);
		L6=new JLabel("Enter Your Designation:",Label.RIGHT);
		L7=new JLabel("Enter Your Address",Label.RIGHT);			
		//L8=new Label("                       ");
                b1=new JButton("Login");
                b1.setToolTipText("Login here");
                b1.setFont(f3);
                
                b2=new JButton("Back");
                b2.setToolTipText("Go back");
                b2.setFont(f3);
                
                b3=new JButton("Sign in");
                b3.setToolTipText("Sign in here");
                b3.setFont(f3);
              
			
		tf1=new JTextField(20);
                tf1.setToolTipText("Enter Your name");
		tf2=new JPasswordField(20);
                tf2.setEchoChar('*');
                tf2.setToolTipText("Enter Your secret password");
                tf3=new JTextField(20);
                tf3.setToolTipText("Enter Your email");
		tf4=new JTextField(20);
                tf4.setToolTipText("Enter Your Mobile No");
		tf5=new JTextField(20);
                tf5.setToolTipText("Enter Yoour Designation");
		tf6=new JTextField(20);
                tf6.setToolTipText("Enter Your address");
                tf7=new JTextField(20);
                
                L9=new JLabel("Already Login Sign in..");
			
		L1.setBounds(220,50,380,80);
		L2.setBounds(100,130,210,80);
		tf1.setBounds(360,150,150,35);
		L3.setBounds(100,180,180,80);
		tf2.setBounds(360,200,150,35);
		L4.setBounds(100,230,180,80);
		tf3.setBounds(360,250,150,35);
		L5.setBounds(100,280,180,80);
		tf4.setBounds(360,300,150,35);
		L6.setBounds(100,330,180,80);
		tf5.setBounds(360,350,150,35);
		L7.setBounds(100,380,180,80);
                tf6.setBounds(360,410,150,35);
		//L8.setBounds(100,380,180,80);
                L9.setBounds(570,430,180,40);
		b1.setBounds(150,480,100,50);
                b2.setBounds(350,480,100,50);
                b3.setBounds(550,480,200,50);
		
		add(L1);
		add(L2);add(tf1);
		add(L3);add(tf2);
		add(L4);add(tf3);
		add(L5);add(tf4);
		add(L6);add(tf5);
                add(L7);add(tf6);
		add(tf7);add(L9);
		add(b1);add(b2);add(b3);
                
                setVisible(true);
		setTitle("Bonafide Certificate Automation");
		setSize(800,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocation(200,50);
                
		
		b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae)
	{
            if(ae.getSource()==b1)
            {
                try
                {
                        setVisible(false);
                        String name=tf1.getText();
                        String key=tf2.getText();
                        String designation=tf5.getText();
                        String mobile_no=tf4.getText();

                        Conn c=new Conn();
                        String query="select * from adminlogin where admin_name='"+name+"' and private_key='"+key+"' and designation='"+designation+"'"; 
                        ResultSet rs=c.s.executeQuery(query);
                        if(rs.next())
                        {
                            JOptionPane.showMessageDialog(null,"Login Successfully!");
                            new admin_dashboard();
                           /* String str=ae.getActionCommand();
                            if(str.equals("Login"))
                            {
                                    admin_dashboard ad1=new admin_dashboard();
                                    ad1.setVisible(true);
                                    ad1.setTitle("Admin Dashboard");
                                    ad1.setSize(500,500);
                                    ad1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            }*/
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Invalid Cardentials!");
                            setVisible(false);
                        }
                }
                catch(Exception e){

                    e.printStackTrace();
                }
            }
            else if(ae.getSource()==b2)
            {
                setVisible(false);
                new Identification();
            }
            else if(ae.getSource()==b3)
            {
                setVisible(false);
                new Sign_up();
            }
        }
        public static void main(String args[])
	{
		new Admin_login();
	}
}
