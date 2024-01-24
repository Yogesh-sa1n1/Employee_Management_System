package Employee_Management;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Delete_Employee extends JFrame implements ActionListener {
    JTable t ,tab;
    JButton b1,b2,b3;
    JTextField t1;
    Font f,f1;
    JLabel l1,l2;
    JScrollPane jsp,jsp1;
    
    Delete_Employee(){
        super("All Employee Details");
    setLayout(null);
    f = new Font("MS UI Gothic",Font.BOLD,17);
    f1 = new Font("Lucida Fax",Font.BOLD,25);
    l1 = new JLabel("Delete any Employee");
    l1.setHorizontalAlignment(JLabel.CENTER);
    l1.setBounds(250,5,400,40);
    l1.setFont(f1);
    add(l1);
    
    l2 = new JLabel("Employee ID");
    l2.setBounds(20,40,300,30);
    l2.setFont(f);
    add(l2);
    
    t1 = new JTextField();
    t1.setBounds(20,70,300,30);
    t1.setFont(f);
    add(t1);
    
    b3 = new JButton("All");
    b3.setBounds(20,110,90,30);
    b3.setFont(f);
    b3.setBackground(Color.BLUE);
    b3.addActionListener(this);
    add(b3);
    
    b1 = new JButton("Delete");
    b1.setBounds(120,110,90,30);
    b1.setFont(f);
    b1.setBackground(Color.GREEN);
    b1.addActionListener(this);
    add(b1);
    
     b2 = new JButton("Cancel");
    b2.setBounds(220,110,100,30);
    b2.setFont(f);
    b2.setBackground(Color.RED);
    b2.addActionListener(this);
    add(b2);
    
    t= new JTable();
    
    
    try{
    ConnectionClass obj = new ConnectionClass();
    String q = "select Eid,Name,Email,Age,Dob,Post from EMP";
    ResultSet rs = obj.stm.executeQuery(q);
    t.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){e.printStackTrace();}
     jsp = new JScrollPane(t);
    jsp.setBounds(0,150,900,700);
     add(jsp);  
     
     setSize(900,700);
    setLocationRelativeTo(null);
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae){
    String eid = t1.getText();
    if(ae.getSource()==b3){
        t= new JTable();
    try{
    ConnectionClass obj = new ConnectionClass();
    String q = "select Eid,Name,Email,Age,Dob,Post from EMP";
    ResultSet rs = obj.stm.executeQuery(q);
    t.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){e.printStackTrace();}
     jsp = new JScrollPane(t);
    jsp.setBounds(0,150,900,700);
     add(jsp);  
    }
    if(ae.getSource()==b1){
        jsp.setVisible(false);
         tab = new JTable();
    try{
    ConnectionClass obj = new ConnectionClass();
    String q = "delete from emp where eid ='"+eid+"'";
    String q1 = "delete from apply_leave where eid='"+eid+"'";
    String q2 = "delete from attendance where eid='"+eid+"'";
    int res = obj.stm.executeUpdate(q);
   
    if(res==1){
        
        JOptionPane.showMessageDialog(null,"Your data successfully deleted");
         obj.stm.executeUpdate(q1);
        obj.stm.executeUpdate(q2);
        this.setVisible(false);
        new Delete_Employee().setVisible(true);
    }
    else{
        JOptionPane.showMessageDialog(null,"Please enter correct Employee Id");
        this.setVisible(false);
        new Delete_Employee().setVisible(true);
    }
    }
    
    catch(Exception e){e.printStackTrace();} 
    try{
    ConnectionClass obj1 = new ConnectionClass();
     String qu ="select Eid,Name,Email,Age,Dob,Post from emp";
    ResultSet rs = obj1.stm.executeQuery(qu);
    tab.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){e.printStackTrace();}
     jsp1 = new JScrollPane(tab);
    jsp1.setBounds(0,150,900,700);
    jsp1.setVisible(true);
     add(jsp1); 
    }
    if(ae.getSource()==b2){ dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));}
    }   
}
