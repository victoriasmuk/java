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
<title>Show Expense</title>
</head>
<body>
	<div class="container  mx-auto w-50">
		<nav class="navbar">
			<div class="container-fluid">
				<h1>Expense Details</h1>
				<a href="/" class="nav-link">Go back</a>
			</div>
		</nav>
		<div>
			<h6>Expense Name: <c:out value="${oneExpense.expenseName}"></c:out> </h6>
			<h6>Expense Description: <c:out value="${oneExpense.description}"></c:out> </h6>
			<h6>Vendor: <c:out value="${oneExpense.vendor}"></c:out> </h6>
			<h6>Amount Spent: $<c:out value="${oneExpense.amount}"></c:out> </h6>
		</div>
	</div>
</body>
</html>