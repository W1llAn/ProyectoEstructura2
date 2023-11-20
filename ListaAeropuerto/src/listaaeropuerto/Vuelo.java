package listaaeropuerto;

import java.util.ArrayList;
import java.util.Date;

public class Vuelo {
    private String nombreEmpresaAvion;
    private String destino;
    private Date fecha;
    public String horaSalida;
    private int cantidadAsientosNoReservados;
    private String estado;
    Asientos[] totalAsientos;

    private int contadorAsientos;

    public Vuelo() {

    }

    public Vuelo(String nombreEmpresaAvion, String destino, Date fecha, String horaSalida,
            int cantidadAsientosNoReservados, String estado) {
        this.nombreEmpresaAvion = nombreEmpresaAvion;
        this.destino = destino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.cantidadAsientosNoReservados = cantidadAsientosNoReservados;
        this.totalAsientos = new Asientos[cantidadAsientosNoReservados];
        this.estado = estado;
        this.contadorAsientos = 0;
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

    public int getCantidadAsientosNoReservados() {
        return this.cantidadAsientosNoReservados;
    }
    public int getCantidadAsientosReservados(){
        int asientosReservados=0;
        for (int i =0;i<this.totalAsientos.length;i++) {
            if (this.totalAsientos[i].getPasajero()!=null) {
                asientosReservados++;
            }
        }
        return asientosReservados;
    }

    public Asientos[] getTotalAsientos(){
        return this.totalAsientos;
    }

    public void setCantidadAsientosNoReservados(int cantidadAsientosNoReservados) {
        this.cantidadAsientosNoReservados = cantidadAsientosNoReservados;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
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
                if (pasajero.getDestinoViaja().toUpperCase().equals(vuelo.getDestino().toUpperCase())&&vuelo.getEstado().equals("Disponible")) {
                    usuarioAtendido = asignarAsientoPasajero(pasajero, vuelo, vuelos);
                }
            }
        }
        return usuarioAtendido;
    }

    private boolean puedeAsignarAsiento(Pasajero pasajero, Vuelo vuelo) {
        return totalAsientos != null && vuelo.contadorAsientos >= 0 && vuelo.contadorAsientos < vuelo.totalAsientos.length;
    }
    private boolean verificarAvionDisponible(Vuelo vuelo){
        return (vuelo.getEstado().equals("Disponible"));
    }
    private boolean verificarPasajeroAsignado(Pasajero pasajeros){
        return (pasajeros.getEstado().equals("Sin Asignar"));
    }
    public boolean asignarAsientoPasajero(Pasajero pasajeros, Vuelo vuelos, ArrayList<Vuelo> listaVuelos) {
        if (this.puedeAsignarAsiento(pasajeros, vuelos) && !(this.evitarDobleAsignacion(vuelos.totalAsientos, pasajeros))
                && verificarAvionDisponible(vuelos) && verificarPasajeroAsignado(pasajeros)) {
            vuelos.totalAsientos[vuelos.contadorAsientos].setPasajero(pasajeros);
            vuelos.setCantidadAsientosNoReservados(vuelos.getCantidadAsientosNoReservados() - 1);
            pasajeros.setEstado("Asignado");
            this.imprimirDetallerAsientosPasajeros(pasajeros, vuelos);
            vuelos.contadorAsientos++;
            if (vuelos.getCantidadAsientosNoReservados()==0) {
                vuelos.setEstado("Lleno");
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean evitarDobleAsignacion(Asientos[] totalAsientosAvion, Pasajero pasajeros) {
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
            if (nombreEmpresa.equals(vuelo.getNombreEmpresaAvion())) {
                vuelo.setEstado("Despegado");
                return true;
            }
        }
        return false;
    }

    public boolean DetalleVueloDespegado(ArrayList<Vuelo> vuelos) {
        boolean verificar = false;
        if (vuelos != null) {
            for (Vuelo vuelo : vuelos) {
                if (vuelo.getEstado().equals("Despegado")) {
                    for (int i = 0; i < vuelo.totalAsientos.length; i++) {
                        Pasajero pasajeroActual = vuelo.totalAsientos[i].getPasajero();
                        if (pasajeroActual != null) {
                           this.imprimirDetallePasajerosAvion(pasajeroActual, vuelo);
                            verificar = true;
                        }
                    }
                }
            }
        }
        return verificar;
    }
        private void imprimirDetallerAsientosPasajeros(Pasajero pasajeros, Vuelo vuelos){
            System.out.println("\n");
            System.out.println("Pasajero " + pasajeros.getNombres() + " asignado al asiento "
                    + (vuelos.contadorAsientos + 1) + " del vuelo a: " + vuelos.getDestino()+" En la empresa: "+ vuelos.getNombreEmpresaAvion());
        }

        private void imprimirDetallePasajerosAvion(Pasajero pasajeros, Vuelo vuelos){
             System.out.println("Pasajero: " + pasajeros.getNombres()+" "+ pasajeros.getApellidos()+" Volando con destino a: "+pasajeros.getDestinoViaja()
             + " En el vuelo de la empresa: "+ vuelos.getNombreEmpresaAvion());
        }
        
}
