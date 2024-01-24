package Employee_Management;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class View_Employee_Data extends JFrame implements ActionListener{
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,t1,t2,t3,t4,t5,t6,t7,t8;
    String emp_id,name,father,address,phone,email,education,post;
    JButton b1,b2;
    View_Employee_Data(String Eid){
    try{
        ConnectionClass obj = new ConnectionClass();
        String str = "select * from EMP where Eid='"+Eid+"'";
        ResultSet rs = obj.stm.executeQuery(str);
        while(rs.next()){
        name=rs.getString("name");
        father = rs.getString("fname");
        address = rs.getString("address");
        phone=rs.getString("phone");
        email=rs.getString("email");
        education = rs.getString("education");
        post = rs.getString("post");
        emp_id = rs.getString("eid");
        }
    }
    catch(Exception e){e.printStackTrace();}
    
    setTitle("Employee Details");
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(450,100);
    setSize(670,642);
    setLayout(null);
    
     String imagepath = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\Project_photo\\t6.jpg";
    ImageIcon img = new ImageIcon(imagepath);
    Image i2 = img.getImage().getScaledInstance(670, 650,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
     l = new JLabel(i3);
      l.setBounds(0,0,670,650);
     l.setIcon(i3);
     add(l);
     
     l1 = new JLabel("Employee Details");
     l1.setBounds(170,10,400,40);
     l1.setFont(new Font("Verdana",Font.BOLD,30));
     l.add(l1);
    
    l2 = new JLabel("Employee ID:");
     l2.setBounds(10,70,120,30);
     l2.setFont(new Font("serif",Font.BOLD,20));
     l.add(l2);
     
     t1 = new JLabel(emp_id);
     t1.setBounds(170,70,200,30);
     t1.setFont(new Font("serif",Font.BOLD,20));
     l.add(t1);
     
    l3 = new JLabel("Name:");
     l3.setBounds(10,120,100,30);
     l3.setFont(new Font("serif",Font.BOLD,20));
     l.add(l3);
     
     t2 = new JLabel(name);
     t2.setBounds(170,120,300,30);
     t2.setFont(new Font("serif",Font.BOLD,20));
     l.add(t2);  
     
    l4 = new JLabel("Father's Name:");
     l4.setBounds(10,170,200,30);
     l4.setFont(new Font("serif",Font.BOLD,20));
     l.add(l4);
     
     t3 = new JLabel(father);
     t3.setBounds(170,170,300,30);
     t3.setFont(new Font("serif",Font.BOLD,20));
     l.add(t3);  
   
      l5 = new JLabel("Address");
     l5.setBounds(10,220,100,30);
     l5.setFont(new Font("serif",Font.BOLD,20));
     l.add(l5);
     
     t4 = new JLabel(address);
     t4.setBounds(170,220,300,30);
     t4.setFont(new Font("serif",Font.BOLD,20));
     l.add(t4);
     
      l6 = new JLabel("Mobile No:");
     l6.setBounds(10,270,100,30);
     l6.setFont(new Font("serif",Font.BOLD,20));
     l.add(l6);
     
     t5 = new JLabel(phone);
     t5.setBounds(170,270,300,30);
     t5.setFont(new Font("serif",Font.BOLD,20));
     l.add(t5);
     
      l7 = new JLabel("Email Id:");
     l7.setBounds(10,320,100,30);
     l7.setFont(new Font("serif",Font.BOLD,20));
     l.add(l7);
     
     t6 = new JLabel(email);
     t6.setBounds(170,320,300,30);
     t6.setFont(new Font("serif",Font.BOLD,20));
     l.add(t6);
     
      l8 = new JLabel("Education");
     l8.setBounds(10,370,100,30);
     l8.setFont(new Font("serif",Font.BOLD,20));
     l.add(l8);
     
     t7 = new JLabel(education);
     t7.setBounds(170,370,300,30);
     t7.setFont(new Font("serif",Font.BOLD,20));
     l.add(t7);
     
      l9 = new JLabel("Designation:");
     l9.setBounds(10,420,100,30);
     l9.setFont(new Font("serif",Font.BOLD,20));
     l.add(l9);
     
     t8 = new JLabel(post);
     t8.setBounds(170,420,300,30);
     t8.setFont(new Font("serif",Font.BOLD,20));
     l.add(t8);
     
     b1 = new JButton("Print");
     b1.setBackground(Color.GREEN);
     b1.setForeground(Color.WHITE);
     b1.setBounds(60,520,100,30);
     b1.addActionListener(this);
     l.add(b1);
     
     b2 = new JButton("Cancel");
     b2.setBackground(Color.RED);
     b2.setForeground(Color.WHITE);
     b2.setBounds(200,520,100,30);
     b2.addActionListener(this);
     l.add(b2);
     dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        JOptionPane.showMessageDialog(null,"Printed Successfully");
            setVisible(false);
        new HomePage();
        }
        if(ae.getSource()==b2){
        setVisible(false);
        new View_Employee();
        }
    }
}
