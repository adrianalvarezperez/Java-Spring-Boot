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


		<p>Id_Empleado: ${empleado.idEmpl}</p>
		<p>Apellidos: ${empleado.apellidos}</p>
		<p>Correo: ${empleado.correo}</p>
		<p>FechaIngreso: ${empleado.fechaIngreso}</p>
		<p>Nombre_Departamento: ${empleado.departamento.nombre}</p>
		<p>Id_Perfil: ${empleado.perfile.idPerfil}</p>
		<p>Id_Depar: ${empleado.departamento.idDepar}</p>
		
	
	
	
		<h1 class="cen">MENSAJES : <span class="spa">${mensaje}</span></h1>	<br><br>
		
	
	
	    <p><a href="/inicio">Volver inicio</a></p><br><br>
	
	
	
	

</body>
</html>