<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Fruity Loops</title>
</head>
<body>

<div class="container text-info">
	<h1>Fruit Store</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${fruits}">
			<tr>
				<td> <c:out value="${fruit.name}"/> </td>
				<td> $<c:out value="${fruit.price}"/> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


</body>
</html>