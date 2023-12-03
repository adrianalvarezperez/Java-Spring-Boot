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



	<form action="/cuenta/realizarExtraccion" method="post">
		
		<input type="number" name="cantidad" placeholder="Introduce una cantidad a extraer: ">
		
		<input type="submit" value="Enviar">
		
	</form>
	
	
	<h1>MENSAJE: ${mensaje}</h1>
	<a href="/inicio">volver inicio</a>


</body>
</html>