package proyecto_final;

import clases.MyScanner;
import clases.Persona;
import exceptions.MyException;

public class MainException {

    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        System.out.println("===== BANCO =====");

        // Pedir datos para crear persona
        String nombre = sc.pedirSoloTexto("Ingrese su nombre:");
        String apellido = sc.pedirSoloTexto("Ingrese su apellido:");
        int edad = sc.pedirNumero("Ingrese su edad:");

        Persona persona = new Persona(nombre, apellido, edad);

        System.out.println("\nPersona registrada correctamente:");
        System.out.println(persona);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n----- MENÚ BANCARIO -----");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Salir");

            int opcion = sc.pedirNumero("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> {
                        int ingresar = sc.pedirNumero("Ingrese la cantidad a depositar: ");
                        if (ingresar <= 0) {
                            System.out.println("No puede ingresar cantidades negativas o cero.");
                        } else {
                            persona.setDinero_en_banco(persona.getDinero_en_banco() + ingresar);
                            System.out.println("Dinero ingresado correctamente. Nueva cantidad de dinero en el banco: " +
                                    persona.getDinero_en_banco() + "€");
                        }
                    }

                    case 2 -> {
                        int sacar = sc.pedirNumero("Ingrese la cantidad a retirar: ");
                        if (sacar > persona.getDinero_en_banco()) {
                            throw new MyException("No tiene suficiente dinero en el banco.");
                        } else if (sacar <= 0) {
                            System.out.println("Ingrese una cantidad válida.");
                        } else {
                            persona.setDinero_en_banco(persona.getDinero_en_banco() - sacar);
                            System.out.println("Ha retirado " + sacar + "€. Nueva cantidad: " +
                                    persona.getDinero_en_banco() + "€");
                        }
                    }

                    case 3 -> {
                        System.out.println("Dinero actual: " + persona.getDinero_en_banco() + "€");
                    }

                    case 4 -> {
                        System.out.println("Saliendo...");
                        salir = true;
                    }

                    default -> System.out.println("Opción no válida. Intentalo de nuevo.");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.cerrar();
        System.out.println("Programa finalizado.");
    }
}
