<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/tracker.css" />">

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
	  <label for="password">New password:</label>
	  <input type="password" name="newpassword" value=""><br>
	  <input name="insert" type="submit" value="SUBMIT"/>
	</form>
	
	<c:if test = "${checkPswOk != null}">
    	<b>${checkPswOk}</b></br>  	
	</c:if>
	
	
	<c:if test = "${checkPswKo != null}">
    	<b>${checkPswKo}</b></br>
	</c:if>
	
	
	<br><a class="btn btn-primary" role="button" href="./homeUser">HOME</a>
</body>
</html>