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
			<th>Payment</th>
		</tr>

		<c:forEach items="${paymentStudent}" var="paymentStudent">
			<tr>
				<td><a target="_blank"
					href="person?action=view&personID=${paymentStudent[0].getPersonID()}">${paymentStudent[0].getName()}
						${paymentStudent[0].getSurname()}</a></td>
				<td>${paymentStudent[1]}</td>
				<td>${paymentStudent[2]}</td>
				<td>${paymentStudent[0].getPayment()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>