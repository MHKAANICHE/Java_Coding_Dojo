<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Dashboard</h1>
	<thead>
	<tr>
	<th>id</th>
	<th>Title</th>
	<th>Author</th>
	<th>Description</th>
	<th>language</th>
	<th>Pages</th>
	</tr>
	</thead>
	<hr>
	<tbody>
		<c:forEach var="book" items="${ListOfBooks}">
			<tr>
				<!--<td>*<td> -->				
				<td><c:out value="${book.id}" />
				<td>
				<td><a href="/view/<c:out value="${book.id}" />"><c:out value="${book.title}" /></a>
				<td>
				<td><c:out value="${book.author}" />
				<td>
				<td><c:out value="${book.description}" />
				<td>
				<td><c:out value="${book.language}" />
				<td>
				<td><c:out value="${book.numberOfPages}" />
				<td>
			</tr>
			<hr>
		</c:forEach>
	</tbody>
</body>
</html>