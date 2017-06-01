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
	<c:set var="course" value='${requestScope.courseq}'/>
	<table>
		<tr>
			<th>CourseId</th>
			<th>Title</th>
			<th>startDate</th>
			<th>endDate</th>
			<th>status</th>
			<th>totalHours</th>
			<th>timetable</th>
			<th>Description</th>
			<th>Syllabus</th>
			<th>prereqCoreCourse</th>
			<th>Cost</th>
			<th>discount</th>
			<th>classroom</th>
			<th>maxStudents</th>
			<th>minStudents</th>
			<th>credits</th>
			<th>idCourseCore</th>
			<th>courseCore</th>
			<th>field</th>
		</tr>
		<tr>
			<td><c:out value="${course.getCourseId()}"/></td>
			<td><c:out value="${course.getTitle()}"/></td>
			<td><c:out value="${course.getStartDate()}"/></td>
			<td><c:out value="${course.getEndDate()}"/></td>
			<td><c:out value="${course.getStatus()}"/></td>
			<td><c:out value="${course.geTotalHours()}"/></td>
			<td><c:out value="${course.getTimetable()}"/></td>
			<td><c:out value="${course.getDescription()}"/></td>
			<td><c:out value="${course.getSyllabus()}"/></td>
			<td><c:out value="${course.getPrereqCoreCourse()}"/></td>
			<td><c:out value="${course.getCost()}"/></td>
			<td><c:out value="${course.getDiscount()}"/></td>
			<td><c:out value="${course.getClassroom()}"/></td>
			<td><c:out value="${course.getMaxStudents()}"/></td>
			<td><c:out value="${course.getMinStudents()}"/></td>
			<td><c:out value="${course.getCredits()}"/></td>
			<td><c:out value="${course.getIdCourseCore()}"/></td>
			<td><c:out value="${course.getCourseCore()}"/></td>
			<td><c:out value="${course.getField()}"/></td>
		</tr>
	</table>
</body>
</html>


		