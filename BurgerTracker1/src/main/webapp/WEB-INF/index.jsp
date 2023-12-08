<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>
	<h1 style="color: blue;">Burger Tracket</h1>
	<div>
		<table>
			<thead>
				<td>Burger Name</td>
				<td>Restaurant Name</td>
				<td>Rating (out of 5)</td>
				
			</thead>
			<tbody>
				<c:forEach var="burger" items="${collectionBurger}">
					<tr>
						<td><c:out value="${burger.name}" /></td>
						<td><c:out value="${burger.restaurant}" /></td>
						<td><c:out value="${burger.rating}" /></td>
					</tr>
					
				</c:forEach>
				<tr>
					<td>Krabby Patty</td>
					<td>Krusty Krab</td>
					<td>5</td>
				</tr>
			</tbody>
		</table>
	</div>

	<table>
		<tr>
			<h1 style="color: blue;">Add a Burger:</h1>
		</tr>
		<tr>
			<h5 style="color: red;">Notes must not be blank</h5>
		</tr>
		<tr>
			<form:form action="/newBurger" method="POST" modelAttribute="burger">
				<td style="color:red;"><form:errors path="name"></form:errors></td>
				<tr>
					<td><form:label path="name">Burger Name </form:label></td>				
					<td><form:input type="text" path="name" /></td>
				</tr>
				<td style="color:red;"><form:errors path="restaurant"></form:errors></td>
				<tr>
					<td><form:label path="restaurant">Restaurant Name</form:label></td>
					<td><form:input type="text" path="restaurant" /></td>
				</tr>
				<td style="color:red;"><form:errors path="rating"></form:errors></td>	
				<tr>
					<td><form:label path="rating">Rating</form:label></td>
					<td><form:input type="number" path="rating" /></td>
				</tr>
				<!-- 				<tr> -->
				<!-- 					<td><label>Notes</label></td> -->
				<!-- 					<td><textarea></textarea></td> -->
				<!-- 				</tr> -->
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</form:form>
		</tr>
	</table>

</body>
</html>