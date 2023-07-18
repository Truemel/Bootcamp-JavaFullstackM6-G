package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.UsuarioDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Administrativo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Cliente;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Profesional;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    private UsuarioDao dao;

    public UsuarioService(UsuarioDao dao){
        this.dao = dao;
    }

    public ArrayList<Usuario> getUsuarioList(){
        return dao.getUsuarioList();
    }

    public Usuario getUsuarioById(int id){
        return dao.getUsuarioById(id);
    }

    public boolean addUsuario(Usuario usu){
        return dao.addUsuario(usu);
    }

    public boolean deleteUsuarioById(int id){
        return dao.deleteUsuarioById(id);
    }

    public boolean updateUsuario(Usuario usu){
        return dao.updateUsuario(usu);
    }

    public ArrayList<Cliente> getClienteList(){
        return dao.getClienteList();
    }

    public ArrayList<Profesional> getProfesionalList(){
        return dao.getProfesionalList();
    }

    public ArrayList<Administrativo> getAdministrativoList(){
        return dao.getAdministrativoList();
    }

    public Cliente getClienteById(int id){
        return dao.getClienteById(id);
    }

    public Profesional getProfesionalById(int id){
        return dao.getProfesionalById(id);
    }

    public Administrativo getAdministrativoById(int id){
        return dao.getAdministrativoById(id);
    }

    public boolean addCliente(Cliente cli){
        return dao.addCliente(cli);
    }

    public boolean addProfesional(Profesional profe){
        return dao.addProfesional(profe);
    }

    public boolean addAdministrativo(Administrativo admin){
        return dao.addAdministrativo(admin);
    }

    public boolean deleteClienteById(int id){
        return dao.deleteClienteById(id);
    }

    public boolean deleteProfesionalById(int id){
        return dao.deleteProfesionalById(id);
    }

    public boolean deleteAdministrativoById(int id){
        return dao.deleteAdministrativoById(id);
    }

    public boolean updateCliente(Cliente cli){
        return dao.updateCliente(cli);
    }

    public boolean updateProfesional(Profesional profe){
        return dao.updateProfesional(profe);
    }

    public boolean updateAdministrativo(Administrativo admin){
        return dao.updateAdministrativo(admin);
    }
}
