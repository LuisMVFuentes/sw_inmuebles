package datos;

import beans.bArrendatario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mArrendatario {

    CADO cado = new CADO();

    public boolean insertar(bArrendatario arrendatario) {
        String sql = "INSERT INTO arrendatario VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, arrendatario.getParametros());
    }

    public boolean modificar(bArrendatario arrendatario) {
        String sql = "UPDATE arrendatario SET nombre='" + arrendatario.getNombre() + "', "
                + "apellido='" + arrendatario.getApellido() + "', dni='" + arrendatario.getDni()
                + "' , telefono='" + arrendatario.getTelefono() + "' WHERE idarrendatario="
                + arrendatario.getIdarrendatario();
        return cado.Ejecutar(sql);
    }

    public List<bArrendatario> arrendatarios() {
        String sql = "SELECT * FROM arrendatario";
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    public List<bArrendatario> seleccionar(int idarrendatario) {
        String sql = "SELECT * FROM arrendatario WHERE idarrendatario=" + idarrendatario;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    private List<bArrendatario> list(ResultSet rs) {
        List<bArrendatario> list = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bArrendatario a = new bArrendatario(rs);
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
