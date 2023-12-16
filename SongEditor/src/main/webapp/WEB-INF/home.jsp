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
<title>Home</title>
</head>
<body>
	<div>
		<h3>
			Hello
			<c:out value="${user_name}" />
		</h3>
	</div>
	<div>
		<a href="">Logout</a>
	</div>
	<div>
		<h1>All Song Labs</h1>
	</div>
	<table>
		<thead>
			<th>Song</th>
			<th># of Collaboration</th>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="song" items="${songs}">
					<td>
						<p>
							<a href="/song/${song.id}">${song.title}</a>
						</p>
						<p><h5>Genre: ${song.genre}</h5></p>

					</td>
					<td>${song.songContributions.size()}contributors</td>
			</tr>
			<hr>
			</c:forEach>
			<td><a href="#">Morning Blues(prototype)</a>
				<h5>Genre: Blues(prototype)</h5></td>
			<td>2 contributions(prototype)</td>
			</tr>
		</tbody>
	</table>
	<button onclick="location.href='/new'" type="button">New Song</button>
</body>
</html>