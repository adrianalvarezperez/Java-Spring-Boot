<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    
    
    	<h1>FORMULARIO DE ALTA DE EVENTOS</h1>

        <form action="/eventos/alta" method="post">
        
            <p><input type="text" name="nombre">Nombre</p>
            <p><input type="text" name="precio">Precio</p>
            <p><input type="text" name="descripcion">Descripcion</p>
            <p><input type="text" name="estado">Estado</p>
            <p><input type="text" name="destacado">Destacado</p>
         
            
            <p><input type="submit" value="Enviar"></p>

        </form>
        
        

</body>
</html>