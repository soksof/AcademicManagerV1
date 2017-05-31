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
	<script src="http://code.jquery.com/jquery-2.1.0.min.js">
	</script>
	<script>
	/*$(function(){
		$('a').click(function(){
			alert("asdasdasdasd");
			window.open($(this).attr('href'),'_blank');
			//document.getElementById('middle').load($(this).attr('href'));
			//$('#middle').load($(this).attr('href'));
		});
	});*/
	</script>
	<script>
	function test(){
		$('#middle').load($(this).attr('href'));
	}
	</script>
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
    <li> <a href="ViewPerson">Home</a></li>
    <li> <a id="linkdisabled" href="#">Courses</a>
      <ul>
        <li><a href="addcourseS.jsp">Add Course</a></li>
		<li><a href="courseEvalS.jsp">Courses' Evaluation</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Teachers</a>
      <ul>
        <li><a href="ApplicantTeachers">View Applicants</a></li>
		<li><a href="teach_c_applS.jsp">Teacher Course Applicants</a></li>
        <li><a href="course_teacherS.jsp">Course Teachers</a></li>
		<li><a href="teacherEvalS.jsp">Teachers' Evaluation</a></li>
		<li><a href="updateTeachS.jsp">Update Profile</a></li>
      </ul>
    </li>
    <li> <a id="linkdisabled" href="#">Students</a> 
		<ul>
			<li><a href="paymentS.jsp">Payments</a></li>
			<li><a href="studentEvalS.jsp">Students' Evaluation</a></li>
		</ul>
	 </li>
	</ul> 
</nav>
	
	</aside>
	
	<div id="middle">
	<!--User profile-->
	<jsp:include page="viewprofile.jsp"></jsp:include>
	</div>
	
	<footer>
		<jsp:include page="_footer.jsp"></jsp:include>
	</footer>

</div>

</body>
</html>