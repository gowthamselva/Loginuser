package com.Harish.web.model.data;

import com.Harish.web.model.user;
import java.sql.*;
public class Data {
public user getuserr(int sno)
{
	user u=new user();
	/*
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from testing where sno=" + sno);
		if(rs.next())
		{
			u.setSno(rs.getInt("sno"));
			u.setName(rs.getString("name"));
			u.setAddress(rs.getString("address"));
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}*/
	
	
	return u;
}
}
