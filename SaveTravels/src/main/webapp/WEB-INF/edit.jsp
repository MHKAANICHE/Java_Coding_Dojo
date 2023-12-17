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
	<h1 style="color:blue;" >Add an expense:</h1>
	<table>
		<form:form action="/saveEditItem" method="POST" modelAttribute="editItem">
			<form:input type="hidden"  path="id" value="${item.id}"/>
			
			
			<tr>
				<td><form:label path="name">Expense Name:</form:label></td>
				<td><form:input type="text"  path="name" value="${item.name}"/></td>
			</tr>
			<tr>
				<td><form:label path="vendor">Vendor:</form:label></td>
				<td><form:input type="text" path="vendor" value="${item.vendor}"/></td>
			</tr>
			<tr>
				<td><form:label path="price">Amount:</form:label></td>
				<td><form:input type="text" path="price" value="${item.price}"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input type="text"  path="description" value="${item.description}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input style="color: blue;" type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>