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
	<h1 style="color:blue;">Save Travels</h1>
	<table>
		<thead>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
			<tr>
				<td><a href="/expenses/${item.id}">${item.name}</a></td>
				<td>${item.vendor}</td>
				<td><fmt:formatNumber value="${item.price}" type="currency" 
				currencySymbol="$" maxFractionDigits="2"/></td>                   
				<td><a href="/expenses/edit/${item.id}">edit</a></td>
				<td><button style="color: red;" onclick="location.href='/expenses/delete/${item.id}'"
							type="button">delete</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div></div>
	<h1 style="color:blue;" >Add an expense:</h1>
	<table>
		<form:form action="/saveNewItem" method="POST" modelAttribute="newItem">
			<tr>
				<td><form:label path="name">Expense Name:</form:label></td>
				<td><form:input type="text"  path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="vendor">Vendor:</form:label></td>
				<td><form:input type="text" path="vendor" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Amount:</form:label></td>
				<td><form:input type="text" path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input type="text"  path="description"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input style="color: blue;" type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</table>

</body>
</html>