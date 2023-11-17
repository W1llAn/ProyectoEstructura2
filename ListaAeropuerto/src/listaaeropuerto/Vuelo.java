package listaaeropuerto;

public class Vuelo {
    private String destino;
    private String fecha;
    public String horaSalida;
    private int cantidadAsientosNoReservados;
    Asientos[] totalAsientos = new Asientos[5];
  
    int contadorAsientos = 0;
public Vuelo(){

}
    public Vuelo(String destino, String fecha, String horaSalida,int cantidadAsientosNoReservados) {
        this.destino = destino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.cantidadAsientosNoReservados=cantidadAsientosNoReservados;
    }
    public int getCantidadAsientosNoReservados(){
        return this.cantidadAsientosNoReservados;

    }
    public void setCantidadAsientosNoRservados(int cantidadAsientosNoReservados){
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
    
}
