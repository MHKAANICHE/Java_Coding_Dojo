<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Song</title>
<!-- Add Bootstrap CSS link -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* Custom styles for the page */
body {
	padding: 20px; /* Add padding for better spacing */
}

/* Style for the title */
h1 {
	color: #007bff; /* Bootstrap primary color */
}

/* Style for the form */
form {
	margin-top: 20px;
}

/* Style for the buttons */
input[type="submit"] {
	margin-top: 10px;
}

/* Style for the cancel and delete buttons */
.cancel-delete-btns {
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="header">
		<div>
			<h3>
				Hello
				<c:out value="${user_name}" />
			</h3>
		</div>
		<div>
			<a href="/logout">Logout</a>
		</div>
	</div>
	<h1>Edit Song</h1>
	<table class="table">
		<form action="/songEdit" method="POST">
			<input type="hidden" name="song_id" value="${song.id}" />
			<tr>
				<td><label>Song Title:</label></td>
				<td><c:out value="${song.title}" /></td>
			</tr>
			<tr>
				<td><label>Genre:</label></td>
				<td><c:out value="${song.genre}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><c:out value="${song.lyrics}" /></td>
			</tr>
			<tr>
				<td><label>Add your Lyrics:</label></td>
				<td><textarea name="lyricsEdit" cols="30" rows="5"><c:if test="${isAuthor==true}"><c:out value="${song.lyrics}" /></c:if></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary" type="submit" value="Submit" /></td>
			</tr>
		</form>
	</table>
	<!-- Add Bootstrap button class for Cancel and Delete buttons -->
	<button class="btn btn-secondary cancel-delete-btns"
		onclick="location.href='/home'" type="button">Cancel</button>
	<form action="/delete/song/${song.id}"  method="POST">
		<c:if test="${isAuthor==true}">
			<button class="btn btn-danger cancel-delete-btns" type="submit">Delete</button>
		</c:if>
	</form>

	

	<!-- Add Bootstrap JS and Popper.js scripts if needed -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
