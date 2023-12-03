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



		<h1>Detalle del evento</h1>	
		
		
		<p>Nombre : ${evento.nombre}</p>
		<p>Descripcion : ${evento.descripcion}</p>
		<p>Precio : ${evento.precio}€</p>
		<p>Precio unitario : ${evento.mostrarPrecioUnitario()}€</p>
		<p>Estado : ${evento.estado}</p>
		<p>Destacado : ${evento.destacado}</p>
		<p>Duracion : ${evento.duracion}</p>
		<p>Aforo Maximo : ${evento.aforoMaximo}</p>
		<p>Minimo Asistencia : ${evento.minimoAsistencia}</p>
		
	
		 <p>Entradas disponibles: ${aforo_restante}</p>
   		 <%String mensaje = (String)request.getAttribute("mensaje"); %>
    	 <% if (mensaje != null){ %>
    	 <h1 style="color:red;">${mensaje}</h1>
   		 <% } %>
    
		<form action="/clientes/reservar/${evento.idEvento}" method="post">
	 		<p><span>Cantidad de personas:</span><input name="cantidad" type="number" min="1" max="10"></p>
			<p><input type="submit" value="Reservar"></p>
		</form>
	
	
		<p><a href="/inicio">Volver inicio</a></p>
		
	
	
</body>
</html>