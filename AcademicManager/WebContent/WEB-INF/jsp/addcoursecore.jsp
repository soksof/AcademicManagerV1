<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="gr.haec.academic.model.Person"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>AcademicManager</title>
</head>

<body>
	<c:set var="course" value='${requestScope.courseq}' />
	<form action="coursecore" method="post">
		<table>
			<tr>
				<td></td>
				<td><input id="input1" type="hidden" name="idcourseCore" value=""></td>
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
				<td>Field</td>
				<!-- Load field enum values -->
				<c:set var="fieldValues"
					value="<%=gr.haec.academic.model.Field.values()%>" />
				<td><select name="field">
						<c:forEach var="val" items="${fieldValues}">
							<option>${val}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input id="submitbutton" type="submit" value="Save"></td>
				<td><input id="submitbutton" type="reset" value="Cancel"></td>
			</tr>
		</table>

	</form>
</body>

</html>