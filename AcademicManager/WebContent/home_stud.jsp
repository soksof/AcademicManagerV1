<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Student's Homepage</title>
</head>
<body>
<div id="pagewrap">

	<header>
	<div id="header-left">
		<h1>Hello Student</h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as student</h4>
			<button type="button">Log Out</button>
	</div>
	</header>
		
	<aside id="left">
	<!-- Side Menu accordion -->
<nav id="menu_box">
  <ul class="menu">
    <li> <a href="home_stud.jsp">Home</a></li>
    <li> <a href="">Courses</a>
      <ul>
        <li><a href="enroll.jsp">Enroll</a></li>
		<li><a href="coursehistory.jsp">History</a></li>
		<li><a href="grades.jsp">Grades</a></li>
      </ul>
    </li>
    <li> <a href="evaluationSt.jsp">Evaluation</a>
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

	</section>

<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>
