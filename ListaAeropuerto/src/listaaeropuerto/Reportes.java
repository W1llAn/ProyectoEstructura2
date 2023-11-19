package listaaeropuerto;

import java.util.ArrayList;

public class Reportes {
    public void listaPasajerosVuelo(ArrayList<Pasajero> pasajeros,ArrayList<Vuelo> vuelos){
        System.out.println("Vuelos:");
        for (Vuelo vuelo : vuelos) {
            System.out.println("Destino"+vuelo.getDestino());
            for (Pasajero pasajero : pasajeros) {
                if (pasajero.getDestinoViaja().equals(vuelo.getDestino())) {
                    System.out.println("-"+pasajero.getNombres()+" "+pasajero.getApellidos());
                }   
            }
        }

    }
    public void cantPersonasDestinos(ArrayList<Pasajero> pasajeros,ArrayList<Vuelo> vuelos){
        System.out.println("Vuelos:");
        for (Vuelo vuelo : vuelos) {
            int cantPasajeros=0;
            for (Pasajero pasajero : pasajeros) {
                if (pasajero.getDestinoViaja().equals(vuelo.getDestino())) {
                 cantPasajeros++;   
                }
            }
            System.out.println("Destino "+vuelo.getDestino()+" : "+cantPasajeros);  

        }
    }
    public void cantPersonasDestinosListaEspera(ArrayList<Vuelo> vuelos,ArrayList<Pasajero> pasajeros){
        System.out.println("Lista actual de espera:");
        for (Vuelo vuelo : vuelos) {
            int cantPasajeros=0;
            double porcentaje=0;
            for (Pasajero pasajero : pasajeros) {
                if (pasajero.getDestinoViaja().equals(vuelo.getDestino())) {
                 cantPasajeros++;   
                }      
                porcentaje = (cantPasajeros*100)/pasajeros.size(); 
            }
            System.out.println("Destino "+vuelo.getDestino()+" : "+porcentaje+"%"); 
        }
    }
}
