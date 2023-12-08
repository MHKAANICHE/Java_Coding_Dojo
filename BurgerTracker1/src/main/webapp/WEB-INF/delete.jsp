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
	<h1 style="color: red;">Delete Burger</h1>
	<table>
		<form:form action="/destroyBurger/${burgerToDelete.id}" method="POST" modelAttribute="burgerToDelete">
			<!-- 	Override method to PUT for Submit -->
		 	<input type="hidden" name="_method" value="delete">
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
				<input type="submit" value="Delete Burger">
			</tr>
		</form:form>
	</table>
</body>
</html>