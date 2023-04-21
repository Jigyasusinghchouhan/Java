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
import java.sql.SQLException;

/**
 * Servlet implementation class bill_details
 */
public class bill_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public bill_details() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String URL="jdbc:mysql://localhost:3306/bill";
		String USERNAME="root";
		String PASSWORD="Gsnp@424343";
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><body>");
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			int bill_no = Integer.parseInt(request.getParameter("bill_no"));
			int total=0;
			String s = "Select * from bill_master where Bill_No=?";
			PreparedStatement pstmt = conn.prepareStatement(s);
			pstmt.setInt(1,bill_no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int b_no = rs.getInt(1);
				String name = rs.getString(2);
				String date = rs.getString(3);
				pw.println("<h5>Bill No: "+ b_no + "</h5>");
				pw.println("<h5>Customer Name: "+ name + "</h5>");
				pw.println("<h5>Date: "+ date + "</h5>");
				
			}
			String s2 = "select Item_Name,Quantity,Rate from bill_details,bill_master where bill_details.Bill_No=? and bill_details.Bill_No=bill_master.Bill_No";
			PreparedStatement pstmt2 = conn.prepareStatement(s2);
			pstmt2.setInt(1, bill_no);
			pw.println("<table border=5px>");
			pw.println("<tr><td><b> ItemName </b></td><td><b> Quantity</b></td><td><b> Rate</b></td><td><b> Total </b></td></tr>");
			ResultSet rs2 = pstmt2.executeQuery();
			while(rs2.next())
			{
				String item_name = rs2.getString(1);
				int quantity = rs2.getInt(2);
				int rate = rs2.getInt(3);
				int total1 = quantity*rate;
				pw.println("<br><td>"+item_name+"</td><td>"+quantity+"</td><td>"+rate+"</td><td>"+total1+"</td>");
				total = total+total1;
				
			}
			pw.println("</table>");
			pw.println("<br><br>");
			pw.println("\n Total bill is :"+ total +" Rupees");
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
