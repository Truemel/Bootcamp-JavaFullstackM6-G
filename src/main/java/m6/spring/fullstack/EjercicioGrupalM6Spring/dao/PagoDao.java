package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Pago;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.PagoMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;

@Component
public class PagoDao implements IPagoDao{

    private JdbcTemplate template;

    public PagoDao(DataSource source){
        template = new JdbcTemplate(source);
    }

    @Override
    public ArrayList<Pago> getPagoList() {
        try {
            return (ArrayList<Pago>) template.query("SELECT * FROM pago", new PagoMapper());
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Pago getPagoById(int id) {
        try {
            return template.queryForObject("SELECT id, cliente_id, monto, fecha FROM pago WHERE id = ?", new PagoMapper(),
                    id);
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addPago(Pago pago) {
        try {
            return template.update("INSERT INTO pago (cliente_id, monto, fecha) VALUES (?,?,?)", pago.getIdCliente(),
                    pago.getMonto(), pago.getFecha()) > 0;
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePago(Pago pago) {
        try {
            return template.update("UPDATE pago SET cliente_id = ?, monto = ?, fecha = ? WHERE id = ?",
                    pago.getIdCliente(), pago.getMonto(), pago.getFecha(), pago.getId()) > 0;
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePagoById(int id) {
        try {
            return template.update("DELETE FROM pago WHERE id = ?", id) > 0;
        }catch (DataAccessException|NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}