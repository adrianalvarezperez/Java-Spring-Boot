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
			display:inline;
		}
		
		body{
			background-color:grey;
		}
		.esti2{
			position:absolute;
			left:50.5%;
			
			text-align:center;
			background-color: blue;
			font-weight:bold;
			color:white;
		}
		.esti3{
			text-align:center;
			background-color: blue;
			font-weight:bold;
			color:white;
		}
		.esti4{
			position:absolute;
			left:25px;
		}
		.esti5{
			position:absolute;
			left:70px;
		}
		.esti6{
			position:absolute;
			left:155px;
		}
		
		.esti8{
			position:absolute;
			left:350px;
		}
		.esti9{
			position:absolute;
			left:430px;	
		}
		.bar{
			display:inline;
			margin-left:15px;
		}
		.acti{
			font-weight:bold;
			color:red;
		}
		
	

</style>
</head>
<body>




		<p class="bar"><a href="#">TIPOS</a></p>
		<p class="bar"><a href="#">EVENTOS</a></p>
		<p class="bar"><a href="#">USUARIOS</a></p>
		<p class="bar"><a href="#">EVENTOS/TIPO</a></p>
		<p class="bar"><a href="#">LOGIN</a></p>
		<p class="bar"><a href="#">REGISTRO</a></p>
		<p class="bar"><a href="#">SALIR</a></p>


	
	<h1 class="esti">LISTADO DE EVENTOS ACTIVOS</h1>
	
	<a class="acti" href="/eventos/activos">VER EVENTOS ACTIVOS</a>&nbsp;&nbsp;
	<a href="/inicio">Volver inicio</a><br><br><br>
	
	
	
	<a class="acti" href="/eventos/cancelados">VER EVENTOS CANCELADOS</a>&nbsp;&nbsp;
	<a href="/inicio">Volver inicio</a>
	
	
	<h3>Mensajes : <span class="spa">${mensaje}</span></h3>	
	
	
	<h3><a href="/eventos/altaForm">NUEVO EVENTO</a></h3>

	

	<table border="2" class="uno">
	
		<caption>  <th>Id</th> <th>Nombre</th> <th>Descripcion</th> <th>Precio</th> <th>Estado</th> <th>Destacado</th> <th>Editar</th> <th>Eliminar</th> <th>Cancelar</th> </caption>
	
	
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${listaEventos}">
	<tr>
		
		<td>${ele.idEvento}</td>
		<td>${ele.nombre}</td>
		<td>${ele.descripcion}</td>
		<td>${ele.precio}</td>
		<td>${ele.estado}</td>
		<td>${ele.destacado}</td>
		<td><a href="/eventos/editar/${ele.idEvento}">Editar Evento</a></td>
		<td><a href="/eventos/eliminar/${ele.idEvento}">Eliminar Evento</a></td>
		<td><a href="/eventos/cancelar/${ele.idEvento}">Cancelar Evento</a></td>
		
	</tr>
	
	
	</c:forEach>
	</table>

</body>
</html>