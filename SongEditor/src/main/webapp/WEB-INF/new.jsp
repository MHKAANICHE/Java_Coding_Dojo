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
<title>New Song</title>
</head>
<body>
	<div>
		<h1>Start a new Song</h1>
	</div>
	<table>
		<form:form action="/newSong" method="POST" modelAttribute="newSong">
			<tr>
				<td><form:label path="title">Song Title:</form:label>
					<form:errors style="color:red;" path="title" /></td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="genre">Genre:</form:label>
					<form:errors style="color:red;" path="genre"/></td>
				<td><form:input type="text" path="genre" /></td>
			</tr>
			<tr>
				<td><form:label path="lyrics">Add your Lyric:</form:label>
					<form:errors style="color:red;" path="lyrics"/></td>
				<td><form:input  type="text" path="lyrics" /></td>
			</tr>
<!-- 			<tr> -->
<%-- 				<td><form:label path="lyrics">Add your Lyric:</form:label> --%>
<%-- 					<form:errors style="color:red;" path="Lyrics"/></td> --%>
<%-- 				<td><form:textarea path="lyrics" rows="10" cols="20" /></td> --%>
<!-- 			</tr> -->
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</table>

</body>
</html>