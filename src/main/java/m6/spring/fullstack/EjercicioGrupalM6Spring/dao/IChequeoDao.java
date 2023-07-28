package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Chequeo;

import java.util.ArrayList;

public interface IChequeoDao {
    public ArrayList<Chequeo> getChequeoList();
    public Chequeo getChequeoById(int id);
    public boolean addChequeo(Chequeo check);
    public boolean updateChequeo(Chequeo check);
    public boolean deleteChequeoById(int id);
}