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
<title>Home</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<style>
</style>
</head>
<body>
	<div class="container d-flex justify-content-center">
		<h1>Home Page</H1>
	</div>
	<div class="container align-self">
		<a href="">New Product</a>  <br>
		<a href="">New Category</a>
	</div>
	<hr>
	<div class="container d-flex">
		<div class="container table ">
			<table>
				<thead>
					<th>Products</th>
				</thead>
				<tbody>
					<tr>
						<td><a href="/#">TV</a></td>
					</tr>
					<tr>
						<td><a href="/#">Sofa</a></td>
					</tr>
					<tr>
						<td><a href="/#">Lamp</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="container table">
			<table>
				<thead>
					<th>Categories</th>
				</thead>
				<tbody>
					<tr>
						<td><a href="/#">Furniture</a></td>
					</tr>
					<tr>
						<td><a href="/#">Electronics</a></td>
					</tr>
					<tr>
						<td><a href="/#">Technology</a></td>
					</tr>
					<tr>
						<td><a href="/#">Kitchen</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>