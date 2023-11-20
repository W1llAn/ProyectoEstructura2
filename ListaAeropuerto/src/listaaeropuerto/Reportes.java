package listaaeropuerto;

import java.util.ArrayList;
import java.util.HashMap;

public class Reportes {
    public void imprimirlistaPasajerosVuelo(ArrayList<Pasajero> pasajeros,ArrayList<Vuelo> vuelos){
        System.out.println("--------------------Vuelos-------------------------");
        for (Vuelo vuelo : vuelos) {
            System.out.println("Destino: "+vuelo.getDestino());
            for (Asientos asiento : vuelo.getTotalAsientos()) {
                if (asiento.getPasajero()!=null) {
                    System.out.println("-"+asiento.getPasajero().getNombres()+" "+asiento.getPasajero().getApellidos());
                }else{
                    System.out.println("-");
                }
            }
        }
    }

    public void estadisticaCantPersonasDestinos(ArrayList<Pasajero> pasajeros,ArrayList<Vuelo> vuelos){
        System.out.println("Lista de Destinos Concurridos");
         HashMap<String, Integer> conteoDestinos = new HashMap<>();
            double porcentaje=0;
            int cantidadPersonasDespegue=0;
            for (Vuelo vuelo : vuelos) {
                if (vuelo.getEstado().equals("Despegado")) {
                    if (conteoDestinos.containsKey(vuelo.getDestino()))  {
                        conteoDestinos.put(vuelo.getDestino(), conteoDestinos.get(vuelo.getDestino())+vuelo.getCantidadAsientosReservados());   
                        cantidadPersonasDespegue+=vuelo.getCantidadAsientosReservados();
                    }
                    else{
                        conteoDestinos.put(vuelo.getDestino(),vuelo.getCantidadAsientosReservados());   
                        cantidadPersonasDespegue+=vuelo.getCantidadAsientosReservados();
                    }   
                }                      
            }   
            for (String destino : conteoDestinos.keySet()) {
                int destinoRep = conteoDestinos.get(destino);
                porcentaje = (destinoRep*100)/cantidadPersonasDespegue;
                this.imprimirEstadisticaCantPersonasDestinos(destino, destinoRep, porcentaje);
            }
    }


    private void imprimirEstadisticaCantPersonasDestinos(String destino,int cantPasajeros,double porcentaje){
        System.out.println("Destino: "+destino+" : "+cantPasajeros+" ----> "+porcentaje+"%"); 
    }


    public void estadisticaCantPersonasDestinosListaEspera(ArrayList<Vuelo> vuelos,ArrayList<Pasajero> pasajeros){
        System.out.println("Lista actual de espera:");
         HashMap<String, Integer> conteoDestinos = new HashMap<>();
            double porcentaje=0;
            for (Pasajero pasajero : pasajeros) {
                if (conteoDestinos.containsKey(pasajero.getDestinoViaja())) {
                    conteoDestinos.put(pasajero.getDestinoViaja(), conteoDestinos.get(pasajero.getDestinoViaja())+1);   
                }
                else{
                    conteoDestinos.put(pasajero.getDestinoViaja(),1);   
                }                    
            }
            for (String destino : conteoDestinos.keySet()) {
                int destinoRep = conteoDestinos.get(destino);
                porcentaje = (destinoRep*100)/pasajeros.size();
                this.imprimirEstadisticaCantPersonasDestinos(destino, destinoRep, porcentaje);
            }
    }
}
