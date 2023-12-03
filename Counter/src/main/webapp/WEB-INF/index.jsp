<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${page=='your_server' }">
		<h1>Welcome User !</h1>
	</c:if>
	<c:if test="${page=='counter' }">
			<p>
			You have visited <a href="/">http://your_server</a> <c:out value="${count}"></c:out> times. <a href="/">Test another visit ?</a>
		</p>
	</c:if>
 	
	
</body>
</html>
