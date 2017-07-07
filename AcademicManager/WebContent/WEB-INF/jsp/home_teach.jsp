<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Teacher's Home</title>
</head>

<body>

	<div id="pagewrap">

		<header>
			<jsp:include page="_header.jsp"></jsp:include>
		</header>

		<aside id="left"> <!-- Side Menu accordion --> <nav
			id="menu_box">
		<ul class="menu">
			<li><a href="javascript:ml('person?action=profile')">Home</a></li>
			<li><a href="coursesT.jsp">Courses</a>
				<ul>
					<li><a href="">Apply</a></li>
					<li><a href="javascript:ml('teacher?action=courseThatTeacherTeaches')">Course History</a></li>
				</ul></li>
			<li><a href="">Reports</a>
				<ul>
					<li><a href="javascript:ml('student?action=courseStudents')">Students List For Each Course</a></li>
					<li><a href="">Student Grades For Past Courses</a></li>
				</ul></li>
			<li><a href="">Student Evaluation</a></li>
			<li><a href="javascript:ml('person?action=edit&personID=${person.getPersonID()}')">Update Profile</a></li>
		</ul>
		</nav> </aside>

		<section id="middle"> 
		<!--Αρχική σελίδα του καθηγητή-->
        <jsp:include page="viewprofile.jsp"></jsp:include>
		</section>

		<footer>
			<jsp:include page="_footer.jsp"></jsp:include>
		</footer>

	</div>

</body>
</html>