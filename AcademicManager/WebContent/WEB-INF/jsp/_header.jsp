<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>AcademicManager</title>
</head>
<body>
 
 <c:set var="person" value='${sessionScope["person"]}'/>
	<div id="header-left">
		<h1>Hello <c:out value="${person.getName()}" /> </h1>
	</div>
	<div id="header-right">	
	<h4>Logged in as <c:out value="${person.getUsername()}" /></h4>
			<button  onclick="location.href='index.html'" type="button">Log Out</button>
	</div>

</body>
</html>