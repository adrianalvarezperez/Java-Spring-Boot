<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Datos Producto </h1>

<p>${producto.codigo }</p>
<p>${producto.descripcion }</p>
<p>${producto.marca }</p>
<p>${producto.color }</p>
<p>${producto.precioUnitario *2}</p>
<p>${producto.familia.descripcion }</p>


</body>
</html>