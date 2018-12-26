<%@page import="beans.tblUsuario"%>
<%
    tblUsuario usuario = new tblUsuario();
    tblUsuario seleccion = new tblUsuario();
    if (session.getAttribute("Arrendador") == null) {
        response.sendRedirect("controlador?opc=1");
    } else if (session.getAttribute("Seleccion") == null) {
        response.sendRedirect("controlador?opc=21");
    } else {
        usuario = (tblUsuario) session.getAttribute("Arrendador");
        seleccion = (tblUsuario) session.getAttribute("Seleccion");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuario</title>
        <script src="script/script.js"></script>
    </head>
    <body>
        <h1>Editar datos</h1>
        <form action="controlador" onsubmit="return validar2()">
            <b>IdUsuario: </b><input type="text" readonly="" id="txtId" name="txtId" value="<%=seleccion.getIdUsuario()%>"><br>
            <b>Nombre: </b><input type="text" id="txtNombre" name="txtNombre" value="<%=seleccion.getNombres()%>"><br>
            <b>Apellidos: </b><input type="text" id="txtApellidos" name="txtApellidos" value="<%=seleccion.getApellidos()%>"><br>
            <b>Telef: </b><input type="text" id="txtTelef" name="txtTelef" value="<%=seleccion.getTelefono()%>"><br>
            <b>DNI: </b><input type="text" id="txtDNI" name="txtDNI" value="<%=seleccion.getDni()%>"><br>
            <br><br>
            <b>Usuario: </b><input type="text" id="txtUsuario" name="txtUsuario" value="<%=seleccion.getUsuario()%>"><br>
            <b>Contraseña: </b><input type="password" id="txtPassword" name="txtPassword" value="<%=seleccion.getContraseña()%>"><br>
            <b>Repetir contraseña: </b><input type="password" id="txtPassword1" value="<%=seleccion.getContraseña()%>"><br>
            <input type="reset">
            <input type="hidden" name="opc" value="221">
            <input type="submit" value="Guardar">
        </form>
        <button onclick="revelar()" id="btnMostrar">Mostrar Contraseña</button>

    </body>
</html>
