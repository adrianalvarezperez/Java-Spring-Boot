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
input[type=text], select {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 20%;
  background-color: #34495E;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #7EB69C;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

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
<div style="margin:20px;padding:20px">
    <form action="/producto/modificarProducto" method="post">
		<p style=font-weight:bold>Introduce ID Producto</p>
        <input type="number" name="idProducto" value="${sesionIdProducto.idProducto}"><br>
        <p style=font-weight:bold>Introduce Nombre del Producto</p>
        <input type="text" name="nombreProducto" value="${sesionIdProducto.nombre}"> <br>
        <p style=font-weight:bold>Introduce Descripción del Producto</p>
        <input type="text" name="descripcion" value="${sesionIdProducto.descripcion}"> <br>
        <p style=font-weight:bold>Introduce Precio del Producto</p>
        <input type="text" name="precio" value="${sesionIdProducto.precio}"> <br>
        <p style=font-weight:bold>Introduce el Stock del Producto</p>
        <input type="number" name="stock" value="${sesionIdProducto.stock}"> <br>

        <input type="submit" value="Enviar"><br>

    </form>



    <h1 class="cen">MENSAJES : ${mensaje}</h1>	<br><br>
	<p><a href="/inicio"><button class="button">Volver inicio</a></p>

</div>
</body>
</html>