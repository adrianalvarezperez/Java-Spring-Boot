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
<body>

<jsp:include page="inicio.jsp"></jsp:include>
<div style="margin:20px;padding:20px">


                        <h1>TODOS LOS PRODUCTOS</h1>
                        <form>
							<label for="busqueda">Buscar</label>
							<input type="text" name="busqueda" placeholder="Busca por nombre">
							<input class="button" width=20% type="submit" />                        
                        </form>
                        <br>
                        <table class="styled-table"> 
                        	
                                <tr>
									<th>ID</th> 
                                    <th>NOMBRE</th> 
                                    <th>DESCRIPCION</th> 
                                    <th>PRECIO</th> 
                                    <th>STOCK</th>
                                    <th>FICHA</th>
                                </tr>
                            
                              <tr>
                            

                                <!-- DEVUELVE LA LISTA --> 
                                <c:forEach var="ele" items="${listaProducto}">
                                <tr>
                                    <td>${ele.idProducto}</td>
                                    <td>${ele.nombre}</td>
                                    <td>${ele.descripcion}</td>
                                    <td>${ele.precio}€</td>
                                    <td>${ele.stock}</td>
                                    <td><a href="/producto/${ele.idProducto}"><button class="button">Ver</button></a></td>
                                    <td>
										<form method="post" action="/compra/carrito/agregar">
											<input type="number" name="cantidad" value="1"  min=0 max=10>
											<input type="hidden" name="id_producto" value="${ele.idProducto}">
											<input class="button" type="submit" value="Agregar al carrito"></input>
										</form>                                    
                                    </td>
                                </tr>
                            
                                </c:forEach>
                        </table><br><br>
                        		<h3 class="cen">MENSAJES : ${mensaje}</h3>	<br><br>
 </div>
</body>
</html>