<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer</title>
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/bootstrap-min-4.4.1.css" />
</head>
<body>
	<div class="container">
		<br>
		<h2>Add Customer</h2>
		<hr>
		<form:form modelAttribute="customer" action="saveCustomer"
			method="POST">

			<form:hidden path="id" />
			
			<div class="form-group">
				<label>First name</label>
				<form:input type="text" class="form-control" path="firstName" />
			</div>
			<div class="form-group">
				<label>Last name</label>
				<form:input type="text" class="form-control" path="lastName" />
			</div>
			<div class="form-group">
				<label>Email address</label>
				<form:input type="email" class="form-control" path="email" />
			</div>

			<div>
				<button type="submit" class="btn btn-primary">Save</button>
				<a href="${ pageContext.request.contextPath }/customer/list"
					class="btn btn-danger">Back</a>
			</div>

		</form:form>
	</div>

</body>
</html>