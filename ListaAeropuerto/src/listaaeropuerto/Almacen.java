package listaaeropuerto;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Pasajero> e= new ArrayList<>();

    public ArrayList<Pasajero> getE() {
        return e;
    }
    public void agregarPasajeros(Pasajero e) {
        this.getE().add(e);
    }
    
}
