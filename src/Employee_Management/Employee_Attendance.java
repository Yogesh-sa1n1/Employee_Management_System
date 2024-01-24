package Employee_Management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Employee_Attendance extends JFrame implements ActionListener {
JLabel l1,l2,l3,l4,l5,l6;
Choice c1,c2,c3;
JButton b1,b2;
Font f;
JPanel p;
JTextField t1,t2,t3;

Employee_Attendance(){
    super("Employee Attendance");
    setSize(450,300);
    setResizable(false);
    setLocation(300,200);
    f = new Font("senserif",Font.BOLD,15);
    
    l1 = new JLabel("Select Employee ID");
    l2 = new JLabel("Date");
    l3 = new JLabel("Attendance");
    l4 = new JLabel("Name");
    l5 = new JLabel("Email");
    
    t1 = new JTextField();
    t2 = new JTextField();
    
    t1.setFont(f);
    t2.setFont(f);
    l1.setFont(f);
    l2.setFont(f);
    l3.setFont(f);
    l4.setFont(f);
    l5.setFont(f);
    
    t1.setEditable(false);
    t2.setEditable(false);
    
    t3= new JTextField();
    t2.setBackground(Color.BLACK);
    t2.setForeground(Color.WHITE);
    Date  d= new Date();
    SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
    String dat = sim.format(d);
    t3.setText(dat);
    
    c3 =new Choice();
    c3.setBackground(Color.BLACK);
    c3.setForeground(Color.WHITE);
    c3.add("Present");
    c3.add("Absent");
    
    b1 = new JButton("Submit");
    b2 = new JButton("Close");
    
    b1.setBackground(Color.GREEN);
    b1.setForeground(Color.WHITE);
    
    b2.setBackground(Color.RED);
    b2.setForeground(Color.WHITE);
    
    b1.setFont(f);
    b2.setFont(f);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    
    c1 = new Choice();
    c1.setBackground(Color.BLACK);
    c1.setForeground(Color.WHITE);
    try{
        ConnectionClass obj = new ConnectionClass();
        String str = "select Eid from emp";
        ResultSet rs = obj.stm.executeQuery(str);
        while(rs.next()){
        c1.add(rs.getString("Eid"));
        }
        }
        catch(Exception e){
        e.printStackTrace();}
    
    p= new JPanel();
    p.setLayout(new GridLayout(6,2,10,10));
    
    p.add(l1);p.add(c1);
    p.add(l4);p.add(t1);
    p.add(l5);p.add(t2);
    p.add(l2);p.add(t3);
    p.add(l3);p.add(c3);
    p.add(b1);p.add(b2);
    
    add(p);
    
    c1.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent arg0){
    try{
    ConnectionClass obj2 = new ConnectionClass();
    String eid = c1.getSelectedItem();
    String q2 = "select * from emp where eid='"+eid+"'";
    ResultSet rset = obj2.stm.executeQuery(q2);
    while(rset.next()){
        t1.setText(rset.getString("name"));
        t2.setText(rset.getString("email"));
    }
    }
    catch(Exception e){e.printStackTrace();}
    
    }
    });
    setVisible(true);
}

public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
String c_id = c1.getSelectedItem();
String c_first = t3.getText();
String c_second = c3.getSelectedItem();
String name = t1.getText();
String email = t2.getText();
String dt = new java.util.Date().toString();
List a=new ArrayList();
try{
    ConnectionClass o = new ConnectionClass();
    String s = "select Date from attendance where Eid='"+c_id+"'";
    ResultSet rs = o.stm.executeQuery(s);
    while(rs.next()){
    a.add(rs.getString("Date"));
    }}
catch(Exception e){e.printStackTrace();}
if(!(a.contains(c_first))){
try{
ConnectionClass obj = new ConnectionClass();
String s = "insert into attendance values('"+c_id+"','"+name+"','"+email+"','"+c_first+"','"+c_second+"','"+dt+"')";
obj.stm.executeUpdate(s);
JOptionPane.showMessageDialog(null,"Data is inserted successfully");
setVisible(false);
}
catch(Exception e){e.printStackTrace();}
}
else {
JOptionPane.showMessageDialog(null,"Attendance is already done");
}}
if(ae.getSource()==b2){
JOptionPane.showMessageDialog(null,"Are you sure to close?");
setVisible(false);
}}
 }
