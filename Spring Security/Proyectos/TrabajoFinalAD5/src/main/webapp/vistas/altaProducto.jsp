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
    <form action="/producto/altaProducto" method="post">

        <input type="text" name="nombreProducto" placeholder="Nombre del producto"><br>
        <input type="text" name="descripcion" placeholder="Descripcion del producto"> <br>
        <input type="text" name="precio" placeholder="Precio del producto"> <br>
        <input type="number" name="stock" placeholder="Stock del producto"> <br>

        <input type="submit" value="Enviar">

    </form>



    <h1 class="cen">MENSAJES : ${mensaje}</h1>	<br><br>
	<p><a href="/inicio"><button class="button">Volver inicio</button></a></p>

</div>
</body>
</html>