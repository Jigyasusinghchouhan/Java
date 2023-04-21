import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost:3306/collage_db";
		String dbUsername = "root";
		String dbPassword = "1234";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);

			String sql ="SELECT * FROM student";
					Statement statement = connection. createStatement();
					ResultSet result = statement. executeQuery(sql);
					while (result. next()) {
					int userld = result.getInt("student_id");
					// String username= result.getString("username");
					// String fullname = result.getString("fullname");
					// String email= result.getString("email");
					// String password = result.getString("password");
					
					System.out.println(userld);
					}
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
