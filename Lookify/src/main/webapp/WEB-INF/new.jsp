<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<style>

.square-box {
	max-width: 600px;
	min-height: 600px;
	border: 1px solid #666;
}
.square-min-box {
	max-width: 400px;
	min-height: 200px;
	border: 1px solid #666;
}

</style>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">	<h1>Add Song</h1> </div>
<div class="container " style="padding:15px">

	<form class="form-group d-flex ">
		<table style="min-width: 400px;
	min-height: 200px;">
			<tr >
				<td><label>Title</label></td>
				<td ><input type="text" style="min-width: 400px;" /></td>
			</tr>
			<tr >
				<td><label>Artist</label></td>
				<td><input type="text" style="min-width: 400px;"/></td>
			</tr>
			<tr >
				<td><label style="min-width: 150px;">Rating(1-10)</label></td>
				<td><input type="number" style="min-width: 400px;"/></td>
			</tr>
			<tr >
				<td></td>
				<td class="d-flex justify-content-end"><input type="submit" value="Add"  class="btn btn-primary shadow p-2 mb-5 rounded  " /></td>
			</tr>
		</table>
	</form>
</div>
<div class="container">
	<a href="">Dashboard</a>
</div>




	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>