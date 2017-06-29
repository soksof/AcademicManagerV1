<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>AcademicManager</title>

</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>CourseID</th>
			<th>Application Date</th>
		</tr>

		<c:forEach items="${applicantList}" var="applicants">
			<tr>
				<td><a target="_blank"
					href="person?action=view&personID=${applicants[0].getPersonID()}">${applicants[0].getName()}
						${applicants[0].getSurname()}</a></td>
				<td>${applicants[1]}</td>
				<td>${applicants[0].getApplicationDate()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>