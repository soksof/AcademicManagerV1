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
			<th>CV</th>
			<th>Field</th>
		</tr>

		<c:forEach items="${teacherActiveList}" var="teacher">
			<tr>
				<td><a target="_blank"
					href="person?action=view&personID=${teacher.getPersonID()}">${teacher.getName()}
						${teacher.getSurname()}</a></td>
				<td>${teacher.getCv()}</td>
				<td>${teacher.getField()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>