<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Billetera Virtual</title>
</head>
<body>
    <h1>Bienvenido a tu Billetera</h1>
    <p>${usuarioLogueado.nombre}</p>
<a href="saldo"><button>Ver saldo</button></a>
 <a href="transacciones">
    <button>Ver mis transacciones</button>
</a>
<a href="deposito.jsp">
    <button>Depositar dinero</button>
</a>
<a href="retiro.jsp">
    <button>Retirar dinero</button>
</a>
</body>
</html>