package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.CapacitacionMapper;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;

@Component
public class CapacitacionDao implements ICapacitacionDao{

    JdbcTemplate template;
    private Log log = LogFactory.getLog(CapacitacionDao.class);

    public CapacitacionDao(DataSource data){
        this.template = new JdbcTemplate(data);
    }
    @Override
    public ArrayList<Capacitacion> obtenerCapacitaciones() {
        log.info("listando capacitaciones");
        try {
            return (ArrayList<Capacitacion>) template.query("SELECT id, nombre, detalle from capacitacion", new CapacitacionMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Capacitacion getCapacitacionById(int id) {
        try {
            return template.queryForObject("SELECT id, nombre, detalle FROM capacitacion WHERE id = "+id, new CapacitacionMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean crearCapacitacion(Capacitacion capa) {
        log.info("generando capacitación");
        try{
            return template.update("INSERT INTO capacitacion (nombre, detalle) VALUES (?, ?)", capa.getNombre(), capa.getDetalle()) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }
}