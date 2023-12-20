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
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Header -->
	<div class=" container d-flex justify-content-between" style="padding : 10px;">
		<div>
			<a href="#">Add New</a> <a href="#">Top Songs</a>
		</div>
		<div>
			<form>
				<div class="form-group d-flex">
					<input type="text" value="your artist name" class="form-control" />
					<input type="submit" value="Search" class="btn btn-primary" />
				</div>
			</form>

		</div>
	</div>
	<!-- Boy -->
	<div class="container">
		<table class="table table-striped " style="border: 1px solid #666;">
			<thead>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<tr>
					<td><a href="#">Shape of you</a></td>
					<td>8</td>
					<td><a href="#">delete</a></td>
				</tr>
				<tr>
					<td><a href="#">Shape of you</a></td>
					<td>7</td>
					<td><a href="#">delete</a></td>
				</tr>
				<tr>
					<td><a href="#">Shape of you</a></td>
					<td>6</td>
					<td><a href="#">delete</a></td>
				</tr>
			</tbody>
		</table>
	</div>


	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>