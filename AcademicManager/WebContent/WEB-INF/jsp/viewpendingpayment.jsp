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
			<th>Discount</th>
		</tr>

		<c:forEach items="${pendingPayment}" var="pendingPayment">
			<tr>
				<td>${pendingPayment[1]}</td>
				<td>${pendingPayment[2]}</td>
				<td>${pendingPayment[4]}</td>
				<td>${pendingPayment[3]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>