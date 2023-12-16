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
<title>Edit Song</title>
</head>
<body>
	<h1>Add to "Morning Blues"</h1>
	<table>
		<form>
			<tr>
				<td><label>Song Title:</label>
				<td><c:out value="${song.title}"/></td>
			</tr>
			<tr>
				<td><label>Genre:</label>
				<td><c:out value="${song.genre}"/></td>
			</tr>
			<tr>
				<td></td>				
				<td><c:out value="${song.lyrics}"/></td>
			</tr>
			<tr>
				<td><label >Add your Lyrics:</label>
				<td><textarea></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form>
	</table>
	<input type="submit" value="Cancel" />
	<c:if test="${author==true}" >
		<input type="submit" value="Delete" />
	</c:if>
	
</body>
</html>