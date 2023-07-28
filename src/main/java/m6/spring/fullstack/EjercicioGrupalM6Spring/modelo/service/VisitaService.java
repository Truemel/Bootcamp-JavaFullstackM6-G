package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.VisitaDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Visita;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VisitaService {

    private VisitaDao dao;

    public VisitaService(VisitaDao dao){
        this.dao = dao;
    }

    public ArrayList<Visita> getVisitaList(){
        return dao.getVisitaList();
    }

    public Visita getVisitaById(int id){
        return dao.getVisitaById(id);
    }

    public boolean updateVisita(Visita vis){
        return dao.updateVisita(vis);
    }

    public boolean addVisita(Visita vis){
        return dao.addVisita(vis);
    }

    public boolean deleteVisitaById(int id){
        return dao.deleteVisitaById(id);
    }
}