package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Visita;

import java.util.ArrayList;

public interface IVisitaDao {
    public ArrayList<Visita> getVisitaList();
    public Visita getVisitaById(int id);
    public boolean updateVisita(Visita vis);
    public boolean deleteVisitaById(int id);
    public boolean addVisita(Visita vis);
}