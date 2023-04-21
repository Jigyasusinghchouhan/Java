import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbctest2 {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "mysql");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from customer");
    while (resultSet.next()) {
      int iid = resultSet.getInt("id");
      String tame = resultSet.getString("Name");
      System.out.println(iid + " " + tame);
    }
    System.out.println(
        "There are two ages in the table customer 12 and 18 . Please enter the age to know the customer names: ");
    int a = sc.nextInt();
    PreparedStatement ps = connection.prepareStatement("select name from db1.customer where age=?");
    ps.setInt(1, a);
    ResultSet rsp = ps.executeQuery();
    while (rsp.next()) {
      System.out.println("Name " + rsp.getString(1));
    }
  }
}