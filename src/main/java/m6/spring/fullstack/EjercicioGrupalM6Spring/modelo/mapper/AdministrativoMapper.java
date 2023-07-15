package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Administrativo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministrativoMapper implements RowMapper<Administrativo> {
    @Override
    public Administrativo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Administrativo(rs.getInt("usuId"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("correo"),
                rs.getString("rut"), rs.getInt("admId"), rs.getString("area"));
    }
}