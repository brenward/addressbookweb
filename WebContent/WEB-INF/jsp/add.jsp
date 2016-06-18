<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book Add</title>
</head>
<body>
	<h1>Address Book</h1>
	<h2>Add Entry</h2>
	<form action="addentry" method="post">
		<table>
			<tr><td>First Name: </td><td><input type="text" name="fname"></td></tr>
			<tr><td>Last Name: </td><td><input type="text" name="lname"></td></tr>
			<tr><td>Address 1: </td><td><input type="text" name="address1"></td></tr>
			<tr><td>Address 2: </td><td><input type="text" name="address2"></td></tr>
			<tr><td>Town: </td><td><input type="text" name="town"></td></tr>
			<tr><td>City: </td><td><input type="text" name="city"></td></tr>
			<tr><td>Zip: </td><td><input type="text" name="zip"></td></tr>
			<tr><td>Phone: </td><td><input type="text" name="phone"></td></tr>
			<tr><td>Email: </td><td><input type="text" name="email"></td></tr>
		</table>
		<input type="submit">		
	</form>
</body>
</html>