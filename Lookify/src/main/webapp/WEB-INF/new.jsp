<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Song</h1>
	<form>
		<table>
			<tr>
				<td><label>Title</label></td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td><label>Artist</label></td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td><label>Rating(1-10)</label></td>
				<td><input type="number" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
	<a href="">Dashboard</a>
</body>
</html>