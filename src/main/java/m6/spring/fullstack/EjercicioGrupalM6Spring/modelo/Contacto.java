package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

public class Contacto {

    private String nombre, email, mensaje;

    public Contacto(){
        nombre = email = mensaje = "";
    }

    public Contacto(String nombre, String email, String mensaje){
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}