<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		.col{
			color:red;
			
		}
		.verd{
			padding:10px;
			background-color:green;
			color:black;
			border-radius:50px;
			text-decoration:none;
		}
		.azu{
			color:blue;
		}
		.roj{
			color:red;
			display:inline;
		}
		.vio{
			color:grey;
			display:inline;
		}
		.lin{
			display:inline;
			margin-left: 18%;
		}
		.lin2{
			display:inline;
		}
		.lin4{
			text-decoration:none;
		}
		.cerr{
			background-color:red;
			border-radius:50px;
			padding:10px;
			text-decoration:none;
			margin-left:10px;
		}
		.ide{
			text-decoration:none;
			margin-left:10px;
		}
</style>
</head>
<body>



		<h1 class="lin2">BIENVENIDO USUARIO: <span class="col">${sesion.nombre}</span></h1>
		
		
<!-- ................................................................ -->
		
		<div class="lin">
			<a href="/proyectos/identificate" class="ide"> IDENTIFICATE</a>
			<a href="/proyectos/cerrarSesion" class="cerr"> SALIR</a>
  		</div><hr>
  
<!-- ................................................................ -->


		<h1>MENSAJES: <span class="azu">${mensaje}</span></h1><hr><br><br>


<!-- ................................................................ -->
		
		
		<a href="/proyectos/formAlta" class="verd"> DAR ALTA</a><br><br><br><br><br>
			
			
<!-- ................................................................ -->
		
		
		<form action="/proyectos/borrar" method="post">
			<input type="number" name="idEmpl"> <p class="roj"> Dar de baja un id_empleado<p>
			
			<input type="submit" value="Enviar">
		</form><br><br><br><br>
		
		
<!-- ................................................................ -->
		
		
		<form action="/proyectos/modificar" method="post">
            <input type="number" name="idEmpl"><p class="vio"> Modificar el id_empleado...</p><br><br>
            <input type="text" name="apellidos"><p class="vio"> Modificar el apellidos por...</p><br><br>
            
            <input type="submit" value="Enviar">
        </form><br><br><br><hr>
		
		
<!-- ................................................................ -->	
		
		
		<h1>SACA LOS EMPLEADOS DE UN DEPARTAMENTO</h1>
		<table border="5" class="uno">
		<caption> 
				   <th>&nbsp;&nbsp;Id_EMPLEADO&nbsp;&nbsp;</th> 
				   <th>&nbsp;APELLIDO&nbsp;</th> 
				   <th>CORREO</th> 
				   <th>SALARIO</th> 
		</caption>
	
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${listaEmplDepart}">
	<tr>
		<td>${ele.idEmpl}</td>
		<td>${ele.apellidos}</td>
		<td>${ele.correo}</td>
		<td>${ele.salario}€</td>
	</tr>
	</c:forEach>
	</table><br><br><br><br><hr>
	
	
<!-- ................................................................ -->
	
	
	<h1>SACA TODOS LOS EMPLEADOS</h1>
	<table border="5" class="uno">
		<caption>  
		 		   <th>Id_EMPLEADO</th> 
				   <th>APELLIDO</th> 
				   <th>CORREO</th> 
				   <th>SALARIO</th> 
				   <th>VER_DETALLE</th> 
		</caption>
	
	<!-- DEVUELVE LA LISTA --> 
	<c:forEach var="ele" items="${listaEmpl}">
	<tr>
		<td>${ele.idEmpl}</td>
		<td>${ele.apellidos}</td>
		<td>${ele.correo}</td>
		<td>${ele.salario}€</td>
		<td><a href="/proyectos/empleadoDetalle/${ele.idEmpl}" class="lin4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VER</a></td>
	</tr>
	</c:forEach>
	</table><br><br><br><br>


<!-- ................................................................ -->


	<a href="/inicio">Volver inicio</a><br><br>


</body>
</html>