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
			<th>Course Title</th>
			<th>Cost</th>
		</tr>

		<c:forEach items="${historyPayment}" var="historyPayment">
			<tr>
				<td>${historyPayment[1]}</td>
				<td>${historyPayment[2]}</td>
				<td>${historyPayment[4]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>