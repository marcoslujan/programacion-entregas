import Exceptions.MyException;
import clases.MyScanner;
import clases.Persona;

import java.util.Scanner;

public class MainException {

    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        Scanner scTexto = new Scanner(System.in);

        // Registrar persona (solo nombre y apellido)
        System.out.println("Registro personal");
        System.out.print("Nombre: ");
        String nombre = scTexto.nextLine();

        System.out.print("Apellido: ");
        String apellido = scTexto.nextLine();

        // Creamos la persona con saldo inicial de 1000 €
        Persona persona = new Persona(nombre, apellido, 0);
        System.out.println("\nBienvenido/a " + persona.getNombre() + " " + persona.getApellido());
        System.out.println("Saldo inicial: " + persona.getDinero_en_banco() + " €\n");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nBANCO");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Mostrar saldo");
            System.out.println("0. Salir");

            int opcion = sc.pedirNumero("Elige una opción: ");

            try {
                switch (opcion) {
                    case 1:
                        sacarDinero(persona);
                        break;

                    case 2:
                        ingresarDinero(persona);
                        break;

                    case 3:
                        System.out.println("Saldo actual: " + persona.getDinero_en_banco() + " €");
                        break;

                    case 0:
                        System.out.println("Saliendo del banco...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        break;
                }
            } catch (MyException e) {
                System.out.println("⚠️ ERROR: " + e.getMessage());
            }
        }
        scTexto.close();
    }

    // Sacar dinero
    public static void sacarDinero(Persona persona) throws MyException {
        int cantidad = sc.pedirNumero("\n¿Cuánto dinero deseas retirar?: ");

        if (cantidad <= 0) {
            throw new MyException("No puedes retirar una cantidad negativa o cero.");
        }
        if (cantidad > persona.getDinero_en_banco()) {
            throw new MyException("Saldo insuficiente. No tienes tanto dinero.");
        }

        persona.setDinero_en_banco(persona.getDinero_en_banco() - cantidad);
        System.out.println("Has retirado " + cantidad + " €. Saldo actual: " + persona.getDinero_en_banco() + " €");
    }

    // Ingresar dinero
    public static void ingresarDinero(Persona persona) throws MyException {
        int cantidad = sc.pedirNumero("\n¿Cuánto dinero deseas ingresar?: ");

        if (cantidad <= 0) {
            throw new MyException("No puedes ingresar una cantidad negativa o cero.");
        }

        persona.setDinero_en_banco(persona.getDinero_en_banco() + cantidad);
        System.out.println("Has ingresado " + cantidad + " €. Saldo actual: " + persona.getDinero_en_banco() + " €");
    }
}