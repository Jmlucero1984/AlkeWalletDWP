<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css?v=<%= System.currentTimeMillis() %>">
<meta charset="UTF-8">
<title>Logueate con tus credenciales</title>
</head>
<body>
<div class="container">
<form action="login" method="post" class="form-login">
    <label>Email:</label>
    <input type="text" name="email">

    <label>Password:</label>
    <input type="password" name="password">

    <button type="submit">Ingresar</button>
</form>
</div>
<p style="color:red">${error}</p>
</body>
</html>