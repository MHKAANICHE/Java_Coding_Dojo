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
    <title>New Song</title>
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

        /* Style for the form */
        form {
            margin-top: 20px;
        }

        /* Style for the buttons */
        input[type="submit"] {
            margin-top: 10px;
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
    <div>
        <h1>Start a new Song</h1>
    </div>
    <table class="table">
        <form:form action="/newSong" method="POST" modelAttribute="newSong">
            <tr>
                <td><form:label path="title">Song Title:</form:label>
                    <form:errors style="color:red;" path="title" /></td>
                <td><form:input class="form-control" type="text" path="title" /></td>
            </tr>
            <tr>
                <td><form:label path="genre">Genre:</form:label>
                    <form:errors style="color:red;" path="genre"/></td>
                <td><form:input class="form-control" type="text" path="genre" /></td>
            </tr>
            <tr>
                <td><form:label path="lyrics">Add your Lyric:</form:label>
                    <form:errors style="color:red;" path="lyrics"/></td>
                <td><form:input class="form-control" type="text" path="lyrics" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input class="btn btn-primary" type="submit" value="Submit" /></td>
            </tr>
        </form:form>
    </table>

    <!-- Add Bootstrap JS and Popper.js scripts if needed -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
