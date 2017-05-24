<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>AcademicManager</title>
<title>Insert title here</title>
</head>
<body>
	<c:set var="person" value='${sessionScope["person"]}'/>
	<h3>Personal Information</h3>
	<p>
		Student: <c:out value="${person.getName()}"/>
		<c:out value="${person.getSurname()}"/>
		<br>
		StudentID: <c:out value="${person.getPersonID()}"/>
		<br>
		Email: <c:out value="${person.getEmail()}"/>
		<br>
		Phone: <c:out value="${person.getPhone()}"/>
		<br>
		Date of Birth: <c:out value="${person.getDob()}" />
		<br>
		TaxNumber: <c:out value="${person.getTaxNumber()}"/>
		<br>
		IBAN: <c:out value="${person.getIban()}"/>
		<br>
		Address: <c:out value="${person.getAddress()}"/>
		<br>
		Sex: <c:out value="${person.getSex()}"/>
	</p>
</body>
</html>