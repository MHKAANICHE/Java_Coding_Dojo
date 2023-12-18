<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<h1>Song by "${song.artist}"</h1>
<table>
<thead>
<th>Name</th>
<th>Rating</th>
<th>Actions</th>
</thead>
<tbody>
<tr>
<td><a href="/#">Shape of you</a></td>
<td>7</td>
<td><a href="/#">delete</a></td>
</tr>
</tbody>
<a href="/#">Dashboard</a>
</table>
</body>
</html>