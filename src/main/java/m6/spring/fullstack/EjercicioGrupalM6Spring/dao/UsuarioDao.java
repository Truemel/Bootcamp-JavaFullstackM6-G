package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Administrativo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Cliente;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Profesional;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Usuario;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.AdministrativoMapper;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.ClienteMapper;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.ProfesionalMapper;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.mapper.UsuarioMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UsuarioDao implements IUsuarioDao{

    JdbcTemplate template;

    public UsuarioDao(DataSource data){
        template = new JdbcTemplate(data);
    }

    /**
     * Inserta usuario en base de datos y retorna la llave primaria
     * @param usu
     * @return int
     */
    private int insertUserAndGetKey(Usuario usu){
        String sql = "INSERT INTO usuario (nombre, apellido, correo, rut, tipo) VALUES (?,?,?,?,?)";
        List<SqlParameter> param = List.of(new SqlParameter(Types.VARCHAR, "nombre"),
                new SqlParameter(Types.VARCHAR, "apellido"), new SqlParameter(Types.VARCHAR, "correo"),
                new SqlParameter(Types.VARCHAR, "rut"), new SqlParameter(Types.VARCHAR, "tipo"));
        PreparedStatementCreatorFactory pFactory = new PreparedStatementCreatorFactory(sql, param);
        pFactory.setReturnGeneratedKeys(true);
        pFactory.setGeneratedKeysColumnNames("id");
        PreparedStatementCreator pCreator = pFactory.newPreparedStatementCreator(List.of(usu.getNombre(),
                usu.getApellido(), usu.getCorreo(), usu.getRut(), usu.getTipo()));
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        template.update(pCreator, key);
        return Objects.requireNonNull(key.getKey()).intValue();
    }

    @Override
    public ArrayList<Usuario> getUsuarioList() {
        try {
            return (ArrayList<Usuario>) template.query("SELECT * FROM usuario", new UsuarioMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario getUsuarioById(int id) {
        try {
            return  template.queryForObject("SELECT * FROM usuario WHERE id = "+id, new UsuarioMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUsuario(Usuario usu) {
        try {
            return template.update("INSERT INTO usuario (nombre, apellido, correo, rut, tipo) VALUES (?,?,?,?,?)",usu.getNombre(),
                    usu.getApellido(), usu.getCorreo(), usu.getRut(), usu.getTipo()) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUsuarioById(int id) {
        try {
            return template.update("DELETE FROM usuario WHERE id = "+id) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUsuario(Usuario usu) {
        try {
            return template.update("UPDATE usuario SET nombre = ?, apellido = ?, correo = ?, rut = ?, tipo = ? WHERE id = ?",
                    usu.getNombre(), usu.getApellido(), usu.getCorreo(), usu.getRut(), usu.getTipo(), usu.getId()) == 1;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public ArrayList<Cliente> getClienteList() {
        try {
            return (ArrayList<Cliente>) template.query("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, cliente.id as cliId, edad, telefono, direccion, capaci_id FROM cliente INNER JOIN usuario ON "
                    + "cliente.usuario_id = usuario.id", new ClienteMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Profesional> getProfesionalList() {
        try {
            return (ArrayList<Profesional>) template.query("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, profesional.id as proId, telefono, cargo FROM profesional INNER JOIN usuario ON "
                    + "profesional.usuario_id = usuario.id", new ProfesionalMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Administrativo> getAdministrativoList() {
        try {
            return (ArrayList<Administrativo>) template.query("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, administrativo.id as admId, area FROM administrativo INNER JOIN usuario ON "
                    + "administrativo.usuario_id = usuario.id", new AdministrativoMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente getClienteById(int id) {
        try {
            return template.queryForObject("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, cliente.id as cliId, edad, telefono, direccion, capaci_id FROM cliente INNER JOIN usuario ON "
                    + "cliente.usuario_id = usuario.id WHERE id = "+id, new ClienteMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Profesional getProfesionalById(int id) {
        try {
            return template.queryForObject("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, profesional.id as proId, telefono, cargo FROM profesional INNER JOIN usuario ON "
                    + "profesional.usuario_id = usuario.id WHERE id = "+id, new ProfesionalMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Administrativo getAdministrativoById(int id) {
        try {
            return template.queryForObject("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, administrativo.id as admId, area FROM administrativo INNER JOIN usuario ON "
                    + "administrativo.usuario_id = usuario.id WHERE id = "+id, new AdministrativoMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addCliente(Cliente cli) {
        try {
            return template.update("INSERT INTO cliente (telefono, direccion, edad, usuario_id, capaci_id) VALUES (?,?,?,?,?)",
                    cli.getTelefono(), cli.getDireccion(), cli.getEdad(), insertUserAndGetKey(cli), cli.getIdCapac()) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addProfesional(Profesional profe) {
        try {
            return template.update("INSERT INTO profesional (telefono, cargo, usuario_id) VALUES (?,?,?)",
                    profe.getTelefono(), profe.getCargo(), insertUserAndGetKey(profe)) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAdministrativo(Administrativo admin) {
        try {
            return template.update("INSERT INTO administrativo (area, usuario_id) VALUES (?, ?)",
                    admin.getArea(), insertUserAndGetKey(admin)) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteClienteById(int id) {
        Cliente cli = getClienteById(id);
        try {
            boolean ok = template.update("DELETE FROM cliente WHERE id = "+id) == 1;
            return (template.update("DELETE FROM usuario WHERE id = "+cli.getId()) == 1) == ok;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProfesionalById(int id) {
        Profesional prof = getProfesionalById(id);
        try {
            boolean ok = template.update("DELETE FROM profesional WHERE id = "+id) == 1;
            return (template.update("DELETE FROM usuario WHERE id = "+prof.getId()) == 1) == ok;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAdministrativoById(int id) {
        Administrativo admin = getAdministrativoById(id);
        try {
            boolean ok = template.update("DELETE FROM administrativo WHERE id = "+id) == 1;
            return (template.update("DELETE FROM usuario WHERE id = "+admin.getId()) == 1) == ok;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCliente(Cliente cli) {
        try {
            return template.update("UPDATE cliente SET telefono = ?, direccion = ?, edad = ?, capaci_id = ? " +
                            "WHERE id = ?", cli.getTelefono(), cli.getDireccion(), cli.getEdad(), cli.getIdCapac(),
                    cli.getIdCliente()) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProfesional(Profesional profe) {
        try {
            return template.update("UPDATE profesional SET telefono = ?, cargo = ? WHERE id = ?", profe.getTelefono(),
                    profe.getCargo(), profe.getIdProfes()) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAdministrativo(Administrativo admin) {
        try {
            return template.update("UPDATE administrativo SET area = ? WHERE id = ?", admin.getArea(), admin.getIdAdmin()) == 1;
        }catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente getClienteByUserId(int id) {
        try {
            return template.queryForObject("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, cliente.id as cliId, edad, telefono, direccion, capaci_id FROM cliente INNER JOIN usuario ON "
                    + "cliente.usuario_id = usuario.id WHERE cliente.usuario_id = "+id, new ClienteMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Profesional getProfesionalByUserId(int id) {
        try {
            return template.queryForObject("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, profesional.id as proId, telefono, cargo FROM profesional INNER JOIN usuario ON "
                    + "profesional.usuario_id = usuario.id WHERE profesional.usuario_id = "+id, new ProfesionalMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Administrativo getAdministrativoByUserId(int id) {
        try {
            return template.queryForObject("SELECT usuario.id as usuId, nombre, apellido, correo,"
                    + "rut, tipo, administrativo.id as admId, area FROM administrativo INNER JOIN usuario ON "
                    + "administrativo.usuario_id = usuario.id WHERE administrativo.usuario_id = "+id, new AdministrativoMapper());
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}