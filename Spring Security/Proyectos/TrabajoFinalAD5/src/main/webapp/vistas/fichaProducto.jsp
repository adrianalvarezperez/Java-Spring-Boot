<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.button {
  background-color: #7EB69C;
  border: none;
  color: white;
  padding: 5px 15px;
  text-align: center;
  display: inline-block;
  font-size: 14px;
  margin: 4px 2px;
  cursor: pointer;
  text-decoration:none;
  font-weight: bold;
  border-radius:5%
  }

</style>
</head>
<body>
<jsp:include page="inicio.jsp"></jsp:include>
<div style="margin:20px;padding:20px" >
	<h1>Ficha de producto</h1>
		<ul>
		<li><h3>Id_PRODUCTO</h3></li>
		<p>${producto.idProducto}</p>
		<li><h3>NOMBRE PRODUCTO</h3></li>
		<p>${producto.nombre}</p>
		<li><h3>DESCRIPCION</h3></li> 
		<p>${producto.descripcion}</p>
		<li><h3>PRECIO</h3></li>  
		<p>${producto.precio} €</p>
		<li><h3>Stock</h3> </li> 
		<p>${producto.stock}</p>
		</ul>
	<p><a href="/producto/catalogoProductos"><button class="button">Volver al catalogo</button></a></p>
</div>
</body>
</html>