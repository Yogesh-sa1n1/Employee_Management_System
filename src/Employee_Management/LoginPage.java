package Employee_Management;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.util.Properties;

public class LoginPage extends JFrame implements ActionListener{
    JLabel lbusername,lbpsd,log;
    JPasswordField tfpsd;
    JTextField tfusername;
    JButton login,cancel;
    public LoginPage(){
        displayWelcomeScreen();
        setLayout(null);
        setTitle("Login Form");
        
     JPanel p = new JPanel();
     p.setBounds(0,0,400,500);
     p.setBackground(Color.BLACK);
     p.setLayout(null);

     add(p);
    String imagepath = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee_Management_System\\src\\Project_photo\\workbuddy.png";
    ImageIcon img = new ImageIcon(imagepath);
    Image i2 = img.getImage().getScaledInstance(400, 480,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0,0,400,480);
    p.add(label);       
    
     JPanel p2 = new JPanel();
     p2.setBounds(400,0,400,500);
     p2.setBackground(Color.BLACK);
     p2.setForeground(Color.WHITE);
     add(p2);    
     p2.setLayout(null);
     log = new JLabel("Login");
     log.setBounds(150,15,150,33);
     log.setFont(new Font("Times New Roman",Font.BOLD,30));
     log.setForeground(Color.WHITE);
     p2.add(log);
     
     JLabel logi = new JLabel("Hello Let's get started");
     logi.setBounds(115,50,200,20);
     logi.setFont(new Font("Times New Roman",Font.PLAIN,15));
     logi.setForeground(Color.WHITE);
     p2.add(logi);
     
      lbusername = new JLabel("USERNAME");
        lbusername.setBounds(30,90,250,30);
        lbusername.setFont(new Font("Times New Roman",Font.PLAIN,20));
        lbusername.setForeground(Color.WHITE);
        p2.add(lbusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(30,130,300,30);
        tfusername.setFont(new Font("Serif",Font.PLAIN,20));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
         lbpsd = new JLabel("PASSWORD");
         lbpsd.setForeground(Color.WHITE);
         lbpsd.setFont(new Font("Times New Roman",Font.PLAIN,20));
        lbpsd.setBounds(30,180,250,30);
        p2.add(lbpsd);
        
        tfpsd = new JPasswordField();
        tfpsd.setBorder(BorderFactory.createEmptyBorder());
        tfpsd.setFont(new Font("Serif",Font.PLAIN,20));
        tfpsd.setBounds(30,220,300,30);
        p2.add(tfpsd);
        
         login = new JButton("Login");
        login.setBounds(30,280,300,40);
        login.setForeground(Color.WHITE);
        login.setFocusable(false);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setFont(new Font("Times New Roman",Font.PLAIN,20));
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);
        
         cancel = new JButton("Cancel");
        cancel.setBounds(30,350,300,40);
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusable(false);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.setFont(new Font("Times New Roman",Font.PLAIN,20));
        cancel.setBorder(BorderFactory.createEmptyBorder());
        p2.add(cancel);
       
     setResizable(false);
    setSize(800,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==login)
        {
        try{
            ConnectionClass obj = new ConnectionClass();
            String name = tfusername.getText();
            String pass = tfpsd.getText();
            String q = "select * from logindata where username='"+name+"' and password='"+pass+"'";
            ResultSet rs = obj.stm.executeQuery(q);
            if(rs.next()){
                
Properties p = new Properties();
p.put("windowTitleFont", "Ebrima PLAIN 15");
p.put("logoString", "");
NoireLookAndFeel.setCurrentTheme(p);
UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            new HomePage().setVisible(true);
            this.setVisible(false);
         
            }
            else{
            JOptionPane.showMessageDialog(null,"You have entered wrong Username and Password");
            this.setVisible(true);
            tfusername.setText("");
            tfpsd.setText("");
            
            }            
        }
        catch(Exception e){e.printStackTrace();}}
        
        if(ae.getSource()==cancel){
        dispose();
        
        }
    }
    
    public static void main(String[] args) throws Exception{
        String str = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
        UIManager.setLookAndFeel(str);
        new LoginPage();
    }
    private void displayWelcomeScreen(){
   final JWindow w = new JWindow(this);
    w.setSize(800,500);
    w.setLocationRelativeTo(null);
    w.setVisible(true);
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    w.add(panel);
    String imagepath = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee_Management_System\\src\\Project_photo\\m2.jpg";
    ImageIcon img = new ImageIcon(imagepath);
    Image i2 = img.getImage().getScaledInstance(800, 500,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0,0,800,500);
    panel.add(label);
    
    JLabel E = new JLabel("WORKFORCE SYSTEM");
    E.setBounds(120,15,600,60);
    E.setForeground(Color.ORANGE);
    E.setFont(new Font("Serif",Font.BOLD,50));
    label.add(E);   
    
    panel.setBackground(Color.WHITE);
    panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
    JProgressBar progress = new JProgressBar(0,100);
    w.add(BorderLayout.PAGE_END,progress);
    progress.setBackground(Color.WHITE);
    progress.setForeground(Color.ORANGE);
    w.revalidate();
     timer = new Timer(100,new ActionListener(){
    public void actionPerformed(ActionEvent e){
    int x=progress.getValue();
    if(x==100){w.dispose();LoginPage.this.setVisible(true);timer.stop();} 
    else{ progress.setValue(x+4);
    }
    }  
    });
    timer.start();
    }
    Timer timer;
}
