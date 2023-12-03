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

<jsp:include page="inicio.jsp"></jsp:include>
<div style="margin:20px;padding:20px">




                        <h1>TODAS TUS COMPRAS</h1>
                        
                        <% List<Compra> compras = (List<Compra>)request.getAttribute("compras");%>
                        <% if (compras== null || compras.isEmpty()) { %>
                        	<h2>Todavia no tienes compras</h2>
                        <% } else { %>
                        	<% for (Compra compra : compras) { %>
                        		<p>ID Compra: <%= compra.getIdCompra() %></p>
                        		<p>Estado: <%= compra.getEstado() %></p>
                        		<p>Direccion: <%= compra.getDireccione().getCalle() %></p>
                        		<p>Tarjeta de pago: <%= compra.getTarjetasBancaria().getNumeroTarjeta() %></p>
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
                        		<hr>
                        	<% } %>
                        <% } %>
                      
              <h3 class="cen">MENSAJES : ${mensaje}</h3>	<br><br>
 </div>
</body>
</html>