import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "mysql");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customer");
        while (resultSet.next()) {
            int iid = resultSet.getInt("id");
            String Fame = resultSet.getString("Name");
            System.out.println(iid + " . " + Fame);
        }
    }
}
