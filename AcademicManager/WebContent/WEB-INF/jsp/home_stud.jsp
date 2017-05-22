<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="gr.haec.academic.model.Person" %>
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
		<h1>Hello <c:out value="${person.getName()}" /> </h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as <c:out value="${person.getUsername()}" /></h4>
			<button  onclick="location.href='index.html'" type="button">Log Out</button>
	</div>
	</header>
		
	<aside id="left">
	<!-- Side Menu accordion -->
<nav id="menu_box">
 <ul class="menu">
    <li> <a href="home_stud.jsp">Home</a></li>
    <li> <a href="#">Courses</a>
      <ul>
        <li><a href="">Reports</a></li>
		<li><a href="">History</a></li>
		<li><a href="">Evaluation</a></li>
		<li><a href="">Registration</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Payments</a>
      <ul>
        <li><a href="">Pending</a></li>
		<li><a href="">History</a></li>
      </ul>
    </li>
    <li><a href="">Messages</a> </li>
	<li><a href="">Account Settings</a></li>
</ul> 
</nav>
	
	</aside>
	
	<section id="middle">
	<!--Αρχική σελίδα του φοιτητή-->
	<h3>Personal Information</h3>
	<p>
		Student: <c:out value="${person.getName()}"/>
		<c:out value="${person.getSurname()}"/>
		<br>
		StudentID: <c:out value="${person.getPersonID()}"/>
		<br>
		Email: <c:out value="${person.getEmail()}"/>
		<br>
		Phone: <c:out value="${person.getPhone()}"/>
		<br>
		Date of Birth: <c:out value="${person.getDob()}" />
		<br>
		TaxNumber: <c:out value="${person.getTaxNumber()}"/>
		<br>
		IBAN: <c:out value="${person.getIban()}"/>
		<br>
		Address: <c:out value="${person.getAddress()}"/>
		<br>
		Sex: <c:out value="${person.getSex()}"/>
	</p>
	</section>


	
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>