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
			<th>CourseID</th>
			<th>Title</th>
			<th>Name</th>
			<th>Timetable</th>
		</tr>

		<c:forEach items="${courseStudents}" var="courseStudents">
			<tr>
				
				<td>${courseStudents[1]}</td>
				<td>${courseStudents[2]}</td>
				<td><a target="_blank"
					href="person?action=view&personID=${courseStudents[4]}">${courseStudents[0].getName()}
						${courseStudents[0].getSurname()}</a></td>
				<td>${courseStudents[3]}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
