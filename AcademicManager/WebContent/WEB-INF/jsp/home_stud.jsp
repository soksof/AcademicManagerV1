<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="gr.haec.academic.model.Person" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>AcademicManager</title>
</head>
<body>
 
<div id="pagewrap">

	<header>
		<jsp:include page="_header.jsp"></jsp:include>
	</header>
		
	<aside id="left">
	<!-- Side Menu accordion -->
<nav id="menu_box">
 <ul class="menu">
    <li> <a href="javascript:ml('person?action=profile')">Home</a></li>
    <li> <a href="#">Courses</a>
      <ul>
        <li><a href="javascript:ml('student?action=activeCourses')">Active Courses</a></li>
		<li><a href="javascript:ml('student?action=pastCourses')">Past Courses</a></li>
		<li><a href="">Register New</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Payments</a>
      <ul>
        <li><a href="javascript:ml('student?action=pendingPayments')">Pending</a></li>
		<li><a href="javascript:ml('student?action=historyPayments')">History</a></li>
      </ul>
    </li>
    <li><a href="">Messages</a> </li>
	<li><a href="javascript:ml('person?action=edit&personID=${person.getPersonID()}')">Update Profile</a></li>
</ul> 
</nav>
	
	</aside>
	
	<section id="middle">
	<!--Αρχική σελίδα του φοιτητή-->
    <jsp:include page="viewprofile.jsp"></jsp:include>
	</section>

	<footer>
		<jsp:include page="_footer.jsp"></jsp:include>
	</footer>

</div>

</body>
</html>