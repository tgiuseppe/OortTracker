<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oort Tracker</title>
</head>
<body>

	<h1 style="text-align:center;"><em>Sign up</em></h1>
	<h3>Enter your credentials</h3>
	
	<form action="./signUp" method="POST">
	
	  <label for="nickname">Nickname:</label>
	  <input type="text" id="nickname" name="nickname" value=""><br>
	  <label for="email">E-mail:</label>
	  <input type="email" name="email" value=""><br>
	  <label for="password">Password:</label>
	  <input type="password" name="password" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	  
	</form>	

</body>
</html>