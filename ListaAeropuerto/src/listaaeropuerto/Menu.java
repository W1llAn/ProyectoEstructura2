package listaaeropuerto;

import java.util.Date;

public class Menu {
    public Teclado tec = new Teclado();
    Controles control = new Controles();
    GestionDeListas gestionListas = new GestionDeListas();
    Vuelo gestionVuelos=new Vuelo();
    public void menu() {
        int op;
        do {
            Opciones();
            op = control.controlarValorOpcion();
            switch (op) {
                case 1:
                control.espacios();
                    do {
                        subMenuRegistros();
                        op = control.controlarValorOpcion();
                        switch (op) {
                            case 1:
                            control.espacios();
                                registroListaEsperaPasajeros();
                                break;
                            case 2:
                            control.espacios();
                                crearVuelos();
                                break;
                            default:
                                break;
                        }
                    } while (op != 3);
                    control.espacios();
                    break;
                case 2:
                int opcion2;
                    do { 
                        subMenuListaEspera();
                        opcion2 = control.controlarValorOpcion();
                        switch (opcion2) {
                            case 1:
                                System.out.println("-----Asignacion de pasajeros----");
                                if(gestionVuelos.atenderListaEspera(gestionListas.getlistaEspera(), gestionListas.getListaVuelos()))
                                    System.out.println("Lista de espera Atendida con exito!");        
                                break;
                            case 2:
                                System.out.println("----Estado de aviones----");
                                gestionListas.imprimirNombresYEstadosAvion();
                                String nombreEmpresa=control.Palabras("Ingrese el nombre del la empresa para dar salida al avion ");
                                if (gestionVuelos.estadoDelAvion(nombreEmpresa, gestionListas.getListaVuelos())) {
                                    System.out.println("Estado del avion cambiado");
                                }else{
                                    System.out.println("No se cambio el estado del avion");
                                }
                                break;
                                case 3:
                                System.out.println("--------DETALLE LISTA DE PASAJEROS EN VUELOS DESPEGADOS--------");
                                if(!(gestionVuelos.DetalleVueloDespegado(gestionListas.getListaVuelos())))
                                    System.out.println("Nada que mostrar en el sistema");
                                break;
                            default:
                                break;
                        }
                    } while (opcion2 != 4);
                    control.espacios();
                    break;
                case 3:
                control.espacios();
                    System.out.println("Reportes");
                    System.out.println("1) Lista de pasajeros por vuelo\n2) Estadistica Destinos Concurridos\n3) Estadisticas de destinos en lista de espera");
                     op = control.controlarValorOpcion();
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
       
    }

    public void subMenuRegistros() {
        System.out.println("   REGISTRO  ");
    System.out.println("1)Pasajeros\n2)Crear Vuelo\n3)Salir");
    
    }

    public void registroListaEsperaPasajeros() {
        System.out.println("  Registro en lista de espera ");
        Pasajero pa = new Pasajero();
        pa.setCedula(control.ControlCedula("Número de Cédula: ",gestionListas));
        pa.setApellidos(control.controlDosPalabras("Apellidos:"));
        pa.setNombres(control.controlDosPalabras("Nombres:"));
        pa.setTelefono(control.ControlNumrs("Teléfono:"));
        pa.setDestinoViaja(control.Palabras("Destino al que viaja: "));
        pa.setEstado("Sin Asignar");
        gestionListas.agregarPasajerosLista(pa);
        gestionListas.agregarPasajerosPerm(pa);
        System.out.println("\n*****Registro Exitoso*****\n");
    }

    public void crearVuelos() {
        System.out.println("*************Registro de vuelos*****************");
        String compania = control.PalabrasYVverificarAvion("Nombre de la compañia: ",gestionListas);
        String destino = control.Palabras("Destino: ");
        Date fecha = control.ingresoFechaVuelo();
        String horaSalida = control.pedirHoraYMinutos();
        int cantidadAsientosNoReservados = control.contolNumerosAsientosDisponibles("Cantidad de espacios no reservados: ");
        System.out.println("\n*****Registro de vuelo exitoso*****\n");
        Vuelo vuelo = new Vuelo(compania.toUpperCase(),destino.toUpperCase(), fecha, horaSalida, cantidadAsientosNoReservados,"Disponible");
        gestionListas.agregarAListaVuelo(vuelo);
        gestionVuelos = vuelo; 
    }
    
    
    
    public void OpcionesReportes(int op){
        Reportes reportes = new Reportes();
        switch (op) {
            case 1:
                reportes.imprimirlistaPasajerosVuelo(gestionListas.getListaPasajerosPerm(), gestionListas.getListaVuelos());
            break;
            case 2:
                reportes.estadisticaCantPersonasDestinos(gestionListas.getListaPasajerosPerm(), gestionListas.getListaVuelos());
            break;
            case 3:
                reportes.estadisticaCantPersonasDestinosListaEspera(gestionListas.getListaVuelos(), gestionListas.getlistaEspera());
            break;
        
            default:
            System.out.println("Opcion inválida");
            break;
        }
    }
    public void subMenuListaEspera(){
        System.out.println("******************LISTA DE ESPERA***********");
        System.out.println("----LISTA PASAJEROS----");
        gestionListas.quitarPasajerosListaEspera();
        gestionListas.imprimirListaEspera();
        System.out.println("----LISTA DE VUELOS----");
        gestionListas.imprimirVuelos();
        System.out.println("\n");
        System.out.println("1)Atender Lista de espera\n2) Dar Salida al avion\n3) Detalle Vuelos Despegados\n4) Salir");
        
    }
    


}
