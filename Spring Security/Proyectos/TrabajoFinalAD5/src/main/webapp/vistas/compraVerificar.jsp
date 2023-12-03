<%@page import="tienda.dto.LineaCompraDTO"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="tienda.modelo.beans.Usuario"%>
<%@page import="tienda.modelo.beans.Direccione"%>
<%@page import="tienda.modelo.beans.TarjetasBancaria"%>
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
                        <form method="post" action="/compra/procesar">
                        <% List<LineaCompraDTO> productosCarrito = (List<LineaCompraDTO>)request.getAttribute("carrito");%>
                        <% if (productosCarrito== null || productosCarrito.isEmpty()) { %>
                        	<h2>El carrito esta vacio</h2>
                        <% } else { %>
                        	<% System.out.println(productosCarrito.get(0).getProductoDTO().getNombre()); %>
                        	<h1>Productos del carrito</h1>
	                        <br>
	                        <table class="styled-table"> 
	                                <tr>
										<th>ID PRODUCTO</th> 
	                                    <th>NOMBRE PRODUCTO</th>  
	                                    <th>PRECIO</th> 
	                                    <th>Cantidad</th>
	                                </tr>
	                                <!-- DEVUELVE LA LISTA --> 
									<% for (LineaCompraDTO producto : productosCarrito) { %>
									    <tr>
									        <td><%= producto.getProductoDTO().getIdProducto() %></td>
									        <td><%= producto.getProductoDTO().getNombre() %></td>
									        <td><%= producto.getPrecioVenta() %>€</td>
									        <td><%= producto.getCantidad() %></td>
									    </tr>
									<% } %>
	                        </table><br>
	                        <h2>Direcciones</h2>
	                        <% Usuario usuario = (Usuario)request.getAttribute("usuario");%>
                        	<% if (usuario.getDirecciones()== null || usuario.getDirecciones().isEmpty()) { %>
                        		<h2>Debes añadir una direccion primero</h2>
                        		<a href="/direccion/altaDireccion">Añadir</a>
                        		<br>
                        	<% } else { %>
	                        	<% for (Direccione direccion : usuario.getDirecciones()) { %>
	                        	<p>
	                        		<input type="radio" name="direccion" value="<%=direccion.getIdDireccion()%>">
	                        		<label for="direccion">
	                        			<%= direccion.getCalle() %>
              							<%= direccion.getNumero() %>
								        <%= direccion.getPiso() %> 
								        <%= direccion.getLetra() %>
                        			</label>
	                        	</p>                        	
	                        	<% } %>
	                        <% } %>
	                        <br>
	                        <h2>Tarjetas Bancarias</h2>
                        	<% if (usuario.getTarjetasBancarias()== null || usuario.getTarjetasBancarias().isEmpty()) { %>
                        		<h2>Debes añadir una tarjeta bancaria primero</h2>
                        		<a href="/tarjeta/altaTarjeta">Añadir</a>
                        		<br>
                        	<% } else { %>
	                        	<% for (TarjetasBancaria tarjeta : usuario.getTarjetasBancarias()) { %>
	                        	<p>
	                        		<input type="radio" name="tarjeta" value="<%=tarjeta.getIdTarjeta() %>">
	                        		<label for="tarjeta">
	                        			<%= tarjeta.getNumeroTarjeta() %>
                        			</label>
	                        	</p>                        	
	                        	<% } %>
	                        <% } %>
                        	<input class="button" type="submit" value="Comprar">
                        </form>
                        <% } %>
                        <h3>Mensaje: ${mensaje}</h3>
 </div>
</body>
</html>