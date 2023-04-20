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
<title>Joy Bundler Names</title>
</head>
<body style="font-family: optima, sans-serif;">
	<div class="container">
		<nav class="navbar">
			<div class="container-fluid">
				<h1 class="card-header"><c:out value="${name.babyName}"/></h1>
				<a href="/dashboard" class="nav-link">Back to dashboard</a>
			</div>					
		</nav>
		<div class="row">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Added by <c:out value="${name.own.firstName}"/></li>
				<li class="list-group-item">Gender: <c:out value="${name.gender}"/></li>
	            <li class="list-group-item">Meaning: <c:out value="${name.meaning}"/></li>
	            <c:choose>
	            <c:when test="${name.getUsers().contains(currentUser)}">
		            <li class="list-group-item">You voted for this name.</li>	            
	            </c:when>
	            <c:otherwise>
	            	<li class="list-group-item">
	            		<a href="/votes/create/${name.id}">Vote</a>          		
	            	</li>
	            </c:otherwise>
	            </c:choose>
			</ul>
		</div>
		<div class="row">
			<c:if test="${name.own.id == userId}">
				<div class="text-end">
					<a href="/names/edit/${name.id}" class="btn btn-outline-dark">Edit</a>
					<a href="/names/delete/${name.id}" class="btn btn-outline-dark">Delete</a>
				</div>
	        </c:if>
		</div>
	</div>

</body>
</html>