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
			<th>Assignment Grades</th>
			<th>Final Grade</th>
		</tr>

		<c:forEach items="${studentGrades}" var="studentGrades">
			<tr>
			<td>${studentGrades[1]}</td>
			<td>${studentGrades[2]}</td>	
			<td><a target="_blank"
					href="person?action=view&personID=${studentGrades[4]}">${studentGrades[0].getName()}
						${studentGrades[0].getSurname()}</a></td>
			<td>${studentGrades[3]}</td>
			<td>${studentGrades[0].getFinalGrade()}</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>