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
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- Your local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<style>
/* Any additional styles specific to this page */
body {
	background-color: #ACA9CB;
}
</style>
</head>
<body>
	<div class="container">
		<h1 style="color: magenta;">Book Club</h1>
		<h3>A place for friends to share thoughts on books.</h3>
	</div>

	<div class="container">
		<!-- 	<div class="container-fluid"> -->
		<div class="row">
			<!-- 		<div class="flex-container"> -->

			<!-- Login Form Column -->
			<div class="col-md-6 form-container">
				<h1>Login</h1>
				<table>
					<form:form action="/register" method="POST"
						modelAttribute="newRegister">
						<tr>
							<td><form:label path="userName">Enter your user name:</form:label></td>
							<td><form:input type="text" path="userName" /> <form:errors
									class="error" path="userName" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Enter your email:</form:label></td>
							<td><form:input type="email" path="email" /> <form:errors
									class="error" path="email" /></td>
						</tr>
						<tr>
							<td><form:label path="password">Enter your password:</form:label></td>
							<td><form:input type="" path="password" /> <form:errors
									class="error"  path="password" /></td>
						</tr>
						<tr>
							<td><form:label path="confirmPW">Confirm your password:</form:label></td>
							<td ><form:input type="" path="confirmPW" /> <form:errors
								class="error" path="confirmPW" /></td>
						</tr>
						<tr>
							<td></td>
							<td class="d-flex justify-content-end"><input type="submit"
								value="Register" class="btn btn-primary" /></td>
						</tr>
					</form:form>
				</table>
			</div>

			<!-- Register Form Column -->
			<div class="col-md-6 form-container">
				<h1>Register</h1>
				<table>
					<form:form action="/loggin" method="POST"
						modelAttribute="newLoggin">
						<tr>
							<td><form:label path="email">Enter your email:</form:label></td>
							<td><form:input type="text" path="email" /> <form:errors
									class="error" path="email" /></td>
						</tr>
						<tr>
							<td><form:label path="password">Enter your password:</form:label></td>
							<td><form:input type="" path="password" /> <form:errors
									class="error" path="password" /></td>
						</tr>
						<tr>
							<td></td>
							<td class="d-flex justify-content-end"><input type="submit"
								value="Login" class="btn btn-success" /></td>
						</tr>
					</form:form>
				</table>
			</div>

		</div>
	</div>

	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
