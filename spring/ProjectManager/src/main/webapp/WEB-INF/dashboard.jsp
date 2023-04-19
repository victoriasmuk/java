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
				<h1 class="card-header">Welcome, <c:out value="${userName}"/></h1>
				<a href="/logout" class="nav-link">Logout</a>
			</div>					
		</nav>
		<nav class="navbar">
			<div class="container-fluid">
				<h4 class="card-header">All Projects</h4>
				<a href="/projects/new" class="nav-link">+ Create new project</a>
			</div>					
		</nav>
		<table class="table table-striped table-hover mb-5">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projectList}" var="project">
					<c:if test="${!user.getProjects().contains(project) && !user.getOwnedProjects().contains(project)}">
						<tr>
                                <td><a href="/projects/view/${project.id}"><c:out value="${project.title}"/></a></td>
                                <td><c:out value="${project.lead.firstName}"/></td>
                                <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
                                <td>
                                    <a href="/projects/addmember/${project.id}">Join Team</a>
                                </td>
                            </tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<hr />
		<h4 class="card-header">Your Projects</h4>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projectList}" var="project">
					<c:if test="${user.getOwnedProjects().contains(project) || user.getProjects().contains(project)}">
						<tr>
                                <td><a href="/projects/view/${project.id}"><c:out value="${project.title}"/></a></td>
                                <td><c:out value="${project.lead.firstName}"/></td>
                                <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${project.lead.id == userId}">
                                            <a href="/projects/delete/${project.id}">Delete</a> |
                                            <a href="/projects/edit/${project.id}">Edit</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/projects/removemember/${project.id}">Leave Team</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>