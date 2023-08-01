package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginVal {
public boolean valid(String name,String password) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","12345678");
	PreparedStatement pt=con.prepareStatement("select * from db where name=? and password=?");
	pt.setString(1,name);
	pt.setString(2,password);
	ResultSet rs=pt.executeQuery();
	if(rs.next()){
		return true;
	}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

}
