<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
		.spa{
			color:red;
		}

</style>
</head>
<body bgcolor="grey">


				<!-- CONTROL + ESPACIO PARA IMPORTAR -->


				<h1>APLICACION DE GESTION DE EMPLEADOS</h1>
				
				
				<h3>MENSAJE : <span class="spa">${mensaje}</span></h3>	
				

				<p><a href="/empleados/altaForm">NUEVO EMPLEADO</a></p> 


				<table border="2">
				
						<tr>
									<th>IdEmpleado</th><th>NombreEmpleado</th><th>Salario</th><th>IdDepart</th><th>NombreDepart</th><th>EDITAR</th><th>ELIMINAR</th><th>CANCELAR</th>							
						</tr>
						
						<!-- DEVUELVE LA LISTA --> 
						<c:forEach var="ele" items="${listaEmpleados}">
						<tr>
						
								<td>${ele.idEmpleado}</td>
								<td>${ele.nombre}</td>
								<td>${ele.salario}</td>
								<td>${ele.departamento.idDepart}</td>
								<td>${ele.departamento.nombre}</td>
								
								<td><a href="/empleados/editar/${ele.idEmpleado}">EDITAR EMPLEADO</a></td>
								<td><a href="/empleados/eliminar/${ele.idEmpleado}">ELIMINAR EMPLEADO</a></td>
								<td><a href="/empleados/cancelar/${ele.idEmpleado}">CANCELAR EMPLEADO</a></td>
						</tr>
						
						
						</c:forEach>
				</table>
				

</body>
</html>