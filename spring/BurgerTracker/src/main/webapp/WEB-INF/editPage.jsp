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
	<div class="container">
		<nav class="navbar">
			<div class="container-fluid">
				<h1>Edit Burger</h1>
				<a href="/" class="nav-link">Go back</a>
			</div>
		</nav>
		<div class="mx-auto w-50">
			<form:form action="/process/edit/${oneBurger.id}" method="PUT" modelAttribute="oneBurger">
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