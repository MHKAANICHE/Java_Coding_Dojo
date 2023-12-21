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
<title>Index</title>
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
	<div class="container">
	<h3>Add a Book to Your Shelf!</h3>
	<a href="/dash">back to the shelves</a>
	</div>
	<div class="container">
	<form:form action="/saveNew" method="POST" modelAttribute="newBook">
		<table>
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input type="text" path="title" />
					<form:errors class="error" path="title"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="author">Author</form:label></td>
				<td><form:input type="text" path="author" />
					<form:errors class="error" path="author"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="myThought">My thoughts</form:label></td>
				<td><form:input type="text" path="myThought" />
					<form:errors class="error" path="myThought"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>