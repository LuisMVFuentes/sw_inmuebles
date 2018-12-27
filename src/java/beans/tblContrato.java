package beans;

public class tblContrato {

    private int idcontrato;
    private String fechaEmision;
    private String estado;
    private int inmueble_idInmueble;
    private int arrendatario_idarrendatario;
    private int datosArrendador_idUsuario;
    private String arrendatario_nombre;
    private String arrendatario_apellido;
    private String inmueble_nombre;
    private String arrendador_nombre;
    private String arrendador_apellido;

    public tblContrato() {
    }

    public tblContrato(int idcontrato, String fechaEmision, String estado, int inmueble_idInmueble, int arrendatario_idarrendatario, int datosArrendador_idUsuario, String arrendatario_nombre, String arrendatario_apellido, String inmueble_nombre, String arrendador_nombre, String arrendador_apellido) {
        this.idcontrato = idcontrato;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.inmueble_idInmueble = inmueble_idInmueble;
        this.arrendatario_idarrendatario = arrendatario_idarrendatario;
        this.datosArrendador_idUsuario = datosArrendador_idUsuario;
        this.arrendatario_nombre = arrendatario_nombre;
        this.arrendatario_apellido = arrendatario_apellido;
        this.inmueble_nombre = inmueble_nombre;
        this.arrendador_nombre = arrendador_nombre;
        this.arrendador_apellido = arrendador_apellido;
    }

    public String getArrendador_apellido() {
        return arrendador_apellido;
    }

    public void setArrendador_apellido(String arrendador_apellido) {
        this.arrendador_apellido = arrendador_apellido;
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

    public int getDatosArrendador_idUsuario() {
        return datosArrendador_idUsuario;
    }

    public void setDatosArrendador_idUsuario(int datosArrendador_idUsuario) {
        this.datosArrendador_idUsuario = datosArrendador_idUsuario;
    }

    public String getArrendatario_nombre() {
        return arrendatario_nombre;
    }

    public void setArrendatario_nombre(String arrendatario_nombre) {
        this.arrendatario_nombre = arrendatario_nombre;
    }

    public String getArrendatario_apellido() {
        return arrendatario_apellido;
    }

    public void setArrendatario_apellido(String arrendatario_apellido) {
        this.arrendatario_apellido = arrendatario_apellido;
    }

    public String getInmueble_nombre() {
        return inmueble_nombre;
    }

    public void setInmueble_nombre(String inmueble_nombre) {
        this.inmueble_nombre = inmueble_nombre;
    }

    public String getArrendador_nombre() {
        return arrendador_nombre;
    }

    public void setArrendador_nombre(String arrendador_nombre) {
        this.arrendador_nombre = arrendador_nombre;
    }

    public Object[] getParametros() {
        Object[] os = new Object[11];
        os[0] = this.idcontrato;
        os[1] = this.fechaEmision;
        os[2] = this.estado;
        os[3] = this.inmueble_idInmueble;
        os[4] = this.arrendatario_idarrendatario;
        os[5] = this.datosArrendador_idUsuario;
        os[6] = this.arrendatario_nombre;
        os[7] = this.arrendatario_apellido;
        os[8] = this.inmueble_nombre;
        os[9] = this.arrendador_nombre;
        os[10] = this.arrendador_apellido;
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
