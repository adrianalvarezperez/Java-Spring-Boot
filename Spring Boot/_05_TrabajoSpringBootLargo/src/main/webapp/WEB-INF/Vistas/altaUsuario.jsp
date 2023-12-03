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



	<form action="/clientes/login" method="post">
		<%String mensaje = (String)request.getAttribute("mensaje"); %>
        	<% if (mensaje != null){ %>
        		<h1 style="color:red;">${mensaje}</h1>
        	<% } %>
	
		<p><input type="text" name="username">Usuario</p>
		<p><input type="password" name="password">Contraseña</p>
		
		<p><input type="submit" value="Enviar"></p>
		
	
	</form>
	
	

</body>
</html>