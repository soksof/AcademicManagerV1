<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Teacher's Home</title>
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
     <li><a href="home_teach.jsp">Home</a></li>
    <li> <a href="coursesT.jsp">Courses</a>
      <ul>
        <li><a href="apply.jsp">Apply</a></li>
	  </ul>
    </li>
    <li> <a href="assignmentsT.jsp">Assignments</a>
      <ul>
        <li><a href="new_assignmentT.jsp">Create</a></li>
      </ul>
    </li>
    <li><a href="">Register Grades</a>
	<ul>
        <li><a href="studCourseGrT.jsp">Student Course-Grades</a></li>
		<li><a href="assignmentGrT.jsp">Assignment Grades</a></li>
    </ul>
	</li>
		<li><a href="studT.jsp">Students</a>
		<ul>
			<li><a href="studGrT.jsp">Grades</a></li>
		</ul>
		</li>	
	<li><a href="profile.jsp">My Profile</a>
	<ul>
			<li><a href="update.jsp">Update</a></li>
		</ul>
	</li>
  </ul> 
</nav>
	
	</aside>
	
	<section id="middle">
	<!--Ο καθηγητής αρχικά από τα μαθήματά του επιλέγει ένα μάθημα και 
	εμφανίζονται σε dropdown οι εργασίες που έχει αναθέσει.
	Εμφανίζονται οι φοιτητές και εισάγει βαθμολογία από 0-10.
	Υποβάλλει μαζικά με submit button-->
		<form>
		<table>
			<tr><td>
				<select>
					<option value="Course 1">Course 1</option>
					<option value="Course 2">Course 2</option>
					<option value="Course 3">Course 3</option>
					<option value="Course 4">Course 4</option>
				</select>
			</td>
			<td>
				<select>
					<option value="Assignment 1">Assignment 1</option>
					<option value="Assignment 2">Assignment 2</option>
					<option value="Assignment 3">Assignment 3</option>
					<option value="Assignment 4">Assignment 4</option>
				</select>
			</td>
			<td>
				<input id="submitbutton1"type="submit" value="Submit">
			</td></tr>
		</table>
		</form>
		</form>
		<table>
		<tr>
			<th>AssignmentID</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Grades</th>
		</tr>
		<tr>
			<td>456</td>
			<td>Kon/na</td>
			<td>Pappa</td>
			<td><input type="number" name="grades" min="0" max="10"></td>
		</tr>
	</table>
	<input id="submitbutton1"type="submit" value="Submit">

	</form>

	
	</section>

	
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>