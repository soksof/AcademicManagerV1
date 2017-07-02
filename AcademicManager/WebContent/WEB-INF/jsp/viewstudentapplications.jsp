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
			<th>Course Title</th>
			<th>Application Date</th>
		</tr>

		<c:forEach items="${applicantStudent}" var="applicantStudent">
			<tr>
				<td><a target="_blank"
					href="person?action=view&personID=${applicantStudent[0].getPersonID()}">${applicantStudent[0].getName()}
						${applicantStudent[0].getSurname()}</a></td>
				<td>${applicantStudent[1]}</td>
				<td>${applicantStudent[2]}</td>
				<td>${applicantStudent[0].getApplicationDate()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>