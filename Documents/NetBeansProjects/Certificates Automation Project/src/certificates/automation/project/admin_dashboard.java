
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class admin_dashboard extends JFrame implements ActionListener
{
    JButton add,view,update,remove,back;
    admin_dashboard()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);
        
        JLabel heading =new JLabel("BONAFIDE CERTIFICATE AUTOMATION");
        heading.setBounds(100,30,900,50);
        heading.setFont(new Font("TAHOMA",Font.BOLD,40));
        heading.setForeground(Color.RED);
        image.add(heading);
        
        add=new JButton("VIEW USERS");
        add.setToolTipText("Click here to view users");
        add.setBounds(250,150,200,40);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("VIEW REQUEST'S");
        view.setToolTipText("Click here to view requests");
        view.setBounds(250,230,200,40);
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("REMOVE USER");
        update.setToolTipText("Click here to remove users");
        update.setBounds(250,310,200,40);
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("REMOVE REQUEST");
        remove.setToolTipText("Click here to remove request");
        remove.setBounds(250,380,200,40);
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLACK);
        remove.addActionListener(this);
        image.add(remove);
        
        back=new JButton("BACK");
        back.setToolTipText("Go back");
        back.setBounds(250,450,200,40);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
        
        
                setVisible(true);
		setTitle("Bonafide Certificate Automation");
		setSize(1000,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocation(200,50);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            setVisible(false);
            new view_users();
        }
        else if(ae.getSource()==view)
        {
            setVisible(false);
            new view_requeste();
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new remove_user();
        }
        else if(ae.getSource()==remove)
        {
            setVisible(false);
            new remove_request();
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Admin_login();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Something went wrong there!");
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new admin_dashboard();
    }
}
