package m6.spring.fullstack.EjercicioGrupalM6Spring.modelo;

public class Administrativo extends Usuario{

    private int idAdmin;
    private String area;

    public Administrativo() {
        super();
        idAdmin = 0;
        area = "";
    }

    public Administrativo(int id, String nombre, String apellido, String correo, String rut, int idAdmin, String area) {
        super(id, nombre, apellido, correo, rut);
        this.idAdmin = idAdmin;
        this.area = area;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "idAdmin=" + idAdmin +
                ", area='" + area + '\'' +
                "} " + super.toString();
    }
}