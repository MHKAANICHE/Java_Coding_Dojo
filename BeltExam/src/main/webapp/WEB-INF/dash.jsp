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
<title>Project Manager Dashboard</title>
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
		<h1>
			Namaste,
			<c:out value="${userName}" />
		</h1>
		<a href="/logout">Log out</a>
	</div>
	<div class="container">
		<h5>Course Schedule</h5>
	</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<th>Class Name</th>
				<th>Instructor</th>
				<th>Weekday</th>
				<th>Price</th>
				<th>Time</th>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
						<td><a href="/classes/${course.id}">${course.name}</a> <c:if
								test="${course.instructor.id == userId }">
								<button type="button" class="btn btn-secondary me-2"
							onclick="location.href='/classes/${course.id}/edit '">edit</button>
						</c:if>
						<td>${course.instructor.userName}</td>
						<td>${course.dayOfWeek}</td>
						<td>$${course.price}</td>
						<td>
							<fmt:formatDate value="${course.hour}" pattern="HH:mm" var="formattedTime" />
								<p>${formattedTime}</p>
						</td>					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<form action="/classes/new" method="GET">
			<input type="submit" value="+ new course" />
		</form>
	</div>

	<!-- Add Bootstrap JS and Popper.js scripts if needed -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
