<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<th>Surname</th>
		<th>title</th>
	</tr>
	
	<c:forEach items="${teacherCoursesList}" var="teachList">
	<tr>
		<td>${teachList.getName()}</td>
		<td>${teachList.getSurname()}</td>
		<td>${teachList.getTitle()}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>