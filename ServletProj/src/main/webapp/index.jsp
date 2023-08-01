<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="row">
        <div class="col text-center">
            <h1>Select</h1>
            <form action="Select">
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary" value="user" name="user">User</button>
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary" value="admin" name="admin">Admin</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
