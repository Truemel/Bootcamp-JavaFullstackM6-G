package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;

import java.util.ArrayList;

public interface ICapacitacionDao {
    public ArrayList<Capacitacion> obtenerCapacitaciones();
    public boolean crearCapacitacion(Capacitacion capa);
}
