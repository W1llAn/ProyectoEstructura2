package listaaeropuerto;

public class Menu {
    public Teclado tec = new Teclado();
    Controles control = new Controles();
    Almacen almacen = new Almacen();
    Pasajero pa = new Pasajero();
    Vuelo vuelo= new Vuelo();
    
    public void menu() {
        int op;
        do {
            Opciones();
            op = tec.Tec().nextInt();

            switch (op) {
                case 1:
                    do {
                        subMenu();
                        op = tec.Tec().nextInt();
                        switch (op) {
                            case 1:
                                listaEsperaPasajeros();
                                break;
                            case 2:
                                vuelos();
                                break;
                            default:
                                break;
                        }
                    } while (op != 3);
                    control.espacios();
                    break;
                case 2:
                    System.out.println("Reportes");
                    System.out.println("1) Lista de pasajeros por vuelo\n2) Cantidad de personas por destino\n 3) Estadisticas de cantidad de personas por destino");
                    System.out.print("Opcion: ");
                     op = tec.Tec().nextInt();
                    break;
                case 3:
                control.espacios();
                    System.out.println("Gracias por utilizar nuestro sistema");
                    System.out.println("\"QUE TENGA UN EXCELENTE DIA\"\n\"Saludos\"");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
        } while (op != 4);
    }

    public void Opciones() {
        System.out.println("Aeropuerto Mariscal Sucre - ECUADOR ");
        System.out.println("     L I S T A  D E  E S P E R A");
        System.out.println("1)Registro\n2)Estadisticas\n3)Salir");
        System.out.print("Opción:");
    }

    public void subMenu() {
        System.out.println("   REGISTRO  ");
        System.out.println("1)Pasajeros\n2)Estadisticas\n3)Salir");
        System.out.print("Opción:");
    }

    public void listaEsperaPasajeros() {
        System.out.println("  Registro en lista de espera ");
        pa.setCedula(control.ControlCedula("Número de Cédula: "));
        pa.setApellidos(control.controlDosPalbras("apellidos:"));
        pa.setNombres(control.controlDosPalbras("nombres:"));
        pa.setTelefono(control.ControlNumrs("Teléfono:"));
        pa.setDestinoViaja(control.Palabras("Destino al que viaja: "));
        almacen.agregarPasajeros(pa);
        almacen.agregarPasajerosPerm(pa);
        System.out.println("\n*****Registro Exitoso*****\n");
    }

    public void vuelos() {
        System.out.println(" Lista de Vuelos en Espera");
        System.out.print("Destino:"); vuelo.setDestino(tec.Tec().next());
        System.out.print("Fecha de salida:");vuelo.setFecha(tec.Tec().next());
        System.out.print("Hora de salida: ");vuelo.setHoraSalida(tec.Tec().next());
        System.out.print("Cantidad de espacios no reservados: ");vuelo.setCantidadAsientosNoRservados(tec.Tec().nextInt());
        almacen.agregarVuelo(vuelo);
    }
    
    public void OpcionesRegistros(int op){
        Reportes reportes = new Reportes();
        switch (op) {
            case 1:
                reportes.listaPasajerosVuelo(almacen.getE(), almacen.getVuelos());
            break;
            case 2:
                reportes.cantPersonasDestinos(almacen.getListaPasajerosPerm(), almacen.getVuelos());
            break;
            case 3:
                reportes.cantPersonasDestinosListaEspera(almacen.getVuelos(), almacen.getListaPasajerosPerm());
            break;
        
            default:
            System.out.println("Opcion inválida");
            break;
        }
    }
    

}
