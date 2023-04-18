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
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Dashboard</title>
</head>
<body style="font-family: optima, sans-serif;">
<div class="card">
	<div class="card-header">
            <h1>Login and Registration</h1>
            <div style="display: flex;">
                <h5 class="navbar-text" style="padding-right: 20px;"> Welcome, <c:out value="${userName}"/> </h5>
                <a href="/" class="navbar-text" style="padding-right: 20px;">Home</a>
                <a href="/logout" class="navbar-text">Logout</a>
            </div>
    </div>
    <div class="card" style="padding-top: 30px;">
        <div class="card-body">
            <div class="container-md">
                <div class="row justify-content-center">
                    <nav style="padding: 0;">
                        <h4>Welcome, <c:out value="${userName}"/> </h4>
                    </nav>
                    <h4>This is your dashboard. Nothing to see here yet.</h4>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>