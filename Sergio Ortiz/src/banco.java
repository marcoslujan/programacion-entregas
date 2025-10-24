import java.util.Scanner;

public class banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.0; // saldo inicial
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n=== MENÚ DEL BANCO ===");
            System.out.println("1. Mostrar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tu saldo actual es: $" + saldo);
                    break;

                case 2:
                    System.out.print("¿Cuánto dinero deseas ingresar?: ");
                    double ingreso = sc.nextDouble();
                    if (ingreso > 0) {
                        saldo += ingreso;
                        System.out.println("Has ingresado $" + ingreso);
                    } else {
                        System.out.println("Cantidad no válida.");
                    }
                    break;

                case 3:
                    System.out.print("¿Cuánto dinero deseas retirar?: ");
                    double retiro = sc.nextDouble();
                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Has retirado $" + retiro);
                    } else if (retiro > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        System.out.println("Cantidad no válida.");
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar nuestro banco. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
