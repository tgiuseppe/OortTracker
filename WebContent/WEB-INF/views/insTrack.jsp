<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/tracker.css" />">

<title>Insert track</title>
</head>
<body>

<h1 class="text-center">Insert a new track</h1>

<form class="text-center border border-light p-5" action="./addtrack" method="POST">

	<label>Mode</label>
    <select name="idMode" class="browser-default custom-select mb-4">
        <option value="" disabled>Choose option</option>
        <c:forEach var="mode" items="${ modeList }">
        	<option value="${ mode.id }">${ mode.type }</option>
        </c:forEach>
    </select>

    <label>Start Address</label>
    <input type="text" id="startAddress" name="startAddress" class="form-control mb-4" placeholder="Start address">
    
    <label>End Address</label>
    <input type="text" id="endAddress" name="endAddress" class="form-control mb-4" placeholder="End address">
    
    <label>Start Time</label>
    <input type="datetime-local" id="startDatetime" name="startDatetime" class="form-control mb-4">
    
    <label>End Time</label>
    <input type="datetime-local" id="endDatetime" name="endDatetime" class="form-control mb-4">

    <!-- Send button -->
    <button class="btn btn-dark btn-block" type="submit">Send</button>

</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>