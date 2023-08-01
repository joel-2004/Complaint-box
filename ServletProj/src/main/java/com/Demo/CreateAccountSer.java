package com.Demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateAccountSer")
public class CreateAccountSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name=request.getParameter("name");
String pass1=request.getParameter("password");
String pass2=request.getParameter("password1");
if(!(pass1.equals(pass2)))
{
	response.sendRedirect("CreateAccount.jsp");
	return;
}
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","12345678");
PreparedStatement pt=con.prepareStatement("select * from db where name=?");
pt.setString(1,name);
ResultSet rs=pt.executeQuery();

if(rs.next())
{
	response.sendRedirect("CreateAccount.jsp");
	return;
}
else {
	PreparedStatement insert=con.prepareStatement("insert into db values(?,?)");
	
	insert.setString(1,name);
	insert.setString(2,pass1);
	insert.executeUpdate();
	response.sendRedirect("Login.jsp");
}

}catch(Exception e)
{
	System.out.println(e);
}
	}

}
