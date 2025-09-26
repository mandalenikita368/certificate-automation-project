
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener
{
    ImageIcon i1,i3;
    Image i2;
    JLabel heading,image;
    JButton b1;
    Splash()
    {
        Color c1=new Color(204,231,191);
        getContentPane().setBackground(c1);
        setLayout(null);
        
        heading =new JLabel("Bonafide Certificate Automation");
        heading.setBounds(190,20,1200,60);
        heading.setFont(new Font("serif",Font.BOLD,60));
        heading.setForeground(Color.red);
        add(heading);
        
        i1=new ImageIcon(ClassLoader.getSystemResource("icons/Splash.jpg"));
        i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        
        b1=new JButton("CLICK HERE TO CONTINUE");
        b1.setToolTipText("Click here");
        b1.setBounds(400,400,300,70);
        b1.setFont(new Font("serif",Font.BOLD,12));
        b1.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image.add(b1);
        
        setSize(1170,680);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,50);
        setTitle("Bonafide Certificate Automation");
        while(true)
        {
            heading.setVisible(false);
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            heading.setVisible(true);
            try
            {
                Thread.sleep(900);
            }catch (Exception e)
            {
            }
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Identification();
        
    }
    public static void main(String args[])
    {
        new Splash();
    }
}
