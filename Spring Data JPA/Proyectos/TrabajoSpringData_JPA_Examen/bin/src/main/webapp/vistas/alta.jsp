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


				<h1>FORMULARIO DE ALTA EMPLEADO</h1>
		  <form action="/proyectos/alta" method="post">
        
           	 <input type="text" name="apellidos">Apellidos <br><br>
           	 <input type="text" name="correo">correo<br><br>
           	 <input type="date" name="fechaNacimiento">FechaNacimiento<br><br>
           	 <input type="text" name="nombre">nombre<br><br>
           	 <input type="text" name="password">contraseña<br><br>
           	 <input type="number" name="salario">salario<br><br>
           	 <input type="number" name="idDepar">idDepartamento<br><br>
           	 <input type="number" name="idPerfil">idPerfil<br><br>

             <input type="submit" value="Enviar">

        </form>



		<p><a href="/inicio">Volver inicio</a></p><br><br>
</body>
</html>