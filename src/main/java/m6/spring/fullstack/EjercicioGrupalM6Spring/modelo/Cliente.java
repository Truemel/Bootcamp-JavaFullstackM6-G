package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

public class Cliente extends Usuario{

    private int idCliente, idCapac;
    private String telefono, direccion;
    private short edad;

    public Cliente() {
        super();
        idCliente = idCapac = 0;
        edad = 0;
        telefono = direccion = "";
    }

    public Cliente(int id, String nombre, String apellido, String correo, String rut, int idCliente, short edad,
                   String telefono, String direccion, int idCapac) {
        super(id, nombre, apellido, correo, rut);
        this.idCliente = idCliente;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idCapac = idCapac;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public int getIdCapac() {
        return idCapac;
    }

    public void setIdCapac(int idCapac) {
        this.idCapac = idCapac;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", idCapac=" + idCapac +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                "} " + super.toString();
    }
}