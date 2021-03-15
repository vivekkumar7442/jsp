<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

<div class="container" align="center">

<form action="/FeedBackServlet" method="post">

<fieldset class="form-group">
<label>Name</label>
<input type="text" name="name" readonly="readonly" class="form-control" style="width: auto;" value="${feedback.userDetail.name}"/>

<label>contact</label>
<input type="text" name="contact"  readonly="readonly" class="form-control" style="width: auto" value="${feedback.userDetail.mobile}"/>


<label>feed back</label>
<input type="text" name="feedback" class="form-control" style="width: auto" value="${feedback.content}"/>


<label>Subject</label>
<input type="text" name="subject" class="form-control" style="width: auto" value="${feedback.subject}"/>

<label>Comment</label>
<input type="text" name="comment" class="form-control" style="width: auto" value="${feedback.subject}"/>

<label>OICD</label>
<input type="text" name="oicd" class="form-control" style="width: auto" value="${feedback.oicId}"/>


<label>Remarks</label>
<input type="text" name="remarks" class="form-control" style="width: auto" value="${feedback.oicRemarks}"/>
<br>
<input type="submit" class="btn btn-success" value="Submit"/>

<input type="submit" class="btn btn-success" value="Save"/>

<input type="submit" class="btn btn-success" value="Cancel"/>




</fieldset>
</form>
</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>