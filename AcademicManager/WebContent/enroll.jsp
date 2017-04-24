<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style_stud.css">
<title>AcademicManager</title>
</head>
<body>
<div id="pagewrap">

	<header>
	<div id="header-left">
		<h1>Hello, <c:out value="${person.getName()}"/> </h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as <c:out value="${person.getUsername()}"/></h4>
			<button class="button_logout" type="button">Log Out</button>
	</div>
	</header>
		
	<aside id="left">
	<!-- Side Menu accordion -->
		<nav id="menu_box">
		  <ul class="menu">
		    <li> <a href="home_stud.jsp">Home</a></li>
		    <li> <a id="linkdisabled" href="#">Courses</a>
		      <ul>
		        <li><a href="enroll.jsp">Enroll</a></li>
				<li><a href="coursehistory.jsp">History</a></li>
				<li><a href="grades.jsp">Grades</a></li>
		      </ul>
		    </li>
		    <li> <a id="linkdisabled" href="#">Evaluation</a>
		      <ul>
		        <li><a href="courseEvalSt.jsp">Course Evaluation</a></li>
				<li><a href="teacherEvalSt.jsp">Teacher Evaluation</a></li>
		      </ul>
		    </li>
		    <li><a href="paymentSt.jsp">Payments</a></li>
		  </ul> 
		</nav>
	
	</aside>

<section id="middle">
	<!--Εμφανίζονται τα μαθήματα στα οποία μπορεί να εγγραφεί ο φοιτητής, 
	τσεκάρει και κάνει submit-->
		<h3>Courses available for enrollment</h3>
			<!-- no check for prerequisite courses - assumption that student can enroll to any course that is ready to start -->
		<sql:query var="cEnroll" dataSource="jdbc/AcademicManagerDB">
			SELECT courseID, title 
				FROM course
			WHERE status='readyToStart';
		</sql:query>
		<form >  
			<c:forEach var="cEn" items="${cEnroll.rows}">
				<input type="checkbox" name="Course" value="Course"><c:out value="${cEn.courseID}"/> <c:out value="${cEn.title}"/><br>
			</c:forEach>
			<br>
			<input class="submit_button" type="button" value="Enroll" >
		</form> 
	</section>


	
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>