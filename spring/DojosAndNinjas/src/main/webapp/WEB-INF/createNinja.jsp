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
<title>New Ninja</title>
</head>
<body>
	<div class="container">
	<h1>New Ninja</h1>
	<form:form action="/ninjas/process/new" method="POST" modelAttribute="ninja">
		<div>
			<form:select path="dojo" class="form-select mb-3">
				<c:forEach var="dojo" items="${allDojos}">
					<form:option value="${dojo.id}" path="dojo">
    					<c:out value="${dojo.dojoName}"/>
    				</form:option>
				</c:forEach>
			</form:select>
		</div>
			<div class="form-floating mb-3">
				<form:input class="form-control" type="text" path="firstName" />
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName" />
			</div>
			<div class="form-floating mb-3">
				<form:input class="form-control" type="text" path="lastName" />
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName" />
			</div>
			<div class="form-floating mb-3">
				<form:input class="form-control" type="number" path="age" />
				<form:label path="age">Age</form:label>
				<form:errors path="age" />
			</div>
			<button class="btn btn-dark" type="submit">Submit</button>
	</form:form>
	</div>
</body>
</html>