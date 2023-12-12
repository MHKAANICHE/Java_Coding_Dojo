<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja</title>
</head>
<body>
	<h1>Ninja</h1>
	<a href="/">dashboard</a>
	<a href="/dojo/new">New Dojo</a>
	<hr>
	<h1>New Ninja</h1>
	<table>
		<form:form action="/saveNinja" method="POST" modelAttribute="newNinja">
			<tr>
				<td><form:select path="dojo">
						<c:forEach var="dojo" items="${dojos}">
							<form:option value="${dojo.id}" path="dojo">
								<c:out value="${dojo.name}" />
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input type="text " path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input type="text" path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Age:</form:label></td>
				<td><form:input type="number" path="age" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save New Ninja" /></td>
			</tr>

		</form:form>
	</table>
	<hr>
</body>
</html>