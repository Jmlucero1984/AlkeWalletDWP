<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="retirar" method="post">

    Monto:
    <input type="number" step="0.01" name="monto" required />

    <button type="submit">Retirar</button>
</form>

<a href="index.jsp"><button>Volver</button></a>
</body>
</html>