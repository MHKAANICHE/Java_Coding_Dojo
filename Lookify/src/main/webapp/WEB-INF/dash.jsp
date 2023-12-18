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
<!-- Header -->
<a href="#">Add New</a>
<a href="#">Top Songs</a>
<form>
<input type="text" value="your artist name"/>
<input type="submit" value="Search"/>
</form>
<!-- Boy -->
<table>
<thead>
<th>Name</th>
<th>Rating</th>
<th>Actions</th>
</thead>
<tbody>
<tr>
<td><a href="#">Shape of you</a></td>
<td>8</td>
<td><a href="#">delete</a></td>
</tr>
</tbody>
</table>
</body>
</html>