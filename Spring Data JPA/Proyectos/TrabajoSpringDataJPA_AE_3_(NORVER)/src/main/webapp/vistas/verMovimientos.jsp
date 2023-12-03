<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

		.spa{
			color:blue;
			font-weight:bold;
		}
		.spa1{
			color:red;
			font-weight:bold;
		}

</style>
</head>
<body>


			<h1>MOVIMIENTOS</h1><hr>
			
			<h3>CUENTA: <span class="spa">${cuentaSesion.idCuenta}</span></h3>
			<h3>SALDO: <span class="spa1">${cuenta.saldo}</span></h3>
				
				
	<table border="2">
	
		<caption> <th>ID_MOVIMIENTOS</th> <th>CANTIDAD</th> <th>FECHA</th> <th>OPERACION</th> </caption>
	
	
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${mov}">
	<tr>
		<td>${ele.idMovimiento}</td>
		<td>${ele.cantidad}</td>
		<td>${ele.fecha}</td>
		<td>${ele.operacion}</td>
	
	</tr>
	
	
	</c:forEach>
	
	</table><br><br><br><br>
	
	
	
	
	<p><a href="/inicio">Volver inicio</a></p>

</body>
</html>