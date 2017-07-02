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
			<th>Evaluation</th>
			<th>Assignment Grades</th>
			<th>Final Grades</th>
		</tr>

		<c:forEach items="${studentEvaluation}" var="studentEvaluation">
			<tr>
				<td><a target="_blank"
					href="person?action=view&personID=${studentEvaluation[0].getPersonID()}">${studentEvaluation[0].getName()}
						${studentEvaluation[0].getSurname()}</a></td>
				<td>${studentEvaluation[2]}</td>
				<td>${studentEvaluation[1]}</td>
				<td>${studentEvaluation[0].getEvaluation()}</td>
				<td>${studentEvaluation[3]}</td>
				<td>${studentEvaluation[0].getFinalGrade()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>