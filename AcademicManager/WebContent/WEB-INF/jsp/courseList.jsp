<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="gr.haec.academic.model.Person" %>
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
			<th>Title</th>
			<th>Description</th>
			<th>Credits</th>
		</tr>
		<c:forEach items="${courseList}" var="course">
		<tr>
			<td>${course.getTitle()}</td>
			<td>${course.getDescription()}</td>
		    <td>${course.getCredits()}</td>
		</tr>
		</c:forEach>		
			
	</table>

</body>

</html>