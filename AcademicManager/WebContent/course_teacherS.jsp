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
<sql:query var="info" dataSource="jdbc/AcademicManagerDB">
select * from teacher 
inner join person on person.personID=teacher.teacherID
inner join courseteacher on teacher.teacherID=courseteacher.teacherID
inner join course on courseteacher.courseID=course.courseID 
inner join coursecore on coursecore.idcourseCore=course.idCourseCore
where teacher.status="Course Teacher" and person.role="teacher";    
 </sql:query>
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
	<!--Εμφανίζονται όλοι οι καθηγητές που διδάσκουν, 
	το μάθημά τους, ημερομηνίες και status μαθήματος-->
	<h3>All Course Teachers</h3>
		<table>
		  <tr>
		  <c:forEach var="inf" items="${info.rows}" >
			<br>
			TeacherID:<c:out value="${inf.teacherID}"/>
			<br>
			Name:<c:out value="${inf.name}" />
			<br>
			Surname:<c:out value="${inf.surname}" />
			<br>
			Tilte:<c:out value="${inf.title}" />
			<br>
			Start Date:<c:out value="${inf.startDate}" />
			<br>
			End Date:<c:out value="${inf.endDate}" />
			<br>
			Status:<c:out value="${inf.status}" />
			<br>
			</c:forEach>
		  </tr>
		
		</table>
	</section>
	
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>