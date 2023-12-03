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



	<form action="/clientes/login" method="post">
			
        <h1 class="cen">MENSAJES : <span class="spa">${mensaje}</span></h1>	<br><br>
	
		<p><input type="text" name="username">Usuario</p>
		<p><input type="password" name="password">Contraseña</p>
		
		<p><input type="submit" value="Enviar"></p>
		
	
	</form>
	
	

</body>
</html>