package proyectos_practicos;

import exception.SacarDineroException;
import proyectos_practicos.MyScanner;

//public class Dinero {
//
//    private static MyScanner sc = new MyScanner();
//
//    public static void main(String[] args) throws SacarDineroException {
//        try{
//            int base = 500;
//
//            int sacar = sc.pedirNumero("Inserte la cantidad a retirar: ");
//
//            if (sacar > base) {
//                throw new SacarDineroException("No tienes tanto dinero!");
//            }
//            System.out.println("Ha sacado " + sacar + " correctamente!");
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }finally{
//            System.out.println("Fin del programa");
//            sc.cerrar();
//        }
//    }
//}

//--------------- 23/10/25 -------------------------------

import exception.SacarDineroException;

public class Dinero {

    private static MyScanner sc = new MyScanner();
    private static int base = 500;

    public static void main(String[] args) throws SacarDineroException {
        try {
            System.out.println("=== REGISTRO DE PERSONA ===");
            String nombre = sc.pideTexto("Ingrese su nombre: ");
            String apellido = sc.pideTexto("Ingrese su apellido: ");
            int edad = sc.pedirNumero("Ingrese su edad: ");
            int cantidadMover = sc.pedirNumero("Ingrese la cantidad de dinero que va a mover: ");

            if (cantidadMover > base) {
                throw new SacarDineroException("No tiene tanto dinero!");
            }

            System.out.println("\nPersona registrada:");
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Edad: " + edad);
            System.out.println("Cantidad a mover: " + cantidadMover);
            System.out.println("Dinero en cuenta: " + base);

            int opcion;
            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Sacar dinero");
                System.out.println("2. Meter dinero");
                System.out.println("3. Mostrar Saldo");
                System.out.println("4. Salir");
                opcion = sc.pedirNumero("Seleccione una opción: ");

                switch (opcion) {
                    case 1:
                        sacarDinero();
                        break;
                    case 2:
                        meterDinero();
                        break;
                    case 3:
                        mostrarSaldo();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 4);

        } catch (SacarDineroException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Fin del programa");
            sc.cerrar();
        }
    }

    private static void sacarDinero() throws SacarDineroException {
        try {
            int sacar = sc.pedirNumero("Inserte la cantidad a retirar: ");

            if (sacar > base) {
                throw new SacarDineroException("No tiene tanto dinero!");
            }

            base -= sacar;
            System.out.println("Ha sacado " + sacar + " correctamente!");
            System.out.println("Dinero actual en cuenta: " + base);

        } catch (SacarDineroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void meterDinero() {
        try {
            int depositar = sc.pedirNumero("Inserte la cantidad a depositar: ");

            if (depositar <= 0) {
                System.out.println("La cantidad debe ser mayor a 0!");
                return;
            }

            base += depositar;
            System.out.println("Ha depositado " + depositar + " correctamente!");
            System.out.println("Dinero actual en cuenta: " + base);

        } catch (Exception e) {
            System.out.println("Error al depositar: " + e.getMessage());
        }
    }

    private static void mostrarSaldo() {
        System.out.println("\n=== SALDO ACTUAL ===");
        System.out.println("Dinero en cuenta: " + base);
        System.out.println("====================");
    }
}
