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
	<h1>Añade a la cesta la cantidad que desses</h1>
	
	<p>precio producto ${producto.precioVenta }
	<form action="/app/cesta/add/${producto.idProductos}/${producto.precioVenta}" method="post">

		
		<div class="form-group">
			<label for="cantidad">Cantidad</label> <input type="number"
				class="form-control" id="cantidad" name="cantidad"
				placeholder="Cantidad">
		</div>
		 <button type="submit" class="btn btn-primary">Submit</button>
	</form>


	
</body>
</html>