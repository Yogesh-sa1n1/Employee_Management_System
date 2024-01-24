package Employee_Management;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Password extends JFrame implements ActionListener{
    JLabel l,l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;
    Font f,f1;
    
    Password(){
    setSize(500,270);
        setLocationRelativeTo(null);
        setTitle("Change Password");
        setLayout(null);
        
        f = new Font("Lucida Fax",Font.BOLD,25);
        f1 = new Font("Lucida Fax",Font.PLAIN,20);
        l= new JLabel("Change Password");
        l.setBounds(120,5,250,50);
        l.setFont(f);
        add(l);
    
        l1 = new JLabel("Old Password");
        l1.setBounds(20,60,150,30);
        l1.setFont(f1);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(220,60,250,30);
        t1.setFont(f1);
        add(t1);
        
        l2 = new JLabel("New Password");
        l2.setBounds(20,100,150,30);
        l2.setFont(f1);
       
        add(l2);
        
        t2 = new JTextField();
        t2.setBounds(220,100,250,30);
        t2.setFont(f1);
        add(t2);
        
        l3 = new JLabel("Confirm Password");
        l3.setBounds(20,140,200,30);
        l3.setFont(f1);
        add(l3);
        
        t3 = new JTextField();
        t3.setBounds(220,140,250,30);
        t3.setFont(f1);
        add(t3);
        
        b1 = new JButton("Change Password");    
        b1.setBounds(220,180,250,30);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        b1.setFont(f1);
        b1.addActionListener(this);
        add(b1);
    
    dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSED));
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    String Old = t1.getText();
    String com="";
    String New = t2.getText();
    String Confirm = t3.getText();
    if(ae.getSource()==b1){
        try{
            ConnectionClass con = new ConnectionClass();
            String q = "select password from logindata where username='admin'";
            ResultSet rs = con.stm.executeQuery(q);
            while(rs.next()){
            com= rs.getString("password");
            }
            if(Old.equals(com)){
                if((New.equals(Confirm)) && !(New.equals(""))){
                    try{
                    String str="update logindata set Password='"+Confirm+"'";
                    int r =con.stm.executeUpdate(str);
                    if(r==1){
                        setVisible(false);
                    JOptionPane.showMessageDialog(null,"Password is changed successfylly");
                    }
                    }
                    catch(Exception e ){
                    e.printStackTrace();
                    }
        }
                else{
            JOptionPane.showMessageDialog(null, "Please enter correct password");
            }
            }
            else{
            JOptionPane.showMessageDialog(null, "Please enter correct password");
            }
        }
        catch(Exception e){e.printStackTrace();}   
    }
    }
}
