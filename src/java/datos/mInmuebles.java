package datos;

import beans.bInmueble;

public class mInmuebles {

    CADO cado = new CADO();

    public boolean insertar(bInmueble inmueble) {
        String sql = "INSERT INTO inmueble VALUES (?, ?, ?, ?)";
        return cado.Ejecutar(sql, inmueble.getParametros());
    }
}
