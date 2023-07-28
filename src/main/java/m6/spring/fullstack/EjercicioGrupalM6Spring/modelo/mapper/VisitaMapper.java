package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Visita;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitaMapper implements RowMapper<Visita> {
    @Override
    public Visita mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Visita(rs.getInt("id"), rs.getInt("cliente_id"),
                rs.getInt("profes_id"), rs.getDate("fecha"), rs.getTime("hora"),
                rs.getString("lugar"), rs.getString("detalle"),
                rs.getBoolean("realizado"));
    }
}