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
<title>dojo</title>
</head>
<body>
	<h1>Dojo</h1>
	<a href="/">dashboard</a>
	<a href="/ninja/new">New Ninja</a>
	<hr>
	<table>
		<form:form action="/saveDojo" method="POST" modelAttribute="newDojo">
			<tr>
				<td><form:label path="name">Dojo name:</form:label></td>
				<td><form:input type="text" path="name"></form:input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save New Dojo" /></td>
			</tr>
		</form:form>
	</table>
	<hr>
</body>
</html>