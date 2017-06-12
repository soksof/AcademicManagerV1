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
			<th>Grades</th>
			<th>Evaluation</th>
		</tr>

		<c:forEach items="${StudentActiveCourses}" var="studentActive">
			<tr>
			<td>${studentActive[0].getCourseID()}</td>
			<td>${studentActive[2]}</td>	
			<td>${studentActive[1]}</td>	
			<td>${studentActive[0].getFinalGrade()}</td>	
			<td><a target="_blank" href="StudentEvaluations?personID=${studentActive[0].getPersonID()}">Evaluation</a></td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>