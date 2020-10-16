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

	<c:if test = "${errore != null}">
    	<b>${errore}</b></br>
	</c:if>
	
	<h1 style="text-align:center;"><em>Modify your password</em></h1>
	
	<h3>Enter your old password</h3>
	
	<form action="./modifyPsw" method="POST" >
	  <label for="password">Old password:</label>
	  <input type="password" name="password" value=""><br>
	</form>
	
	<c:if test = "${checkPswOk != null)}">
    	<b>${checkPswOk}</b></br>
    	
    		<form action="./modifyPsw" method="POST" >
			  <label for="password">New password:</label>
			  <input type="password" name="password" value=""><br>
			</form>	
	</c:if>
	
	
	<c:if test = "${checkPswKo != null}">
    	<b>${checkPswKo}</b></br>
	</c:if>
	
	
	<a hfer="./homeUser">HOME</a>
</body>
</html>