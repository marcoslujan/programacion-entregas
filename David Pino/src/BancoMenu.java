import java.util.Scanner;

public class BancoMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== BIENVENIDO AL BANCO ===");
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        Persona persona = new Persona(nombre, apellido, edad);

        System.out.println("\nCuenta creada correctamente ✅");
        System.out.println(persona.getNombre() + " " + persona.getApellido() + ", tu saldo inicial es de 1000€.");

        int opcion;
        do {
            System.out.println("\n===== MENÚ BANCO =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nTu saldo actual es: " + persona.getDinero_en_banco() + "€");
                    break;
                case 2:
                    System.out.print("Cantidad a ingresar: ");
                    int ingreso = sc.nextInt();
                    if (ingreso > 0) {
                        persona.setDinero_en_banco(persona.getDinero_en_banco() + ingreso);
                        System.out.println("Has ingresado " + ingreso + "€. Saldo actual: " + persona.getDinero_en_banco() + "€");
                    } else {
                        System.out.println("La cantidad debe ser positiva.");
                    }
                    break;
                case 3:
                    System.out.print("Cantidad a retirar: ");
                    int retiro = sc.nextInt();
                    if (retiro > 0 && retiro <= persona.getDinero_en_banco()) {
                        persona.setDinero_en_banco(persona.getDinero_en_banco() - retiro);
                        System.out.println("Has retirado " + retiro + "€. Saldo actual: " + persona.getDinero_en_banco() + "€");
                    } else {
                        System.out.println("Cantidad inválida o saldo insuficiente.❌");
                    }
                    break;
                case 4:
                    System.out.println("\nSaliendo del sistema... ¡Hasta pronto, " + persona.getNombre() + "!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
