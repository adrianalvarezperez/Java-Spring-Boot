<%@page import="eventos.modelo.beans.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


		.esti{
			color:navy;
			text-align:center;
		}
		.uno{
			text-align:center;
			color:white;
			margin-left:3%;
			
		}
		body{
			background-color:black;
		}
		.nav1:link{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:25%;
			padding:5px;
		}
		.nav1:visited{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:25%;
			padding:5px;
		}
		.nav2:link{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:40%;
			padding:5px;
		}
		.nav2:visited{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:40%;
			padding:5px;
		}
		.nav3:link{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:60%;
			padding:5px;
		}
		.nav3:visited{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:60%;
			padding:5px;
		}
		.nav4:link{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:70%;
			padding:5px;
		}
		.nav4:visited{
			border:4px solid lime;
			color:white;
			font-weight:bold;
			text-decoration:none;
			position:absolute;
			left:70%;
			padding:5px;
		}
		.acti{
			font-weight:bold;
			color:aqua;
		}
		.cen{
			text-align:center;
			color:red;
		}
		.cen1{
			text-align:center;
			color:red;
			margin-left:80%;
			font-size: 20px;
		}
		.dest{
			font-weight:bold;
			color:blue;
		}
		.spa{
			color:white;
			font-weight:bold;
		}
		.new{
			color:lime;
			font-weight:bold;	
			margin-left:40%;
			font-size:40px;
		}
		.lin{
			text-decoration:none;
		}
		th{
			color:red;
		}
		.vac{
			color:red;
		}
	

</style>
</head>
<body>



		
		<p><a class="nav1" href="/inicio">TIPO DE EVENTO</a></p>
		<p><a class="nav2" href="">MIS RESERVAS</a></p>
		<p><a class="nav3" href="/clientes/loginForm">LOGIN</a></p>
		<p><a class="nav4" href="/clientes/cerrarSesion">SALIR</a></p>

       	<h1 class="cen1">Bienvenido: <span class="spa">${clienteSesion.username}</span></h1>	
       	
       	<p class="spa">Login ----> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Usuario: pepe / Usuario: juan<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;contraseña: "" <span class="vac">*campo vacio</span></p>

	
	<h1 class="esti">LISTADO DE EVENTOS</h1><hr><br><br>
	
	<a class="acti" href="/clientes/activos">VER EVENTOS ACTIVOS</a>&nbsp;&nbsp;
	<a class="lin" href="/inicio">Volver inicio</a><br><br><br>
	 
	
	
	<a class="acti" href="/clientes/cancelados">VER EVENTOS CANCELADOS</a>&nbsp;&nbsp;
	<a class="lin" href="/inicio">Volver inicio</a><br><br>
	
	<h1 class="cen">MENSAJES : <span class="spa">${mensaje}</span></h1>	<br><br>
	
	<a class="dest" href="/clientes/destacados">VER EVENTOS DESTACADOS</a>&nbsp;&nbsp;
	<a class="lin" href="/inicio">Volver inicio</a><br><br><br>
	
	
	
	<a class="dest" href="/clientes/noDestacados">VER EVENTOS NO DESTACADOS</a>&nbsp;&nbsp;
	<a class="lin" href="/inicio">Volver inicio</a>
	
	
	
	<h3><a href="/eventos/altaForm" class="new">CREAR NUEVO EVENTO</a></h3>

	

	<table border="5" class="uno">
	
		<caption>  <th>&nbsp;&nbsp;Id&nbsp;&nbsp;</th> <th>&nbsp;Nombre Evento&nbsp;</th> <th>Descripcion</th> <th>Precio</th> <th>&nbsp;&nbsp;Estado&nbsp;&nbsp;</th> <th>&nbsp;Destacado&nbsp;</th> <th>&nbsp;FechaEvento&nbsp;</th> <th>EditarEvento</th> <th>&nbsp;&nbsp;DetalleEvento&nbsp;&nbsp;</th> <th>EliminarEvento</th> <th>CancelarEvento</th>  <th>&nbsp;&nbsp;CancelarDestacado&nbsp;&nbsp;</th> </caption>
	
	
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${listaEventos}">
	<tr>
		
		<td>${ele.idEvento}</td>
		<td>${ele.nombre}</td>
		<td>${ele.descripcion}</td>
		<td>${ele.precio}€</td>
		<td>${ele.estado}</td>
		<td>${ele.destacado}</td>
		<td>${ele.fechaInicio}</td>
		<td><a href="/eventos/editar/${ele.idEvento}">Editar Evento</a></td>
		<td><a href="/clientes/detalle/${ele.idEvento}">Detalle</a></td>
		<td><a href="/eventos/eliminar/${ele.idEvento}">Eliminar Evento</a></td>
		<td><a href="/eventos/cancelar/${ele.idEvento}">Cancelar Evento</a></td>
		<td><a href="/eventos/cancelarDestacado/${ele.idEvento}">Cancelar Evento Destacado</a></td>
		
	</tr>
	
	
	</c:forEach>
	</table>

</body>
</html>