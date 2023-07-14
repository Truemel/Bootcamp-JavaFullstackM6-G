package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CapacitacionMapper implements RowMapper<Capacitacion> {
    @Override
    public Capacitacion mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Capacitacion(rs.getInt("id"), rs.getString("nombre"), rs.getString("detalle"));
    }
}