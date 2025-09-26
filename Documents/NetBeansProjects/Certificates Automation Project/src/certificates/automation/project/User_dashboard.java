
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.*;
public class User_dashboard extends JFrame implements ActionListener
{
    JLabel l1,l2,image;
    JButton b1,b2;
    User_dashboard()
    {
                Color c1=new Color(204,231,191);
                getContentPane().setBackground(c1);
                setLayout(null);
		setBackground(Color.cyan);
		setForeground(Color.red);
		Font f1=new Font("Times New Roman",Font.BOLD,45);
		Font f2=new Font("Times New Roman",Font.BOLD,40);
		l1=new JLabel("GOVERNMENT POLYTECHNIC NANDED");
		//b1.setForeground(Color.cyan);
		l2=new JLabel("***Bonafide Certificate***");
		
		
		b1=new JButton("Apply for Bonafide Certificate");
                b1.setToolTipText("click here");
		b2=new JButton("BACK");
                b2.setToolTipText("Go back");
		l1.setFont(f1);
		l2.setFont(f2);
		
	
		
		add(l1);
		add(l2);
		add(b1);
		add(b2);
                
                
                b1.addActionListener(this);
                b2.addActionListener(this);
		
		l1.setBounds(220,250,900,40);
		l2.setBounds(350,300,500,40);
		b1.setBounds(390,400,300,40);
		b2.setBounds(470,500,120,30);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bonafide-certificate-high-resolution-logo.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,30,200,200);
        add(image);
                
        setVisible(true);
	setTitle("Bonafide Certificate Automation");
	setSize(1170,650);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,50);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            setVisible(false);
            new BonafideApply();
        }
        if(ae.getSource()==b2)
        {
            setVisible(false);
            new user_login();
        }
        
    }
    public static void main(String args[])
    {
        new User_dashboard();
    }
            
}
