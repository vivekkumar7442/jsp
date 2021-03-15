<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Staff Login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>

</style>
</head>

<body>

<h1 style="color: green;font-family: cursive;font-style: italic;" align="center"> Login Page</h1>

<div class="conatiner" style="color: green;align-content: center;" align="center">

<form action="StaffLogin" method="post" >

<fieldset class="form-group">
<label> Staff Id</label>
<input type="text" name="staffid" class="form-control" style="width: 20%"/>
<label>Password</label>
<input type="password" name="password" class="form-control" style="width: 20%"/>
<br>
<input type="submit" class="btn btn-success" value="Login"/>
<br>

<p> <font color="red">${errorMessage}</font></p>


</fieldset>
</form>

</div>

 

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>