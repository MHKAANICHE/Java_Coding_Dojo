<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book View</title>
</head>
<body>
	<h1>Book View</h1>
	<h1>
		<c:out value="book.title" />
	</h1>
	<h3>
		Author :
		<c:out value="book.author" />
	</h3>
	<h3>Description :</h3>
	<p>
		<c:out value="book.description" />
	</p>
	<h3>
		language :
		<c:out value="book.language" />
	</h3>
	<h3>
		Number of pages :
		<c:out value="book.numOfPages" />
	</h3>
</body>
</html>