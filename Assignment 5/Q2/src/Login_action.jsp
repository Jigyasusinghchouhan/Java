<%@ page import="java.sql.*" %>
<%
    // Retrieve the form data
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Connect to the database
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");

        // Check if the username and password are correct
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rs = stmt.executeQuery();

        if (rs.next()) {
            // If the username and password are correct, set the session attribute and redirect to the home page
            session.setAttribute("username", username);
            response.sendRedirect("login.jsp");
        } else {
            // If the username and password are incorrect, display an error message
            out.println("<h1>Login Failed!</h1>");
            out.println("<p>Incorrect username or password. Please try again.</p>");
        }
    } catch (ClassNotFoundException e) {
        // Display the error message
        out.println("<h1>Database Error!</h1>");
        e.printStackTrace();
    } catch (SQLException e) {
        // Display the error message
        out.println("<h1>Login Failed!</h1>");
        e.printStackTrace();
    } finally {
        // Close the database connection, statement, and result set
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
