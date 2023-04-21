<%@ page import="java.sql.*" %>
<%
    // Retrieve the form data
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String country = request.getParameter("country");

    // Connect to the database
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");

        // Insert the data into the table
        String sql = "INSERT INTO users (name, password, email, country) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.setString(3, email);
        stmt.setString(4, country);
        int rowsInserted = stmt.executeUpdate();

        // Display the success message
        out.println("<h1>Registration Successful!</h1>");
    } catch (ClassNotFoundException e) {
        // Display the error message
        out.println("<h1>Database Error!</h1>");
        e.printStackTrace();
    } catch (SQLException e) {
        // Display the error message
        out.println("<h1>Registration Failed!</h1>");
        e.printStackTrace();
    } finally {
        // Close the database connection and statement
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
