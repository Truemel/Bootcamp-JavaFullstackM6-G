package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.PagoDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Pago;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PagoService {

    private PagoDao dao;

    public PagoService(PagoDao dao){
        this.dao = dao;
    }

    public ArrayList<Pago> getPagoList(){
        return dao.getPagoList();
    }

    public Pago getPagoById(int id){
        return dao.getPagoById(id);
    }

    public boolean updatePago(Pago pago){
        return dao.updatePago(pago);
    }

    public boolean addPago(Pago pago){
        return dao.addPago(pago);
    }

    public boolean deletePagoById(int id){
        return dao.deletePagoById(id);
    }
}