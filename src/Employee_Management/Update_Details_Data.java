package Employee_Management;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Update_Details_Data extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    Font f1,f2;
    Choice ch;
    
    Update_Details_Data(){
        super("Update Employee");
        setLocation(450,50);
        setSize(950,750);
        
        f1 = new Font("Arial",Font.BOLD,25);
        f2 = new Font("Arial",Font.BOLD,18);
        
        ch = new Choice();
        ch.setBackground(Color.BLACK);
        ch.setForeground(Color.WHITE);
        ch.add("");
        try{
        ConnectionClass obj = new ConnectionClass();
        String str = "select Eid from emp";
        ResultSet rs = obj.stm.executeQuery(str);
        while(rs.next()){
        ch.add(rs.getString("Eid"));
        }
        }
        catch(Exception e){
        e.printStackTrace();}
        
        l1 = new JLabel("Update Employee");
        l2 = new JLabel("Name");
        l3 = new JLabel("Father's Name");
        l4 = new JLabel("Age");
        l5 = new JLabel("Date Of Birth");
        l6 = new JLabel("Address");
        l7 = new JLabel("Phone");
        l8 = new JLabel("Email");
        l9 = new JLabel("Education");
        l10 = new JLabel("Job Post");
        l11 = new JLabel("Aadhar");
        l12 = new JLabel("Employee ID");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        
        b1 = new JButton("Update");
        b2 = new JButton("Back");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        l11.setFont(f2);
        l12.setFont(f2);
        ch.setFont(f2);
        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);
        t7.setFont(f2);
        t8.setFont(f2);
        t9.setFont(f2);
        t10.setFont(f2);
        
        b1.setFont(f2);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        b2.setFont(f2);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1); 
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,0,0));
        
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(12,2,10,10));
        
        p3.add(l12);
        p3.add(ch);
        p3.add(l2);
        p3.add(t1);
        p3.add(l3);
        p3.add(t2);
        p3.add(l4);
        p3.add(t3);
        p3.add(l5);
        p3.add(t4);
        p3.add(l6);
        p3.add(t5);
        p3.add(l7);
        p3.add(t6);
        p3.add(l8);
        p3.add(t7);
        p3.add(l9);
        p3.add(t8);
        p3.add(l10);
        p3.add(t9);
        p3.add(l11);
        p3.add(t10);
        p3.add(b1);
        p3.add(b2);
        
        String imagepath = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\Project_photo\\img1.jpg";
    ImageIcon img = new ImageIcon(imagepath);
    Image i2 = img.getImage().getScaledInstance(400, 700,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
     l12 = new JLabel(i3);
     p2.add(l12);
     
     setLayout(new BorderLayout(10,10));
     add(p1,"North");
     add(p2,"West");
     add(p3,"Center");
     p1.setBackground(Color.BLACK);
     p2.setBackground(Color.BLACK);
     p3.setBackground(Color.BLACK);
     
     ch.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
    
     try{
     ConnectionClass obj1 = new ConnectionClass();
     String eid = ch.getSelectedItem();
     String q1 = "select * from EMP where Eid='"+eid+"'";
     ResultSet rst = obj1.stm.executeQuery(q1);
     while(rst.next()){
     t1.setText(rst.getString("name"));
     t2.setText(rst.getString("fname"));
     t3.setText(rst.getString("age"));
     t4.setText(rst.getString("dob"));
     t5.setText(rst.getString("address"));
     t6.setText(rst.getString("phone"));
     t7.setText(rst.getString("email"));
     t8.setText(rst.getString("education"));
     t9.setText(rst.getString("post"));
     t10.setText(rst.getString("aadhar"));
     }
     }
     catch(Exception e){e.printStackTrace();}
     }
     });
     dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    String id = ch.getSelectedItem();
    String name = t1.getText();
    String fname = t2.getText();
    String age = t3.getText();
    String dob = t4.getText();
    String address = t5.getText();
    String phone = t6.getText();
    String email = t7.getText();
    String education = t8.getText();
    String job_post = t9.getText();
    String aadhar = t10.getText();
    
    if(ae.getSource()==b1){
    try{
        ConnectionClass obj3= new ConnectionClass();
        String st = "update EMP Set name='"+name+"',fname='"+fname+"',age='"+age+"',dob='"+dob+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',post='"+job_post+"',aadhar='"+aadhar+"' where Eid='"+id+"'";
        int aa=obj3.stm.executeUpdate(st);
        if(aa==1){
        JOptionPane.showMessageDialog(null,"Details Successfully inserted");
        setVisible(false);
        new Update_Details_Data();
            }
        else JOptionPane.showMessageDialog(null,"Fill all details carefully");
    }
            catch(Exception e){e.printStackTrace();}
    }
    if(ae.getSource()==b2){dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));setVisible(false);}
    
    }
}
