<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login and Register</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyJPAeDf6qD5uJC5Fb6fFoPsFntG1gQJG"
	crossorigin="anonymous">
<style>
/* Custom styles for the page */
body {
	padding: 20px; /* Add padding for better spacing */
}

/* Style for the form container */
.form-container {
	margin-top: 20px;
}

/* Style for the buttons */
input[type="submit"] {
	margin-top: 10px;
}

/* Flex container to arrange the two columns side by side */
.flex-container {
	display: flex;
	justify-content: space-between;
}

/* Header styles */
.header {
	text-align: center;
	padding: 10px;
	background-color: #007bff; /* Bootstrap primary color */
	color: #fff;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Welcome to Your Website</h1>
	</div>

	<div class="container-fluid">
		<div class="flex-container">

			<!-- Login Form Column -->
			<div class="col-md-6 form-container">
				<h1>Login</h1>
				<table>
					<form:form action="/register" method="POST"
						modelAttribute="newRegister">
						<tr>
							<td><form:label path="userName">Enter your user name:</form:label></td>
							<td><form:input type="text" path="userName" /> <form:errors style="color:red;"
									path="userName" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Enter your email:</form:label></td>
							<td><form:input type="email" path="email" /> <form:errors style="color:red;"
									path="email" /></td>
						</tr>
						<tr>
							<td><form:label path="password">Enter your password:</form:label></td>
							<td><form:input type="" path="password" /> <form:errors style="color:red;"
									path="password" /></td>
						</tr>
						<tr>
							<td><form:label path="confirmPW">Confirm your password:</form:label></td>
							<td><form:input type="" path="confirmPW" /> <form:errors style="color:red;"
									path="confirmPW" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Register"
								class="btn btn-primary" /></td>
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
							<td><form:input type="text" path="email" />
								<form:errors style="color:red;" path="email" /></td>
						</tr>
						<tr>
							<td><form:label path="password">Enter your password:</form:label></td>
							<td><form:input type="" path="password" />
								<form:errors style="color:red;" path="password" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Login"
								class="btn btn-success" /></td>
						</tr>
					</form:form>
				</table>
				</div>

        </div>
    </div>

    <!-- Add Bootstrap JS and Popper.js scripts if needed -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>



