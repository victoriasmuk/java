<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Counter</title>
</head>
<body>

<div class="container">
	<p>Counter: <c:out value="${count}"/></p>
	<p>
		<a href="clear">Reset the counter</a>
	</p>
	<p>
		<a href="/">Go back home</a>
	</p>
	
</div>

</body>
</html>