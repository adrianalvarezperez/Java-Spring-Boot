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
		
		<p>Descripcion : ${evento.descripcion}</p>
		<p>Precio : ${evento.precio}€</p>
		<p>Nombre : ${evento.nombre}</p>
		<p>Estado : ${evento.estado}</p>
		<p>Destacado : ${evento.destacado}</p>

	
	
	
	
		<p><a href="/inicio">Volver inicio</a></p>
		
	
	
</body>
</html>