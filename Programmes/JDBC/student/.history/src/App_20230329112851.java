import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost:3306/collage_db";
		String dbUsername = "root";
		String dbPassword = "1234";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
			

			String sql ="SELECT * FROM student";
					Statement statement = connection.createStatement();
					ResultSet result = statement. executeQuery(sql);
					System.out.println("connected" );
					while (result.next()) {
					int studenid = result.getInt("student_id");
					String name= result.getString("student_name");
					String prn = result.getString("student_prn");
					String no= result.getString("student_no.");
					int percentage = result.getInt("student_percentage");
//					
					System.out.println(studenid);
					}
			connection.close();
				
				} catch (SQLException ex) {
				ex. printStackTrace();
				
		
		}
		
		}

	

}
