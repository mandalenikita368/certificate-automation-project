package certificates.automation.project;
//import sun.awt.Graphics2Delegate;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.net.URL;

//import javafx.print.Printer;

class BonafideCertificate extends JFrame implements ActionListener, Printable 
{

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19,l20,l21,l22,l23;
    JButton b1, b3;

    private String name;
    private String ay;
    private String dob;
    private String addr;
    private String sem;
    private String br;

    BonafideCertificate(String name, String ay, String dob, String addr, String sem, String br) {

        this.name = name;
        this.ay = ay;
        this.dob = dob;
        this.addr = addr;
        this.sem = sem;
        this.br = br;
        setLayout(null);
        Container c = getContentPane();
        Color c1=new Color(204,231,191);
        c.setBackground(c1);
        Font f1 = new Font("Arial Black", Font.BOLD, 15);
        Font f2 = new Font("Arial Black", Font.BOLD, 13);
        Font f3 = new Font("Arial Black", Font.BOLD, 15);
        Font f4 = new Font("Arial Black", Font.PLAIN, 11);

        ImageIcon i=createImageIcon("logo.jpg","Image not found");
        l23=new JLabel(i);
        if (i != null) {
            l23.setIcon(i);
        }


        l1 = new JLabel("GOVERNMENT POLYTECHNIC,NANDED");
        l2 = new JLabel("VEER SAWARKAR MARK,BABANAGAR,NANDED");
        l3 = new JLabel("Phone:02462-254210.  Tele.Fax:252520");
        l4 = new JLabel("www.gpnanded.org.in");
        l16 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l5 = new JLabel("Bonafide Certificate");
        l6 = new JLabel("This is to certify that,Mr/Miss:   " + name);
        l12 = new JLabel("");
        l7 = new JLabel("is/was a Bonafide student of this institute studying in   " + sem);
        l17 = new JLabel("");
        l18 = new JLabel("Semester Diploma Course in  " + br);
        l19 = new JLabel("");
        l11 = new JLabel("Engineering during the Academic Year:   " + ay);
        l13 = new JLabel("");
        l8 = new JLabel("As per this office record his/her Date of Birth is: " + dob +"   ");
        l14 = new JLabel("");
        l9 = new JLabel("and Residential Address is:   " + addr);
        l15 = new JLabel("");
        l10 = new JLabel("He/She bears a good moral Character.");
        l20=new JLabel("Principal");
        l21=new JLabel("Government Polytechnic,Nanded");
        b1 = new JButton("PRINT");
        b1.setToolTipText("Print your Certificate");
        b3=new JButton("Cancel");
        b3.setToolTipText("cancel certificate");
        ImageIcon ii = createImageIcon1("img.jpg","image not found");
        l22 = new JLabel(ii);
        if (ii != null) {
            l22.setIcon(ii);
        }



        c.add(l23);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l16);
        c.add(l5);
        c.add(l6);
        c.add(l12);
        c.add(l7);
        c.add(l17);
        c.add(l18);
        c.add(l19);
        c.add(l11);
        c.add(l13);
        c.add(l8);
        c.add(l14);
        c.add(l9);
        c.add(l15);
        c.add(l10);
        c.add(l22);
        c.add(l20);
        c.add(l21);
        c.add(b1);
        c.add(b3);

        b1.addActionListener(this);

        b3.addActionListener(this);

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f3);
        l6.setFont(f4);
        l11.setFont(f4);
        l7.setFont(f4);
        l8.setFont(f4);
        l9.setFont(f4);
        l10.setFont(f4);
        l18.setFont(f4);
        l20.setFont(f4);
        l21.setFont(f4);

        l1.setForeground(Color.red);
        l5.setForeground(Color.red);
        l20.setForeground(Color.red);
        l21.setForeground(Color.red);

        l23.setBounds(230,10,150,100);
        l1.setBounds(125, 120, 800, 40);
        l2.setBounds(130, 160, 500, 40);
        l3.setBounds(160, 200, 500, 40);
        l4.setBounds(195, 240, 500, 40);
        l16.setBounds(0, 280, 1200, 20);
        l5.setBounds(200, 320, 500, 40);
        l6.setBounds(10, 400, 500, 40);
        l12.setBounds(320, 300, 500, 50);
        l7.setBounds(10, 430, 500, 50);
        l17.setBounds(510, 430, 180, 40);
        l18.setBounds(390, 435, 300, 40);
        l19.setBounds(860, 430, 180, 40);
        l11.setBounds(10, 460, 500, 40);
        l13.setBounds(380, 460, 500, 50);
        l8.setBounds(10, 490, 500, 40);
        l14.setBounds(450, 490, 500, 50);
        l9.setBounds(10, 520, 500, 40);
        l15.setBounds(290, 520, 500, 50);
        l10.setBounds(10, 550, 500, 40);
        l22.setBounds(350, 570, 200, 40);

        l20.setBounds(400,600,500,40);
        l21.setBounds(300,620,500,40);

        b1.setBounds(40,320, 150, 40);
        b3.setBounds(360, 660, 150, 40);

        setVisible(true);
        setSize(700, 750);
        setLocation(300,50);
        setTitle("Bonafide Certificate Automation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    protected ImageIcon createImageIcon(String path, String description) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    protected ImageIcon createImageIcon1(String path, String description) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            printCertificate();

        }
        else if (ae.getSource() == b3) 
        {
            setVisible(false);
            new BonafideApply();
        }
    }

    public void printCertificate() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        boolean cancel = job.printDialog();
        if (ok)
        {

            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        else if(cancel)
        {
            setVisible(false);
            new BonafideCertificate("","","","","","");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Something is wrong there!");
        }
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        // Print the frame content
        this.printAll(g);

        return PAGE_EXISTS;
    }



    public static void main(String args[]) {
        new BonafideCertificate("", "", "", "", "", "");
    }
}