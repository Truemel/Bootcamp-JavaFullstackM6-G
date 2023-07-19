package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rs.getString("tipo"));
        return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                rs.getString("correo"), rs.getString("rut"), rs.getString("tipo"));
    }
}