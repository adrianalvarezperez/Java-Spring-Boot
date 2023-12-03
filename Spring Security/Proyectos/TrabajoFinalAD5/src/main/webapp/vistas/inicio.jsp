<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  nav {
    background-color: #34495e;
    border-bottom: 1px solid #eee;
    display: flex;
    justify-content: space-between;
    padding: 10px;
  }

  .navbar-brand {
    font-size: 24px;
    font-weight: bold;
    color: #7EB69C;
    text-decoration: none;
    padding:10px;
  }

  .navbar-nav {
    display: flex;
    list-style: none;
    margin: 15px;
    padding: 0;
  }

  .nav-item {
    margin: 0 10px;
  }

  .nav-link {
    color: #fff;
    text-decoration: none;
    font-weight: bold;
  }

  .nav-link:hover {
    color: #7EB69C;
  }
</style>

</head>
<body>
<nav>
  <a class="navbar-brand" href="/">Tienda de animales</a>
  <ul class="navbar-nav">
    <sec:authorize access="!isAuthenticated() || hasAnyAuthority('ROLE_CLIENTE')">
      <li class="nav-item">
        <a class="nav-link" href="/producto/catalogoProductos">Catalogo</a>
      </li>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated() || hasAnyAuthority('ROLE_CLIENTE')">
      <li class="nav-item">
        <a class="nav-link" href="/compra/carrito">Carrito</a>
      </li>
    </sec:authorize>
    <sec:authorize access="hasAnyAuthority('ROLE_CLIENTE')">
      <li class="nav-item">
        <a class="nav-link" href="/direccion/altaDireccion">Direcciones</a>
      </li>
    </sec:authorize> 
    <sec:authorize access="hasAnyAuthority('ROLE_CLIENTE')">
      <li class="nav-item">
        <a class="nav-link" href="/tarjeta/altaTarjeta">Tarjetas</a>
      </li>
    </sec:authorize>   
    <sec:authorize access="hasAnyAuthority('ROLE_CLIENTE')">
      <li class="nav-item">
        <a class="nav-link" href="/cliente/compras">Mis pedidos</a>
      </li>
    </sec:authorize> 
    <sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
      <li class="nav-item">
        <a class="nav-link" href="/producto/producto">Productos</a>
      </li>
    </sec:authorize> 
   	  <sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
	      <li class="nav-item">
	        <a class="nav-link" href="/admin/altaAdmin">Alta admins</a>
	      </li>
      </sec:authorize>
      <sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
	      <li class="nav-item">
	        <a class="nav-link" href="/admin/compras">Compras del dia</a>
	      </li>
      </sec:authorize>
      <sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
	      <li class="nav-item">
	        <a class="nav-link" href="/admin/clientes">Listado Clientes</a>
	      </li>
      </sec:authorize>
      <sec:authorize access="!isAuthenticated()">
      	<li class="nav-item">
      		<a class="nav-link" href="/login">Identificate</a>
   		</li>
		<li class="nav-item">
			<a class="nav-link" href="/registro">Registrate</a>
		</li>
	  </sec:authorize>
      <sec:authorize access="hasAnyAuthority('ROLE_CLIENTE')">
      <li class="nav-item">
        <a class="nav-link" href="/cliente/cerrarSesion">Cerrar Sesión</a>
      </li>
      </sec:authorize> 
		<sec:authorize access="hasAuthority('ROLE_ADMINISTRADOR')">
		<li class="nav-item"><a class="nav-link" href="/logout">Cerrar Sesión</a></li>
		</sec:authorize>
    </ul>
    <p style="color:white"><sec:authorize access="hasAuthority('ROLE_CLIENTE')">Hola, <sec:authentication property="name"/></sec:authorize></p>
	 <p style="color:white"><sec:authorize access="hasAuthority('ROLE_ADMINISTRADOR')">Hola admin, <sec:authentication property="name"/></sec:authorize></p>
  </div>
</nav>
	</body>
	</html>
	
        
