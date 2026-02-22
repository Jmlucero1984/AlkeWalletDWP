<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/styles.css?v=<%= System.currentTimeMillis() %>">
<head>
    <title>Saldo</title>
</head>
<body>
<div class="container">
    <h2>Saldo actual:</h2>
    <p>${cuenta.balance}</p>
    <a href="index.jsp"><button class="btn">Volver</button></a>
    </div>
</body>
</html>