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
	<div
		class="container d-flex justify-content-between align-items-center">
		<h3>
			Hello "
			<c:out value="${user_name}" />
			"
		</h3>
		<a href="/logout">Logout</a>
	</div>
	<div
		class="container d-flex justify-content-between align-items-center">
		<h5>Books from everyone's shelves:</h5>
		<a href="/new">+ Add a to my shelf!</a>
	</div>
	<div class="container d-flex justify-content-center align-items-center">
		<table class="table table-striped">
			<thead>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Action</th>
			</thead>
			<tbody>
				<c:forEach var="book" items="${notBorrowedBooks}">
					<tr>
						<td>${book.id}</td>
						<td><a href="/show/${book.id}">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.owner.userName}</td>
						<td><c:choose>
								<c:when test="${user_id == book.owner.id}">
									<a href="/book/${book.id}/edit/">edit</a>
									<a href="/book/${book.id}/delete/">delete</a>
								</c:when>
								<c:otherwise>
									<a href="/book/${book.id}/borrow">borrow</a>
								</c:otherwise>
							</c:choose></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<h6>Book I'm Borrowing...</h6>
		<table class="table table-striped">
			<thead>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Action</th>
			</thead>
			<tbody>
				<c:forEach var="book" items="${borrowedBooks}">
					<tr>
						<td>${book.id}</td>
						<td><a href="/#">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.owner.userName}</td>
						<td><a href="/book/${book.id}/return">return</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>

	<!-- Add Bootstrap JS and Popper.js scripts if needed -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
