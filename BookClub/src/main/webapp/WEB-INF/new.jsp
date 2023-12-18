<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<style>
/* Custom styles for the page */
.error {
	color: red; /* Add padding for better spacing */
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/dash">back to the shelves</a>
	<h1>Add a Book to Your Shelf!</h1>
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
</body>
</html>