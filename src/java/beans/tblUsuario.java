package beans;

import java.sql.ResultSet;

public class tblUsuario {

    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String dni;
    private String usuario;
    private String contraseña;

    public tblUsuario() {
    }

    public tblUsuario(int idUsuario, String nombres, String apellidos, String telefono, String dni, String usuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public tblUsuario(ResultSet rs) {
        try {
            this.idUsuario = rs.getInt(1);
            this.nombres = rs.getString(2);
            this.apellidos = rs.getString(3);
            this.telefono = rs.getString(4);
            this.dni = rs.getString(5);
            this.usuario = rs.getString(6);
            this.contraseña = rs.getString(7);
        } catch (Exception e) {
        }
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Object[] getParametros() {
        Object[] os = new Object[7];
        os[0] = this.idUsuario;
        os[1] = this.nombres;
        os[2] = this.apellidos;
        os[3] = this.telefono;
        os[4] = this.dni;
        os[5] = this.usuario;
        os[6] = this.contraseña;
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
