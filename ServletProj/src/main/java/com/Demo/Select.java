package com.Demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String user=request.getParameter("user");
String admin=request.getParameter("admin");
if (user != null && !user.isEmpty()) {
    response.sendRedirect("Login.jsp");
} else if (admin != null && !admin.isEmpty()) {
    response.sendRedirect("AdminLogin.jsp");
	}
	}

}
