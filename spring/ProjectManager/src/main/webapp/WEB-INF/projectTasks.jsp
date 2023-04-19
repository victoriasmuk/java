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
<title>Project Manager</title>
</head>
<body style="font-family: optima, sans-serif;">
	<div class="container">
		<nav class="navbar">
			<div class="container-fluid">
				<h1 class="card-header">Project: <c:out value="${project.title}"/></h1>
				<a href="/dashboard" class="nav-link">Back to dashboard</a>
			</div>					
		</nav>
		<div class="row">
			<h4>Project Lead: <c:out value="${project.lead.firstName}"/></h4>
		</div>
		<div class="row">
			<form:form modelAttribute="task" method="post" action="/tasks/create/${project.id}">
				<%-- <form:input type="hidden" path="creatorName" value="${userId}"/> --%>
				<div class="form-floating mb-3">
                    <form:textarea path="description" class="form-control" id="task" rows="3"></form:textarea>
					<form:label path="description">Add a task ticket for this team:</form:label>
                    <form:errors path="description" style="color: brown;"/>
				</div>
				<button type='submit' class="btn btn-outline-dark">Sumbit</button>
			</form:form>
		</div>
		<div class="row">
            <ul class="list-group list-group-flush">
                <c:forEach items="${project.tasks}" var="oneTask">
	                <li class="list-group-item">
	                	<strong>Added by <c:out value="${oneTask.creatorName}"/> at <fmt:formatDate value="${oneTask.createdAt}" pattern="hh:mm a MMMM dd"/></strong>
	                	<br />
	               		<c:out value="${oneTask.description}"/>
	               	</li>
                </c:forEach>
            </ul>
        </div>
	</div>
</body>
</html>