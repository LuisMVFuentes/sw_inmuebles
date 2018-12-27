package beans;

import java.sql.ResultSet;

public class bContrato {

    private int idcontrato;
    private String fechaEmision;
    private String estado;
    private int inmueble_idInmueble;
    private int arrendatario_idarrendatario;
    private int datosArrendador_idUsuario;

    public bContrato() {
    }

    public bContrato(int idcontrato, String fechaEmision, String estado, int inmueble_idInmueble, int arrendatario_idarrendatario, int datosArrendador_idUsuario) {
        this.idcontrato = idcontrato;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.inmueble_idInmueble = inmueble_idInmueble;
        this.arrendatario_idarrendatario = arrendatario_idarrendatario;
        this.datosArrendador_idUsuario = datosArrendador_idUsuario;
    }

    public bContrato(ResultSet rs) {
        try {
            this.idcontrato = rs.getInt(1);
            this.fechaEmision = rs.getString(4);
            this.estado = rs.getString(3);
            this.inmueble_idInmueble = rs.getInt(4);
            this.arrendatario_idarrendatario = rs.getInt(5);
            this.datosArrendador_idUsuario = rs.getInt(6);
        } catch (Exception e) {
        }
    }

    public int getDatosArrendador_idUsuario() {
        return datosArrendador_idUsuario;
    }

    public void setDatosArrendador_idUsuario(int datosArrendador_idUsuario) {
        this.datosArrendador_idUsuario = datosArrendador_idUsuario;
    }

    public int getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(int idcontrato) {
        this.idcontrato = idcontrato;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getInmueble_idInmueble() {
        return inmueble_idInmueble;
    }

    public void setInmueble_idInmueble(int inmueble_idInmueble) {
        this.inmueble_idInmueble = inmueble_idInmueble;
    }

    public int getArrendatario_idarrendatario() {
        return arrendatario_idarrendatario;
    }

    public void setArrendatario_idarrendatario(int arrendatario_idarrendatario) {
        this.arrendatario_idarrendatario = arrendatario_idarrendatario;
    }

    public Object[] getParametros() {
        Object[] os = new Object[6];
        os[0] = this.idcontrato;
        os[1] = this.fechaEmision;
        os[2] = this.estado;
        os[3] = this.inmueble_idInmueble;
        os[4] = this.arrendatario_idarrendatario;
        os[5] = this.datosArrendador_idUsuario;
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
