<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css?v=<%= System.currentTimeMillis() %>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="retirar" method="post">

    Monto:
    <input type="number" step="0.01" name="monto" required />

    <button type="submit" class="btn btn-retiro">Retirar</button>
</form>

<a href="index.jsp"><button class="btn">Volver</button></a>
</div>
</body>
</html>