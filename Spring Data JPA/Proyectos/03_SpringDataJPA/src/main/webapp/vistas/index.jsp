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
	
	<h3>MENSAJE: ${mensaje}</h3>
	
	<a href="/alta">DAR DE ALTA</a><br><br><br>
	
					
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
	
	
	
	
	<form action="/porFamilia" method="post">
		<input type="number" name="idFamilia" placeholder="Id_Familia/Id_Producto">
		<input type="submit" value="enviar">
	
	</form>
	
	
	<table border="2">
	<caption>  <th>ID_PRODUCTO</th> <th>DESCRIPCION</th> <th>ID_FAMILIA</th> <th>PRECIO</th> </caption>
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${fam3}">
	<tr>
		<td>${ele.idProducto}</td>
		<td>${ele.descripcion}</td>
		<td>${ele.familia.idFamilia}</td>
		<td>${ele.precioUnitario}</td>
	
	</tr>
	</c:forEach>
	</table><br><br><br><br>
	
	
	
	
	<table border="2">
	<caption>  <th>ID_PRODUCTO</th> <th>DESCRIPCION</th> <th>ID_FAMILIA</th> <th>PRECIO</th> </caption>
	<tr>
		<td>${fam4.idProducto}</td>
		<td>${fam4.descripcion}</td>
		<td>${fam4.familia.idFamilia}</td>
		<td>${fam4.precioUnitario}</td>

	</tr>
	</table><br><br><br><br>
	
	
	<a href="/inicio">volver inicio</a>
	

</body>
</html>