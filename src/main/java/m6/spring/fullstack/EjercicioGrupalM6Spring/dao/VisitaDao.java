package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Visita;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.VisitaMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;

@Component
public class VisitaDao implements IVisitaDao{

    private JdbcTemplate template;

    public VisitaDao(DataSource source){
        template = new JdbcTemplate(source);
    }

    @Override
    public ArrayList<Visita> getVisitaList() {
        try {
            return (ArrayList<Visita>) template.query("SELECT * FROM visita", new VisitaMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Visita getVisitaById(int id) {
        try {
            return template.queryForObject("SELECT * FROM visita WHERE id = "+id, new VisitaMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateVisita(Visita vis) {
        try {
            return template.update("UPDATE visita SET cliente_id = ?, fecha = ?, hora = ?, lugar = ?," +
                            "realizado = ?, detalle = ?, profes_id = ? WHERE id = ?", vis.getIdCliente(),
                    vis.getFecha(), vis.getHora(), vis.getLugar(), vis.isRealizado(), vis.getDetalle(),
                    vis.getIdProfe(), vis.getId()) > 0;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteVisitaById(int id) {
        try {
            return template.update("DELETE FROM visita WHERE id = ?", id) > 0;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addVisita(Visita vis) {
        try {
            return template.update("INSERT INTO visita (cliente_id, fecha, hora, lugar, realizado, detalle, " +
                    "profes_id) VALUES (?,?,?,?,?,?,?)", vis.getIdCliente(), vis.getFecha(), vis.getHora(),
                    vis.getLugar(), vis.isRealizado(), vis.getDetalle(), vis.getIdProfe()) > 0;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }
}