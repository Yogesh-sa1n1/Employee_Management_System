package Employee_Management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Employee_Report extends JFrame implements ActionListener{
    
    JTable t;
    JButton print;
    Font f,f1;
    JLabel l1,l2;
    JScrollPane jsp;
    
    Employee_Report(){
        super("Employee Reports");
    setLayout(null);
    f = new Font("MS UI Gothic",Font.BOLD,17);
    f1 = new Font("Lucida Fax",Font.BOLD,25);
    l1 = new JLabel("All Employee Records");
    l1.setHorizontalAlignment(JLabel.CENTER);
    l1.setBounds(250,5,400,40);
    l1.setFont(f1);
    add(l1);
    
    print = new JButton("Print");
        print.setBounds(800,15,80,20);
        print.setBackground(Color.GREEN);
        print.setForeground(Color.WHITE);
        add(print);
        print.addActionListener(this);
    
    t= new JTable();
            t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    
    try{
    ConnectionClass obj = new ConnectionClass();
    String q = "select * from emp";
    ResultSet rs = obj.stm.executeQuery(q);
    t.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){e.printStackTrace();}
     jsp = new JScrollPane(t);
    jsp.setBounds(0,50,900,700);
     add(jsp);  
     
     setSize(900,700);
    setLocationRelativeTo(null);
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==print){
            try{t.print();}
            catch(Exception e){e.printStackTrace();}
            }
    }
    
}
