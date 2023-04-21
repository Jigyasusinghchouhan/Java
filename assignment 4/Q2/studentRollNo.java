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
import java.sql.ResultSet;


public class studentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public studentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL="jdbc:mysql://localhost:3306/ServletAssignment";
		String USERNAME="root";
		String PASSWORD="Gsnp@424343";
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><body>");
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			int rollNo = Integer.parseInt(request.getParameter("roll_no"));
			String s = "Select * from studentresult where RollNo=?";
			PreparedStatement pstmt = conn.prepareStatement(s);
			pstmt.setInt(1,rollNo);
			ResultSet rs = pstmt.executeQuery();
			pw.println("<table border=5px>");
			pw.println("<tr><td><b> Name </b></td><td><b> RollNo </b></td><td><b> Result </b></td></tr>");
			while(rs.next())
			{
				String name = rs.getString(1);
				int roll_no = rs.getInt(2);
				float result  = rs.getFloat(3);
				pw.println("<br><td>"+name+"</td><td>"+roll_no+"</td><td>"+result+"</td>");
				
			}
			pw.println("</table>");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
