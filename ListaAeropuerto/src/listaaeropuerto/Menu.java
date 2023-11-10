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
                    System.out.println("HOLAAAAAAAAA");
                    break;
                case 3:
            for(int i=0; i<almacen.getE().size(); i++){
                System.out.println(almacen.getE().get(i).getNombres());
            }
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
        System.out.println("     L I S T A  D E  E S P E R A");
        System.out.println("1)Registro\n2)Lista de espera\n3)Estadisticas\n4)Salir");
        System.out.print("Opción:");
    }

    public void subMenu() {
        System.out.println("   REGISTRO  ");
        System.out.println("1)Pasajeros\n2)Vuelos\n3)Salir");
        System.out.print("Opción:");
    }

    public void listaEsperaPasajeros() {
        System.out.println("  Registro en lista de espera ");
        System.out.print("Número de Cédula: ");
        pa.setCedula(tec.Tec().next());
        System.out.print("Apellidos: ");
        pa.setApellidos(tec.Tec().nextLine());
        System.out.print("Nombres: ");
        pa.setNombres(tec.Tec().nextLine());
        System.out.print("Dirección: ");
        pa.setDireccion(tec.Tec().nextLine());
        System.out.print("Teléfono: ");
        pa.setTelefono(tec.Tec().nextInt());
        System.out.print("Destino al que viaja: ");
        pa.setDestinoViaja(tec.Tec().next());
        almacen.agregarPasajeros(pa);
        System.out.println("\n*****Registro Exitoso*****\n");
    }

    public void vuelos() {
        System.out.println(" Lista de Vuelos en Espera");
        System.out.print("Destino:"); vuelo.setDestino(tec.Tec().next());
        System.out.print("Fecha de salida:");vuelo.setFecha(tec.Tec().next());
        System.out.print("Hora de salida: ");vuelo.setHoraSalida(tec.Tec().next());
        System.out.print("Cantidad de espacios no reservados: ");vuelo.setCantidadAsientosNoRservados(tec.Tec().nextInt());
    }
}
