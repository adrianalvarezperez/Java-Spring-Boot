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
  .styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}
</style>
</head>
<body style="margin:0;padding:0">


<jsp:include page="inicio.jsp"></jsp:include>
<div style="margin:20px;padding:20px" >
				<br>
				<br>
				<br>
                <a href="/producto/altaProducto"><button class="button">Dar de alta productos</button></a>



                <h1>TODOS LOS PRODUCTOS</h1>
                <table class="styled-table">
                        <caption>  
                                   <th>ID</th> 
                                   <th>NOMBRE </th> 
                                   <th>DESCRIPCION</th> 
                                   <th>PRECIO</th> 
                                   <th>STOCK</th> 
                        </caption>
                    

                        <!-- DEVUELVE LA LISTA --> 
                        <c:forEach var="ele" items="${listaProducto}">
                        <tr class="active-row">
                            <td>${ele.idProducto}</td>
                            <td>${ele.nombre}</td>
                            <td>${ele.descripcion}</td>
                            <td>${ele.precio}€</td>
                            <td>${ele.stock}</td>
                            <td><a href="/producto/modificarProducto/${ele.idProducto}" class="lin4"><button class="button">Modificar</button></a></td>
                            <td><a href="/producto/eliminarProducto/${ele.idProducto}" class="lin4"><button class="button">Borrar</button></a></td>
                        </tr>
                        </c:forEach>
                </table><br><br><br><br>

                <h1 class="cen">MENSAJES: ${mensaje}</h1>	<br><br>
                <a href="/inicio"><button class="button">Volver inicio</button></a>
</div>
                
</body>
</html>