package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.CapacitacionDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CapacitacionService {

    private CapacitacionDao dao;

    public CapacitacionService(CapacitacionDao dao){
        this.dao = dao;
    }

    public ArrayList<Capacitacion> getCapacitacionList(){
        return dao.obtenerCapacitaciones();
    }

    public boolean addCapacitacion(Capacitacion capa){
        return dao.crearCapacitacion(capa);
    }
}