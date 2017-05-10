<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="gr.haec.academic.model.Person" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="gr.haec.academic.controller.LoginController" %>
<%@ page import="gr.haec.academic.controller.AuthenticateUser" %>

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
    <li> <a href="">MENU.ITEM 1</a></li>
    <li> <a href="">MENU.ITEM 2</a>
      <ul>
        <li><a href="">MENU.ITEM 2.1</a></li>
		<li><a href="">MENU.ITEM 2.2</a></li>
		<li><a href="">MENU.ITEM 2.3</a></li>
      </ul>
    </li>
    <li><a id="linkdisabled" href="#">DISABLED LINK</a></li>
</ul> 
</nav>
	
	</aside>
	
	<section id="middle">
		<!-- MAIN CONTENT -->
		
		<table>
			<tr>
				<th>item1.1</th>
				<th>item1.2</th>
				<th>item1.3</th>
			</tr>
			<tr>
				<td>item2.1</td>
				<td>item2.2</td>
				<td>item2.3</td>
			</tr>
			<tr>
				<td>item3.1</td>
				<td>item3.2</td>
				<td>item3.3</td>
			</tr>	
			<tr>
				<td>item4.1</td>
				<td>item4.2</td>
				<td>item4.3</td>
			</tr>		
		</table>	
		SMALL BUTTON
		<button id="smallbutton">INFO</button><br><br>
		SUBMIT BUTTON
		<button class="submitbutton">SUBMIT</button><br><br>
		LINK THAT LOOKS LIKE A BUTTON
		<a href="http://google.gr" class="button">GOOGLE</a><br><br>
		INPUT
		<input id="input1" type="text" name="username"><br><br>
		<ul id="list_nostyle">
			<li>list1</li>
			<li>list2</li>
			<li>list3</li>
		</ul>
		
	</section>


	
	<footer>
		<h4>Contact us</h4>
		<p>22 Massalias Str. Athens, Greece 106 80, Tel: +30 210 3680950</p>
	</footer>

</div>

</body>
</html>