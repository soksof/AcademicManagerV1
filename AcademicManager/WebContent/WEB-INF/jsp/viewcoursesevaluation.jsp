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
			<th>Evaluation</th>
			<th>Evaluation Date</th>
		</tr>

		<c:forEach items="${CoursesEvaluations}" var="coursesEvaluations">
			<tr>
			    <td>${coursesEvaluations[0].getCourseID()}</td>
			    <td>${coursesEvaluations[0].getTitle()}</td>
				<td><a target="_blank"
					href="person?action=view&personID=${coursesEvaluations[3]}">${coursesEvaluations[1]}
						${coursesEvaluations[2]}</a></td>
				<td>${coursesEvaluations[0].getEvaluation()}</td>
				<td>${coursesEvaluations[0].getEvaluationDate()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>