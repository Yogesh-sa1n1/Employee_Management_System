package Employee_Management;
import java.sql.*;

public class ConnectionClass {
    Connection con;
    Statement stm;
 public ConnectionClass() {
    try{
     Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","");
    stm = con.createStatement();
    System.out.print(con);
          
    }
    catch(Exception e){e.printStackTrace();}
}   
    public static void main(String[] args) {
        new ConnectionClass();
    }
}
