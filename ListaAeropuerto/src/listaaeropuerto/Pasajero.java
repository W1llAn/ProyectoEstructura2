package listaaeropuerto;

public class Pasajero {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int telefono;
    private String destinoViaja;

    public Pasajero() {
    }

    public Pasajero(String cedula, String nombres, String apellidos, String direccion, int telefono,
            String destinoViaja) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.destinoViaja = destinoViaja;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDestinoViaja() {
        return this.destinoViaja;
    }

    public void setDestinoViaja(String destinoViaja) {
        this.destinoViaja = destinoViaja;
    }
}
