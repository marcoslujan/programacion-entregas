import java.util.Scanner;

public class Banco {
    public static void main(String[] args) throws SaldoInsuficiente {
        Scanner sc = new Scanner(System.in);
        System.out.println("===================");
        System.out.println(" Ingrese sus datos ");
        System.out.println("===================");

        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese su apellido:");
        String apellido = sc.nextLine();

        System.out.println("Ingrese su edad:");
        int edad = sc.nextInt();

        double Dinero = 200.00;
        int opcion;
        System.out.println("Hola " + nombre + apellido + ", su edad es " + edad + " y tiene " + Dinero + " en su cuenta");

        do {
            System.out.println("\n=== MENÚ DEL BANCO ===");
            System.out.println("1. Ingresar Dinero");
            System.out.println("2. Retirar Dinero");
            System.out.println("3. Verificar Saldo");
            System.out.println("4. Salir");
            System.out.print("Por favor elija una opción para continuar: ");
            opcion = sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese cuánto dinero desea ingresar:");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Por favor ingrese un número válido:");
                            sc.next();
                        }
                        double ingreso = sc.nextDouble();
                        if (ingreso <= 0) {
                            System.out.println("No puede ingresar menos de 1.00 euro");
                        } else {
                            Dinero += ingreso;
                            System.out.println("Has ingresado " + ingreso + " euros.");
                            System.out.println("Ahora tienes " + Dinero + " euros en tu cuenta.");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese cuánto dinero desea retirar:");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Por favor ingrese un número válido:");
                            sc.next();
                        }
                        double retiro = sc.nextDouble();
                        if (retiro <= 0) {
                            System.out.println("La cantidad a retirar debe ser mayor a 0");
                        } else if (retiro > Dinero) {
                            throw new SaldoInsuficiente("Fondos insuficientes para realizar la operación");
                        } else {
                            Dinero -= retiro;
                            System.out.println("Has retirado " + retiro + " euros.");
                            System.out.println("Ahora tienes " + Dinero + " euros en tu cuenta.");
                        }
                        break;
                    case 3:
                        System.out.println("Tu saldo actual es: " + Dinero + " euros.");
                        break;
                    case 4:
                        System.out.println("Gracias por usar nuestro banco, " + nombre + " " + apellido);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (SaldoInsuficiente e) {
                System.out.println("Error, saldo insuficiente: " + e.getMessage());
            }
        } while (opcion != 4);
        sc.close();
    }
}