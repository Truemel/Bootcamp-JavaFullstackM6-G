package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.CapacitacionMapper;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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
        return (ArrayList<Capacitacion>) template.query("SELECT id, nombre, detalle from capacitacion", new CapacitacionMapper());
    }

    @Override
    public boolean crearCapacitacion(Capacitacion capa) {
        log.info("generando capacitación");
        return template.update("INSERT INTO capacitacion (nombre, detalle) VALUES (?, ?)", capa.getNombre(), capa.getDetalle()) == 1;
    }
}