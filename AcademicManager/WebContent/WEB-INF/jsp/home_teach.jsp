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
			<li><a href="home_teach.jsp">Home</a></li>
			<li><a href="coursesT.jsp">Courses</a>
				<ul>
					<li><a href="apply.jsp">Apply</a></li>
					<li><a href="">Course History</a></li>
				</ul></li>
			<li><a href="">Reports</a>
				<ul>
					<li><a href="">Students List For Each Course</a></li>
					<li><a href="">Student Grades For Past Courses</a></li>
				</ul></li>
			<li><a href="">Student Evaluation</a></li>
			<li><a href="">Messages</a>
			<li><a href="">Account Settings</a></li>
		</ul>
		</nav> </aside>

		<section id="middle"> 
		<!--Αρχική σελίδα του καθηγητή-->
        <jsp:include page="viewperson.jsp"></jsp:include>
		</section>

		<footer>
			<jsp:include page="_footer.jsp"></jsp:include>
		</footer>

	</div>

</body>
</html>