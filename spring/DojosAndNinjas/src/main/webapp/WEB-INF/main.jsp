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
<title>Dojos and Ninjas</title>
</head>
<body>
	<div class="container">
		<h1>Dojos and Ninjas</h1>
		<a href="/dojos/new">Create New Dojo</a>
		<a href="/ninjas/new">Create New Ninja</a>
		<h3>All Ninjas</h3>
		<table class="table table-striped table-hover text-center">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Dojo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allNinjas}" var="ninja">
				<tr>
					<td> <c:out value="${ninja.firstName}" /> </td>
					<td> <c:out value="${ninja.lastName}" /> </td>
					<td> <c:out value="${ninja.age}" /> </td>
					<td>
						<a href="/dojos/${ninja.dojo.id}">
							<c:out value="${ninja.dojo.dojoName}" /> 
						</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>