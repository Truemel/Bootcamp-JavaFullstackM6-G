package m6.spring.fullstack.EjercicioGrupalM6Spring.dao;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;

import java.util.ArrayList;

public class CapacitacionDao implements ICapacitacionDao{

    private ArrayList<Capacitacion> lista = new ArrayList<Capacitacion>();

    public CapacitacionDao(){
        lista.add(new Capacitacion(1, "Nombre1", "Detalle1"));
        lista.add(new Capacitacion(2, "Nombre2", "Detalle2"));
        lista.add(new Capacitacion(3, "Nombre3", "Detalle3"));
    }
    @Override
    public ArrayList<Capacitacion> obtenerCapacitaciones() {
        return lista;
    }

    @Override
    public boolean crearCapacitacion(Capacitacion capa) {
        try {
            lista.add(capa);
            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }
}
