<%@page import="utiles.generador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Arrendatario</title>
        <script src="script/script.js"></script>
    </head>
    <body>
        <h1>Nuevo Arrendatario</h1>
        <form action="controlador" onsubmit="return validar4()">
            <b>IdUsuario: </b><input type="text" id="txtId" name="txtId" value="<%=new generador().getId()%>"><br>
            <b>Nombre: </b><input type="text" id="txtNombre" name="txtNombre"><br>
            <b>Apellidos: </b><input type="text" id="txtApellidos" name="txtApellidos"><br>
            <b>Telef: </b><input type="text" id="txtTelef" name="txtTelef"><br>
            <b>DNI: </b><input type="text" id="txtDNI" name="txtDNI"><br>
            <input type="reset">
            <input type="hidden" name="opc" value="411">
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
