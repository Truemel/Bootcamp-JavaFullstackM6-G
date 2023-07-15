package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Profesional;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesionalMapper implements RowMapper<Profesional> {
    @Override
    public Profesional mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Profesional(rs.getInt("usuId"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("correo"),
                rs.getString("rut"), rs.getInt("proId"),
                rs.getString("telefono"), rs.getString("cargo"));
    }
}