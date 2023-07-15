package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Administrativo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Cliente;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Profesional;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Usuario;

import java.util.ArrayList;

public interface IUsuarioDao {
    public ArrayList<Usuario> getUsuarioList();
    public Usuario getUsuarioById(int id);
    public boolean addUsuario(Usuario usu);
    public boolean deleteUsuarioById(int id);
    public boolean updateUsuario(Usuario usu);
    public ArrayList<Cliente> getClienteList();
    public ArrayList<Profesional> getProfesionalList();
    public ArrayList<Administrativo> getAdministrativoList();
    public Cliente getClienteById(int id);
    public Profesional getProfesionalById(int id);
    public Administrativo getAdministrativoById(int id);
    public boolean addCliente(Cliente cli);
    public boolean addProfesional(Profesional profe);
    public boolean addAdministrativo(Administrativo admin);
    public boolean deleteClienteById(int id);
    public boolean deleteProfesionalById(int id);
    public boolean deleteAdministrativoById(int id);
    public boolean updateCliente(Cliente cli);
    public boolean updateProfesional(Profesional profe);
    public boolean updateAdministrativo(Administrativo admin);
}
