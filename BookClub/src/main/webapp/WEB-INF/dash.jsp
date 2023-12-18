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
    <title>Home</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles for the header */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            background-color: #f8f9fa; /* Bootstrap background color */
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
    <!-------------------------------------->
    <div>
        <h3>Books from everyone's shelves:</h3>
    </div>
    <div>
    <a href="/new">+ Add a to my shelf!</a>
    </div>

    <table class="table table-striped">
        <thead>
           <th >ID</th>
           <th>Title</th>
           <th>Author Name</th>
           <th>Posted by</th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
            <th>${book.id}</th>
           <th><a href="/show/${book.id}">${book.title}</a></th>
           <th>${book.author}</th>
           <th>${book.owner.userName}</th>
            </tr>
        </c:forEach>         
        </tbody>
    </table>
   
    <!-- Add Bootstrap JS and Popper.js scripts if needed -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
