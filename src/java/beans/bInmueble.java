package beans;

import java.sql.ResultSet;

public class bInmueble {

    private int idInmueble;
    private String codInmueble;
    private String nombre;
    private int valor;

    public bInmueble() {
    }

    public bInmueble(int idInmueble, String codInmueble, String nombre, int valor) {
        this.idInmueble = idInmueble;
        this.codInmueble = codInmueble;
        this.nombre = nombre;
        this.valor = valor;
    }

    public bInmueble(ResultSet rs) {
        try {
            this.idInmueble = rs.getInt(1);
            this.codInmueble = rs.getString(2);
            this.nombre = rs.getString(3);
            this.valor = rs.getInt(4);
        } catch (Exception e) {
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getCodInmueble() {
        return codInmueble;
    }

    public void setCodInmueble(String codInmueble) {
        this.codInmueble = codInmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object[] getParametros() {
        Object[] os = new Object[4];
        os[0] = this.idInmueble;
        os[1] = this.codInmueble;
        os[2] = this.nombre;
        os[3] = this.valor;
        return os;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < getParametros().length; i++) {
            s += (i != 0 && i < getParametros().length) ? ", " : "";
            s += getParametros()[i];
        }
        return s;
    }
}
