<%@page import="tienda.modelo.beans.*"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<sec:authorize access="hasAuthority('ROLE_ADMINISTRADOR')">
						


                        <h1>Las compras de hoy</h1><br>
                       
                        <% List<Compra> compras = (List<Compra>)request.getAttribute("compras");%>
                        <% if (compras== null || compras.isEmpty()) { %>
                        	<h2>Todavia no hay compras hoy</h2>
                        <% } else { %>
                        	<% for (Compra compra : compras) { %>
                        		<ul>
                        		<li><p>ID Compra: <%= compra.getIdCompra() %></p></li>
                        		<li><p>Estado: <%= compra.getEstado() %></p></li>
                        		<li><p>Direccion: <%= compra.getDireccione().getCalle() %></p></li>
                        		<li><p>Tarjeta de pago: <%= compra.getTarjetasBancaria().getNumeroTarjeta() %></p></li>
                        		<li><p>Usuario: <%= compra.getUsuario().getNombre() %> <%= compra.getUsuario().getApellidos() %></p></li>
                        		</ul>
                        		<table class="styled-table" >
                        			<tr>
                        			    <th>NOMBRE</th> 
                                    	<th>PRECIO Unitario</th> 
                                    	<th>CANTIDAD</th>
                        			</tr>
                        			<% BigDecimal total = new BigDecimal(0); %>
									<% for (LineasDeCompra linea : compra.getLineasDeCompras()) { %>
										<tr>
											<td><%= linea.getProducto().getNombre() %></td>
											<td><%= linea.getPrecioUnitario() %> €</td>
											<td><%= linea.getCantidad() %></td>
										</tr>
									<% total = total.add(linea.getPrecioUnitario().multiply(BigDecimal.valueOf(linea.getCantidad())));  %>
                        			<% } %>
                        		</table>
                        		<h3>Total: <%= total.doubleValue() %> €</h3>
                        		<br><hr>
                        	<% } %>
                        <% } %>
</sec:authorize>
<br><h3 class="cen">MENSAJES : ${mensaje}</h3>	<br><br>
</div>
</body>
</html>