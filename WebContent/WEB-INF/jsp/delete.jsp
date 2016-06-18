<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book Delete</title>
</head>
<body>
	<h1>Address Book</h1>
	<h2>Delete Entry</h2>
	<form action="deleteentry" method="post">
		ID: <input type="text" name="id">
		<input type="submit">	
	</form>

	<h2>Current Entries</h2>
	<table border="1">
		<tr><th>Entry ID</th><th>First Name</th><th>Last Name</th><th>Address 1</th><th>Address 2</th><th>Town</th><th>City</th><th>Zip</th><th>Phone Number</th><th>Email</th></tr>
		<c:forEach var="address" items="${addresses}">
			<tr>
				<td><c:out value="${address.idAddress}"></c:out></td>
				<td><c:out value="${address.firstName}"></c:out></td>
				<td><c:out value="${address.lastName}"></c:out></td>
				<td><c:out value="${address.address.address1}"></c:out></td>
				<td><c:out value="${address.address.address2}"></c:out></td>
				<td><c:out value="${address.address.town}"></c:out></td>
				<td><c:out value="${address.address.city}"></c:out></td>
				<td><c:out value="${address.zip}"></c:out></td>
				<td><c:out value="${address.phoneNumber}"></c:out></td>
				<td><c:out value="${address.email}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>