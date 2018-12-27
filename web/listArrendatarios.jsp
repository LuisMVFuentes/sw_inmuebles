<%@page import="java.util.ArrayList"%>
<%@page import="beans.bArrendatario"%>
<%@page import="java.util.Iterator"%>
<%@page import="beans.tblUsuario"%>
<%
    Iterator<bArrendatario> itArrendatario = (session.getAttribute("Arrendatarios") != null)
            ? (Iterator<bArrendatario>) session.getAttribute("Arrendatarios")
            : (new ArrayList<bArrendatario>()).iterator();
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
        <title>Lista de Arrendatarios</title>
        <script src="script/script.js"></script>
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
                <td colspan="4" align="center">Ver Arrendatarios</td>
                <td colspan="3" align="center"><a href="controlador?opc=5">Ver Contratos</a></td>
            </tr>
            <tr><th colspan="13" align="center"><hr></th></tr>
        </table>
        <br><br>
        <table align="center">
            <tr><td colspan="8" align="right"><a href="controlador?opc=41">Registrar</a></td></tr>
            <tr><td colspan="8"><hr></td></tr>
            <tr>
                <th>#</th>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Telefono</th>
                <th colspan="2">Acciones</th>
            </tr>
            <tr><td colspan="8"><hr></td></tr>
                    <%
                        int c = 1;
                        for (Iterator it = itArrendatario; it.hasNext();) {
                            bArrendatario arrendat = (bArrendatario) it.next();
                    %>
            <tr>
                <td><%=c%></td>
                <td><%=arrendat.getIdarrendatario()%></td>
                <td><%=arrendat.getNombre()%></td>
                <td><%=arrendat.getApellido()%></td>
                <td><%=arrendat.getDni()%></td>
                <td><%=arrendat.getTelefono()%></td>
                <td><a href="controlador?opc=42&idArrendatario=<%=arrendat.getIdarrendatario()%>">Editar</a></td>
                <td><form action="controlador" onsubmit="return eliminar()">
                        <input type="submit" value="Eliminar">
                        <input type="hidden" name="opc" value="43">
                        <input type="hidden" name="idArrendatario" value="<%=arrendat.getIdarrendatario()%>">
                    </form></td>
            </tr>
            <%
                    c++;
                }
            %>
        </table>
    </body>
</html>
