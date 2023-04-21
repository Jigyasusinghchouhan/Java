import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class downloadFile
 */
public class downloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public downloadFile() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String filename = "abc.txt";
		String filepath = "C:\\Users\\Poojan Patel\\eclipse-workspace\\ServletPrograms\\src\\main\\webapp\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		FileInputStream fileInput = new FileInputStream(filepath+filename);
		int i;
		while((i = fileInput.read()) != -1 ) {
			pw.write(i);
		}
		fileInput.close();
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
