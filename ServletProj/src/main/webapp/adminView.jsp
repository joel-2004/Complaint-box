<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Dashboard</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setHeader("Expires", "0"); //proxy
if (session.getAttribute("username") == null) {
    response.sendRedirect("AdminLogin.jsp");
} else {
    String username = (String) session.getAttribute("username");
    if (!"admin".equalsIgnoreCase(username)) {
        response.sendRedirect("AdminLogin.jsp");
    }
}

// Database configuration
String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/XE"; // Replace 'your_database_name' with the actual database name
String dbUsername = "SYSTEM"; // Replace 'your_database_username' with the actual database username
String dbPassword = "12345678"; // Replace 'your_database_password' with the actual database password

try {
    // Load the MySQL JDBC driver
    Class.forName("oracle.jdbc.driver.OracleDriver");
    // Create a connection to the database
    Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

    // Create a statement to execute SQL queries
    Statement statement = connection.createStatement();

    // Execute the SQL query to fetch data from the "complaints" table
    String sqlQuery = "SELECT title, description,name FROM complaint";
    ResultSet resultSet = statement.executeQuery(sqlQuery);

    // Process the result set and print the titles and descriptions
    while (resultSet.next()) {
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String name=resultSet.getString("name");
        out.println("<h2>Title: " + title + "</h2>");
        out.println("<p>Description: " + description + "</p>");
        out.println("<p>Complanint by the user: " + name + "</p>");
        out.println("<hr>");
    }

    // Close the result set, statement, and connection
    resultSet.close();
    statement.close();
    connection.close();
   
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
    e.printStackTrace();
}
%>
<form action="Logout">
<button type="submit">Logout</button>
</form>
</body>
</html>
