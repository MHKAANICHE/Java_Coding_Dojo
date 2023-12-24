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
	<div class ="container d-flex justify-content-betweenalign-items-center">
	<h1>Create a Course</h1>
	</div>
<div class="container">
	<table>
		<form:form action="/saveNewCourse" method="POST"
			modelAttribute="newCourse">
			<tr>
				<td><form:label path="name">Name</form:label> </td>
				<td><form:input type="text" path="name" /><form:errors
						class="error" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="dayOfWeek">Day of Week</form:label> </td>
				<td><form:select path="dayOfWeek" id="dayOfWeek">
						<form:option value="">-- Select Day --</form:option>
						<form:option value="Mon">Monday</form:option>
						<form:option value="Tue">Tuesday</form:option>
						<form:option value="Wed">Wednesday</form:option>
						<form:option value="Thu">Thursday</form:option>
						<form:option value="Fri">Friday</form:option>
						<form:option value="Sat">Saturday</form:option>
						<form:option value="Sun">Sunday</form:option>
					</form:select><form:errors
						class="error" path="dayOfWeek" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Drop-in Price</form:label> </td>
				<td><form:input type="number" path="price" /><form:errors
						class="error" path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="hour">Time</form:label> </td>
				<td><form:input type="time" path="hour" /><form:errors
						class="error" path="hour" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label> </td>
				<td><form:input type="text" path="description" /><form:errors
						class="error" path="description" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="button" class="btn btn-secondary me-2"
						onclick="location.href='/classes'">Cancel</button> <input
					type="submit" class="btn btn-primary" value="Submit" /></td>
			</tr>
		</form:form>
	</table>
</div>	
	
</body>
</html>