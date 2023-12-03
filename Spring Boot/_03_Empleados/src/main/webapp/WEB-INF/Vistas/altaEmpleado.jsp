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




				<h1>FORMULARIO DE ALTA DE EMPLEADO</h1>
				
				
				
				
				<form action="/empleados/alta" method="post">
				
								
						<p><input type="text" name="nombre">NOMBRE</p>
						<p><input type="text" name="salario">SALARIO</p>
				
						
						<p><input type="submit" value="Enviar"></p>
				
				</form>



</body>
</html>