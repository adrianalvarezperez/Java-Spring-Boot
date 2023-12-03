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
<div style="margin:20px;padding:20px" >
<sec:authorize access="hasAuthority('ROLE_ADMINISTRADOR')">
				


                        <h1>Listado de clientes</h1>
                
                        <% List<Usuario> clientes = (List<Usuario>)request.getAttribute("clientes");%>
                        <% if (clientes== null || clientes.isEmpty()) { %>
                        	<h2>Todavia no hay clientes</h2>
                        <% } else { %>
                        	<% for (Usuario cliente : clientes) { %>
                        		<table class="styled-table">
                        			<tr>
                        			    <th>NOMBRE</th>
                        			    <th>APELLIDOS</th>
                                    	<th>Cantidad de pedidos</th> 
                                    	<th>Gastado</th>
                        			</tr>
									<tr>
                        			    <td><%= cliente.getNombre() %></td>
                        			    <td><%= cliente.getApellidos() %></td> 
                                    	<td><%= cliente.getCompras().size() %></td>
                                    	<% BigDecimal total = new BigDecimal(0); %>
                                    	<% for (Compra compra : cliente.getCompras()) { %>
                                    		<% for (LineasDeCompra linea : compra.getLineasDeCompras()) { %>
                                    			<% total = total.add(linea.getPrecioUnitario().multiply(BigDecimal.valueOf(linea.getCantidad())));  %>
                                    		<% } %>
                                    	<% } %>
                                    	<td>Total: <%= total.doubleValue() %> €</td>
									</tr>
                        		</table>                      		
                        	<% } %>
      
                        <% } %>
                        <h3 class="cen">MENSAJES : ${mensaje}</h3>	<br><br>
</sec:authorize>
</div>
</body>
</html>