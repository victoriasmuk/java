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
				<h1 class="card-header">Project Details</h1>
				<a href="/dashboard" class="nav-link">Back to dashboard</a>
			</div>					
		</nav>
		<div class="row">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Project Title: <c:out value="${project.title}"/></li>
				<li class="list-group-item">Project Description: <c:out value="${project.description}"/></li>
	            <li class="list-group-item">Due Date: <fmt:formatDate value="${project.dueDate}" pattern="MM/dd/yyyy"/></li>
			</ul>
		</div>
		<div class="row">
		<a href="/projects/tasks/${project.id}" class="nav-link text-start">See tasks →</a>
			<c:if test="${project.lead.id == userId}">
				<div class="text-end">
					<a href="/projects/delete/${project.id}" class="btn btn-outline-dark">Delete project</a>
				</div>
	        </c:if>
		</div>
	</div>
</body>
</html>