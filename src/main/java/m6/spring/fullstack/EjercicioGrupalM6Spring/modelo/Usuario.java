package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

public class Usuario {

    public static enum Tipo {CLIENTE, ADMINISTRATIVO, PROFESIONAL};
    private int id;
    private String nombre, apellido, correo, rut;
    private Tipo tipo;

    public Usuario(){
        id = 0;
        nombre = apellido = correo = rut = "";
        tipo = Tipo.CLIENTE;
    }

    public Usuario(int id, String nombre, String apellido, String correo, String rut, Tipo tipo){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rut = rut;
        setTipo(tipo);
    }

    public Usuario(int id, String nombre, String apellido, String correo, String rut, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rut = rut;
        setTipo(tipo);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = Tipo.valueOf(tipo.toUpperCase());
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", rut='" + rut + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}