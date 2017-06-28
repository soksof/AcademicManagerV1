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
			<th>Course Core</th>
		</tr>
		<c:forEach items="${coursecoreList}" var="cc">
		<tr>
			<td><a href="javascript:ml('coursecore?action=update&courseID=${cc.getCcID()}')">${cc.getCcCode()} - ${cc.getCcTitle()}</a></td>
		</tr>
		</c:forEach>		
	</table>

</body>

</html>