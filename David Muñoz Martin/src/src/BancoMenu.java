package src;

import java.util.Scanner;

public class BancoMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos del usuario
        System.out.println("=== BIENVENIDO AL BANCO ===");
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        // Crear la persona con 1000€ iniciales
        Persona persona = new Persona(nombre, apellido, edad);
        System.out.println("\nCuenta creada con éxito para " + persona.getNombre() + " " + persona.getApellido() + ".");
        System.out.println("Saldo inicial: " + persona.getDinero_en_banco() + "€\n");

        int opcion;
        do {
            System.out.println("===== MENÚ DEL BANCO =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tu saldo actual es: " + persona.getDinero_en_banco() + "€\n");
                    break;

                case 2:
                    System.out.print("¿Cuánto dinero deseas ingresar?: ");
                    int ingreso = sc.nextInt();
                    if (ingreso > 0) {
                        persona.setDinero_en_banco(persona.getDinero_en_banco() + ingreso);
                        System.out.println("Has ingresado " + ingreso + "€. Nuevo saldo: " + persona.getDinero_en_banco() + "€\n");
                    } else {
                        System.out.println("Cantidad no válida.\n");
                    }
                    break;

                case 3:
                    System.out.print("¿Cuánto dinero deseas retirar?: ");
                    int retirada = sc.nextInt();
                    if (retirada > 0 && retirada <= persona.getDinero_en_banco()) {
                        persona.setDinero_en_banco(persona.getDinero_en_banco() - retirada);
                        System.out.println("Has retirado " + retirada + "€. Nuevo saldo: " + persona.getDinero_en_banco() + "€\n");
                    } else {
                        System.out.println("Cantidad no válida o saldo insuficiente.\n");
                    }
                    break;

                case 0:
                    System.out.println("Gracias por usar el banco. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida.\n");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
