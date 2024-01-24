package Employee_Management;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Date;
public class HomePage extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,labe2;
        Font f,f1,f2;
        JPanel p1,p2;
        
   public HomePage(){
        super("WorkBuddy");
        setLocation(0,0);
        setSize(1550,820);
        
        f = new Font("Lucida Fax",Font.BOLD,20);
        f2 = new Font("Gadugi",Font.BOLD,35);
        f1 = new Font("MS UI Gothic",Font.BOLD,18);
     
        String str = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\Project_photo\\m4.jpg";
        ImageIcon ic = new ImageIcon(str);
       Image img = ic.getImage().getScaledInstance(1550, 800,Image.SCALE_DEFAULT);
       ImageIcon ici = new ImageIcon(img);
        l1 = new JLabel(ici);
       
       JMenuBar m1 = new JMenuBar();
       JMenu men1 = new JMenu("Employee");
       JMenuItem ment1 = new JMenuItem("New Employee");
       JMenuItem ment2 = new JMenuItem("View Profile");
 
       JMenu men2 = new JMenu("Edit");
       JMenuItem ment3 = new JMenuItem("Update Details");
       
       JMenu men3 = new JMenu("Attendance");
       JMenuItem ment5 = new JMenuItem("Take Attendance");
       JMenuItem ment6 = new JMenuItem("View Attendance");
       
       JMenu men4 = new JMenu("Leave");
       JMenuItem ment7 = new JMenuItem("Apply Leave");
       JMenuItem ment8 = new JMenuItem("View Leaves");
       
       JMenu men5 = new JMenu("Password");
       JMenuItem ment9 = new JMenuItem("Change Password");
       JMenuItem ment10 = new JMenuItem("Employee Report");
       
       JMenu men6 = new JMenu("Exit");
       JMenuItem ment11 = new JMenuItem("Logout");
       
       JMenu men7 = new JMenu("Delete");
       JMenuItem ment12 = new JMenuItem("Delete Employee");
              
       men1.add(ment1);
       men1.add(ment2);
       men1.add(ment10);
       
       men2.add(ment3);
       men3.add(ment5);
       men3.add(ment6);
       men4.add(ment7);
       men4.add(ment8);
       men5.add(ment9);
       men6.add(ment11);
       men7.add(ment12);
       men6.setForeground(Color.RED);
       
       m1.add(men1);
       m1.add(men2);
       m1.add(men3);
       m1.add(men4);
       m1.add(men7);
       m1.add(men5);
       m1.add(men6);
       
       men1.setFont(f);
       men2.setFont(f);
       men3.setFont(f);
       men4.setFont(f);
       men5.setFont(f);
       men6.setFont(f);
       men7.setFont(f);
       
       ment1.setFont(f1);
       ment2.setFont(f1);
       ment3.setFont(f1);
       ment5.setFont(f1);
       ment6.setFont(f1);
       ment7.setFont(f1);
       ment8.setFont(f1);
       ment9.setFont(f1);
       ment10.setFont(f1);
       ment11.setFont(f1);
       ment12.setFont(f1);
       
       ment1.setBackground(Color.WHITE);
       ment2.setBackground(Color.WHITE);
       ment3.setBackground(Color.WHITE);
       ment5.setBackground(Color.WHITE);
       ment6.setBackground(Color.WHITE);
       ment7.setBackground(Color.WHITE);
       ment8.setBackground(Color.WHITE);
       ment9.setBackground(Color.WHITE);
       ment10.setBackground(Color.WHITE);
       ment11.setBackground(Color.WHITE);
       ment12.setBackground(Color.WHITE);
      
       ment1.setForeground(Color.BLACK);
       ment2.setForeground(Color.BLACK);
       ment3.setForeground(Color.BLACK);
       ment5.setForeground(Color.BLACK);
       ment6.setForeground(Color.BLACK);
       ment7.setForeground(Color.BLACK);
       ment8.setForeground(Color.BLACK);
       ment9.setForeground(Color.BLACK);
       ment10.setForeground(Color.BLACK);
       ment11.setForeground(Color.BLACK);
       ment12.setForeground(Color.BLACK);
       
       ment1.addActionListener(this);
       ment2.addActionListener(this);
       ment3.addActionListener(this);
       ment5.addActionListener(this);
       ment6.addActionListener(this);
       ment7.addActionListener(this);
       ment8.addActionListener(this);
       ment9.addActionListener(this);
       ment10.addActionListener(this);
       ment11.addActionListener(this);
       ment12.addActionListener(this);
       
       setJMenuBar(m1);
       add(l1);
       
       p2 = new JPanel();
       p2.setBackground(Color.BLACK );
       p2.setBounds(0,720,1550,40);
       l1.add(p2);
       p2.setLayout(null);

       JLabel label = new JLabel("WORKFORCE SYSTEM");
       label.setBounds(20,0,250,30);
       label.setForeground(Color.WHITE);
       label.setFont(new Font("Lucida Fax",Font.BOLD,20));
       p2.add(label);
       
       labe2 = new JLabel();
       labe2.setBounds(650,0,250,30);
       labe2.setForeground(Color.WHITE);
       labe2.setFont(new Font("Lucida Fax",Font.BOLD,20));
       p2.add(labe2);
       
       
       JLabel label1 = new JLabel("CREATED BY YOGESH");
       label1.setBounds(1280,0,250,30);
       label1.setForeground(Color.WHITE);
       label1.setFont(new Font("Lucida Fax",Font.BOLD,20));
       p2.add(label1);
       
       Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();
       
       setBackground(Color.BLACK);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);   
    }
   
   private void updateDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(new Date());
        labe2.setText(formattedDateTime);
    }

    public void actionPerformed(ActionEvent ae){
    String comnd = ae.getActionCommand();
    if(comnd.equals("New Employee"))
        new Add_Employee();
    else if(comnd.equals("View Profile"))
        new View_Employee();
    else if(comnd.equals("Employee Report"))
        new Employee_Report();
    else if(comnd.equals("Update Details"))
        new Update_Details_Data().setVisible(true);
    else if(comnd.equals("Take Attendance"))
        new Employee_Attendance().setVisible(true);
    else if(comnd.equals("View Attendance"))
        new View_Attendance().setVisible(true);
    else if(comnd.equals("Apply Leave"))
        new Apply_Leave();
    else if(comnd.equals("View Leaves"))
        new View_Leaves().setVisible(true);
    else if(comnd.equals("Change Password"))
        new Password();
    else if(comnd.equals("Delete Employee"))
        new Delete_Employee().setVisible(true);
    else if(comnd.equals("Logout"))
        System.exit(0);
    }
    }


