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

input[type=date], select {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password], select {
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
<div div style="margin:20px;padding:20px">
<sec:authorize access="hasAuthority('ROLE_ADMINISTRADOR')">
	<form action="/admin/altaAdmin" method="post">
			<p style=font-weight:bold >Alta Administador</p>
			<input type="text" name="nombre" placeholder="Introduzca su Nombre"><br><br>
			<input type="text" name="apellido" placeholder="Introduzca su Apellido"><br><br><p>Fecha Nacimiento </p>
			<input type="date" name="fechaNacimiento"><br><br>
			<input type="text" name="email" placeholder="Introduce su Email"><br><br>
			<input type="password" name="password" placeholder="Introduce una contraseña"><br><br>
			
	
			<input type="submit" value="Enviar">
			
	</form>



	<h1 class="cen">MENSAJES : ${mensaje}</h1>	<br><br>
	<p><a href="/inicio"> <button class="button">Volver inicio</button></a></p>
</sec:authorize>
</div>
</body>
</html>