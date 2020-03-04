<%@page import="com.Harish.web.model.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">

<%
	user u = (user)request.getAttribute("Harish");

	out.print(u);

%>

</body>
</html>