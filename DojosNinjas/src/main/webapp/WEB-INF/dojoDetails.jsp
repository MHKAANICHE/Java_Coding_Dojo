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
<title>${dojo.name}</title>
</head>
<body>
<h1>${dojo.name}</h1>
<c:forEach var="ninja" items="${dojo.ninja}">
<a>${ninja.firstName} ${ninja.lastName}</a><br>
</c:forEach>
</body>
</html>