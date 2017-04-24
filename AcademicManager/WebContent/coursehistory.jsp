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
	<!--Ο φοιτητής βλέπει όλα τα μαθήματα του και βαθμό-->
		<h3> My Course History</h3>
		<table class="table1">
		<sql:query var="courseh" dataSource="jdbc/AcademicManagerDB">
		SELECT courseID,title,startDate,endDate,finalGrade,status,field,credits from course NATURAL JOIN coursestudent  WHERE studentid="${person.getPersonID()}";
		</sql:query>	
			<tr class="tr1">
				<th class="th1">ID</th>
				<th class="th1">Course</th>
				<th class="th1">StartDate</th>
				<th class="th1">EndDate</th>
				<th class="th1">Grade</th>
				<th class="th1">Status</th>
				<th class="th1">Field</th>
				<th class="th1">Credits</th>
			</tr>
		
				<c:forEach var="ch" items="${courseh.rows}" >
			<tr class="tr1">
				<td class="td1"><c:out value="${ch.courseID}" /></td>
				<td class="td1"><c:out value="${ch.title}" /></td>
				<td class="td1"><fmt:formatDate value="${ch.startDate}" pattern="dd-MM-yyyy"/></td>
				<td class="td1"><fmt:formatDate value="${ch.endDate}" pattern="dd-MM-yyyy"/></td>
				<td class="td1"><c:out value="${ch.finalGrade}"/></td>
				<td class="td1"><c:out value="${ch.status}"/></td>
				<td class="td1"><c:out value="${ch.field}"/></td>
				<td class="td1"><c:out value="${ch.credits}"/></td>
			</tr>
			</c:forEach>
		</table>
	
	</section>
		
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>

