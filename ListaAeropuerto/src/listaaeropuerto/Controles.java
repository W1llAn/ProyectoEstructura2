package listaaeropuerto;

import javax.swing.JOptionPane;

public class Controles {
    Teclado tec = new Teclado();

    public void espacios() {
        for (int i = 0; i < 12; i++) {
            System.out.println("");
        }
    }

    public String ControlCedula() {
        String cedula, patron;
        patron = "^[0-9]{10}$";
        boolean aux = false;

        do {

            cedula = tec.Tec().next();

            if (cedula.matches(patron)) {
                // if (gestor.VerificarCedula(cedula) == false) {

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
                System.out.println("Cédula incorrecta (Contiene 10 números)");
            }
        } while (!aux);

        return cedula;
    }

    public String controlDosPalbras(String mensaje) {
        boolean control ;
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
                }else{
                    control=true;
                }
            }
        } while (control==false);

        // comprobamos si tiene dos palabras
        return NombresApellidos;
    }
}
