
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Identification extends JFrame implements ActionListener
{
    JLabel l1;
    JRadioButton r1,r2;
    //JButton b1;
    Identification()
    {
        Color c=new Color(204,231,191);
        getContentPane().setBackground(c);
        setLayout(null);
		
		Font f1=new Font("Times New Roman",Font.BOLD,33);
		Font f2=new Font("Arial Black",Font.BOLD,20);
                //l1.setForeground(Color.RED);
		
		l1=new JLabel("LOGIN AS...");
		l1.setFont(f1);
		setFont(f2);
		r1=new JRadioButton("Admin");
                r1.setToolTipText("Are you Admin?");
		r2=new JRadioButton("Student");
                r2.setToolTipText("Are you Student?");
	
		l1.setBounds(150,50,200,40);
		r1.setBounds(100,150,150,30);
		r2.setBounds(100,200,150,30);
		
		add(l1);
		add(r1);
		add(r2);

		r1.addActionListener(this);
		r2.addActionListener(this);
                
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
                Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
                ImageIcon i3=new ImageIcon(i2);
                JLabel image=new JLabel(i3);
                image.setBounds(350,10,180,200);
                add(image);
                
               /*b1=new JButton("BACK"); 
               b1.setBounds(350,250,200,30);
               add(b1);
               b1.addActionListener(this);*/
        
        setSize(600,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500,80);
        setTitle("Bonafide Certificate Automation");
    }
    public void actionPerformed(ActionEvent ae)
    {
            try{
                setVisible(false);
                /*if(ae.getSource()==b1)
                    {
                        setVisible(false);
                        new Splash();
                    }    */   
                 if(r1.isSelected())
                    {
                        setVisible(false);
                        new Sign_up();				
                    }
                else if(r2.isSelected())
                    {
                        setVisible(false);
                        new user_login();
                    }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    public static void main(String args[])
    {
        new Identification();
    
    }
}
