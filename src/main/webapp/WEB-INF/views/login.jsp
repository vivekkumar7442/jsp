
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My First Servlet Application from JSP</title>
</head>
<%
System.out.println(request.getParameter("name"));
Date date=new Date();
%>
<body>



<div style="text-align:center">
<h1>Enter your Login details</h1>


<form action="/login.do" method="post">

Enter your name:<input type="text" name="name"/>
<br>
<br>
Enter password :<input type="password" name="password"/>

<br>
<br>
<p> <font color="red">${errorMessage}</font></p>

<input type="submit" value="Login"/>
</form>
</div>




</body>
</html>