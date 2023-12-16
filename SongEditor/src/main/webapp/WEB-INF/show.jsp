<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Song</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles for the page */
        body {
            padding: 20px; /* Add padding for better spacing */
        }

        /* Style for the title */
        h1 {
            color: #007bff; /* Bootstrap primary color */
        }

        /* Style for the table */
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #dee2e6; /* Bootstrap border color */
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        /* Style for the button */
        button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="header">
        <div>
            <h3>
                Hello
                <c:out value="${user_name}" />
            </h3>
        </div>
        <div>
            <a href="/logout">Logout</a>
        </div>
    </div>
    <h1><c:out value="${song.title}" /></h1>
    <h3>Started by <c:out value="${author_name}" /></h3>
    <table class="table">
        <tr>
            <td>Genre:</td>
            <td>${song.genre}</td>
        </tr>
        <tr>
            <td>Lyrics:</td>
            <td><p>${song.lyrics}</p></td>
        </tr>
    </table>
    <!-- Add Bootstrap button class -->
    <button class="btn btn-primary" onclick="location.href='/song/${song.id}/edit'" type="button">Contribute</button>
    <hr>
    <table class="table">
        <h3>Collaborators</h3>
        <c:forEach var="contr" items="${contributors}">
            <tr><td><c:out value="${contr.contributor.getUserName()}" /></td></tr>
        </c:forEach>
    </table>

    <!-- Add Bootstrap JS and Popper.js scripts if needed -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
