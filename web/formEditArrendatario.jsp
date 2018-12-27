<%@page import="beans.bArrendatario"%>
<%@page import="utiles.generador"%>
<%
    bArrendatario arrendat = new bArrendatario();
    if (session.getAttribute("selArrendat") == null) {
        response.sendRedirect("controlador?opc=1");
    } else {
        arrendat = (bArrendatario) session.getAttribute("selArrendat");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Arrendatario</title>
        <script src="script/script.js"></script>
    </head>
    <body>
        <h1>Editar Arrendatario</h1>
        <form action="controlador" onsubmit="return validar4()">
            <b>IdUsuario: </b><input type="text" readonly="" id="txtId" name="txtId" value="<%=arrendat.getIdarrendatario()%>"><br>
            <b>Nombre: </b><input type="text" id="txtNombre" name="txtNombre" value="<%=arrendat.getNombre()%>"><br>
            <b>Apellidos: </b><input type="text" id="txtApellidos" name="txtApellidos" value="<%=arrendat.getApellido()%>"><br>
            <b>Telef: </b><input type="text" id="txtTelef" name="txtTelef" value="<%=arrendat.getTelefono()%>"><br>
            <b>DNI: </b><input type="text" id="txtDNI" name="txtDNI" value="<%=arrendat.getDni()%>"><br>
            <input type="reset">
            <input type="hidden" name="opc" value="421">
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
