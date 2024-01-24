package Employee_Management;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.Border;
import java.util.regex.*;

public class Add_Employee extends JFrame implements ActionListener{
   
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JButton b,b1;
    JDateChooser dcdob;
    Choice ch1;
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    Add_Employee(){
        
        
        setSize(900,600);
        setLocationRelativeTo(null);
        l = new JLabel();
        l.setBounds(0,0,900,600);
        String str = "C:\\Users\\ys395\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\Project_photo\\t2.jpg";
        ImageIcon img = new ImageIcon(str);
        Image i1 = img.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i1);
        l.setIcon(img1);
        add(l);
        
        l1 = new JLabel("New Employee Details");
        l1.setBounds(280,30,500,50);
        l1.setFont(new Font("Serif",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        l.add(l1);
        
        l2 = new JLabel("Name");
        l2.setBounds(50,150,150,30);
        l2.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(210,150,150,30);
        l.add(t1);
        
        l3 = new JLabel("Father Name");
        l3.setBounds(450,150,200,30);
        l3.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l3);
        
        t2 = new JTextField();
        t2.setBounds(600,150,150,30);
        l.add(t2);
        
        l4 = new JLabel("Age");
        l4.setBounds(50,200,100,30);
        l4.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l4);
        
        t3 = new JTextField();
        t3.setBounds(210,200,150,30);
        l.add(t3);
        
        l5 = new JLabel("Date of Birth");
        l5.setBounds(450,200,200,30);
        l5.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l5);
        
        dcdob = new JDateChooser();
    dcdob.setBounds(600,200,150,30);
    l.add(dcdob);
        
        
        l6 = new JLabel("Address");
        l6.setBounds(50,250,100,30);
        l6.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l6);
        
        t5 = new JTextField();
        t5.setBounds(210,250,150,30);
        l.add(t5);
        
        l7 = new JLabel("Phone");
        l7.setBounds(450,250,100,20);
        l7.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l7);
        
        t6 = new JTextField();
        t6.setBounds(600,250,150,30);
        l.add(t6);
        
        l8 = new JLabel("Email Id");
        l8.setBounds(50,300,100,30);
        l8.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l8);
        
        t7 = new JTextField();
        t7.setBounds(210,300,150,30);
        l.add(t7);
        
        l9 = new JLabel("Education");
        l9.setBounds(450,300,100,30);
        l9.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l9);
        
        t8 = new JTextField();
        t8.setBounds(600,300,150,30);
        l.add(t8);
        
        ch1 = new Choice();
        ch1.add("Software Developer");
        ch1.add("Data Scientist");
        ch1.add("Web Developer");
        ch1.add("Marketing Specialist");
        ch1.add("Product Manager");
        ch1.add("Sales Manager");
        ch1.add("Network Engineer");
        ch1.add("Security Engineer");
        ch1.setBounds(210,350,150,30);
        ch1.setFont(new Font("Aerial",Font.BOLD,13));
        ch1.setBackground(Color.BLACK);
        l.add(ch1);
        
        l10 = new JLabel("Designation");
        l10.setBounds(50,350,150,30);
        l10.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l10);
        
//        t9 = new JTextField();
//        t9.setBounds(200,350,150,30);
//        l.add(t9);
        
         l11 = new JLabel("Aadhar No");
        l11.setBounds(450,350,100,30);
        l11.setFont(new Font("Aerial",Font.BOLD,20));
        l.add(l11);
        
        t10 = new JTextField();
        t10.setBounds(600,350,150,30);
        l.add(t10);
        
         l12 = new JLabel("Employee Id");
        l12.setBounds(50,400,150,30);
        l12.setFont(new Font("Arial",Font.BOLD,20));
        l.add(l12);
        
        l13= new JLabel("99"+number);
        l13.setBounds(210,400,150,30);
        l13.setFont(new Font("Arial",Font.BOLD,20));
        l.add(l13);
        
        l14 = new JLabel("Salary");
        l14.setBounds(450,400,100,30);
        l14.setFont(new Font("Arial",Font.BOLD,20));
        l.add(l14);
        
        t4 = new JTextField();
        t4.setBounds(600,400,150,30);
        l.add(t4);
        
        b = new JButton("SUBMIT");
        b.setBackground(Color.GREEN);
        b.setForeground(Color.WHITE);
        b.setBounds(250,500,150,40);
        l.add(b);
        
        b1 = new JButton("CANCEL");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,500,150,40);
        l.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setTitle("Add Employee");
        setLayout(null);
        setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    
        String name = t1.getText();
        String fname = t2.getText();
        String age=t3.getText();
        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String address = t5.getText();
        String phone = t6.getText();
        String email = t7.getText();
        String education = t8.getText();
        String post = ch1.getSelectedItem();
        String aadhar = t10.getText();
        String eid = l13.getText();
        String salary = t4.getText();
        boolean f1=true,f2=true,f3=true,f4=true,f7=true;
        if(ae.getSource()==b){
             try
            {int a;
            if(name.equals("")){
             a=Integer.parseInt("S");}
            t1.setBorder(BorderFactory.createLineBorder(Color.white));  
        }
            catch(NumberFormatException e)
        {
            f7=false;
            Border border = BorderFactory.createLineBorder(Color.RED, 3);
            t1.setBorder(border);
        }
          
            try
        {
            int num=Integer.parseInt(age);

            t3.setBorder(BorderFactory.createLineBorder(Color.white));
                
        }
            catch(NumberFormatException e)
        {
            f1=false;
            Border border = BorderFactory.createLineBorder(Color.RED, 3);
            t3.setBorder(border);
        }
        
            try{
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
        Matcher match = ptrn.matcher(phone); 
        boolean f=(match.find() && match.group().equals(phone)); 
        if(f==false){
        int num=Integer.parseInt("S");}
        else{
        t6.setBorder(BorderFactory.createLineBorder(Color.white));
        }}
         catch(NumberFormatException e){
         f2=false;
         Border border = BorderFactory.createLineBorder(Color.RED, 3);
            t6.setBorder(border);
         
         }
        
            try{
       String regex = "^(.+)@(.+)$";
       Pattern pattern = Pattern.compile(regex);  
       Matcher matcher = pattern.matcher(email);  
       boolean em = matcher.matches();
        if(em==false){
        int num1=Integer.parseInt("S");}
        else{
        t7.setBorder(BorderFactory.createLineBorder(Color.white));}
            }
            catch(NumberFormatException e){
         f3=false;
         Border border = BorderFactory.createLineBorder(Color.RED, 3);
            t7.setBorder(border);
         }
            
        int num2;
        try{
        if(aadhar.length()==12){
        t10.setBorder(BorderFactory.createLineBorder(Color.white));
        }
        else 
               num2=Integer.parseInt("S");
        }
        catch(NumberFormatException e){
         f4=false;
         Border border = BorderFactory.createLineBorder(Color.RED, 3);
            t10.setBorder(border);
         
         }
        
   
           if(f1==true && f2==true && f3==true && f4==true && f7==true) 
           {
            try{
        ConnectionClass obj = new ConnectionClass();
        String q = "insert into EMP values('"+eid+"','"+name+"','"+fname+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+post+"','"+aadhar+"','"+salary+"')";
        obj.stm.executeUpdate(q);
        JOptionPane.showMessageDialog(null,"Details Successfully inserted");
        setVisible(false);
         new Add_Employee();
            }
            catch(Exception e){e.printStackTrace();}
           }
           else
              JOptionPane.showMessageDialog(null,"Entered field is not valid");  
        }
        if(ae.getSource()==b1){
        setVisible(false);
        }   }
    }
