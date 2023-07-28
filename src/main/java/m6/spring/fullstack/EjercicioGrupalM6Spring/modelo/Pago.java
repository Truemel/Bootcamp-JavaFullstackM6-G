package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

import java.util.Date;

public class Pago {

    private int id, idCliente;
    private float monto;
    private Date fecha;

    public Pago(){
        id = idCliente = 0;
        monto = 0;
        fecha = new Date();
    }

    public Pago(int id, int idCliente, float monto, Date fecha){
        this.id = id;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fecha = fecha;
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

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", monto=" + monto +
                ", fecha=" + fecha +
                '}';
    }
}