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




	<form action="/cuenta/cuent" method="post">
	
		<p><input type="text" name="idCuenta" size="50" placeholder="Introduce su numero de cuenta: "></p>
		
		<p><input type="submit" value="Entrar"></p>
		
	</form>
	
	<p><a href="/inicio">Volver inicio</a></p><br><br>
	
	
	<h1>MENSAJES: <span class="spa">${mensaje}</span></h1>	<br><br>
	
	
	

</body>
</html>