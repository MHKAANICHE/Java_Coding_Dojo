<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Top Songs</h1>
<h3>
<span>{song.id}</span>
<span> - </span>
<span><a href="/#">{song.title}</a></span>
<span> - </span>
<span>{song.artist}</span>
</h3>

<a href="#">Dashboard</a>
</body>
</html>