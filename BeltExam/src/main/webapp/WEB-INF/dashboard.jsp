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
				<h1 class="card-header">Hello, <c:out value="${userName}"/>. Here are some name suggestions.</h1>
				<a href="/logout" class="nav-link">Logout</a>
			</div>					
		</nav>
		<nav class="navbar">
			<div class="container-fluid">
				<h4 class="card-header">Baby Names</h4>
				<a href="/names/new" class="nav-link">+ Add a name</a>
			</div>					
		</nav>
		<table class="table table-striped table-hover mb-5">
			<thead>
				<tr>
					<th>Vote</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Origin</th>
					<th>Total Votes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${nameList}" var="name">
					<tr>
						<td>
						<c:if test="${!user.getNames().contains(name)}">
							<a href="/votes/create/${name.id}">Vote</a>
						</c:if>
						</td>
						<td><a href="/names/view/${name.id}"><c:out value="${name.babyName}"/></a></td>
						<td><c:out value="${name.gender}"/></td>
						<td><c:out value="${name.origin}"/></td>
						<td><c:out value="${name.getUsers().size()}"/></td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>

</body>
</html>