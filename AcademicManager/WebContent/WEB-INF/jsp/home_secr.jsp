<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="gr.haec.academic.model.Person"%>
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
					<li><a href="javascript:ml('person?action=profile')">Home</a></li>
					<li><a id="linkdisabled" href="#">Courses</a>
						<ul>
							<li><a href="javascript:ml('course?action=add')">Add Course</a></li>
							<li><a href="javascript:ml('coursecore?action=add')">Add Course Core</a></li>
							<li><a href="javascript:ml('course?action=coursesEvaluation')">Courses' Evaluation</a></li>
						</ul></li>
					<li><a id="linkdisabled" href="#">Teachers</a>
						<ul>
							<li><a href="javascript:ml('teacher?action=listApplicants')">View
									Applicants</a></li>
							<li><a
								href="javascript:ml('teacher?action=courseApplicants')">Course
									Applications</a></li>
							<li><a href="javascript:ml('teacher?action=courseTeachers')">Course
									Teachers</a></li>
							<li><a
								href="javascript:ml('teacher?action=teachActiveCourses')">Active
									Course Teachers</a></li>
							<li><a href="javascript:ml('teacher?action=teachersEvaluation')">Teachers' Evaluation</a></li>
						</ul></li>
					<li><a id="linkdisabled" href="#">Students</a>
						<ul>
							<li><a href="javascript:ml('student?action=studentApllication')">Course
									Applications</a></li>
							<li><a href="javascript:ml('student?action=studentPayments')">Payments</a></li>
							<li><a href="javascript:ml('student?action=allStudentEvaluation')">Students' Evaluation</a></li>
							<li><a href="javascript:ml('student?action=listcoursestudappl')">All Course Applications</a></li>
						</ul></li>
					<li><a
						href="javascript:ml('person?action=edit&personID=${person.getPersonID()}')">Update
							Profile</a></li>
				</ul>
			</nav>

		</aside>

		<section id="middle">
			<!--User profile-->
			<jsp:include page="viewprofile.jsp"></jsp:include>
		</section>

		<footer>
			<jsp:include page="_footer.jsp"></jsp:include>
		</footer>

	</div>

</body>
</html>