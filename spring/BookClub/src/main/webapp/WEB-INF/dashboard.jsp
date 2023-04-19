<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Read Share</title>
</head>
<body style="font-family: optima, sans-serif;">
	<div class="container">
		<nav class="navbar">
			<div class="container-fluid">
				<h1 class="card-header">Welcome, <c:out value="${userName}"/></h1>
				<a href="/logout" class="nav-link">Logout</a>
			</div>					
		</nav>
		<nav class="navbar">
			<div class="container-fluid">
				<h4 class="card-header">Books from everyone's shelves:</h4>
				<a href="/books/new" class="nav-link">+ Add to my shelf</a>
			</div>					
		</nav>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allBooks}" var="book">
				<tr>
					<td> <c:out value="${book.id}"/> </td>
					<td> 
						<a href="/books/${book.id}">
							<c:out value="${book.title}"/> 
						</a>
					</td>
					<td> <c:out value="${book.author}"/> </td>
					<td> <c:out value="${book.user.userName}"/> </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		
	</div>

</body>
</html>