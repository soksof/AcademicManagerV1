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
	<form action="course" method="post">
		<table>
			<tr>
				<td></td>
				<td><input id="input1" type="hidden" name="courseid" value=""></td>
			</tr>
			<tr>
				<td>Course Core</td>
				<td><input id="input1" type="text" name="courseCore" value=""
					required></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input id="input1" type="text" name="title" value=""
					required></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input id="input1" type="text" name="description" value=""
					required></td>
			</tr>


			<tr>
				<td><input id="submitbutton" type="submit" value="Save"></td>
				<td><input id="cancelbutton" type="button" value="Cancel"
					onclick="javascript:ml('person?action=profile')"></td>
			</tr>
		</table>

	</form>
</body>

</html>