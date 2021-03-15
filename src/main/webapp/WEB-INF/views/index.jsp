<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login Page</title>
</head>
<body>

<h1>Login Sucess</h1>
<br>
 <h1 align="center">from JSP and name <b>${name}</b> and password is: ${password} </h1>

<br>

<h1 align="center">To Do List is</h1>



<table border="2px" align="center" style="width:50%">
<tr>

<th>
No
</th>

<th>
Todo Name
</th>

<th>
Action
</th>


</tr>
   <c:forEach items="${toDo}" var="list" varStatus="loop">
    <tr>      
    <td>${loop.index+1}</td>
    <c:if test = "${list.name== 'html'}">
   		<td> <a href="/delete.do?name=${list.name}">${list.name}</a></td> 
     </c:if>
   	<c:if test = "${list.name!= 'html'}">
   	<td> ${list.name}</td> 
   	</c:if>
    <td>
    	
    </td>
    </tr>
</c:forEach>


</table>
<br>
<div style="text-align:center">
<form action="todo.add" method="post" >
 Add Details:<input type="text" name ="todo">  <input type="submit" value="add"> 

</form>
</div>
<br>







</body>
</html>