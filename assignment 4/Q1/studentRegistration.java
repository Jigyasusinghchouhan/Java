import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class studentRegistrartion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public studentRegistrartion() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DB_URL = "jdbc:mysql://localhost:3306/ServletAssignment";
		String DB_Username = "root";
		String DB_Password = "Gsnp@424343";
		
		try {
			
			Connection conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
			String crateTable = "CREATE TABLE IF NOT EXISTS studentRegistration(Name varchar(20), Password varchar(20), Email varchar(50), Country varchar(20), Primary key(Email))";
			Statement stmt = conn.createStatement();
			stmt.execute(crateTable);
			
			String name = request.getParameter("st_name");
			String password = request.getParameter("st_pass");
			String email = request.getParameter("st_email");
			String country = request.getParameter("st_country");
			
			String insertQuery = "INSERT INTO studentRegistration(Name, Password, Email, Country) VALUES (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1,name);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, country);
			
			pstmt.executeUpdate();
			
			PrintWriter pw = response.getWriter();
			pw.printf("\n Value Inserted Successfully");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
