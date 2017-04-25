<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style_stud.css">
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
		<li><a href="updateTeachS.jsp">Update Profile</a></li>
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
	<!--Εμφανίζονται στην γραμματεία σε πίνακα όλοι οι 
	καθηγητές που έκανα αίτηση για να διδάξουν μάθημα, ο 
τίτλος του μαθήματος, η ημερομηνία αίτησης, σε pop-up το cv
και και γίνεται accepted όταν πατηθεί το κουμπί accept	-->
	<h3>Course Applicant Teachers</h3>
		<form>
		<table>
		 <tr>
			<th>TeacherID</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Course</th>
			<th>Date</th>
			<th>Info</th>
			<th>Accept</th>
		  </tr>
		 <tr>
			<td>5542</td>
			<td>Stella</td>
			<td>Paliou</td>
			<td>Finance I</td>
			<td>9/9/2016</td>
			<td><input type="button" value="CV" onClick="popUp('popup.html')"></td>
			<td><input type="submit" value="accept"></td>
		  </tr>
		</table>
	<form>
	</section>

		
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>