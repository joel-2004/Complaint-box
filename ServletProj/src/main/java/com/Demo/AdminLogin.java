package com.Demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String pass=request.getParameter("password");

		if(name.equals("admin")&&pass.equals("admin"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("username",name);
			response.sendRedirect("adminView.jsp");
		}
		else {
			response.sendRedirect("AdminLogin.jsp");
		}
		

	}

	
}
