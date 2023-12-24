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
<title>Create a course</title>
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
	<divclass="container d-flex justify-content-between align-items-center">
		<h1>Create a Course</h1>
		<a href="/#">Log Out</a>
	</div>		
			<table>
			<form:form action="/saveNewCourse" method="POST" modelAttribute="newCourse">		
				<tr>
					<td><form:label  path="name">Name</form:label>
						<form:errors class="error" path="name"/></td>
					<td><form:input type="text" path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="dayOfWeek">Day of Week</form:label>
						<form:errors class="error" path="dayOfWeek"/></td>
					<td><form:input type="text" path="dayOfWeek" /></td>
				</tr>
				<tr>
					<td><form:label  path="price">Drop-in Price</form:label>
						<form:errors class="error" path="price"/></td>
					<td><form:input type="number" path="price" /></td>
				</tr>
				<tr>
					<td><form:label path="hour">Time</form:label> 
					<form:errors class="error" path="hour"/></td>
					<td><form:input type="time" path="hour" /></td>
				</tr>
				<tr>
					<td><form:label  path="description">Description:</form:label>
					<form:errors class="error" path="description"/></td>
					<td><form:input type="text" path="description" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="button" class="btn btn-secondary me-2"
							onclick="location.href='/dash'">Cancel</button> <input
						type="submit" class="btn btn-primary" value="Submit" /></td>
				</tr>
				</form:form>
			</table>
		
		
<!-- 		<div class="container mt-3"> -->
<%-- 				<form:form>	 --%>
<!-- 					<div class="row"> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"></div> -->
<!-- 							<div class="col-md-6"> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:label for="courseName" path="name">Name</form:label> --%>
<%-- 								<form:errors path="name"></form:errors> --%>
<!-- 							</div> -->
<!-- 							<div class="col-md-6"> -->
<%-- 								<form:input type="text" path="name" name="courseName" --%>
<%-- 									class="form-control" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:label for="dayOfWeek" path="dayOfWeek">Day of Week</form:label> --%>
<%-- 							<form:errors path="dayOfWeek"></form:errors> --%>
<!-- 							</div> -->
<!-- 							<div class="col-md-6"> -->
<%-- 								<form:input type="text" path="dayOfWeek" class="form-control" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->

<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:label for="dropInPrice" path="price">Drop-in Price</form:label> --%>
<%-- 							<form:errors path="price"></form:errors> --%>
<!-- 							</div> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:input type="number" path="price" class="form-control" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:label for="time" path="hour">Time</form:label> --%>
<%-- 							<form:errors path="hour"></form:errors> --%>
<!-- 							</div> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:input type="time" path="hour" class="form-control" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"> -->
<%-- 								<form:label for="courseDescription" path="description">Description</form:label> --%>
<%-- 							<form:errors path="description"></form:errors> --%>
<!-- 							</div> -->
<!-- 							<div clasline: [s="col-md-6"> -->
<!-- 								<textarea name="courseDescription" path="description" -->
<!-- 									class="form-control" cols="20" rows="3"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-3"></div> -->
<!-- 							<div class="col-md-6 d-flex justify-content-end align-items-center" -->
<!-- 								style="margin-top: 10px;"> -->
<!-- 								<button type="button" class="btn btn-secondary me-2" -->
<!-- 									onclick="location.href='/dash'">Cancel</button> -->
<!-- 								<input type="submit" class="btn btn-primary" value="Submit"/> -->
<!-- 							</div> -->
<%-- 				</form:form> --%>
<!-- 			</div> -->
</body>
</html>