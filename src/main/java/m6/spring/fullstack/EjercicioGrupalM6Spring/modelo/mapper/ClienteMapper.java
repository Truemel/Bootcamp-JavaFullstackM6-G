package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Cliente(rs.getInt("usuId"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("correo"),
                rs.getString("rut"), rs.getInt("cliId"),
                rs.getShort("edad"), rs.getString("telefono"),
                rs.getString("direccion"), rs.getInt("capaci_id"));
    }
}