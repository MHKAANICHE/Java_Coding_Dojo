<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>activities</title>
</head>
<body>
		<!-- Extract Message -->
		<c:forEach var="message" items="${messages}" >
			<p style="color:	
			<c:if test="${message.contains('won')}">green</c:if> 			
 			<c:if test="${!message.contains('won')}">red</c:if> 
			">
			<c:out value="${message}"></c:out>
			</p>
		</c:forEach>
		<!-- ... -->
</body>
</html>