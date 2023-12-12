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
<title>Dashboard</title>
</head>
<body>
	<h1>Dashboard</h1>
	<a href="/ninja/new">New Ninja</a>
	<a href="/dojo/new">New Dojo</a>
	<hr>
	<h3>Dojos:</h3>
	<table>
		<c:forEach var="dojo" items="${dojosList}">
			<tr>
				<a href="/dojo/${dojo.id}">${dojo.name}</a>
			</tr><br>
		</c:forEach>
		<hr>
	</table>
	<hr>
	<h3>Ninjas:</h3>
	<table>
		<c:forEach var="ninja" items="${ninjasList}">
			<tr>
				<a href="/ninja/${ninja.id}">${ninja.firstName} ${ninja.lastName}</a>
			</tr><br>
		</c:forEach>
		<hr>
	</table>
</body>
</html>