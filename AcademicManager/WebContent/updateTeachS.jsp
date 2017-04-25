<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>Hello <c:out value="${person.getName()}" /></h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as <c:out value="${person.getUsername()}" /></h4>
		<input id="submitbutton1" type="submit" value="Log Out">
	</div>
	</header>
		
	<aside id="left">
	<!-- Side Menu accordion -->
<nav id="menu_box">
  <ul class="menu">
    <li><a href="home_secr.jsp">Home</a></li>
    <li><a id="linkdisabled" href="#">Courses</a>
      <ul>
        <li><a href="addcourseS.jsp">Add Course</a></li>
		<li><a href="courseEvalS.jsp">Courses' Evaluation</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Teachers</a>
      <ul>
        <li><a href="applicantS.jsp">Applicants</a></li>
		<li><a href="teach_c_applS.jsp">Teacher Course Applicants</a></li>
        <li><a href="course_teacherS.jsp">Course Teachers</a></li>
		<li><a href="teacherEvalS.jsp">Teachers' Evaluation</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">Students</a> 
		<ul>
			<li><a href="paymentS.jsp">Payments</a></li>
			<li><a href="studentEvalS.jsp">Students' Evaluation</a></li>
		</ul>
	 </li>
	</ul> 
</nav>
	
	</aside>
	
	<section id="middle">
	<!--H Γραμματεία βρίσκει έναν συγκεκριμένο καθηγητή.
	Εμφανίζεται το προφίλ του καθηγητή με
	τα σταθερά του στοιχεία ως κείμενο, τα 
	υπόλοιπα μέσα σε πεδία ώστε να μπορεί να τα αλλάξει 
	και κάνει update-->
	<form>
	<h3>Choose a Teacher to update his/her profile</h3>
	<table>
        <tr>
            <td>TeacherID</td> 
			<td><select><option>1231</option></select></td>
		</tr>
		<tr>
            <td>First Name</td>
		</tr>
		<tr>
            <td>Last Name</td>
		</tr>
		<tr>
            <td>E-mail</td>
			<td><input id="input1" type="email" name="email"  maxlength="60" required></td>
		</tr>
		<tr>
            <td>Phone Number</td>
			<td><input id="input1" type="text" name="phone"  maxlength="45" required></td>
		</tr>
		<tr>
            <td>Home Address</td>
			<td><input id="input1" type="text" name="address"  maxlength="100" required></td>
		</tr>
		<tr>
            <td>Date of Birth</td>
		</tr>
		<tr>
            <td>Username</td>
			<td><input id="input1" type="text" name="username"  maxlength="45" required></td>
		</tr>
		<tr>
            <td>Password</td>
			<td><input id="input1" type="password" name="password"  maxlength="45" required></td>
		</tr>
		<tr>
            <td>Tax Number</td>
		</tr>
		<tr>
            <td>IBAN</td>
			<td><input id="input1" type="text" name="iban"  maxlength="45" required></td>
		</tr>
		<tr>
            <td>Gender</td>
		<tr>
			<td colspan="2" ><textarea id="input1" rows="4" cols="30">CV</textarea></td>
		
		</table>	
		
		<input id="submitbutton"type="submit" value="Update">
	</form>
	</section>
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>