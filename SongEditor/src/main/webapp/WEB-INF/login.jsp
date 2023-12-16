<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login and Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyJPAeDf6qD5uJC5Fb6fFoPsFntG1gQJG" crossorigin="anonymous">

</head>
<body>
<table>
    <thead>
    <td></td>
    <td></td>
    <td><h1>Welcome</h1></td>
    </thead>
    <tbody>
    <tr>
        <td>
            <tr>
                <h1>Login</h1>
            </tr>
            <tr>
                <table>
                    <form:form action="/register" method="POST" modelAttribute="newRegister">
                        <tr>
                            <td><form:label path="userName">Enter your user name:</form:label></td>
                            <td><form:input type="text" path="userName"/> <form:errors
                                    path="userName"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="email">Enter your email:</form:label></td>
                            <td><form:input type="email" path="email"/> <form:errors
                                    path="email"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="password">Enter your password:</form:label></td>
                            <td><form:input type="" path="password"/> <form:errors
                                    path="password"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="confirmPW">Confirm your password:</form:label></td>
                            <td><form:input type="" path="confirmPW"/> <form:errors
                                    path="confirmPW"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Register" class="btn btn-primary"/></td>
                        </tr>
                    </form:form>
                </table>
            </tr>
        </td>


        <td>
            <tr>
                <h1>Register</h1>
            </tr>
            <tr>
                <table>
                    <form:form action="/loggin" method="POST" modelAttribute="newLoggin">
                        <tr>
                            <td><form:label path="email">Enter your email:</form:label></td>
                            <td><form:input type="text" path="email"/><form:errors path="email"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="password">Enter your password:</form:label></td>
                            <td><form:input type="" path="password"/><form:errors path="password"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Login" class="btn btn-success"/></td>
                        </tr>
                    </form:form>
                </table>
            </tr>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
