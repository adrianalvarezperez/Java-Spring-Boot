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
			color:yellow;
		}
		.uno{
			text-align:center;
		}
		body{
			background-color:grey;
		}
		.bar{
			display:inline;
			margin-left:15px;
		}
		.acti{
			font-weight:bold;
			color:red;
		}
		.cen{
			text-align:center;
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
			color:green;
			font-weight:bold;	
		}
	

</style>
</head>
<body>




		<p class="bar"><a href="/inicio">TIPO DE EVENTO</a></p>
		<p class="bar"><a href="">MIS RESERVAS</a></p>
		<p class="bar"><a href="/clientes/loginForm">LOGIN</a></p>
		<p class="bar"><a href="">REGISTRO</a></p>
		<p class="bar"><a href="/clientes/cerrarSesion">SALIR</a></p>
	<%Usuario usu= (Usuario)session.getAttribute("clienteSesion"); %>
       	<% if (usu != null){ %>
       		<p style="color:red;">Bienvenido: ${clienteSesion.username}</p>
       	<% } %>

	
	<h1 class="esti">LISTADO DE EVENTOS ACTIVOS</h1>
	
	<a class="acti" href="/clientes/activos">VER EVENTOS ACTIVOS</a>&nbsp;&nbsp;
	<a href="/inicio">Volver inicio</a><br><br><br>
	
	
	
	<a class="acti" href="/clientes/cancelados">VER EVENTOS CANCELADOS</a>&nbsp;&nbsp;
	<a href="/inicio">Volver inicio</a><br><br><br>
	
	
	
	<a class="dest" href="/clientes/destacados">VER EVENTOS DESTACADOS</a>&nbsp;&nbsp;
	<a href="/inicio">Volver inicio</a><br><br><br>
	
	
	
	<a class="dest" href="/clientes/noDestacados">VER EVENTOS NO DESTACADOS</a>&nbsp;&nbsp;
	<a href="/inicio">Volver inicio</a>
	
	
	<h3>Mensajes : <span class="spa">${mensaje}</span></h3>	
	
	
	<h3><a href="/eventos/altaForm" class="new">NUEVA EVENTO</a></h3>

	

	<table border="2" class="uno">
	
		<caption>  <th>&nbsp;&nbsp;Id&nbsp;&nbsp;</th> <th>&nbsp;Nombre Evento&nbsp;</th> <th>Descripcion</th> <th>Precio</th> <th>&nbsp;&nbsp;Estado&nbsp;&nbsp;</th> <th>&nbsp;Destacado&nbsp;</th> <th>&nbsp;FechaNacimiento&nbsp;</th> <th>EditarEvento</th> <th>EliminarEvento</th> <th>CancelarEvento</th> <th>&nbsp;&nbsp;DetalleEvento&nbsp;&nbsp;</th> <th>&nbsp;&nbsp;CancelarDestacado&nbsp;&nbsp;</th> </caption>
	
	
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
		<td><a href="/eventos/eliminar/${ele.idEvento}">Eliminar Evento</a></td>
		<td><a href="/eventos/cancelar/${ele.idEvento}">Cancelar Evento</a></td>
		<td><a href="/clientes/detalle/${ele.idEvento}">Detalle</a></td>
		<td><a href="/eventos/cancelarDestacado/${ele.idEvento}">Cancelar Evento Destacado</a></td>
		
	</tr>
	
	
	</c:forEach>
	</table>

</body>
</html>