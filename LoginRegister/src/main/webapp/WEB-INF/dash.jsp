<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Welcome to Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyJPAeDf6qD5uJC5Fb6fFoPsFntG1gQJG" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa; /* Set your desired background color */
        }

        h1 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <td>
                <h1>Welcome to Dashboard <c:out value="${user_name}"/></h1>
            </td>
            <td></td>
            <td>
                <a href="/logout" class="btn btn-danger">Logout</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
