package Employee_Management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Apply_Leave extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4;
    Font f1,f2;
    Choice ch1,ch2;
    
    Apply_Leave(){
        super("Apply Employee Leave");
        setSize(950,450);
        setLocationRelativeTo(null);
        setResizable(false);
        
        f1= new Font("Arial",Font.BOLD,25);
        f2= new Font("Arial",Font.BOLD,16);
        
        l1 = new JLabel("Apply Employee Leave");
        l2 = new JLabel("Employee ID");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5= new JLabel("Start Date");
        l6 = new JLabel("End Date");
        l7 = new JLabel("Leave Reason");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.GREEN);
        b2 = new JButton("Close");
        b2.setBackground(Color.RED);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        ch1 = new Choice();
        ch1.setBackground(Color.BLACK);
        ch1.add("");
        
        try{
        
        ConnectionClass cu= new ConnectionClass();
        String q= "select Eid from emp";
                ResultSet rs = cu.stm.executeQuery(q);
        while(rs.next()){
            ch1.add(rs.getString("Eid"));
        }}
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
        ch2 = new Choice();
        ch2.add("Employee health Issue");
        ch2.add("Family Member Health Issue");
        ch2.add("Function/Celebration");
        ch2.add("Personal Things");
        ch2.add("Others");
        ch2.setBackground(Color.BLACK);
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        ch1.setFont(f2);
        ch2.setFont(f2);
        
        t1.setFont(f2);
        t2.setFont(f2);
    t3.setFont(f2);
    t4.setFont(f2);
    
    b1.setFont(f2);
    b2.setFont(f2);
    
    t1.setEditable(false);
    t2.setEditable(false);
    
    p1 = new JPanel();
    p1.setLayout(new GridLayout(1,1,10,10));
    p1.add(l1);
    
    p2 = new JPanel();
    p2.setLayout(new GridLayout(7,2,10,10));
    p2.add(l2);
    p2.add(ch1);
    p2.add(l3);
    p2.add(t1);
    p2.add(l4);
    p2.add(t2);
    p2.add(l5);
    p2.add(t3);
    p2.add(l6);
    p2.add(t4);
    p2.add(l7);
    p2.add(ch2);
   p2.add(b1);
    p2.add(b2);
    
    p3 = new JPanel();
    p3.setLayout(new GridLayout(1,1,10,10));
   
  
    String str = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\Project_photo\\delete.png";
    ImageIcon img = new ImageIcon(str);
    Image img1 = img.getImage().getScaledInstance(450, 370, Image.SCALE_DEFAULT);
            ImageIcon ic = new ImageIcon(img1);
            l8 = new JLabel(ic);
            p3.add(l8);
            setLayout(new BorderLayout());
    add(p1,"North");
    add(p2,"West");
    add(p3,"Center");
    
ch1.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent arg0){
        try{
        ConnectionClass obj = new ConnectionClass();
        String eid = ch1.getSelectedItem();
        String q1 = "select * from emp where eid='"+eid+"'";
        ResultSet rest= obj.stm.executeQuery(q1);
        while(rest.next()){
        t1.setText(rest.getString("name"));
        t2.setText(rest.getString("email"));
        }
        }
    catch(Exception e){e.printStackTrace();}
    }});
    setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
        String eid = ch1.getSelectedItem();
        String name=t1.getText();
        String email = t2.getText();
        String startdt =t3.getText();
        String edd= t4.getText();
        String reason= ch2.getSelectedItem();
        String apply = new java.util.Date().toString();
        
        try{
        ConnectionClass obj2 = new ConnectionClass();
        String q1 = "insert into apply_leave values('"+eid+"','"+name+"','"+email+"','"+startdt+"','"+edd+"','"+reason+"','"+apply+"')";
        int aa = obj2.stm.executeUpdate(q1);
        if(aa==1){JOptionPane.showMessageDialog(null,"Your data successfully Updated");}
        else JOptionPane.showMessageDialog(null,"Please, Fill all details carefully");
        }
        catch(Exception e){e.printStackTrace();}
        }
    
        if(ae.getSource()==b2){
        JOptionPane.showMessageDialog(null, "Are you sure to close");
        this.setVisible(false);       
    }}
   }
