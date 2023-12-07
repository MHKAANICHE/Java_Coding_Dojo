<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Book</title>
</head>
<body>
<h1>Create New Book</h1>
<form action="/OnSubmit">
<div>
<label>Title: </label>
<input type="text" name="title"/>
</div>
<div><label>Author: </label>
<input type="text" name="author"/></div>

<div><label>Description: </label>
<input type="text" name="descr"/></div>

<div><label>Language: </label>
<input type="text" name="lang"/></div>

<div><label>Number of pages: </label>
<input type="number" name="pages"/></div>

<div><input type="submit" value="Save new Book" /></div>
</form>
</body>
</html>