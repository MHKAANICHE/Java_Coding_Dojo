<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Loop</title>
</head>
<body>
	<h3>Fruit Store</h3>
	<table>
		<th>Name</th>
		<th>Price</th>
		
		<c:forEach var="fruit" items="${itemList}">
			<tr>
				<td><c:out value="${fruit.name}"></c:out></td>

				<td><c:out value="${fruit.price}"></c:out></td>
			</tr>
		</c:forEach>



	</table>
</body>
</html>