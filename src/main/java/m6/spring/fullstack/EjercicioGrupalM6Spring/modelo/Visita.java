package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

import java.sql.Date;
import java.sql.Time;

public class Visita {

    private int id, idCliente, idProfe;
    private Date fecha;
    private Time hora;
    private String lugar, detalle;
    private boolean realizado;

    public Visita(){
        id = idCliente = idProfe = 0;
        fecha = new Date(0);
        hora = new Time(0, 0, 0);
        lugar = detalle = "";
        realizado = false;
    }

    public Visita(int id, int idCliente, int idProfe, Date fecha, Time hora, String lugar, String detalle, boolean realizado){
        this.id = id;
        this.idCliente = idCliente;
        this.idProfe = idProfe;
        this.fecha = fecha;
        setHora(hora);
        this.lugar = lugar;
        this.detalle = detalle;
        this.realizado = realizado;
    }

    public Visita(int id, int idCliente, int idProfe, Date fecha, String hora, String lugar, String detalle, boolean realizado){
        this.id = id;
        this.idCliente = idCliente;
        this.idProfe = idProfe;
        this.fecha = fecha;
        setHora(hora);
        this.lugar = lugar;
        this.detalle = detalle;
        this.realizado = realizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(int idProfe) {
        this.idProfe = idProfe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setHora(String hora){
        setHora(Time.valueOf(hora));
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idProfe=" + idProfe +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", lugar='" + lugar + '\'' +
                ", detalle='" + detalle + '\'' +
                ", realizado=" + realizado +
                '}';
    }
}