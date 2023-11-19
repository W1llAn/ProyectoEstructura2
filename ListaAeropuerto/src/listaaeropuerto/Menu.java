package listaaeropuerto;

public class Menu {
    public Teclado tec = new Teclado();
    Controles control = new Controles();
    Almacen almacen = new Almacen();
    Vuelo gestionVuelos=new Vuelo();
    public void menu() {
        int op;
        do {
            Opciones();
            op = tec.Tec().nextInt();

            switch (op) {
                case 1:
                    do {
                        subMenuRegistros();
                        op = tec.Tec().nextInt();
                        switch (op) {
                            case 1:
                                registroListaEsperaPasajeros();
                                break;
                            case 2:
                                crearVuelos();
                                break;
                            default:
                                break;
                        }
                    } while (op != 3);
                    control.espacios();
                    break;
                case 2:
                    do {
                        subMenuListaEspera();
                        op = tec.Tec().nextInt();
                        switch (op) {
                            case 1:
                                System.out.println("-----Asignacion de pasajeros----");
                                gestionVuelos.atenderListaEspera(almacen.getlistaEspera(), almacen.getListaVuelos());                
                                break;
                            case 2:
                                System.out.println("----Estado de aviones----");
                                almacen.imprimirNombresYEstadosAvion();
                                String nombreEmpresa=control.Palabras("Ingrese el nombre del la empresa para dar salida al avion; ");
                                if (gestionVuelos.estadoDelAvion(nombreEmpresa, almacen.getListaVuelos())) {
                                    System.out.println("Estado del vuelo cambiado");
                                }else{
                                    System.out.println("No se cambio el estado del vuelo por que ya despego");
                                }
                                break;
                            default:
                                break;
                        }
                    } while (op != 3);

                break;
                case 3:
                    System.out.println("Reportes");
                    System.out.println("1) Lista de pasajeros por vuelo\n2) Cantidad de personas por destino\n 3) Estadisticas de cantidad de personas por destino");
                    System.out.print("Opcion: ");
                     op = tec.Tec().nextInt();
                     this.OpcionesReportes(op);
                    break;
                case 4:
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
        System.out.println("     L I S T A  D E  E S P E R A    ");
        System.out.println("1)Registro\n2)Gestion Vuelos\n3)Estadisticas\n4)Salir");
        System.out.print("Opción:");
    }

    public void subMenuRegistros() {
        System.out.println("   REGISTRO  ");
    System.out.println("1)Pasajeros\n2)Crear Vuelo\n3)Salir");
        System.out.print("Opción:");
    }

    public void registroListaEsperaPasajeros() {
        System.out.println("  Registro en lista de espera ");
        Pasajero pa = new Pasajero();
        pa.setCedula(control.ControlCedula("Número de Cédula: "));
        pa.setApellidos(control.controlDosPalbras("apellidos:"));
        pa.setNombres(control.controlDosPalbras("nombres:"));
        pa.setTelefono(control.ControlNumrs("Teléfono:"));
        pa.setDestinoViaja(control.Palabras("Destino al que viaja: "));
        almacen.agregarPasajerosLista(pa);
        almacen.agregarPasajerosPerm(pa);
        System.out.println("\n*****Registro Exitoso*****\n");
    }

    public void crearVuelos() {
        System.out.println("Registro de vuelos");
        System.out.print("Nombre de la compañia: ");
        String compania = tec.Tec().next();
        System.out.print("Destino: ");
        String destino = tec.Tec().next();
        System.out.print("Fecha de salida: ");
        String fecha = tec.Tec().next();
        System.out.print("Hora de salida: ");
        String horaSalida = tec.Tec().next();
        System.out.print("Cantidad de espacios no reservados: ");
        int cantidadAsientosNoReservados = tec.Tec().nextInt();
        Vuelo vuelo = new Vuelo(compania,destino, fecha, horaSalida, cantidadAsientosNoReservados,"Disponible");
        almacen.agregarAListaVuelo(vuelo);
        gestionVuelos = vuelo; 
    }
    
    
    
    public void OpcionesReportes(int op){
        Reportes reportes = new Reportes();
        switch (op) {
            case 1:
                reportes.listaPasajerosVuelo(almacen.getlistaEspera(), almacen.getListaVuelos());
            break;
            case 2:
                reportes.cantPersonasDestinos(almacen.getListaPasajerosPerm(), almacen.getListaVuelos());
            break;
            case 3:
                reportes.cantPersonasDestinosListaEspera(almacen.getListaVuelos(), almacen.getListaPasajerosPerm());
            break;
        
            default:
            System.out.println("Opcion inválida");
            break;
        }
    }
    public void subMenuListaEspera(){
        System.out.println("******************LISTA DE ESPERA***********");
        System.out.println("----LISTA PASAJEROS----");
        almacen.imprimirListaEspera();
        System.out.println("----LISTA DE VUELOS DISPONIBLES----");
        almacen.imprimirVuelos();
        System.out.println("1)Atender Lista de espera\n2) Dar Salida al avion\n3) Salir");
        

    }
    


}
