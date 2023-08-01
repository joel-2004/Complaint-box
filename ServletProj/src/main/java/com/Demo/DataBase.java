package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
public static void main(String[] args) {
	//displayTable();
	createTable();
}
	static void createTable() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","12345678");
		Statement st=con.createStatement();	
		//st.executeQuery("drop table complaint");
//		st.executeQuery("create table db(name varchar(30),password varchar(30))");
//		st.executeQuery("insert into db values('joel','1234')");
		st.executeQuery("create table complaint(title varchar(30), description varchar(300),name varchar(30))");
	} catch (Exception e) {

		e.printStackTrace();
	}
	
}
	static void displayTable()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","12345678");
				Statement st=con.createStatement();	
		//	st.executeQuery("delete from db where password='demo'");
				ResultSet rs=st.executeQuery("select * from complaint");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2));
				}
						
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
