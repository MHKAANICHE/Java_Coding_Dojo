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
		<h3>Gentle Yoga with ${course.instructor.userName}</h3>
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
				<li>${student.userName}-${student.email}</li>
			</c:forEach>
		</ul>
	</div>

	<div class="container mt-4">
    <h5>Add Students to Course</h5>
    <br>

    <div class="row">
        <!-- New Student Form -->
        <div class="col-md-6">
            <h5>New Student</h5>
            <form:form action="/saveNewStudent/${course.id}" method="POST" modelAttribute="newStudent">
                <div class="form-group">
                    <form:input type="hidden" path="password" class="form-control" />
                    <form:errors path="password" cssClass="text-danger" />
                </div>
                <div class="form-group">
                    <form:input type="hidden" path="confirmPW" class="form-control" />
                    <form:errors path="confirmPW" cssClass="text-danger" />
                </div>
                <div class="form-group">
                    <form:label path="userName">Student Name:</form:label>
                    <form:input type="text" path="userName" class="form-control" />
                    <form:errors path="userName" cssClass="text-danger" />
                </div>
                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:input type="email" path="email" class="form-control" />
                    <form:errors path="email" cssClass="text-danger" />
                </div>
                <button type="submit" class="btn btn-primary">Add new student</button>
            </form:form>
        </div>

        <!-- Existing Student Form -->
        <div class="col-md-6">
            <h5>Existing Student</h5>
            <form:form action="/enrollStudent/${course.id}" method="POST">
                <div class="form-group">
                    <select name="student_id" class="form-control">
                        <c:forEach var="student" items="${notEnrolledStudents}">
                            <option value="${student.id}">${student.userName} - ${student.email}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add existing student</button>
            </form:form>
        </div>
    </div>
</div>
		
</html>