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

	<div class="container">
		<h1>Send an Omikuji!</h1>
		<form action="/process" method="POST" class="form-control">
			<div class="form-floating mb-3">
				<input type="number" name="number" id="number" min="5" max="25" class="form-control" />
				<label>Pick any number from 5 to 25</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="city" id="city" class="form-control" />
				<label>Enter the name of any city</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="name" id="name" class="form-control" />
				<label>Enter the name of any real person</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="career" id="career" class="form-control" />
				<label>Enter professional endeavor or hobby:</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="thing" id="thing" class="form-control" />
				<label>Enter any type of living thing</label>
			</div>
			<div class="form-floating mb-3">
				<textarea name="message" id="message"  class="form-control"></textarea>
				<label>Say something nice to someone:</label>
			</div>
			<p class="mt-3">Send and show a friend</p>
			<button type="submit" class="btn btn-success">Send</button>
		</form>
	</div>

</body>
</html>