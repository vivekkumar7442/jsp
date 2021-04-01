<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Details</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
	
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.css" />
	<link rel="stylesheet" type="text/css"
	href="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" />
	<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js" />
	



</head>
<body>

	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div class="container" style="width: 50%;border-color: green;padding: 2px;">

	<table class="table  table-bordered table-striped table-hover"  style="width: 100%"
		id="feedbacktable">
		<thead>
			<tr >
				<th scope="col" style="display: none">id </th>
				<th scope="col">Feedback No</th>
				<th scope="col">Feedback Type</th>
				<th scope="col">Status</th>
				<th scope="col">date</th>
				<th scope="col">OIC ID</th>
			</tr>
		</thead>

		<tbody>
				<c:forEach items="${feedBackList}" var="list" varStatus="loop">
						<tr id="fedrow">
						<td  style="display: none">{list.id}</td>
						<c:if test="${list.status!='completed'}">
		 				<td id="feedbackUpdateCall"><a  href="javascript:test(${list.id})" style="cursor:pointer">${list.feedbackId}</a></td> 
						</c:if>
						<c:if test="${list.status== 'completed'}">
						<td>${list.feedbackId}</td>
						</c:if>
						<td>${list.type}</td>
						<td>${list.status}</td>
						<td>${list.createdTime}</td>
						<td>${list.oicId}</td>

					</tr>
					
				</c:forEach>
			</tbody>
	</table>
	</div>

	<div id="updateFeedbackDive" class="container" align="center">

		<!-- <form name="feedbackUp"> -->
			<div class="row">
				<div class="col-md-6">
					<label>Name</label> <input type="text" name="name" id="username"
						readonly="readonly" class="form-control" style="width: auto;"
						value="${feedback.userDetail.name}" /> <label>contact</label> <input
						type="text" name="contact" id="mobilenumber" readonly="readonly"
						class="form-control" style="width: auto"
						value="${feedback.userDetail.mobile}" />
				</div>
				<div class="col-md-6">
					<label>feed back</label> <input type="text" name="feedback"
						id="feedbackcontent" class="form-control" style="width: auto"
						value="${feedback.content}" /> <label>Subject</label> <input
						type="text" name="subject" id="feedbacksubject"
						class="form-control" style="width: auto"
						value="${feedback.subject}" />
				</div>

				<div class="col-md-6">
					<label>Comment</label> <input type="text" name="comment"
						id="feedbackcomment" class="form-control" style="width: auto"
						value="${feedback.subject}" /> <label>OICD</label> <input
						type="text" name="oicd" id="oicid" class="form-control"
						style="width: auto" value="${feedback.oicId}" />
				</div>

				<div class="col-md-6">
					<label>Comment</label> <input type="text" name="comment"
						id="feedbackcomment" class="form-control" style="width: auto"
						value="${feedback.subject}" /> <label>OICD</label> <input
						type="text" name="oicd" id="oicid" class="form-control"
						style="width: auto" value="${feedback.oicId}" />
				</div>

				<div class="col-md-6">

					<label>Remarks</label> <input type="text" name="remarks"
						id="remarks" class="form-control" style="width: auto"
						value="${feedback.oicRemarks}" />
				</div>

			</div>

			<fieldset class="form-group">








				<br> <input type="submit" class="btn btn-success" id="submitid"
					value="Submit" /> <input type="submit" class="btn btn-success"
					value="Save" id="saveId" /> <input type=button id="cancelbutton"
					class="btn btn-success" value="Cancel" />




			</fieldset>
<!-- 		</form> -->
	</div>


	<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>


	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.js"></script>
			<script src="/views/form-validation.js"></script>
			<script>
			// just for the demos, avoids form submit
			jQuery.validator.setDefaults({
			  debug: true,
			  success: "valid"
			});
			$( "#feedbackUp" ).validate({
			  rules: {
			    field: {
			      required: true,
			      step: 10
			    }
			  }
			});
			</script>
		
	<script>
		$(document).ready(function() {
			$('#feedbacktable').DataTable({
				 "pagingType": "full_numbers",
					 "columnDefs": [
				            {"orderable": false, visible: false, "targets": 0,"type": 'num'},
				            {"orderable": true, "targets": 1 },
				            {"orderable": false, "targets": 2},
				            {"orderable": false, "targets": 3 },
				            {"orderable": true, "targets": 4 },
				            {"orderable": true, "targets": 5 }
				        ],
				        "lengthChange": true,
				        "pageLength": 5,
				        "lengthMenu": [[5,10, 15, 20, 25, 30, -1], [5,10, 15, 20, 25, 30, "All"]]
			});
			 $("#updateFeedbackDive").hide();
			 
			 
			 
		
		          var id = $(this).find("td:first-child").text();
					  $("#cancelbutton").click(function(){
						  $("#updateFeedbackDive").hide();
					  });
					  
					  $("#saveId").click(function(){
						  
						  var userNmae=$('#username').val(); 
						  $('#mobilenumber').val(); 
						  $('#feedbackcontent').val(); 
						  $('#feedbacksubject').val(); 
						  $('#feedbackcomment').val(); 
						  $('#oicid').val(); 
						  $('#remarks').val(); 
						  alert($('#username').val());
						  var data={userName:userNmae}
						  postUpdate(data);

						});
				 
			
		});
		
		function test(id) {
			alert(id);
			$.get("http://localhost:8080/first-web-application/FeedBackServlet?feedbackId="+id, function(data, status){
				var  dat = JSON.parse(data);
				alert(dat);
				  $('#username').val(dat.userDetail.name); 
				  $('#mobilenumber').val(dat.userDetail.mobile); 
				  $('#feedbackcontent').val(dat.content); 
				  $('#feedbacksubject').val(dat.subject); 
				  $('#feedbackcomment').val(dat.subject); 
				  $('#oicid').val(dat.oicid); 
				  $('#remarks').val(dat.oicRemarks); 
				  $("#updateFeedbackDive").show();

			  
			  });
		}
		
		function postUpdate(data) {
			alert(data);
			  var posting = $.post( "http://localhost:8080/first-web-application/FeedBackServlet", data);
			  
			  $.post("http://localhost:8080/first-web-application/FeedBackServlet", data, function(result){
				  var myJSON = JSON.stringify(result);
				  alert(myJSON);
				  });


		}
		

	</script>
</body>
</html>