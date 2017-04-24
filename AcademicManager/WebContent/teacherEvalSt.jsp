<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!--O φοιτητής επιλέγει τους καθηγητές του 
	και γράφει αξιολόγηση σε textarea. Υποβάλλει 
	πατώντας κουμπί-->
	<h3>Choose a teacher to submit evaluation</h3>
	
		<sql:query var="teacherlist" dataSource="jdbc/AcademicManagerDB">
			SELECT p.name, p.surname, cs.courseID, c.title FROM person p
				JOIN courseteacher ct
					ON p.personID = ct.teacherID
				JOIN  coursestudent cs
					ON ct.courseID=cs.courseID
				JOIN course c
					ON c.courseID=ct.courseID
			WHERE cs.studentid=${person.getPersonID()};
		</sql:query>
	<form>	
	<select>
		<c:forEach var="tl" items="${teacherlist.rows}" >
			<option><c:out value="${tl.name}"/> <c:out value="${tl.surname}"/> - <c:out value="${tl.courseID}"/> <c:out value="${tl.title}"/></option>
		</c:forEach>
	</select>
	<br><br>
	<textarea id="input1" rows="4" cols="30">Write your evaluation...</textarea>
	<input class="submit_button" type="submit" value="Save">
	</form>
	</section>
		
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>