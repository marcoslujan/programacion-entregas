import Exceptions.exception;
import clases.Persona;

public class banco {
    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        String nombre = sc.pedirSoloTexto("Introduce tu nombre: ");
        String apellido = sc.pedirSoloTexto("Introduce tu apellido: ");
        int edad;
        do {
            edad = sc.pedirNumero("Introduce tu edad: ");
            if (edad > 130 || edad <= 0) {
                System.out.println("No puede ser, estarías muerto ya, ponla de nuevo");
            }
        } while (edad > 130 || edad <= 0);
        Persona cliente = new Persona(nombre, apellido, edad);
        int opcion;

        do {

            System.out.println("\n--- MENÚ BANCO ---");
            System.out.println("1. Añadir dinero");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Ver saldo");
            System.out.println("4. Salir");
            opcion = sc.pedirNumero("Ingrese una opción: ");

            switch (opcion) {

                case 1:
                    double ingreso = sc.pedirDecimal("Cantidad a ingresar: ");
                    cliente.setDinero_en_banco(cliente.getDinero_en_banco() + ingreso);
                    System.out.println("Has ingresado " + ingreso + "€. Nuevo saldo: " + cliente.getDinero_en_banco() + "€.");
                    break;

                case 2:
                    double retirada = sc.pedirDecimal("Cantidad a retirar: ");
                    try {
                        sacarDinero(cliente, retirada);
                        System.out.println("Has retirado " + retirada + "€. Nuevo saldo: " + cliente.getDinero_en_banco() + "€.");
                    } catch (exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Saldo actual: " + cliente.getDinero_en_banco() + "€.");
                    break;

                case 4:
                    System.out.println("Gracias por usar el banco. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
    }

    private static void sacarDinero(Persona cliente, double cantidad) throws exception {
        if (cantidad > cliente.getDinero_en_banco()) {
            throw new exception("No puedes sacar más dinero del que tienes. Saldo actual: " + cliente.getDinero_en_banco() + "€.");
        }
        cliente.setDinero_en_banco(cliente.getDinero_en_banco() - cantidad);
    }
}