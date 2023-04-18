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
<title>Dojo Page</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${dojo.dojoName}"/> Location Ninjas</h1>
		<table class="table table-striped table-hover text-center">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="ninja">
				<tr>
					<td> <c:out value="${ninja.firstName}" /> </td>
					<td> <c:out value="${ninja.lastName}" /> </td>
					<td> <c:out value="${ninja.age}" /> </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>