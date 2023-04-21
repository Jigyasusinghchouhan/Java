<%@ page import="java.io.*, javax.servlet.*" %>
<%
    // Get the file name from the request parameter
    String fileName = request.getParameter("file");

    // Set the MIME type for the file
    response.setContentType("application/pdf");

    // Set the content-disposition header to force the browser to download the file
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

    // Get the file input stream and output stream
    InputStream in = new FileInputStream(getServletContext().getRealPath("/downloads/" + fileName));
    OutputStream out = response.getOutputStream();

    // Write the file to the output stream
    byte[] buffer = new byte[4096];
    int bytesRead = -1;
    while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
    }

    // Close the streams
    in.close();
    out.close();
%>
