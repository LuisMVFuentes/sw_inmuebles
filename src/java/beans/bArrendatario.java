package beans;

import java.sql.ResultSet;

public class bArrendatario {

    private int idarrendatario;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;

    public bArrendatario() {
    }

    public bArrendatario(int idarrendatario, String nombre, String apellido, String dni, String telefono) {
        this.idarrendatario = idarrendatario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    public bArrendatario(ResultSet rs) {
        try {
            this.idarrendatario = rs.getInt(1);
            this.nombre = rs.getString(2);
            this.apellido = rs.getString(3);
            this.dni = rs.getString(4);
            this.telefono = rs.getString(5);
        } catch (Exception e) {
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdarrendatario() {
        return idarrendatario;
    }

    public void setIdarrendatario(int idarrendatario) {
        this.idarrendatario = idarrendatario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Object[] getParametros() {
        Object[] os = new Object[5];
        os[0] = this.idarrendatario;
        os[1] = this.nombre;
        os[2] = this.apellido;
        os[3] = this.dni;
        os[4] = this.telefono;
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
