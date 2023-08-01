<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0");//proxy
if(session.getAttribute("username")==null)
{
    response.sendRedirect("Login.jsp");
}
%>

<div class="container text-center">
    <h1>Welcome ${username}</h1>
    <h1>Your complaint here</h1>
    <form action="Complaint">
        <div class="form-group">
            <h2><label for="title">Title</label></h2>
            <input type="text" name="title" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="desc">Description</label>
            <textarea name="desc" class="form-control" rows="5" required></textarea>
        </div>
        <div class="form-group">
        <br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
    <br>
    <form action="Logout">
        <button type="submit" class="btn btn-danger">Logout</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
