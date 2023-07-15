package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

public class Profesional extends Usuario{

    private int idProfes;
    private String telefono, cargo;

    public Profesional() {
        super();
        idProfes = 0;
        telefono = cargo = "";
    }

    public Profesional(int id, String nombre,  String apellido, String correo, String rut, int idProfes,
                       String telefono, String cargo) {
        super(id, nombre, apellido, correo, rut);
        this.idProfes = idProfes;
        this.cargo = cargo;
        this.telefono = telefono;
    }

    public int getIdProfes() {
        return idProfes;
    }

    public void setIdProfes(int idProfes) {
        this.idProfes = idProfes;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "idProfes=" + idProfes +
                ", telefono='" + telefono + '\'' +
                ", cargo='" + cargo + '\'' +
                "} " + super.toString();
    }
}