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


<table class="table table-bordered"
		style=" margin: auto">
		<thead>
			<tr>

				<th scope="col" style="margin: auto">No</th>

				<th scope="col" style="margin: auto">Name</th>

				<th scope="col" style="margin: auto">Address</th>
				
				<th scope="col" style="margin: auto">Action</th>
				


			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user}" var="list" varStatus="loop">
				<tr>
				 	<td>${loop.index+1}</td>


					<td>${list.name}</td>
					
	 <td>${list.address}</td>

					 <td><a href="/edit.do?name=${list.name}"><i
							class="icon-edit">Edit</i></a> &nbsp;&nbsp;&nbsp; <a href="/delete.do?name=${list.name}"><i
							class="icon-edit">Delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>