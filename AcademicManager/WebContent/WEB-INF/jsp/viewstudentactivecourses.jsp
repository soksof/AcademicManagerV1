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
			<th>Classroom</th>
			<th>Timetable</th>
		</tr>

		<c:forEach items="${StudentActiveCourses}" var="studentActive">
			<tr>
			<td>${studentActive.getCourseID()}</td>	
			<td>${studentActive.getTitle()}</td>	
			<td>${studentActive.getClassroom()}</td>	
			<td>${studentActive.getTimetable()}</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>