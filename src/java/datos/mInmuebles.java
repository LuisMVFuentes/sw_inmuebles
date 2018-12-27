package datos;

import beans.bInmueble;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mInmuebles {

    CADO cado = new CADO();

    public boolean insertar(bInmueble inmueble) {
        String sql = "INSERT INTO inmueble VALUES (?, ?, ?, ?)";
        return cado.Ejecutar(sql, inmueble.getParametros());
    }

    public boolean modificar(bInmueble inmueble) {
        String sql = "UPDATE inmueble SET codInmueble='" + inmueble.getCodInmueble() + "',"
                + "nombre='" + inmueble.getNombre() + "', valor=" + inmueble.getValor() + " "
                + "WHERE idInmueble=" + inmueble.getIdInmueble();
        return cado.Ejecutar(sql);
    }

    public List<bInmueble> seleccionar(int idInmueble) {
        String sql = "SELECT * FROM inmueble WHERE idInmueble=" + idInmueble;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    public List<bInmueble> inmuebles() {
        String sql = "SELECT * FROM inmueble";
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    private List<bInmueble> list(ResultSet rs) {
        List<bInmueble> list = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bInmueble inmueble = new bInmueble(rs);
                list.add(inmueble);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
