package listaaeropuerto;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Controles {
    Teclado tec = new Teclado();

    public void espacios() {
        for (int i = 0; i < 12; i++) {
            System.out.println("");
        }
    }

    public String ControlCedula(String mensaje, GestionDeListas almacen) {
        String cedula, patron;
        patron = "^[0-9]{10}$";
        boolean aux = false;

        do {
            System.out.print(mensaje);
            cedula = tec.Tec().next();

            if (cedula.matches(patron)) {
                if (!verificarCedulaExistente(cedula, almacen)) {

                    int primerosdos = Integer.parseInt(cedula.substring(0, 2));

                    if (primerosdos >= 1 && primerosdos <= 24) {
                        String nueveprimeros = cedula.substring(0, 9);
                        String digitosImpares = "";
                        String digitosPares = "";

                        for (int i = 0; i < nueveprimeros.length(); i++) {
                            char digito = nueveprimeros.charAt(i);
                            if (i % 2 == 0) {
                                digitosImpares += digito;
                            } else {
                                digitosPares += digito;
                            }
                        }

                        int sumaImpares = 0;
                        for (int i = 0; i < digitosImpares.length(); i++) {
                            int digitoImpar = Character.getNumericValue(digitosImpares.charAt(i));
                            int resultado = digitoImpar * 2;
                            if (resultado > 9) {
                                resultado -= 9;
                            }
                            sumaImpares += resultado;
                        }

                        int sumaPares = 0;
                        for (int i = 0; i < digitosPares.length(); i++) {
                            int digitoPar = Character.getNumericValue(digitosPares.charAt(i));
                            sumaPares += digitoPar;
                        }

                        int sumaTotal = sumaPares + sumaImpares;
                        int ultimoDigito = sumaTotal % 10;
                        int numeroFinal = 10 - ultimoDigito;
                        String ultimoDigitoCedula = cedula.substring(9);

                        if (numeroFinal == Integer.parseInt(ultimoDigitoCedula)) {
                            aux = true;
                        } else {
                            System.out.println("Cédula incorrecta");
                        }
                    } else {
                        System.out.println("Cédula incorrecta");
                    }
                } else {
                    System.out.println("La cédula " + cedula + " ya se encuentra registrada en el sistema");
                }

            } else {
                System.out.println("Cédula incorrecta (Contiene 10 números)");
            }
        } while (!aux);

        return cedula;
    }

    public String controlDosPalabras(String mensaje) {
        boolean control;
        String patron = "^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+\\s[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+$";
        String NombresApellidos;
        do {
            System.out.print("Ingrese sus dos " + mensaje);
            NombresApellidos = tec.Tec().nextLine();
            if (!(NombresApellidos.matches(patron))) {
                control = false;
            } else {
                String[] palabras = NombresApellidos.split(" ");
                if (palabras.length != 2) {
                    control = false;
                } else {
                    control = true;
                }
            }
        } while (control == false);

        // comprobamos si tiene dos palabras
        return NombresApellidos.toUpperCase();
    }

    public String Palabras(String opcion) {
        String patron, palabra;
        patron = "^[a-zA-Z\\s]+$";
        do {
            System.out.print(opcion);
            palabra = tec.Tec().next();
            if (!(palabra.matches(patron))) {
                System.out.println("Ingreso solo letras.");
            }
        } while (!(palabra.matches(patron)));
        return palabra.toUpperCase();
    }
    public String PalabrasYVverificarAvion(String mensaje,GestionDeListas listaVuelos) {
        boolean aux = false;
        String patron, palabra;
        patron = "^[a-zA-Z\\s]+$";
        do {
            System.out.print(mensaje);
            palabra = tec.Tec().next();
            if (!(this.verificarAvionExistente(palabra, listaVuelos))) {
                if ((palabra.matches(patron))) {
                    aux= true;
            }
            }
            
        } while (!aux);
        return palabra.toUpperCase();
    }

    public int ControlNumrs(String mensaje) {
        String patron, num;
        patron = "^[0-9]+$";
        do {
            System.out.print(mensaje);
            num = tec.Tec().next();
            if (!num.matches(patron) || num.length() != 10) {
                System.out.println("Por favor, ingrese solamente 10 números.");
            }
        } while (!num.matches(patron) || num.length() != 10);
        return Integer.parseInt(num);
    }

    public boolean verificarCedulaExistente(String cedula, GestionDeListas almacen) {
        for (int i = 0; i < almacen.getListaPasajerosPerm().size(); i++) {
            if (cedula.equals(almacen.getListaPasajerosPerm().get(i).getCedula())) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarAvionExistente(String nombreAvion, GestionDeListas listaVuelos){
        System.out.println("+++++++++++++++++++"+listaVuelos.getListaVuelos().size());
        for (int i = 0; i < listaVuelos.getListaVuelos().size(); i++) {
            if (nombreAvion.equals(listaVuelos.getListaVuelos().get(i).getNombreEmpresaAvion())) {
                return true;
            }
        }
        return false;

    }
    public Date ingresoFechaVuelo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String inputDate;
        Date fecha = null;
        // Bucle hasta que se ingrese una fecha válida
        while (fecha == null) {
            System.out.print("Ingrese la fecha de salida (formato dd/MM/yyyy): ");
            inputDate = tec.Tec().nextLine();

            try {
                fecha = dateFormat.parse(inputDate);
                if (fecha.before(new Date())) {
                    System.out.println("La fecha del vuelo no puede estar en el pasado.");
                    fecha = null; // Reiniciar para volver a solicitar la fecha
                }
            } catch (ParseException e) {
                System.out.println("Fecha no válida. Intente nuevamente.");
            }
        }

        return fecha;
    }
    public String pedirHoraYMinutos() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String hora;
        Date horaDate = null;

        do {
            System.out.print("Hora de salida (formato HH:mm): ");
            hora = tec.Tec().nextLine();

            try {
                horaDate = formatoHora.parse(hora);
            } catch (ParseException e) {
                System.out.println("Formato de hora inválido. Intente nuevamente.");
            }

        } while (horaDate == null);
        return formatoHora.format(horaDate);
    }
     public int contolNumerosAsientosDisponibles(String mensaje) {
        String patron, num;
        patron = "^[0-9]+$";
        do {
            System.out.print(mensaje);
            num = tec.Tec().next();
        } while (!num.matches(patron) );
        return Integer.parseInt(num);
    }
    public int controlarValorOpcion() {
        String patron,opcion;
        patron = "^[0-9]+$";
        do {
            System.out.print("Opcion: ");
            opcion= tec.Tec().next();
        } while (!opcion.matches(patron) );
        return Integer.parseInt(opcion);
    }

}
