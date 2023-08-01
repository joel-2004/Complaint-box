package com.Demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Complaint
 */
@WebServlet("/Complaint")
public class Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("username");
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","12345678");
		PreparedStatement ps=con.prepareStatement("insert into complaint values(?,?,?)");
		ps.setString(1,title);
		ps.setString(2, desc);
		ps.setString(3, name);
		ps.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	response.sendRedirect("submitted.jsp");
	}


}
