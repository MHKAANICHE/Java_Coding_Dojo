<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Date</title>
</head>
<body>
<!-- 	<p> -->
<%-- 		<c:out value="${view}"></c:out> --%>
<!-- 	</p> -->
	<div>
		<c:if test="${view == 'index' }">
			<a href="/date" name="date">Date Template</a>
			<a href="/time" name="time">Time Template</a>
		</c:if>
	</div>
	<div>
		<c:if test="${view== 'date' }">
			<p><c:out value="${info}"></c:out></p>
		</c:if>
		<c:if test="${view== 'time' }">
			<p><c:out value="${info}"></c:out></p>
		</c:if>

	</div>
</body>
</html>