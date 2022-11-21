import java.sql.*;
public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/userdetails?characterEncoding=latin1";
            String user = "root";
            String pwd = "root7970";

            Connection con = DriverManager.getConnection(url,user,pwd);

            String q = "CREATE TABLE userinfo(userID int(10) primary key auto_increment,name varchar(50) not null , email varchar(50) not null ,password varchar(16) not null)";

            Statement stmt = con.createStatement();

            stmt.executeUpdate(q);
            System.out.println("Table Created Successfully Into Database....... ");
            con.close();

        }catch (Exception err){
            System.out.println("Server Error... Occured ");
            System.out.println("Try Again......");
            err.printStackTrace();
        }
    }
}