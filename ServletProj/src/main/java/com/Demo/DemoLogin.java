package com.Demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DemoLogin")
public class DemoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		LoginVal lv=new LoginVal();
		boolean validated=lv.valid(name,pass);
		if(validated)
		{
			HttpSession session=request.getSession();
			session.setAttribute("username",name);
			response.sendRedirect("Welcome.jsp");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
		

	}

	
}
