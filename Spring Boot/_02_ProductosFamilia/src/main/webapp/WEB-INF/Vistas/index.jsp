<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>

<style>
	
		.spa{
			color:red;
		}

</style>
</head>
<body>
	
	<h1>Bienvenido a Productos App</h1>
	
	<h2>Opciones Productos</h2>

	
	<p><a href="productos?opcion=novedades">Novedades</a></p>
	<p><a href="familias?opcion=todas">Familia</a></p>
	
	<h2>Listado de productos</h2>
	 
		<h3>Mensajes : <span class="spa">${mensaje}</span></h3>
	 
	<h3><a href="/productos/altaForm">Nuevo Producto</a></h3>
	<table border="2">
	<tr>
	<th>Id</th><th>Descripcion</th><th>precio</th><th>Fecha</th><th>idFamilia</th><th>descripcionFamilia</th><th>Editar</th><th>Eliminar</th>
	</tr>
	<c:forEach var="ele" items="${listaProductos}">
		<tr>
		
		<td>${ele.idProducto}</td>
		<td>${ele.descripcion}</td>
		<td>${ele.precioUnitario}</td>
		<td>${ele.fechaAlta}</td>
		<td>${ele.familia.idFamilia}</td>
		<td>${ele.familia.descripcion}</td>
		<td><a href="/productos/editar?id=${ele.idProducto}">Editar Producto</a></td>
		<td><a href="/productos/eliminar/${ele.idProducto}">Eliminar Producto</a></td>
		</tr>
	
	</c:forEach>
	</table>
</body>
</html>