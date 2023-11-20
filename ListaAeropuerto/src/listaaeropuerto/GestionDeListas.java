package listaaeropuerto;

import java.util.ArrayList;


public class GestionDeListas {
    private ArrayList<Pasajero> listaEspera= new ArrayList<>();
    private ArrayList <Vuelo> listaVuelos= new ArrayList<>();
    private ArrayList<Pasajero> listaPasajerosPermanentes= new ArrayList<>();
    
    public ArrayList<Pasajero> getlistaEspera() {
        return listaEspera;
    }
    public void agregarPasajerosLista(Pasajero pasajeros) {
        this.getlistaEspera().add(pasajeros);
    }

    public ArrayList<Pasajero> getListaPasajerosPerm() {
        return listaPasajerosPermanentes;
    }
    public void agregarPasajerosPerm(Pasajero listaPasajerosPermanentes) {
        this.getListaPasajerosPerm().add(listaPasajerosPermanentes);
    }
    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }
     public void agregarAListaVuelo(Vuelo vuelos) {
        this.getListaVuelos().add(vuelos);
    }
    public void imprimirVuelos(){
        for (Vuelo vuelos : this.getListaVuelos()) {
            System.out.println("-------------------------------------");
            System.out.println("Destino de vuelo: "+ vuelos.getDestino());
            System.out.println("Fecha de salida: "+vuelos.getFecha());
            System.out.println("Hora de salida: "+vuelos.getHoraSalida());
            System.out.println("Espacios disponibles: "+vuelos.getCantidadAsientosNoReservados());
            System.out.println("Estado: "+vuelos.getEstado());
        }
    }
    public void imprimirListaEspera(){
        for(Pasajero listaespera : this.getlistaEspera()){
        System.out.println("Cedula: "+listaespera.getCedula()+ ":  "+
                            listaespera.getNombres()+" "+listaespera.getApellidos()+" Destino: "+listaespera.getDestinoViaja()+"  "+listaespera.getEstado());
        }
    }

    public void imprimirNombresYEstadosAvion(){
        for (Vuelo listaVuelos : this.getListaVuelos()) {
            System.out.println("Empresa: "+listaVuelos.getNombreEmpresaAvion()+" Estado: "+ listaVuelos.getEstado());
        }
    }

    public boolean quitarPasajerosListaEspera() {
        boolean eliminado = false;
        for (int i = this.getlistaEspera().size() - 1; i >= 0; i--) {
            if (this.getlistaEspera().get(i).getEstado().equals("Asignado")) {
                this.getlistaEspera().remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }
    

}
