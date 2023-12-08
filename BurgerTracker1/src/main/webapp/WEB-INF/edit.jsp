<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Burger</title>
</head>
<body>
	<h1 style="color: blue;">Edit Burger</h1>
	<table>
		<form:form action="/editBurger" method="POST" modelAttribute="burgerToEdit">
			<!-- 	Override method to PUT for Submit -->
		 	<input type="hidden" name="_method" value="put">
			<!-- Show id  -->
				<td><form:label path="id" />ID : ${burgerToEdit.id}</td>
			<tr>
				<td><form:label path="name">Burger Name:</form:label></td>
				<td style="color: red;"><form:errors path="name"></form:errors></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="restaurant">Restaurant Name:</form:label></td>
				<td style="color: red;"><form:errors path="restaurant"></form:errors></td>
				<td><form:input path="restaurant" /></td>
			</tr>
			<tr>
				<td><form:label path="rating">Rating:</form:label></td>
				<td style="color: red;"><form:errors path="rating"></form:errors></td>
				<td><form:input path="rating" /></td>
			</tr>
			<tr>
				<input type="submit" value="Edit Burger">
			</tr>
		</form:form>
	</table>
</body>
</html>