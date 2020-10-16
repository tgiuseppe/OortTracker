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

	<h1 style="text-align:center;"><em>Settings</em></h1>
	<h3>Modify your credentials</h3>
	
	<form action="./settings" method="POST">
	  <input type="hidden" id="id" name="id" value="${userBean.id}"/>
	  <label for="nickname">Nickname:</label>
	  <input type="text" id="nickname" name="nickname" value="${userBean.nickname}"><br>
	  <label for="email">E-mail:</label>
	  <input type="email" name="email" value="${userBean.email}"><br>
	   <input name="insert" type="submit" value="SETUP"/>
	   
	 </form>	 
	 
	 	<c:if test = "${checkNickAndMail != null}">
	    	<b>${checkNickAndMail}</b></br>
		</c:if>
	 
	 
	 <a href="./modifyPsw">Password</a>
<!-- 	 <form action="./modifyPsw" method="POST" >
	  <label for="password">Password:</label>
	  <input type="password" name="password" value=""><br>
	 </form>
 -->	  
	
<a hfer="./homeUser">HOME</a>
</body>
</html>