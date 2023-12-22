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
<title>New Product</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<style>
</style>
</head>
<body>
	<div class="container d-flex justify-content-center">
		<h1>New Product</h1>
	</div>
	<div class="container">
		<a href="/#">Home</a>
	</div>
	<hr>
	<div class="container ">
		<form>
			<table class="col-md-12">
				<tr>
					<td><label class="form-label">Name:</label></td>
					<td><input class="form-control" type="text" /></td>
				</tr>
				<tr>
					<td></td>
					<td class="row"><input type="submit" value="Submit"	class="btn btn-primary" /></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- 	<div -->
	<!-- 		class="container square-box  -->
	<!-- 		d-flex justify-content-center align-items-center "> -->

	<!-- 		<div class="square-min-box d-flex align-items-center "> -->
	<!-- 			<div > -->
	<!-- 			<div class=" d-flex justify-content-center"> -->
	<!-- 				<h1>Welcome to Lookify!</h1> -->
	<!-- 			</div> -->
	<!-- 			<div class=" d-flex justify-content-center"> -->
	<!-- 				<a href="/dash">Start Looking</a> -->
	<!-- 			</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>