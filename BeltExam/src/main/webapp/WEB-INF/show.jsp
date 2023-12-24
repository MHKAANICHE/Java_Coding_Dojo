<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create a Task</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- Your local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<style>
/* Any additional styles specific to this page */
body {
	background-color: #ACA9CB;
}
</style>
</head>
<body>
	<div
		class="container d-flex justify-content-between align-items-center">
		<h3>Gentle Yoga with {instructor.name}</h3>
	</div>

	<div class="container mt-4">
		<h5>
			<span>Day:</span> <span>${course.dayOfWeek}</span>
		</h5>
		<h5>
			<span>Cost:</span> <span>$${course.price}</span>
		</h5>
		<h5>
			<span>Time:</span>
			<fmt:formatDate value="${course.hour}" pattern="HH:mm"
				var="formattedTime" />
			<span>${formattedTime}</span>
		</h5>
		<br>
		<h6>
			<span>Description:</span> <span>${course.description}</span>
		</h6>
	</div>

	<hr>

	<div class="container mt-4">
		<h5>Students</h5>
		<ul>
			<c:forEach var="student" items="${course.students}">
				<li>${student.userName}- ${student.email}</li>
			</c:forEach>
			<li>Naomi - onaimo@gmail.com</li>
			<li>Jim - jim@gmail.com</li>
		</ul>
	</div>

	<div class="container mt-4">
		<h5>Add Students to Course</h5>
		<br>
		<h5>New Student</h5>
		<form:form action="/saveNewStudent/${course.id}" method="POST" modelAttribute="newStudent">
			<table>
			<tr>
				<td><form:input type="hidden" path="password" />
				<form:errors path="password" ></form:errors>
				<td><form:input type="hidden" path="confirmPW" />
				<form:errors path="confirmPW" ></form:errors>
			</tr>
				<tr>
					<td><form:label path="userName">Student Name:</form:label></td>
					<td><form:input type="text" path="userName" />
					<form:errors path="userName" ></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="email">Email:</form:label></td>
					<td><form:input type="email" path="email" />
					<form:errors path="email" ></form:errors></td>
				</tr>
				<tr>
					<td><</td>
					<td><input type="submit" value="Add new student" /></td>
				</tr>
			</table>
		</form:form>

		<!-- 		<div class="row"> -->
		<!-- 			<div class="col-md-6"> -->
		<%-- 				<form> --%>
		<!-- 					<h5>New Student</h5> -->
		<!-- 					<div class="form-group"> -->
		<!-- 						<div class="row"> -->
		<!-- 							<div class="col-md-4"> -->
		<!-- 								<label for="newStudentName">Student Name:</label> -->
		<!-- 							</div> -->
		<!-- 							<div class="col-md-8"> -->
		<!-- 								<input type="text" class="form-control" id="newStudentName"> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<!-- 					<div class="form-group"> -->
		<!-- 						<div class="row"> -->
		<!-- 							<div class="col-md-4"> -->
		<!-- 								<label for="newStudentEmail">Email:</label> -->
		<!-- 							</div> -->
		<!-- 							<div class="col-md-8"> -->
		<!-- 								<input type="email" class="form-control" id="newStudentEmail"> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<!-- 					<div class="row"> -->
		<!-- 						<div class="col-md-4"></div> -->
		<!-- 						<div class="col-md-8 d-flex justify-content-end align-items-center " style="margin-top: 10px;"> -->
		<!-- 							<input type="submit" class="btn btn-primary" value="Add Student" /> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<%-- 				</form> --%>
		<!-- 			</div> -->

		<div class="col-md-6">
			<form>
				<h5>Existing Student</h5>
				<div class="form-group">
					<div class="row">
						<div class="col-md-4">
							<label for="existingStudent">Choose Student</label>
						</div>
						<div class="col-md-8">
							<select class="form-control" id="existingStudent">
								<option>alan - okay@gmail.com</option>
								<option>jim - jim@gmail.com</option>
							</select>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-8 d-flex justify-content-end align-items-center">
						<input type="submit" class="btn btn-primary" value="Add Student" />
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>