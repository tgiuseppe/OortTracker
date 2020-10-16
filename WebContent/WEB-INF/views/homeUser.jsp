<%@ page import="it.beije.oort.bean.User"%>
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
	
<%
User userBean = (User)session.getAttribute("userBean");

if (userBean == null) {
%>
	<b>Sorry: access not allowed.</b></br><b>You must sign in.</b></br>
	<a href="./signIn" >signIn</a>
<%
} else {
%>
<%-- 	<h1>Benvenuto <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>
 --%>		
		<p style="text-align:side;"><a href="./settings">Settings</a></p> <p style="text-align:right;"><a href="./home">Logout</a></p>
		
		
		
<%
}
%>

</body>
</html>