package carlossuquilanda.src;

import clases.Direccion;
import clases.MyExepcion;
import clases.MyScanner;
import clases.Persona;

public class Banco {
    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner();
        Persona persona = new Persona();
        Direccion direccion = new Direccion();
        System.out.println("****************************************************");
        System.out.println("**      BIENVENIDO AL BANCO NACIONAL DE ESPAÑA    **");
        System.out.println("****************************************************");
        String nombre = myScanner.pedirSoloTexto("Ingrese su nombre: ");
        String apellido = myScanner.pedirSoloTexto("Ingrese su apellido: ");
        int edad = myScanner.pedirNumero("Ingrese su edad: ");
        int dinero = myScanner.pedirNumero("Ingrese su dinero: ");
        System.out.println("😁 ENHORABUENA, SU PERFIL SE HA CREADO CORRECTAMENTE 😁 \n");
        Persona usuario = new Persona(nombre, apellido, edad, dinero);

        boolean continuar = true;
        while (continuar) {
            System.out.println("QUE QUIERE HACER AHORA: ");
            System.out.println("1. VER SALDO");
            System.out.println("2. INGRESAR DINERO");
            System.out.println("3. RETIRAR DINERO");
            System.out.println("4. SALIR");
            int opcion= myScanner.pedirNumero("--> OPCIÓN: ");

            switch (opcion) {

                case 1:
                    System.out.println("SU SALDO ACTUAL ES DE: " + dinero);
                    break;

                case 2:
                    int ingreso = myScanner.pedirNumero("¿CUANTO DINERO QUIERE INGRESAR?: ");
                    dinero =dinero + ingreso;
                    System.out.println("OPERACIÓN REALIZADA CORRECTAEMNTE");
                    break;

                case 3:
                    boolean error = false;
                    do {
                        try {
                            error = true;
                            int retirada = myScanner.pedirNumero("¿CUANTO DINERO QUIERE RETIRAR?: ");
                            if (dinero < retirada) {
                                throw new MyExepcion("ERROR. NO PUEDE RETIRAR MAS DINERO DEL QUE SU SALDO ACTUAL");
                            } else {
                                dinero = dinero - retirada;
                                System.out.println("OPERACIÓN REALIZADA CORRECTAEMNTE");
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("Por favor intentelo de nuevo");
                        }
                    }while (error);
                    break;

                case 4:
                    continuar = false;
                    break;

            }

            if (continuar) {
                System.out.println("\n --> PULSE ENTER PARA VOLVER AL MENU <--");
                new java.util.Scanner(System.in).nextLine();
            }

        }

    }
}
