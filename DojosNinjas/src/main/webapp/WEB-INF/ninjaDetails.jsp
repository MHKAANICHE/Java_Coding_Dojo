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
	<table>
		<form:form action="/editNinja" method="POST"
			modelAttribute="editNinja">
<%-- 			<form:input type= "hidden" path="id"  value="${ninja.id}"/> --%>
			<tr>
				<td><form:label path="id">Id:</form:label></td>
				<td><form:input type="text" path="id" value="${ninja.id}"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First name:</form:label></td>
				<td><form:input type="text" path="firstName" value="${ninja.firstName}"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last name:</form:label></td>
				<td><form:input type="text" path="lastName"  value="${ninja.lastName}"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="age">Age:</form:label></td>
				<td><form:input type="number" path="age" value="${ninja.age}" ></form:input></td>
			</tr>
			<tr>
				<td><form:select path="dojo">
						<c:forEach var="dojo" items="${dojos}">
							<form:option value="${dojo.id}" path="dojo">
								<c:out value="${dojo.name}" />
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit Ninja" /></td>
			</tr>
		</form:form>
	</table>


	<h1>${ninja.firstName}${ninja.lastName}</h1>
	<h3>Age :${ninja.age}</h3>
	<h3>Age :${ninja.dojo.name}</h3>

</body>
</html>