<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<h1>Hello, <c:out value="${person.getName()}" /></h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as <c:out value="${person.getUsername()}" /></h4>
			<form value="Log Out" action="LogoutServlet" method="post">  
				<input id="logout_button" type="submit" value="Log Out">
			</form>
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
		Date of Birth: <fmt:formatDate value="${person.getDob()}" pattern="dd-MM-yyyy"/>
		<br>
		TaxNumber: <c:out value="${person.getTaxNumber()}"/>
		<br>
		IBAN: <c:out value="${person.getIban()}"/>
		<br>
		Address: <c:out value="${person.getAddress()}"/>
		<br>
		Sex: <c:out value="${person.getSex()}"/>
	</p>
	
	<%-- ΕΜΦΑΝΙΣΗ ΤΩΝ ΜΗΝΥΜΑΤΩΝ
	<c:set var="person" value='${sessionScope["person"]}'/>
	<sql:query var="box" dataSource="jdbc/AcademicManagerDB">
		select * from inbox where inbox.to=${person.getPersonID()};        
	</sql:query>
	<p>MESSAGES<hr>
	<c:forEach var="in" items="${box.rows}">
		Title: <c:out value="${in.title}" /><br>
		From: <c:out value="${in.from}" /> 
		Date: <c:out value="${in.date}"/>
		<br>
		Message: <c:out value="${in.message}" /><br><br>
	</c:forEach>
	</p>
	--%>
	
	
</section>
<footer>
	<h4>Contact us</h4>
	<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
</footer>

</div>

</body>
</html>
