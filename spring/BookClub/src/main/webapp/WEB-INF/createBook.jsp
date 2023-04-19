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
				<h1 class="card-header">Add a book to your shelf!</h1>
				<a href="/books" class="nav-link">back to the shelves</a>
			</div>					
		</nav>
		<div class="card-body">
			<form:form action="/books/process/new" modelAttribute="book" method="POST">
				<form:input type="hidden" path="user" value="${userId}"/>
				<div class="form-floating mb-3">
		            <form:input type="text" path="title" class="form-control"/>
					<form:label path="title" >Title</form:label>
		            <form:errors path="title" style="color: brown;"/>
				</div>
				<div class="form-floating mb-3">
		            <form:input type="text" path="author" class="form-control"/>
					<form:label path="author" >Author</form:label>
		            <form:errors path="author" style="color: brown;"/>
				</div>
				<div class="form-floating mb-3">
		            <form:textarea path="thoughts" class="form-control"/>
					<form:label path="thoughts" >My thoughts</form:label>
		            <form:errors path="thoughts" style="color: brown;"/>
				</div>
				<div class="card-body">
					<button type='submit' class="btn btn-outline-dark">Sumbit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>