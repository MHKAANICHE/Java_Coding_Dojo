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

	<div class="container d-flex justify-content-between align-items-center">
		<h1>
			<c:out value="${book.title}" />
		</h1>
		<a href="/dash">back to the shelves</a>
	</div>

	<div class="container">
		<h3>
			<span style="color: red;"><c:out
					value="${book.owner.userName}" /></span> <span style="color: black;">
				read </span> <span style="color: magenta;"><c:out
					value="${book.title}" /></span> <span style="color: black;"> by </span> <span
				style="color: green;"><c:out value="${book.author}" /></span>
		</h3>
	</div>
	<div class="container">
		<h3>
			Here are
			<c:out value="${book.owner.userName}" />
			's thoughts:
		</h3>
	


	<hr />
	<p>"${book.myThought}"</p>
	<hr />

	<c:if test="${isOwner}">
		<div class="d-flex justify-content-end" >
		<button
			onClick="location.href='/book/<c:out value = "${book.id}" />/edit/'"
			type="submit" class="btn btn-primary" style="margin : 5px;">edit</button>
		<form action="/book/<c:out value = "${book.id}" />/delete/" method="POST" >
		<input type="submit" value="delete" class="btn btn-danger" style="margin : 5px;"/>
		</form>
		</div>		
	</c:if>
	
	</div>
</body>
</html>