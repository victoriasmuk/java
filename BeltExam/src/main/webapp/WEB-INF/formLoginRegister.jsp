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
<title>Joy Bundler Names</title>
</head>
<body style="font-family: optima, sans-serif;">
	<div class="container">
        <h1 class="card-header">Joy Bundler Names</h1>
        <div class="card-body">
        	<div class="container">
        		<div class="row">
        		<!-- LOGIN BOX -->
        			<div class="col-sm-5 col-md-6">
        				<h3 class="card-header">Login</h3>
        				<form:form action="/login" method="POST" modelAttribute="loginUser">
        					<div class="form-floating mb-3">
        						<form:input class="form-control" type="text" path="email" />
        						<form:label path="email">Email</form:label>
        						<form:errors path="email" style="color: brown;" />
        					</div>
        					<div class="form-floating mb-3">
        						<form:input class="form-control" type="password" path="password" />
        						<form:label path="password">Password</form:label>
        						<form:errors path="password" style="color: brown;" />
        					</div>
        					<div class="card-body">
        						<button type='submit' class="btn btn-outline-dark">Login</button>
        					</div>
        				</form:form>
        			</div>
        			<!-- REGISTER BOX -->
                	<div class="col-sm-5 offset-sm-2 col-md-6 offset-md-0">
                    	<h3 class="card-header">Register</h3>
                    	<form:form action="/register" method="POST" modelAttribute="newUser">
                    		<div class="form-floating mb-3">
                    			<form:input class="form-control" type="text" path="firstName" />
                    			<form:label path="firstName">First Name</form:label>
                    			<form:errors path="firstName" style="color: brown;" />
                    		</div>
                    		<div class="form-floating mb-3">
                    			<form:input class="form-control" type="text" path="lastName" />
                    			<form:label path="lastName">Last Name</form:label>
                    			<form:errors path="lastName" style="color: brown;" />
                    		</div>
                    		<div class="form-floating mb-3">
								<form:input class="form-control" type="text" path="email" />
                    			<form:label path="email">Email</form:label>
								<form:errors path="email" style="color: brown;" />
                    		</div>
                    		<div class="form-floating mb-3">
								<form:input class="form-control" type="password" path="password" />
                    			<form:label path="password">Password</form:label>
								<form:errors path="password" style="color: brown;" />
                    		</div>
                    		<div class="form-floating mb-3">
								<form:input class="form-control" type="password" path="confirmPassword" />
	                    		<form:label path="confirmPassword">Confirm Password</form:label>
								<form:errors path="confirmPassword" style="color: brown;" />
                    		</div>
                    		<div class="card-body">
                            	<button type='submit' class="btn btn-outline-dark">Register</button>
                        	</div>      
                    	</form:form>
                    </div>
        		</div>
        	</div>
        </div>
      </div>
</body>
</html>