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
			<th>Students ID</th>
			<th>Evaluation</th>
		</tr>

		<c:forEach items="${teacherEvaluation}" var="teacherEvaluation">
			<tr>
			    <td>${teacherEvaluation[3]}</td>
			    <td>${teacherEvaluation[2]}</td>
				<td><a target="_blank"
					href="person?action=view&personID=${teacherEvaluation[0].getPersonID()}">${teacherEvaluation[0].getName()}
						${teacherEvaluation[0].getSurname()}</a></td>
				<td>${teacherEvaluation[1]}</td>
				<td>${teacherEvaluation[0].getEvaluationTeacher()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>