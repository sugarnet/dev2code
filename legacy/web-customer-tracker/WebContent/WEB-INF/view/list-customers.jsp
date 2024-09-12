<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/bootstrap-min-4.4.1.css" />
</head>
<body>
	<div class="container">
		<br>
		<h1>List Customers</h1>
		<hr>
		<br>
		<!-- TODO: Implement search! -->
		<form class="form-inline">
			
		  	<div class="form-group mb-2">
		    	<label>Search</label>
		 	</div>
		  	<div class="form-group mx-sm-3 mb-2">
		    	<input type="text" class="form-control" placeholder="Last Name/First Name">
		  	</div>
		  	<button class="btn btn-primary mb-2">Search</button>
		  	<div class="text-right">
			  	<button type="button" class="btn btn-success mb-2 ml-5 text-right"
					onclick="window.location.href='formAddCustomer'; return false;">
					Add customer
				</button>
		  	</div>
			
		</form>
		<br>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${ customers }">

					<c:url var="updateLink" value="/customer/showFormUpdate">
						<c:param name="customerId" value="${ customer.id }"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${ customer.id }"></c:param>
					</c:url>

					<tr>
						<td>${ customer.firstName }</td>
						<td>${ customer.lastName }</td>
						<td>${ customer.email }</td>
						<td>
							<a href="${ updateLink }" class="btn btn-primary">Edit</a>
							<a href="${ deleteLink }" class="btn btn-danger"
								onclick="if(!confirm('Are you sure you want to delete this customer?')) return false;">
								Delete
							</a>
						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


</body>
</html>