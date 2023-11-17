package listaaeropuerto;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Pasajero> e= new ArrayList<>();
    private ArrayList <Vuelo> vuelos= new ArrayList<>();
    private ArrayList<Pasajero> listaPasajerosPermanentes= new ArrayList<>();
    
    public ArrayList<Pasajero> getE() {
        return e;
    }
    public void agregarPasajeros(Pasajero e) {
        this.getE().add(e);
    }

    public ArrayList<Pasajero> getListaPasajerosPerm() {
        return listaPasajerosPermanentes;
    }
    public void agregarPasajerosPerm(Pasajero listaPasajerosPermanentes) {
        this.getE().add(listaPasajerosPermanentes);
    }
    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }
     public void agregarVuelo(Vuelo vuelos) {
        this.getVuelos().add(vuelos);
    }
    
}
