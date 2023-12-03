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




				<h1>FORMULARIO DE ALTA DE PRODUCTO</h1>
				
				
				
				
				<form action="/productos/alta" method="post">
				
						
						<p><input type="text" name="descripcion">Descripcion</p>			<!-- LOS NAME SE LLAMAN IGUAL QUE EN "PROC_ALTA_EMPLEADO" -->
						<p><input type="text" name="precioUnitario">Precio</p>
						<p><input type="text" name="fechaAlta">Fecha</p>
						
						
						<p><input type="text" name="familia.descripcion">descripcionFamilia</p>
				
					
					
						<p><input type="submit" value="Enviar"></p>
					
					
						
						
				
				</form>
				
			
				
						
					
				
						
						
						
				
	
				
				
				
				



</body>
</html>