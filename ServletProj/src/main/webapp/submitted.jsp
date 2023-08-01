<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Page</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0");//proxy
if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<p>
<h1>Submitted</h1>
<p>
<a href="Welcome.jsp">Submit another complaint</a>
</p>
<p>
<form action="Logout">
<button type="submit">Logout</button>
</form>

</body>
</html>