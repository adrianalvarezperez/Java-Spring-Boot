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
<style type="text/css">
.lin1{
	background-color: rgba(130, 117, 156, 27%);
	padding-left: 250px;
}
.lin2{
    height: 40px;
    color: rgba(139, 0, 0, 83%);
    font-weight: bold;
    font-size: 17px;
    display: inline-block;
    margin-left: 60px;
    margin-top: 35px;
}
.color{
    color: rgb(255, 147, 5);
    display: inline;
    margin-left: 100px;
    font-weight: bold;
    font-size: 30px;
}

</style>
</head>
<body>

<jsp:include page="inicio.jsp"></jsp:include>
						<h1 class="cen">MENSAJES : ${mensaje}</h1>	<br><br>
</body>
</html>