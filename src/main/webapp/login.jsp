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
<h1>AlkeWallet</h1>
<form action="login" method="post" class="form-login">
    <label>EMAIL:</label>
    <input type="text" name="email">

    <label>PASSWORD:</label>
    <input type="password" name="password">
       <p style="color:red">
            ${error}
        </p>

    <button class="btn" type="submit">Ingresar</button>
</form>
</div>
</body>
</html>