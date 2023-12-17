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
<title>Insert title here</title>
</head>
<body>
</table>
	<di></di>
	<h1 style="color:blue;" >Add an expense:</h1>
	<a href="/expenses">Go back</a>
	<table>		
			<tr>
				<td>Expense Name:</td>
				<td><c:out value="${item.name}"/> </td>
			</tr>
			<tr>
				<td>Vendor:</label></td>
				<td><c:out value="${item.vendor}"/></td>
			</tr>
			<tr>
				<td><label>Amount:</label></td>
				<td>$<c:out value="${item.price}"/></td>
			</tr>
			<tr>
				<td><label>Description</label></td>
				<td><c:out value="${item.description}"/></td>
			</tr>
	</table>
</body>
</html>