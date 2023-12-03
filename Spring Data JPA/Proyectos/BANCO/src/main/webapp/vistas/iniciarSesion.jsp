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




			<form action="/cuenta/abrir" method="post">
					
				<input type="text" name="idCuenta" placeholder="Introduce su numero de cuenta">
				<input type="submit" value="enviar">	
					
			</form><br><br>
					
					
					
			<h1>MENSAJES: ${mensaje}</h1>
			<a href="/inicio">volver al inicio</a>
			
			

</body>
</html>