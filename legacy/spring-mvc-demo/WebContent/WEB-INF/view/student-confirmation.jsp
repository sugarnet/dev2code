<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student confirmation</title>
	</head>
	<body>

		The student confirmed: ${ student.firstName } ${ student.lastName }
		<br><br>
		Country: ${ student.country }
		<br><br>
		Favorite Language: ${ student.favoriteLanguage }
		<br><br>
		Operating Systems:
		<ul>
			<c:forEach var="op" items="${ student.operatingSystems }" >
				<li> ${ op } </li>
			</c:forEach>
			
		</ul>
	
	</body>
</html>