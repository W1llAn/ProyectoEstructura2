package listaaeropuerto;
import java.util.ArrayList;

public class Vuelo {
    private String nombreEmpresaAvion;
    private String destino;
    private String fecha;
    public String horaSalida;
    private int cantidadAsientosNoReservados;
    private String estado;
    Asientos[] totalAsientos;
  
    private int contadorAsientos;
public Vuelo(){

}
    public Vuelo(String nombreEmpresaAvion,String destino, String fecha, String horaSalida,int cantidadAsientosNoReservados, String estado) {
        this.nombreEmpresaAvion = nombreEmpresaAvion;
        this.destino = destino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.cantidadAsientosNoReservados=cantidadAsientosNoReservados; 
        this.totalAsientos = new Asientos[cantidadAsientosNoReservados];
        this.estado = estado;
        this.contadorAsientos=0;
        for (int i = 0; i < cantidadAsientosNoReservados; i++) {
            totalAsientos[i] = new Asientos();
        }
    }
    public String getNombreEmpresaAvion() {
        return this.nombreEmpresaAvion;
    }

    public void setNombreEmpresaAvion(String nombreEmpresaAvion) {
        this.nombreEmpresaAvion = nombreEmpresaAvion;
    }
    
    public int getCantidadAsientosNoReservados(){
        return this.cantidadAsientosNoReservados;

    }
    public void setCantidadAsientosNoReservados(int cantidadAsientosNoReservados){
        this.cantidadAsientosNoReservados=cantidadAsientosNoReservados;
    }
    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraSalida() {
        return this.horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean atenderListaEspera(ArrayList<Pasajero> pasajeros, ArrayList<Vuelo> vuelos) {
        boolean usuarioAtendido = false;
        for (Pasajero pasajero : pasajeros) {
            for (Vuelo vuelo : vuelos) {
                System.out.println(pasajero.getDestinoViaja());
                System.out.println(vuelo.getDestino());
                if (pasajero.getDestinoViaja().toUpperCase().equals(vuelo.getDestino().toUpperCase())) {
                    usuarioAtendido = asignarAsientoPasajero(pasajero,vuelo,vuelos);       
                }
            }
        }
    
        return usuarioAtendido;
    }
    
    public boolean asignarAsientoPasajero(Pasajero pasajeros,Vuelo vuelos,ArrayList<Vuelo> listaVuelos){
        if (this.totalAsientos != null && contadorAsientos >= 0 && contadorAsientos < this.totalAsientos.length&&!(this.evitarDobleAsignacion(this.totalAsientos, pasajeros))&&!(vuelos.getEstado().equals("Despegado"))) {
            this.totalAsientos[contadorAsientos].setPasajero(pasajeros);
            vuelos.setCantidadAsientosNoReservados(vuelos.getCantidadAsientosNoReservados()-1);
            System.out.println("Pasajero " + pasajeros.getNombres() + " asignado al asiento " + (vuelos.contadorAsientos+1)+" del vuelo a: " +vuelos.getDestino() );
            
            contadorAsientos++;
            return true;
        } else {
         System.out.println("Capacidad del avion al maximo!");

            return false;
        }
    }
    public boolean darSalidaAvion(){
        return false;
    }
  public boolean evitarDobleAsignacion(Asientos[] totalAsientosAvion, Pasajero pasajeros) {
    System.out.println("/////////////////////////////////"+totalAsientosAvion.length);
    for (int i = 0; i < totalAsientosAvion.length; i++) {
        Pasajero pasajeroActual = totalAsientosAvion[i].getPasajero();
        if (pasajeroActual != null && pasajeroActual.getCedula().equals(pasajeros.getCedula())) {
            return true;
        }
    }
    return false;
}
public boolean estadoDelAvion(String nombreEmpresa, ArrayList<Vuelo> vuelos) {
    for (Vuelo vuelo : vuelos) {
        if (nombreEmpresa.equals(vuelo.getNombreEmpresaAvion())||vuelo.cantidadAsientosNoReservados==0) {
            vuelo.setEstado("Despegado");
            for (int i = 0; i < vuelo.totalAsientos.length; i++) {
                Pasajero pasajeroActual = vuelo.totalAsientos[i].getPasajero();
                if (pasajeroActual != null) {
                    System.out.println("Nombre: " + pasajeroActual.getNombres());
                }
            }
            return true;
        }
    }
    return false;
}

}
