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


	<form action="/proyectos/login" method="post">
		<input type="text" name="idEmpl"> Usuario<br><br>
		<input type="password" name="password"> Contraseña<br><br>
		
		<input type="submit" value="Enviar"><br><br><br><br>
	</form>
	
	
<!-- ................................................................ -->	
	
	
	<a href="/inicio">Volver inicio</a><br><br>
	
	
	<h1 class="cen">MENSAJES : <span class="spa">${mensaje}</span></h1>	<br><br>
	
	
	

</body>
</html>