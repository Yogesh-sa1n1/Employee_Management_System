package Employee_Management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Employee extends JFrame implements ActionListener {
    
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;
    View_Employee(){
        setTitle("View Employee");
        setBackground(Color.GREEN);
        setLayout(null);
        
        
        
        
        String imagepath = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\Project_photo\\t1.jpg";
    ImageIcon img = new ImageIcon(imagepath);
    Image i2 = img.getImage().getScaledInstance(500, 270,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
     l1 = new JLabel(i3);
      l1.setBounds(0,0,500,270);
     l1.setIcon(i3);
   
    
        
    l2 = new JLabel("Employee id");
    l2.setVisible(true);
    l2.setBounds(240,40,250,35);
    l2.setForeground(Color.WHITE);
    l2.setFont(new Font("Aerial",Font.BOLD,30));
    l1.add(l2);
    add(l1);
    
    t = new JTextField();
    t.setBounds(240,90,220,30);
    l1.add(t);
    
    b = new JButton("Search");
    b.setBounds(240,150,100,30);
    b.setForeground(Color.WHITE);
    b.setBackground(Color.GREEN);
    b.addActionListener(this);
    l1.add(b);
    
    b2 = new JButton("Cancel");
    b2.setBackground(Color.RED);
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    b2.setBounds(360,150,100,30);
    l1.add(b2);
  
    //setDefaultCloseOperation(EXIT_ON_CLOSE);
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setSize(500,270);
    setLocation(450,250);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b){
    setVisible(false);
    new View_Employee_Data(t.getText());
    }
    if(ae.getSource()==b2){
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    }
    
}
