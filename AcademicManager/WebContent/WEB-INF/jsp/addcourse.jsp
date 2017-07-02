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
				<td>CourseID</td>
				<td><input id="input1" type="hidden" name="courseid" value=""></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input id="input1" type="text" name="startdate" value=""
					required></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input id="input1" type="text" name="enddate" value=""
					required></td>
			</tr>
			<tr>
				<td>Status</td>
				<!-- Load field enum values -->
				<c:set var="courseStatusValues"
					value="<%=gr.haec.academic.model.CourseStatus.values()%>" />
				<td><select name="courseStatus">
						<c:forEach var="val" items="${courseStatusValues}">
							<option>${val}</option>
						</c:forEach>
				</select></td>
			</tr>
            <tr>
				<td>Total Hours</td>
				<td><input id="input1" type="text" name="totalhours" value=""
					required></td>
			</tr>
			<tr>
				<td>Timetable</td>
				<td><input id="input1" type="text" name="timetable" value=""
					required></td>
			</tr>
			<tr>
				<td>Syllabus</td>
				<td><input id="input1" type="text" name="syllabus" value=""
					required></td>
			</tr>
			<tr>
				<td>Cost</td>
				<td><input id="input1" type="text" name="cost" value=""
					required></td>
			</tr>
			<tr>
				<td>Discount</td>
				<td><input id="input1" type="text" name="discount" value=""
					required></td>
			</tr>
			<tr>
				<td>Classroom</td>
				<td><input id="input1" type="text" name="classroom" value=""
					required></td>
			</tr>
			<tr>
				<td>Max Students</td>
				<td><input id="input1" type="text" name="maxstudent" value=""
					required></td>
			</tr>
			<tr>
				<td>Min Students</td>
				<td><input id="input1" type="text" name="minstudent" value=""
					required></td>
			</tr>
			<tr>
				<td>Credits</td>
				<td><input id="input1" type="text" name="credits" value=""
					required></td>
			</tr>
			<tr>
				<td>Id Course Core</td>
				<td><input id="input1" type="text" name="idcoursecore" value=""
					required></td>
			</tr>

			<tr>
				<td><input id="submitbutton" type="submit" value="Save"></td>
				<td><input id="cancelbutton" type="button" value="Cancel" onclick="javascript:ml('person?action=profile')"></td>
			</tr>
		</table>

	</form>
</body>

</html>