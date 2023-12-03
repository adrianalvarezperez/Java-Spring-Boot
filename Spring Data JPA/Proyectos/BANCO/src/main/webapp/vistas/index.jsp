<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="grey">


		<div>
			<h1>BANCO CRUCEROS</h1>
			<a href="/cuenta/entrar">IDENTIFICATE</a>
			<a href="/cuenta/cerrar">SALIR</a>
		</div>
		
		
		
		<h1>SU CUENTA ES LA NUMERO: ${cuentaSesion.idCuenta}</h1><br><br>
		<h1>SALDO: ${cuentaSesion.saldo}</h1>

		
		<h1>Mensaje: ${mensaje}</h1><br><br>
		
		
		<a href="/cuenta/ingreso">INGRESO</a><br><br>
		
		<a href="/cuenta/extraccion">EXTRAER</a><br><br>
		
		<a href="/cuenta/transferencia">TRANFERENCIA</a><br><br>
		
		
		<a href="/inicio">volver inicio</a><br><br>
		
		
		
		
	<table border="2">
	
	<caption>  <th>ID_MOVIMIENTO</th> <th>ID_CUENTA</th> <th>CANTIDAD</th> <th>FECHA</th> <th>OPERACION</th> <th>SALDO</th> </caption>
	
	
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${movimientosSesion}">
	<tr>
		<td>${ele.idMovimiento}</td>
		<td>${ele.cuenta.idCuenta}</td>
		<td>${ele.cantidad}</td>
		<td>${ele.fecha}</td>
		<td>${ele.operacion}</td>
		<td>${ele.cuenta.saldo}</td>
	
	</tr>
	
	
	</c:forEach>
	
	</table><br><br><br><br>

</body>
</html>