package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Chequeo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.ChequeoMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ChequeoDao implements IChequeoDao{

    private JdbcTemplate temp;

    public ChequeoDao(JdbcTemplate temp){
        this.temp = temp;
    }

    @Override
    public ArrayList<Chequeo> getChequeoList() {
        try{
            return (ArrayList<Chequeo>) temp.query("SELECT * FROM chequeo", new ChequeoMapper());
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Chequeo getChequeoById(int id) {
        try {
            return temp.queryForObject("SELECT id, visita_id, detalle, estado FROM chequeo WHERE id = ?",
                    new ChequeoMapper(), id);
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addChequeo(Chequeo check) {
        try {
            return temp.update("INSERT INTO chequeo (visita_id, detalle, estado) VALUES (?,?,?)",
                    check.getIdVisit(), check.getDetalle(), check.getEstado()) > 0;
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateChequeo(Chequeo check) {
        try {
            return temp.update("UPDATE chequeo SET visita_id = ?, detalle = ?, estado = ? WHERE id = ?",
                    check.getIdVisit(), check.getDetalle(), check.getEstado(), check.getId()) > 0;
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteChequeoById(int id) {
        try {
            return temp.update("DELETE FROM chequeo WHERE id = ?", id) > 0;
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}