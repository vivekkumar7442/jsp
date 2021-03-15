<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container" style="text-align: center">
		<form action="/user" method="post">
		<fieldset>
			<label style="color: green; font-family: cursive;"> Name </label>
			 <input type="text" name="name" class="form-control"/> 
			 <label style="color: green; font-family: cursive;"> Address </label> 
			 <input type="text" name="address" class="form-control"/>
        </fieldset>
        <input type="submit" class="btn btn-success" value="Add"/>
        </form>
	</div>



	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>