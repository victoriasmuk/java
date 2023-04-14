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
	<div class="container text-center">
		<h1>All Books</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th> ID </th>
					<th> Title </th>
					<th> Language </th>
					<th> Number of Pages </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBook" items="${bookList}">
				<tr>
					<td> <c:out value="${oneBook.id}"></c:out> </td>
					<td> 
						<a href="/books/${oneBook.id}">
							<c:out value="${oneBook.title}"></c:out> 
						</a>
					</td>
					<td> <c:out value="${oneBook.language}"></c:out> </td>
					<td> <c:out value="${oneBook.pages}"></c:out> </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
</body>
</html>