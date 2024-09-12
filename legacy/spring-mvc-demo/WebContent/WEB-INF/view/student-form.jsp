<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student registration form</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName"/>
			<br><br>
			Last Name: <form:input path="lastName"/>
			<br><br>
			
			Country:
			<form:select path="country">
				<form:options items="${ theCountryOptions }" />
			</form:select>
			 
			<%-- form:select path="country">
				<form:options items="${ student.countries }" />
			</form:select --%>
			
			<%--   form:select path="country">
				<form:option value="Brazil" label="Brazil" />
				<form:option value="France" label="France" />
				<form:option value="Germany" label="Germany" />
				<form:option value="Italy" label="Italy" />
			</form:select --%>
			
						
			<br><br>
			
			Favorite Language:
			
			Java <form:radiobutton path="favoriteLanguage" value="Java" />
			PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
			C# <form:radiobutton path="favoriteLanguage" value="C#" />
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

			<br><br>
			
			Operating Systems:
			
			Linux <form:checkbox path="operatingSystems" value="Linux" />
			Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
			Windows <form:checkbox path="operatingSystems" value="Windows" />			
			<br><br>
			
			<input type="submit" value="Submit" />
		</form:form>
	
	</body>
</html>