package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Chequeo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChequeoMapper implements RowMapper<Chequeo> {
    @Override
    public Chequeo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Chequeo(rs.getInt("id"), rs.getInt("visita_id"),
                rs.getString("detalle"), rs.getString("estado"));
    }
}