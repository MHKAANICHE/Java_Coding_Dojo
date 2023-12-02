<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment</title>
</head>
<body>
<h3>Customer Name :
<c:out value="${customerName }"></c:out> 
</h3>
<div>
<p>
Item name : 
<c:out value = "${itemName }"></c:out>
</p>
<p>
Price : 
<c:out value = "${price }"></c:out>
</p>
<p>
Description : 
<c:out value = "${description }"></c:out>
</p>
<p>
Vendor : 
<c:out value = "${vendor }"></c:out>
</p>
</div>
</body>
</html>