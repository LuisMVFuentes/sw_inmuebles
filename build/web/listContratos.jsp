<%@page import="beans.tblUsuario"%>
<%
    tblUsuario usuario = new tblUsuario();
    if (session.getAttribute("Arrendador") == null) {
        response.sendRedirect("controlador  ?opc=1");
    } else {
        usuario = (tblUsuario) session.getAttribute("Arrendador");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Contratos</title>
    </head>
    <body>
        <table align="center">
            <tr><th colspan="13" align="center"><h1>SW_INMUEBLES</h1></th></tr>
            <tr><th colspan="13" align="center"><hr></th></tr>
            <tr>
                <th>ID: </th>
                <td><%=usuario.getIdUsuario() + ", "%></td>
                <th>Nombre: </th>
                <td><%=usuario.getNombres() + ", "%></td>
                <th>Apellidos: </th>
                <td><%=usuario.getApellidos() + ", "%></td>
                <th>Telefono: </th>
                <td><%=usuario.getTelefono() + ", "%></td>
                <th>DNI: </th>
                <td><%=usuario.getDni() + ", "%></td>
                <th>Usuario: </th>
                <td><%=usuario.getUsuario()%></td>
                <td><a href="">Editar</a></td>
            </tr>
            <tr><th colspan="13" align="center"><hr></th></tr>
            <tr>
                <td colspan="3" align="center"><a href="controlador?opc=21">Home</a></td>
                <td colspan="3" align="center"><a href="controlador?opc=3">Ver Inmuebles</a></td>
                <td colspan="4" align="center"><a href="controlador?opc=4">Ver Arrendatarios</a></td>
                <td colspan="3" align="center">Ver Contratos</td>
            </tr>
            <tr><th colspan="13" align="center"><hr></th></tr>
        </table>
        <br><br>
        <table align="center">
            <tr><td colspan="8" align="right"><a href="#">Registro</a></td></tr>
            <tr><td colspan="8"><hr></td></tr>
            <tr>
                <th>#</th>
                <th>ID</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Inmueble</th>
                <th>Arrendatario</th>
                <th colspan="2">Acciones</th>
            </tr>
            <tr><td colspan="8"><hr></td></tr>
        </table>
    </body>
</html>
