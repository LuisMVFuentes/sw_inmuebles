<%@page import="java.util.ArrayList"%>
<%@page import="beans.bInmueble"%>
<%@page import="java.util.Iterator"%>
<%@page import="beans.tblUsuario"%>
<%
    tblUsuario usuario = new tblUsuario();
    Iterator<bInmueble> itInmuebles = (session.getAttribute("Inmuebles") != null)
            ? (Iterator<bInmueble>) session.getAttribute("Inmuebles")
            : (new ArrayList<bInmueble>()).iterator();
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
        <title>Lista de Inmuebles</title>
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
                <td colspan="3" align="center">Ver Inmuebles</td>
                <td colspan="4" align="center"><a href="controlador?opc=4">Ver Arrendatarios</a></td>
                <td colspan="3" align="center"><a href="controlador?opc=5">Ver Contratos</a></td>
            </tr>
            <tr><th colspan="13" align="center"><hr></th></tr>
        </table>

        <br><br>
        <table border="0" align="center">
            <tr>
                <td colspan="7" align="right"><a href="controlador?opc=31">Registrar</a></td>
            </tr>
            <tr><td colspan="7"><hr></td></tr>
            <tr>
                <th>#</th>
                <th>ID</th>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Valor</th>
                <th colspan="2">Acciones</th>
            </tr>
            <tr><td colspan="7"><hr></td></tr>
                    <%
                        int c = 1;
                        for (Iterator it = itInmuebles; it.hasNext();) {
                            bInmueble inmueble = (bInmueble) it.next();
                    %>
            <tr>
                <td><%=inmueble.getIdInmueble()%></td>
                <td><%=inmueble.getCodInmueble()%></td>
                <td><%=inmueble.getNombre()%></td>
                <td>S/.<%=inmueble.getValor()%></td>
                <td><a href="controlador?opc=32&idInmueble=<%=inmueble.getIdInmueble()%>">Editar</a></td>
                <td><form action="controlador" onsubmit="return eliminar()">
                        <input type="submit" value="Eliminar">
                        <input type="hidden" name="opc" value="33">
                        <input type="hidden" name="idInmueble" value="<%=inmueble.getIdInmueble()%>">
                    </form></td>
            </tr>
            <%
                    c++;
                }
            %>
        </table>
    </body>
</html>
