<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h3>Send an Omikuji!</h3>
	<div>
		<form  action="/show" method="POST">					
			<label >Pick any number from 5 to 25</label> 
			<input type="number" name="luckyNumber"> 
			<label >Enter the name of any city</label> 
			<input type="text" name="cityName"> 
			<label >Enter the name of any real person</label>
			<input type="text" name="userName"> 
			<label >Enter professional endeavor or hobby</label>
			<input type="text" name="userProfession"> 
			<label >Enter any type of living thing</label> 
			<input type="text" name="livingThing"> 
			<label >Say something nice to someone :</label>
			<input type="text" name="message"> 
			<p>Send and show a friend</p>
			<input type="submit" value="Send">
		</form>
	</div>
</body>
</html>