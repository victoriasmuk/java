<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Read Share</title>
</head>
<body style="font-family: optima, sans-serif;">
	<div class="container">
		<nav class="navbar">
			<div class="container-fluid">
				<h1 class="card-header"><c:out value="${book.title}"/></h1>
				<a href="/books" class="nav-link">back to the shelves</a>
			</div>					
		</nav>
		<div class="card-body">
			<c:choose>
			<c:when test="${userId == book.user.id}">
				<h4> You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/> </h4>
				<h4> Here are your thoughts: </h4>
			</c:when>
			<c:otherwise>
				<h4> <c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/> </h4>
				<h4> Here are <c:out value="${book.user.userName}"/>'s thoughts: </h4>
			</c:otherwise>
			</c:choose>
			<hr />
			<p> <c:out value="${book.thoughts}"/> </p>
			<hr />
			<div class="d-grid gap-2 d-md-flex">
				<c:if test="${userId == book.user.id}">
				<a class="btn btn-outline-dark" href="/books/${book.id}/edit">Edit</a>
				<form action="/books/delete/${book.id}" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="Delete" class="btn btn-outline-dark"/>
				</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>