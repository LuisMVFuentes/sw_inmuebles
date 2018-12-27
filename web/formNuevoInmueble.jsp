<%@page import="beans.tblUsuario"%>
<%@page import="utiles.generador"%>
<%
    tblUsuario usuario = new tblUsuario();
    if (session.getAttribute("Arrendador") == null) {
        response.sendRedirect("controlador?opc=1");
    } else {
        usuario = (tblUsuario) session.getAttribute("Arrendador");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Inmueble</title>
        <script src="script/script.js"></script>
    </head>
    <body>
        <h1>Nuevo Inmueble</h1>
        <form action="controlador" onsubmit="return validar3()">
            Id: <input type="text" id="txtId" name="txtId" readonly="" value="<%=new generador().getId()%>"><br>
            Codigo: <input type="text" id="txtCodigo" name="txtCodigo" value="<%=new generador().getCodigo()%>"><br>
            Nombre: <input type="text" id="txtNombre" name="txtNombre"><br>
            Valor: <input type="text" id="txtValor" name="txtValor"><br>
            <input type="hidden" name="opc" value="311">
            <input type="reset">
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
