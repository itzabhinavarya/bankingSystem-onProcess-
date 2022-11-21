import java.sql.*;
import java.util.Scanner;

public class insert {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/userdetails?characterEncoding=latin1";
            String user = "root";
            String pwd = "root7970";

            Connection con = DriverManager.getConnection(url,user,pwd);

            String q = "INSERT INTO userinfo(name,email,password)VALUES(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(q);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Your Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Your Email : ");
            String email = sc.nextLine();
            System.out.print("Set a Password : ");
            String password = sc.nextLine();

            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);

            pstmt.executeUpdate();
            System.out.println("Data Inserted Successfully Into Database....... ");
            con.close();

        }catch (Exception err){
            System.out.println("Server Error... Occured ");
            System.out.println("Try Again......");
            err.printStackTrace();
        }
    }
}