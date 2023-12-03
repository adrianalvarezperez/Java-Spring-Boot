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
		.spa2{
			color:red;
			font-weight:bold;
		}
		.spa3{
			margin-left:40%;
			margin-top: 150px;
		}
		.cen1{
			text-align:center;
			margin-left:66%;
			font-size: 20px;
		}.lin{
			display:flex;
		}
		.lin2{
			width:40%;
		}
		.nav4{
			margin-left:150px;
			margin-top:50px;
			background-color:red;
			text-decoration:none;
			padding-top:5px;
		}
		.cuen{
			margin-left:35%;
			margin-top:50px;
			background-color:green;
			text-decoration:none;
			padding-top:5px;
		}
</style>
</head>
<body>




<div class="lin">
		<h1 class="lin2">BIENVENIDO AL CAJERO VIRTUAL</h1>
		<a href="/cuenta/numeroCuenta" class="cuen">IDENTIFICATE</a>
		<a class="nav4" href="/cuenta/cerrarSesion">SALIR</a>
	</div><br><br>
	
	<h1 class="cen1">BIENVENIDO USUARIO: <span class="spa">${cuentaSesion.idCuenta}</span></h1>	
  
	
	
	
	<a href="/cuenta/ingresarCantidad">-INGRESAR DINERO A LA CUENTA</a><br><br>
	<a href="/cuenta/extraerCantidad">-EXTRAER DINERO DE LA CUENTA</a><br><br>
	<a href="/cuenta/movimientos">-VER MOVIMIENTOS</a><br><br>
	<a href="/cuenta/transferenciaDestino">-TRANSFERENCIA</a><br><br><br><br>
	
	
	
	<h1 class="spa3">MENSAJES: <span class="spa2">${mensaje}</span></h1>	

</body>
</html>