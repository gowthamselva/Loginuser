package com.Harish.web.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Harish.web.model.user;

public class Login {
	public String name="",pass="";
	
	public user getoutput(String uname,String password)
	{
		user u=new user();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from users where Name='"+(String)uname+"' and Password='"+(String)password+"'");
			if(rs.next())
			{
				name=rs.getString("Name");
				pass=rs.getString("Password");
				u.setUname(name);
				u.setPassword(pass);
			}
			else
			{
				u.setUname("Incorrect Username or Password");
			}
			System.out.println(name+" "+uname);
			System.out.println(pass+" "+password);
			/*if(name.equals(uname) && pass.equals(password))
			{
				
			}
			else
			{
				
			}
			*/
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		return u;
	}
}
