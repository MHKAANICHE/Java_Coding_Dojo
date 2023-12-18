<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div>
		<h1>
			<c:out value="${book.title}" />
		</h1>
	</div>
	<div>
		<a href="/dash">back to the shelves</a>
	</div>

	<div>
		<h3>
			<span style="color: red;"><c:out
					value="${book.owner.userName}" /></span> <span style="color: black;">
				read </span> <span style="color: magenta;"><c:out
					value="${book.title}" /></span> <span style="color: black;"> by </span> <span
				style="color: green;"><c:out value="${book.author}" /></span>
		</h3>
	</div>
	<div>
		<h3>
			Here are
			<c:out value="${book.owner.userName}" />
			's thoughts:
		</h3>
	</div>


	<hr />
	<p>"${book.myThought}"</p>
	<hr />

	<c:if test="${isOwner}">
		<button
			onClick="location.href='/book/<c:out value = "${book.id}" />/edit/'"
			type="submit">edit</button>
		<form action="/book/<c:out value = "${book.id}" />/delete/" method="POST">
		<input type="submit" value="delete"/>
		</form>			
	</c:if>
</body>
</html>