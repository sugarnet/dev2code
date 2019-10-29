<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer confirmation</title>
	</head>
	<body>
		The customer is confirmed: ${ customer.firstName } ${ customer.lastName }
		<br><br>
		Free passes: ${ customer.freePasses }
		<br><br>
		Postal code: ${ customer.postalCode }	
		<br><br>
		Course code: ${ customer.courseCode }	
			
	</body>
</html>