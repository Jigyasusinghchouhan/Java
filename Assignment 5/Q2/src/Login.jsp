<%@ page import="java.sql.*" %>
<%
    // Check if the user is already logged in
    String username = (String) session.getAttribute("username");
    if (username != null) {
        // If the user is already logged in, display the welcome message and logout link
        out.println("<h1>Welcome, " + username + "!</h1>");
        out.println("<p><a href='logout.jsp'>Logout</a></p>");
    } else {
        // If the user is not logged in, display the login form
%>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<h1>Login Form</h1>
<form method="post" action="login_action.jsp">
    <label>Username:</label>
    <input type="text" name="username"><br>
    <label>Password:</label>
    <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
<%
    }
%>
