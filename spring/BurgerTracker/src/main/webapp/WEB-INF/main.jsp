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
<title>Burger Tracker</title>
</head>
<body>
	<div class="container text-center">
		<h1>Burger Tracker</h1>
		<div class="card mx-auto w-50">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBurger" items="${burgerList}">
				<tr>
					<td> <c:out value="${oneBurger.burgerName}"></c:out> </td>
					<td> <c:out value="${oneBurger.restaurantName}"></c:out> </td>
					<td> <c:out value="${oneBurger.rating}"></c:out> </td>
					<td>
						<a href="/burgers/edit/${oneBurger.id}"> Edit </a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div class="mx-auto w-50 mt-5">
			<form:form action="/process" method="POST" modelAttribute="newBurger">
				<div class="form-floating mb-3">
					<form:input class="form-control" type="text" path="burgerName" />
					<form:label path="burgerName"> Burger Name </form:label>
					<form:errors path="burgerName" />
				</div>
				<div class="form-floating mb-3">
					<form:input class="form-control" type="text" path="restaurantName" />
					<form:label path="restaurantName"> Restaurant Name </form:label>
					<form:errors path="restaurantName" />
				</div>
				<div class="form-floating mb-3">
					<form:input class="form-control" type="number" path="rating" />
					<form:label path="rating">Rating</form:label>
					<form:errors path="rating" />
				</div>
				<div class="form-floating mb-3">
					<form:textarea class="form-control" path="notes" />
					<form:label path="notes"> Notes </form:label>
					<form:errors path="notes" />
				</div>
				<button class="btn btn-dark" type="submit">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>