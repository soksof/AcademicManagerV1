<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>AcademicManager</title>
</head>
<body>
 <c:set var="person" value='${sessionScope["person"]}'/>
<div id="pagewrap">

	<header>
	<div id="header-left">
		<h1>Hello <c:out value="${person.getName()}" /></h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as <c:out value="${person.getUsername()}" /></h4>
		<button type="button">Log Out</button>
	</div>
	</header>
		
	<aside id="left">
	<!-- Side Menu accordion -->
<nav id="menu_box">
  <ul class="menu">
    <li><a href="home_secr.jsp">Home</a></li>
    <li><a id="linkdisabled" href="#">Courses</a>
      <ul>
        <li><a href="addcourseS.jsp">Add Course</a></li>
		<li><a href="courseEvalS.jsp">Courses' Evaluation</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Teachers</a>
      <ul>
        <li><a href="applicantS.jsp">Applicants</a></li>
		<li><a href="teach_c_applS.jsp">Teacher Course Applicants</a></li>
        <li><a href="course_teacherS.jsp">Course Teachers</a></li>
		<li><a href="teacherEvalS.jsp">Teachers' Evaluation</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Students</a> 
		<ul>
			<li><a href="paymentS.jsp">Payments</a></li>
			<li><a href="studentEvalS.jsp">Students' Evaluation</a></li>
		</ul>
	 </li>
	</ul> 
</nav>
	
	</aside>
	
	<section id="middle">
	<!--Η γραμματεία προθέτει μάθημα συμπληρώντας 
	σε φόρμα όλα τα στοιχεία του μαθήματος-->
	<h3>Add a new course by filling in all required information</h3>
	<form method="post">
	<table>
	<tr>
	<td colspan="2"><input id="input1" type="text" name="title" placeholder="Course Title" size="62" maxlength="60" required></td>
	</tr>
	<tr>
	<td> <input id="input1" type="date" name="startDate" placeholder="Start Date" required></td>
	<td> <input id="input1" type="date" name="startDate" placeholder="End Date" required></td>
	</tr>
	<tr>
	<td><input id="input1" type="text" name="classroom" placeholder="Classroom" required></td>
	<td><input id="input1" type="text" name="timetable" placeholder="Timetable" maxlength="45" required></td>
	</tr>
	<tr>
	<td colspan="2"><textarea id="input1" rows="4" cols="30">Description</textarea></td>
	</tr>
	<tr>
	<td colspan="2" ><textarea id="input1" rows="4" cols="30">Syllabus</textarea></td>
	</tr>
	<tr>
	<td><id="input1" input type="text" name="field" placeholder="Field" maxlength="45" required></td>
	<td><id="input1" input type="number" name="credits" placeholder="Credits" min="1"  required></td>
	</tr>
	<tr>
	<td colspan="2">
	Prerequisite Courses
	<select>
		<option value="Course 1">Course 1</option>
		<option value="Course 2">Course 2</option>
		<option value="Course 3">Course 3</option>
		<option value="Course 4">Course 4</option>
	</select>
	</td>
	</tr>
	<tr>
	<td><input id="input1" type="text" name="cost" placeholder="Cost" required></td>
	<td><input id="input1" type="text" name="discount" placeholder="Discount" required></td>
	</tr>
	<tr>
	<td colspan="2"><input id="input1" type="number" name="hours" placeholder="Total hours" min="1" required></td>
	<tr>
	<td><input id="input1" type="number" name="maxStudents" placeholder="Max Students" min="1" max="20" required></td>
	<td><input id="input1" type="number" name="minStudents" placeholder="Min Students" min="1" required></td>
	</tr>
	<tr>
	<td><input id="submitbutton" type="submit" value="Add"></td>
	<td><input id="submitbutton" type="reset" value="Reset"></td>
	</tr>
	</table>
	</form>
	</section>
	
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>