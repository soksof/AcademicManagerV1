<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>AcademicManager</title>
</head>
<body>
	<c:set var="person" value='${requestScope.personq}' />
	<h3>Editing</h3>
	<p>
	<form action="person" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input id="input1" type="text" name="name"
					value="${person.getName()}" required></td>
			</tr>
			<tr>
				<td>personID</td>
				<td><input id="input1" type="hidden" name="personid"
					value="${person.personID()}" required></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><input id="input1" type="text" name="surname"
					value="${person.getSurname()}" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="input1" type="text" name="email"
					value="${person.getEmail()}" required></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input id="input1" type="text" name="phone"
					value="${person.getPhone()}" required></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input id="input1" type="date" name="dob"
					value="${person.getDob()}" required></td>
			<tr>
				<td>Tax Number</td>
				<td><input id="input1" type="text" name="taxnumber"
					value="${person.getTaxNumber()}" required></td>
			</tr>
			<tr>
				<td>IBAN</td>
				<td><input id="input1" type="text" name="iban"
					value="${person.getIban()}" required></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input id="input1" type="text" name="address"
					value="${person.getAddress()}" required></td>
			</tr>
			<tr>
				<td>Sex</td>
				<!-- Load sex enum values -->
				<c:set var="sexValues"
					value="<%=gr.haec.academic.model.Sex.values()%>" />
				<td><select>
						<c:forEach var="val" items="${sexValues}">

							<c:choose>
								<c:when test="${person.getSex()==val}">
									<option selected>${val}</option>
								</c:when>
								<c:otherwise>
									<option>${val}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input id="submitbutton" type="submit" value="Update"></td>
				<td><input id="submitbutton" type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>