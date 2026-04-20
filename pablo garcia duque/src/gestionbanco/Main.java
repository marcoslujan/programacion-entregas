package gestionbanco;

import clases.MyScanner;
import clases.Persona;

public class Main {

    private static  MyScanner scanner = new MyScanner();
    private static Persona persona = new Persona();

    public static void main(String[] args) throws NohaydineroExcepcion {

        persona.setNombre(scanner.pedirSoloTexto("Introduzca su nombre: "));
        persona.setApellido(scanner.pedirSoloTexto("Introduzca su apellido: "));
        persona.setEdad(scanner.pedirNumero("Introduzca su edad: "));
        gestionarBanco(persona);
        System.out.println("¡Hasta pronto!");

        // Con el try - catch conseguimos que nos lance la frase del error y no la excepción en rojo
    }

    private static void gestionarBanco (Persona persona) throws NohaydineroExcepcion {
        while (true) {
            System.out.println("¡Bienvenido a su banco " + persona.getNombre() + persona.getApellido() + " de " + persona.getEdad() + " años.");
            System.out.println("\n=== GESTOR DE Banco ===");
            System.out.println("1) Retirar dinero");
            System.out.println("2) Ingresar dinero");
            System.out.println("3) Mostrar saldo");
            System.out.println("0) Salir");
            int opcion = scanner.pedirNumero("Introduce una opción entre 1 y 3, o elige 0 para salir.");
            if (opcion < 0 || opcion > 3) {
                System.out.println("¡Esa no es una opción válida! ¡Prueba de nuevo!");
                continue;
            }
            switch (opcion) {
                case 0: {
                    return;
                }
                case 1:
                    sacarDinero(persona);
                    break;
                case 2:
                    ingresarDinero(persona);
                    break;
                case 3:
                    mostrarSaldo(persona);
                    break;
            }

        }

    }

    private static void ingresarDinero(Persona persona) {
        System.out.println("\n*** INGRESAR DINERO ***");
        int cantidad = scanner.pedirNumero("¿Cuánto dinero quiere ingresar?: ");
        int nuevosaldo = cantidad + persona.getDinero_en_banco();
        persona.setDinero_en_banco(nuevosaldo);
        System.out.println("Su nuevo saldo es " + persona.getDinero_en_banco());
    }

    private static void sacarDinero(Persona persona) throws NohaydineroExcepcion {
        System.out.println("\n*** SACAR DINERO ***");
        int cantidad = scanner.pedirNumero("¿Cuánto dinero quiere retirar?: ");
        int nuevosaldo = persona.getDinero_en_banco() - cantidad;
        persona.setDinero_en_banco(nuevosaldo);
        System.out.println("Su nuevo saldo es " + persona.getDinero_en_banco());
        System.out.println("Recoja su dinero. Ha retirado exitosamente " + cantidad);

        try {
            if (cantidad > persona.getDinero_en_banco()) {
                throw new NohaydineroExcepcion("❌ No tienes suficiente dinero ❌");
            }
        } catch (NohaydineroExcepcion e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Volviendo al menú... \n");
        }
    }

    private static void mostrarSaldo(Persona persona) {
        System.out.println("\n*** MOSTRAR SALDO ***");
        System.out.println("Su saldo es " + persona.getDinero_en_banco());
    }
}

// Vamos a crearnos el gestor de un banco usando la clase persona, que no pueda sacar más dinero del que tiene y
// que pueda meter dinero. 1 sacar dinero 2 meter pasta y 3 mostrar saldo y salir.


