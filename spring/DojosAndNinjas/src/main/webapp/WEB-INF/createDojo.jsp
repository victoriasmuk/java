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
<title>New Dojo</title>
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		<form:form action="/dojos/process/new" modelAttribute="dojo" method="POST">
			<div class="form-floating mb-3">
				<form:input class="form-control" type="text" path="dojoName" />
				<form:label path="dojoName"> Dojo Name</form:label>
				<form:errors path="dojoName" />
			</div>
			<button class="btn btn-dark" type="submit">Submit</button>
		</form:form>
	
	</div>
</body>
</html>