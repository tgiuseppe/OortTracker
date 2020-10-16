<%@ page import="it.beije.oort.bean.User"%>
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


<title>Oort Tracker</title>
</head>
<body>
	
<%
User userBean = (User)session.getAttribute("userBean");

if (userBean == null) {
%>
	<b>Sorry: access not allowed.</b></br><b>You must sign in.</b></br>
	<a href="./signIn" >signIn</a>
<%
} else {
%>
 	<h1 style="text-align:center;"><em>Welcome <%= (userBean.getNickname() != null) ? userBean.getNickname() : "" %> </em></h1>
		
<!-- 		<p style="text-align:side;"><a href="./settings">Settings</a></p> <p style="text-align:right;"><a href="./home">Logout</a></p>
 -->	
 <div style="text-align:center;">	
		<a class="btn btn-primary" href="./settings" role="button">Settings</a></br>
		
		<a class="btn btn-outline-dark" href="./home" role="button">Logout</a>
</div>
		
		
<%
}
%>

</body>
</html>