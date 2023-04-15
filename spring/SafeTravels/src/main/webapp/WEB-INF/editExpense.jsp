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
<title>Edit Expense</title>
</head>
<body>
	<div class="container mx-auto w-50">
		<nav class="navbar">
			<div class="container-fluid">
				<h1>Edit Expense</h1>
				<a href="/" class="nav-link">Go back</a>
			</div>
		</nav>
		<div>
			<form:form action="/expenses/edit/${oneExpense.id}" method="PUT" modelAttribute="oneExpense">
				<div class="form-floating mb-3">
					<form:input class="form-control" type="text" path="expenseName" />
					<form:label path="expenseName"> Expense Name </form:label>
					<form:errors path="expenseName" />
				</div>
				<div class="form-floating mb-3">
					<form:input class="form-control" type="text" path="vendor" />
					<form:label path="vendor"> Vendor </form:label>
					<form:errors path="vendor" />
				</div>
				<div class="form-floating mb-3">
					<form:input class="form-control" type="number" path="amount" />
					<form:label path="amount"> Amount </form:label>
					<form:errors path="amount" />
				</div>
				<div class="form-floating mb-3">
					<form:textarea class="form-control" path="description" />
					<form:label path="description"> Description </form:label>
					<form:errors path="description" />
				</div>
				<button class="btn btn-dark" type="submit">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>