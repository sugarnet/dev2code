<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer Registration Form</title>
		
		<style type="text/css">
			.error {
				color: red;
			}
		</style>
	</head>
	<body>
	
		<i>Fill out the form. Asterisk (*) means required.</i>
		<br><br>
		<form:form action="processForm" modelAttribute="customer">
			First name: <form:input path="firstName"/>
			<br><br>
			Last name (*): <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"></form:errors>
			<br><br>
			Free passes: <form:input path="freePasses"/>
			<form:errors path="freePasses" cssClass="error"></form:errors>
			<br><br>
			Postal code: <form:input path="postalCode"/>
			<form:errors path="postalCode" cssClass="error"></form:errors>
			<br><br>
			Course code: <form:input path="courseCode"/>
			<form:errors path="courseCode" cssClass="error"></form:errors>
			<br><br>
			
			<input type="submit" value="Submit" />
		</form:form>
	
	</body>
</html>