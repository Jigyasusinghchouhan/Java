<%@ page import="java.io.*, java.util.*, javax.servlet.*" %>
<%
    // Get the file name and path
    String fileName = "";
    String filePath = "";
    try {
        // Get the HTTP request and parts
        HttpServletRequest request = (HttpServletRequest) request;
        Collection<Part> parts = request.getParts();

        // Loop through the parts
        for (Part part : parts) {
            if (part.getName().equals("file")) {
                // If the part is the file input, get the file name and save the file
                fileName = new File(part.getSubmittedFileName()).getName();
                filePath = getServletContext().getRealPath("/uploads/" + fileName);
                part.write(filePath);
                break;
            }
        }

        // Display a success message
        out.println("<h1>File Uploaded Successfully!</h1>");
        out.println("<p>File Name: " + fileName + "</p>");
        out.println("<p>File Path: " + filePath + "</p>");
    } catch (Exception e) {
        // Display an error message
        out.println("<h1>File Upload Failed!</h1>");
        out.println("<p>Error: " + e.getMessage() + "</p>");
    }
%>

