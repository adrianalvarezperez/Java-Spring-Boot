<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>PRUEBAS "SPRING_DATA_JPA"</h1>
	
					
	<table border="2">
	<caption>  <th>DESCRIPCION</th> <th>ID</th> </caption>
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${fam}">
	<tr>
		
		<td>${ele.descripcion}</td>
		<td>${ele.idFamilia}</td>
	
	</tr>
	</c:forEach>
	</table><br><br><br><br>
	
	
	
	
	<table border="2">
	<caption>  <th>DESCRIPCION</th> <th>ID</th> </caption>
	<tr>
		
		<td>${fam2.descripcion}</td>
		<td>${fam2.idFamilia}</td>

	</tr>
	</table><br><br><br><br>
	
	

</body>
</html>