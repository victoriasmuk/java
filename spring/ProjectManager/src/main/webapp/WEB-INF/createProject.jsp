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
<title>Project Manager</title>
</head>
<body style="font-family: optima, sans-serif;">
	<div class="container">
		<nav class="navbar">
			<div class="container-fluid">
				<h1 class="card-header">Create a Project</h1>
				<a href="/dashboard" class="nav-link">Back to dashboard</a>
			</div>					
		</nav>
		<div class="card-body">
			<form:form modelAttribute="project" action="/projects/create" method="post">
				<form:input type="hidden" path="lead" value="${userId}"/>
				<div class="form-floating mb-3">
	                <form:input path="title" type="text" class="form-control" id="title"/>
					<form:label path="title">Project Title</form:label>
	                <form:errors path="title" style="color: brown;"/>
				</div>
				<div class="form-floating mb-3">
                    <form:textarea path="description" class="form-control" id="description" rows="3"></form:textarea>
	                <form:label path="description">Project Description</form:label>
	                <form:errors path="description" style="color: brown;"/>
				</div>
				<div class="mb-3">
                    <form:label path="dueDate">Due Date</form:label>
                    <form:input path="dueDate" type="date" name="dueDate" id="dueDate"/>
	                <form:errors path="dueDate" style="color: brown;"/>
				</div>
				<div class="d-grid gap-2 d-md-flex">
					<a href="/dashboard" class="btn btn-outline-dark">Cancel</a>
					<button type='submit' class="btn btn-outline-dark">Sumbit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>