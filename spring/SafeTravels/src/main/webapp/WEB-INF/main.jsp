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
<title>Safe Travels</title>
</head>
<body>
	<div class="container">
		<h1 class="mx-auto w-50">Safe Travels</h1>
		<div class="card mx-auto w-50">
			<table class="table table-striped table-hover text-center">
				<thead>
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneExpense" items="${expenseList}">
					<tr class="align-middle">
						<td>
							<a href="/expenses/${oneExpense.id}"> <c:out value="${oneExpense.expenseName}" /> </a>
						</td>
						<td> <c:out value="${oneExpense.vendor}" /> </td>
						<td> $<c:out value="${oneExpense.amount}" /> </td>
						<td>
							<div class="d-flex justify-content-around align-items-center">
								<a href="/expenses/edit/${oneExpense.id}"> Edit </a>
								<form action="/expenses/delete/${oneExpense.id}" method="POST">
									<input type="hidden" name="_method" value="delete" />
									<button type="submit" class="btn btn-link">Delete</button>
								</form>
							</div>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="mx-auto w-50 mt-5">
			<h3>Add an expense:</h3>
			<form:form action="/expenses/process" method="POST" modelAttribute="newExpense">
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