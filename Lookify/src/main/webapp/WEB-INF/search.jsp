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
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<style>
.square-box {
	max-width: 600px;
	min-height: 600px;
	border: 1px solid #666;
}

.square-min-box {
	max-width: 400px;
	min-height: 200px;
	border: 1px solid #666;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding: 20px">

	<div class="contianer">
		<h1>Song by "${artist}"</h1>
	</div>

	<div class="contianer">
		<table class="table table-striped " style="border: 1px solid #666;">
			<thead>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</thead>
			<tbody>
			<c:forEach var="song" items="${songs}">
					<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td>${song.rating}</td>
					<td><a href="/songs/${song.id}/delete">delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="contianer">
		<a href="/dash">Dashboard</a>
	</div>


	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>