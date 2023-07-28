package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Pago;

import java.util.ArrayList;

public interface IPagoDao {
    public ArrayList<Pago> getPagoList();
    public Pago getPagoById(int id);
    public boolean addPago(Pago pago);
    public boolean updatePago(Pago pago);
    public boolean deletePagoById(int id);
}
