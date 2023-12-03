<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Omikuji</title>
</head>
<body>
<h3>Here's You Omikuji!</h3>
<div>
<p>In <c:out value="${card.luckyNumber}" /> years, you will live in <c:out value="${card.cityName}" /> with <c:out value="${card.userName}" /> as your roomate, <c:out value="${card.userProfession}" />. The next time you see a <c:out value="${card.livingThing}" />, you will have good luck. Also, <c:out value="${card.message}" />.</p>
</div>
<a href="/"  >Go Back</a>
</body>
</html>