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
<title>Show Song</title>
</head>
<body>
	<h1><c:out value="${song.title}"/></h1>
	<h3>started by <c:out value="${author_name}"/></h3>
	<table>
		<tr>
			<td>Genre:</td>
			<td>"${song.genre}"</td>
		</tr>
		<tr>
			<td>Lyrics:</td>
			<td><p>"${song.lyrics}"<p></td>
		</tr>
	</table>
	<button onclick="location.href='/song/${song.id}/edit'" type="button">Contirbute</button>
	<hr>
	<table>
		<h3>Collaborators</h3>
		<c:forEach var="contr" items="contributors">
			<tr><c:out value="${contr}"/></tr>
		</c:forEach>
		<tr>John
		</tr>
		<tr>Mike
		</tr>
		<tr>Franc
		</tr>
	</table>
</body>
</html>