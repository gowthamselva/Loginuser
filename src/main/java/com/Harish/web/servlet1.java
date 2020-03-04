package com.Harish.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Harish.web.model.user;
import com.Harish.web.model.data.Data;
import com.Harish.web.model.data.Login;


public class servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int sno=Integer.parseInt(request.getParameter("sno"));
		String uname=request.getParameter("username");
		String password=request.getParameter("pass");
		System.out.println(uname);
		System.out.println(password);
		Login d=new Login();
		
		//user u=d.getuserr(sno);
		//request.setAttribute("Harish", u); 
		//RequestDispatcher rd=request.getRequestDispatcher("showdata.jsp");
		//rd.forward(request, response);
		user u=d.getoutput(uname, password);
		System.out.println("Harish123 "+d.name);
		
		if(!d.name.isEmpty() && !d.pass.isEmpty())
		{
		request.setAttribute("Harish", u);
		RequestDispatcher rd=request.getRequestDispatcher("Dashboard.jsp");
		rd.forward(request, response);
		}
	
		else
		{
			request.setAttribute("Harish", u);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);	
		}
		
	}

	

}
