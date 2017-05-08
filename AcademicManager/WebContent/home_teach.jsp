<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Teacher's Home</title>
</head>

<c:set var="person" value='${sessionScope["person"]}' />
<body>

	<div id="pagewrap">

		<header>
		<div id="header-left">
			<h1>
				Hello,
				<c:out value="${person.getName()}" />
			</h1>
		</div>
		<div id="header-right">
			<h4>
				Logged in as
				<c:out value="${person.getUsername()}" />
			</h4>
			<button class="button_logout" type="button">Log Out</button>
		</div>
		</header>

		<aside id="left"> <!-- Side Menu accordion --> <nav
			id="menu_box">
		<ul class="menu">
			<li><a href="home_teach.jsp">Home</a></li>
			<li><a href="coursesT.jsp">Courses</a>
				<ul>
					<li><a href="apply.jsp">Apply</a></li>
					<li><a href="">Course History</a></li>
				</ul>
				</li>
			<li><a href="">Reports</a>
				<ul>
					<li><a href="">Students List For Each Course</a></li>
					<li><a href="">Student Grades For Past Courses</a></li>
				</ul></li>
			<li><a href="">Student Evaluation</a></li>
			<li><a href="">Messages</a>
			<li><a href="">Account Settings</a>
			</li>
		</ul>
		</nav> </aside>

		<section id="middle"> <!--Αρχική σελίδα του καθηγητή-->
		<h3>Personal Information</h3>
		<p>
			Student:
			<c:out value="${person.getName()}" />
			<c:out value="${person.getSurname()}" />
			<br> StudentID:
			<c:out value="${person.getPersonID()}" />
			<br> Email:
			<c:out value="${person.getEmail()}" />
			<br> Phone:
			<c:out value="${person.getPhone()}" />
			<br> Date of Birth:
			<c:out value="${person.getDob()}" />
			<br> TaxNumber:
			<c:out value="${person.getTaxNumber()}" />
			<br> IBAN:
			<c:out value="${person.getIban()}" />
			<br> Address:
			<c:out value="${person.getAddress()}" />
			<br> Sex:
			<c:out value="${person.getSex()}" />
		</p>
		</section>



		<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
		</footer>

	</div>

</body>
</html>