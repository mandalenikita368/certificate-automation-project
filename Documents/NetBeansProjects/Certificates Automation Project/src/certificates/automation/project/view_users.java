
package certificates.automation.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class view_users extends JFrame implements ActionListener
{
    JTable table;
    JButton b1;
    view_users()
    {
        
        Color c1=new Color(204,231,191);
        getContentPane().setBackground(c1);
        setLayout(null);
        
        b1=new JButton("Cancel");
        b1.setBounds(50, 670, 200, 30);
        b1.addActionListener(this);
        
        add(b1);
        table=new JTable();
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from  userslogin");
            table.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,10,900,650);
        
        add(jsp);
        
        setVisible(true);
	setTitle("Bonafide Certificate Automation");
	setSize(1000,750);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,50);

    
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            setVisible(false);
            new admin_dashboard();
        }
    }
    public static void main(String args[])
    {
        new view_users();
    }
   
}
