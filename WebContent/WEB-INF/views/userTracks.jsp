<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Tracks</title>
</head>
<body>

<h1 class="text-center">Your tracks</h1>

<div class="container border border-dark">
	<div class="row bg-dark text-light font-weight-bold">
		<div class="col">
			Mode
		</div>
		<div class="col">
			Start address
		</div>
		<div class="col">
			End address
		</div>
		<div class="col">
			Start time
		</div>
		<div class="col">
			End time
		</div>
	</div>
	<c:forEach var="track" items="${ trackList }">
		<div class="row bg-light text-dark">
		<div class="col">
			${ modeMap[track.idMode].type }
		</div>
		<div class="col">
			${ track.startAddress }
		</div>
		<div class="col">
			${ track.endAddress }
		</div>
		<div class="col">
			<fmt:formatDate value="${ track.startDatetime }" pattern="yyyy-MM-dd HH:mm"/>
		</div>
		<div class="col">
			<fmt:formatDate value="${ track.endDatetime }" pattern="yyyy-MM-dd HH:mm"/>
		</div>
	</div>
	</c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>