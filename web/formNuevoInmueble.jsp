<%@page import="utiles.generador"%>
<%

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Inmueble</title>
    </head>
    <body>
        <form>
            Id: <input type="text" id="txtId" name="txtId" readonly=""><br>
            Codigo: <input type="text" id="txtCodigo" name="txtCodigo"><br>
            Nombre: <input type="text" id="txtNombre" name="txtNombre"><br>
            Valor: <input type="text" id="txtValor" name="txtValor"><br>
            <input type="reset">
            <input type="submit" value="Guardar">
        </form>
        <button onclick="generar()">Generar</button>
        <script>
            function generar() {
                var id = document.getElementById("txtId");
                var codigo = document.getElementById("txtCodigo");
                id.removeAttribute("value");
                id.setAttribute("value", "");
                codigo.removeAttribute("value");
                codigo.setAttribute("value", "");
            }
        </script>
    </body>
</html>
