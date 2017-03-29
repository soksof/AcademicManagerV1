<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<sql:query var="listPeople" dataSource="jdbc/AcademicManagerDB">
	select personID, name, surname from person;    
</sql:query>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th> PersonID </th>
			<th> Name </th>
			<th> Surname </th>
		</tr>
		
		<c:forEach var="p" items="${listPeople.rows} ">
			<tr>
				<td><c:out value="${p.personID}" /></td>
				<td><c:out value="${p.name}" /></td>
				<td><c:out value="${p.surname}" /></td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>