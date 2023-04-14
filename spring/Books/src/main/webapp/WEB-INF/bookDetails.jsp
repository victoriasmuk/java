<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Read Share</title>
</head>
<body>
	<div class="container">
		<h1> <c:out value="${oneBook.title}"></c:out> </h1>
		<h6>Description: <c:out value="${oneBook.description}"></c:out></h6>
		<h6>Language: <c:out value="${oneBook.language}"></c:out></h6>
		<h6>Number of Pages: <c:out value="${oneBook.pages}"></c:out></h6>
	</div>
</body>
</html>