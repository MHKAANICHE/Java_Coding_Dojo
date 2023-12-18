<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<style>
.error{ color: red;}
</style>
</head>
<body>
<a href="/dash">back to the shelves</a>
	<h1>Change your Entry!</h1>
	<form:form action="/saveEditBook" method="POST" modelAttribute="editBook">
		<table>
			<form:input type="hidden" path="id" value="${book.id}"/>
			<tr>
			<form:errors class ="error" path="id"></form:errors>
			<form:errors class ="error" path="title"></form:errors>
			<form:errors class ="error" path="author"></form:errors>
			<form:errors class ="error" path="myThought"></form:errors>
			<form:errors class ="error" path="createdAt"></form:errors>
			<form:errors class ="error" path="updatedAt"></form:errors>
			<form:errors class ="error" path="owner"></form:errors>
			</tr>
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input type="text" path="title" value="${book.title}"/>
				<form:errors class ="error" path="title"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="author">Author</form:label></td>
				<td><form:input type="text" path="author" value="${book.author}"/>
				<form:errors class ="error" path="author"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="myThought" >My thoughts</form:label></td>
				<td><form:input type="text" path="myThought" value="${book.myThought}"/>
				<form:errors class ="error" path="myThought"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form >
</body>
</html>