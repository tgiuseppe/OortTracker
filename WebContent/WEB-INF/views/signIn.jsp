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

	<h1 style="text-align:center;"><em>Login<em></em></h1>
	<h3>Enter your credentials</h3>
		
		<form action="./signIn" method="POST">
			NICKNAME&nbsp;<input type="text" name="nickname" value="" /><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value="" /><br>
			<input type="submit" value="SIGN IN"/>
		</form>
	


</body>
</html>