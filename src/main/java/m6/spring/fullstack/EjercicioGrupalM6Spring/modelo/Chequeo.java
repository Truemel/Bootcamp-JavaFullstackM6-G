package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

public class Chequeo {

    public static enum Check {PENDIENTE, COMPLETADO};

    private int id, idVisit;
    private String detalle;
    private Check estado;

    public Chequeo(){
        id = idVisit = 0;
        detalle = "";
        estado = Check.PENDIENTE;
    }

    public Chequeo(int id, int idVisit, String detalle, Check estado){
        this.id = id;
        this.idVisit = idVisit;
        this.detalle = detalle;
        setEstado(estado);
    }

    public Chequeo(int id, int idVisit, String detalle, String estado){
        this.id = id;
        this.idVisit = idVisit;
        this.detalle = detalle;
        setEstado(estado);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Check getEstado() {
        return estado;
    }

    public void setEstado(Check estado) {
        this.estado = estado;
    }

    public void setEstado(String estado){
        setEstado(Check.valueOf(estado.toUpperCase()));
    }

    @Override
    public String toString() {
        return "Chequeo{" +
                "id=" + id +
                ", idVisit=" + idVisit +
                ", detalle='" + detalle + '\'' +
                ", estado=" + estado +
                '}';
    }
}