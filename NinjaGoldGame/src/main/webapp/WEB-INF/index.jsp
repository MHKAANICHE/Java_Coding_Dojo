<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
</head>
<body>
	<div>
		<h1>Your Gold:</h1>
		<h3>
			<c:out value="${score}" />
		</h3>
	</div>
<div  style="display:flex">	
	<div class="Box" style="margin:auto;border: 3px solid;padding:5px ; text-align:center;">
		<form action="/play" method="POST">
			<h1>Farm</h1>
			<h3>(earns 10-20 gold)</h3>
			<input type="hidden" name="playerChoice" value="Farm" /> <input
				type="submit" value="Find Gold!" />
		</form>
	</div>
	
		<div class="Box" style="margin:auto;border: 3px solid;padding:5px ; text-align:center;">
		<form action="/play" method="POST">
			<h1>Cave</h1>
			<h3>(earns 5-10 gold)</h3>
			<input type="hidden" name="playerChoice" value="Cave" /> <input
				type="submit" value="Find Gold!" />
		</form>
	</div>
			<div class="Box" style="margin:auto;border: 3px solid;padding:5px ; text-align:center;">
		<form action="/play" method="POST">
			<h1>House</h1>
			<h3>(earns 2-5 gold)</h3>
			<input type="hidden" name="playerChoice" value="House" /> <input
				type="submit" value="Find Gold!" />
		</form>
	</div>
	
				<div class="Box" style="margin:auto;border: 3px solid;padding:5px ; text-align:center;">
		<form action="/play" method="POST">
			<h1>Casino</h1>
			<h3>(earns 0-50 gold)</h3>
			<input type="hidden" name="playerChoice" value="Casino" /> <input
				type="submit" value="Find Gold!" />
		</form>
	</div>
	
</div>	
	
	<div>
		<h1>Activities:</h1>
		
		<!-- iFrame do not accept color -->
 		<iframe 
 			srcdoc=" 
 		<!-- Extract Message -->	
		<c:forEach var="message" items="${messages}" > 
 			<p> <c:out value="${message}"/></p> 
 		</c:forEach> 
 		<!-- ... -->
		" width=500px> 
		</iframe> 
		
		
		<!-- Extract Message -->
		<c:forEach var="message" items="${messages}" >
			<p style="color:	
			<c:if test="${message.contains('won')}">green</c:if> 			
 			<c:if test="${!message.contains('won')}">red</c:if> 
		
			">
			<c:out value="${message}"></c:out>
			</p>
		</c:forEach>
		<!-- ... -->
	</div>
</body>
</html>