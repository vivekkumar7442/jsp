
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Numbers</title>
</head>
<%
System.out.println(request.getParameter("name"));
Date date = new Date();
%>
<body>



	<div style="text-align: center">
		<h1>Add Numbers</h1>


		<form action="addnumber" method="post">

			Enter Number A:<input type="text" name="a" /> <br> <br>
			Enter Number B :<input type="text" name="b" /> <br> <br>
			<p>
				<font color="red">${errorMessage}</font>
			</p>

			<input type="submit" value="Add" />
		</form>
	</div>
	
	<p> list print ${list} </p>






</body>
</html>