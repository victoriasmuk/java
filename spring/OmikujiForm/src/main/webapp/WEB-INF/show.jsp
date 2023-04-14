<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji Form</title>
</head>
<body>

	<div class="container text-center">
		<h1>Here's Your Omikuji!</h1>
		<div class="card mx-auto w-50" style="background-color:aliceblue" >			
				In <c:out value="${number}"/> years, 
				you will live in <c:out value="${city}"/> 
				with <c:out value="${name}"/> as your roommate, 
				<c:out value="${career}"/> for a living. 
				The next time you see a <c:out value="${thing}"/>, 
				you will have good luck. 
				Also, <c:out value="${message}"/>."
		</div>
		<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>