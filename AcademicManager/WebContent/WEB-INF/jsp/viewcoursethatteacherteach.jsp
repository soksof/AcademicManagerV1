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
		<th>CourseID</th>
		<th>Title</th>
		<th>Course Core</th>
		<th>Start Date</th>
		<th>End Date</th>
	</tr>
	
	<c:forEach items="${teacherCoursesList}" var="teachList">
	<tr>
		<td>${teachList[2]}</td>
		<td>${teachList[1]}</td>
		<td>${teachList[3]}</td>
		<td>${teachList[4]}</td>
		<td>${teachList[5]}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>