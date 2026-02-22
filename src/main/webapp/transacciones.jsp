<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="Model.Transaccion" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Mis Transacciones</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Monto</th>
        <th>Estado</th>
        <th>Fecha</th>
    </tr>

    <%
        List<Transaccion> lista = (List<Transaccion>) request.getAttribute("transacciones");

        for (Transaccion t : lista) {
    %>
    <tr>
        <td><%= t.getTransaccionId() %></td>
        <td><%= t.getCantidad() %></td>
        <td><%= t.getEstado() %></td>
        <td><%= t.getFechaCreacion() %></td>
    </tr>
    <%
        }
    %>
</table>

<a href="index.jsp">Volver</a>
</body>
</html>