<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css?v=<%= System.currentTimeMillis() %>">
<title>Billetera Virtual</title>
</head>
<body>

<div class="container">
<%
    if (session == null || session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
	 
%>
	<h1>Bienvenido a tu AlkeWallet</h1>
	<p>${usuarioLogueado.nombre}</p>
	<a href="saldo">
		<button class="btn">Ver saldo</button>
	</a>
	<a href="transacciones">
		<button class="btn">Ver mis transacciones</button>
	</a>
	<a href="deposito.jsp">
		<button class="btn">Depositar dinero</button>
	</a>
	<a href="retiro.jsp">
		<button class="btn">Retirar dinero</button>
	</a>
	</div>
	
</body>
</html>