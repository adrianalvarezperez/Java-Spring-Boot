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
			color:red;
			font-weight:bold;
		}

</style>
</head>
<body>
			
		<form action="/cuenta/extraccion" method="post">
			<input type="number" name="cantidad"  placeholder="Introduce una cantidad a sacar:">
		
			<input type="submit" value="Enviar">
		</form>
		
		
		<h1>MENSAJES: <span class="spa">${mensaje}</span></h1>	<br><br>
		
		<p><a href="/inicio">Volver inicio</a></p>
</body>
</html>