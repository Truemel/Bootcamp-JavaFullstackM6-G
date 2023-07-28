package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.ChequeoDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Chequeo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChequeoService {

    private ChequeoDao dao;

    public ChequeoService(ChequeoDao dao){
        this.dao = dao;
    }

    public ArrayList<Chequeo> getChequeoList(){
        return dao.getChequeoList();
    }

    public Chequeo getChequeoById(int id){
        return dao.getChequeoById(id);
    }

    public boolean addChequeo(Chequeo check){
        return dao.addChequeo(check);
    }

    public boolean updateChequeo(Chequeo check){
        return dao.updateChequeo(check);
    }

    public boolean deleteChequeoById(int id){
        return dao.deleteChequeoById(id);
    }
}