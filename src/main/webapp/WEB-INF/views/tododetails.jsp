<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>To-Do Details</title>
</head>
<body>
	<header class="page-header"
		style="background-color: green; height: 60px">
		<!-- <div>header content</div> -->
	</header>

	<h1 style="color:green;font-family: cursive;">Login Sucess</h1>


	<h1 style="color: green; font-family: cursive;" align="center">To
		Do List</h1>



	<table class="table table-bordered"
		style="border: 1px solid green; margin: auto">
		<thead>
			<tr>

				<th scope="col" style="margin: auto">No</th>

				<th scope="col" style="margin: auto">Name</th>

				<th scope="col" style="margin: auto">Action</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach items="${toDo}" var="list" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>


					<td>${list.name}</td>

					<td><a href="/delete.do?name=${list.name}"><i
							class="icon-edit">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<br>
	<div class="container" style="text-align: center">
		<form action="todo.add" method="post">


		
				<label style="color:green;font-family: cursive;"> Add Details: </label> <input type="text" name="todo"
					class="form-control" />

		
			<input type="submit" class="btn btn-success" style="color:green"
				value="add" />

		</form>
	</div>







	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>