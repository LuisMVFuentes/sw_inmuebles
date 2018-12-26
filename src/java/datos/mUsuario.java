package datos;

import beans.tblUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mUsuario {

    CADO cado = new CADO();

    public boolean modificar(tblUsuario usuario) {
        String sql = "UPDATE datosarrendador INNER JOIN arrendador ON datosarrendador.idUsuario=arrendador.datosArrendador_idUsuario "
                + "SET datosarrendador.nombres='" + usuario.getNombres() + "', datosarrendador.apellidos='" + usuario.getApellidos() + "', "
                + "datosarrendador.telefono='" + usuario.getTelefono() + "', datosarrendador.dni='" + usuario.getDni() + "', "
                + "arrendador.usuario='" + usuario.getUsuario() + "', arrendador.contraseña='" + usuario.getContraseña() + "' "
                + "WHERE datosarrendador.idUsuario=" + usuario.getIdUsuario();
        return cado.Ejecutar(sql);
    }

    public List<tblUsuario> usuarios(String usu, String pass) {
        String sql = "SELECT datosarrendador.*, arrendador.usuario, arrendador.contraseña "
                + "FROM datosarrendador INNER JOIN arrendador ON datosarrendador.idUsuario "
                + "= arrendador.datosArrendador_idUsuario WHERE arrendador.usuario =? AND "
                + "arrendador.contraseña =?";
        Object[] os = {usu, pass};
        ResultSet rs = cado.Recuperar(sql, os);
        return list(rs);
    }

    public List<tblUsuario> seleccionar(int idUsuario) {
        String sql = "SELECT datosarrendador.*, arrendador.usuario, arrendador.contraseña "
                + "FROM datosarrendador INNER JOIN arrendador ON datosarrendador.idUsuario "
                + "= arrendador.datosArrendador_idUsuario WHERE datosarrendador.idUsuario=?";
        Object[] os = {idUsuario};
        ResultSet rs = cado.Recuperar(sql, os);
        return list(rs);
    }

    private List<tblUsuario> list(ResultSet rs) {
        List<tblUsuario> usuarios = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                tblUsuario usuario = new tblUsuario(rs);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
        }
        return usuarios;
    }
}
