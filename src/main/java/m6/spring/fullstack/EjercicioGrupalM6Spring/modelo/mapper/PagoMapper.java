package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Pago;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PagoMapper implements RowMapper<Pago> {

    @Override
    public Pago mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Pago(rs.getInt("id"), rs.getInt("cliente_id"),
                rs.getFloat("monto"), rs.getDate("fecha"));
    }
}