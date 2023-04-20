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
				<h1 class="card-header">Add a name!</h1>
				<a href="/dashboard" class="nav-link">Back to dashboard</a>
			</div>					
		</nav>
		<div class="card-body">
			<form:form modelAttribute="name" action="/names/create" method="post">
				<form:input type="hidden" path="own" value="${userId}"/>
				<div class="form-floating mb-3">
	                <form:input path="babyName" type="text" class="form-control" id="babyName"/>
					<form:label path="babyName">New Name</form:label>
	                <form:errors path="babyName" style="color: brown;"/>
				</div>
				<div class="mb-3">
	                <form:select path="gender" class="form-select">
	                	<form:option value="NA" selected="true" label="Gender"></form:option>
	                	<form:option value="Neutral" label="Neutral"></form:option>
	                	<form:option value="Male" label="Male"></form:option>
	                	<form:option value="Female" label="Female"></form:option>
	                </form:select>
	                <form:errors path="gender" style="color: brown;"/>
				</div>
				<div class="form-floating mb-3">
	                <form:input path="origin" type="text" class="form-control" id="origin"/>
					<form:label path="origin">Origin</form:label>
	                <form:errors path="origin" style="color: brown;"/>
				</div>
				<div class="form-floating mb-3">
                    <form:textarea path="meaning" class="form-control" id="meaning" rows="3"></form:textarea>
	                <form:label path="meaning">Meaning</form:label>
	                <form:errors path="meaning" style="color: brown;"/>
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