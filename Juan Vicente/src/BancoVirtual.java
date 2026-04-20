import java.util.Scanner;

public class BancoVirtual {
    private Persona titular;
    private double saldo;

    public BancoVirtual(Persona titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se han depositado " + cantidad + "€");
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser mayor que 0.");
        } else if (cantidad > saldo) {
            System.out.println("Fondos insuficientes. No puedes retirar " + cantidad + "€");
        } else {
            saldo -= cantidad;
            System.out.println("Has retirado " + cantidad + "€");
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual: " + saldo + "€");
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Banco Virtual ---");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Ver saldo");
            System.out.println("4. Mostrar datos del titular");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double dep = sc.nextDouble();
                    depositar(dep);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double ret = sc.nextDouble();
                    retirar(ret);
                    break;
                case 3:
                    mostrarSaldo();
                    break;
                case 4:
                    titular.mostrarDatos();
                    break;
                case 0:
                    System.out.println("Gracias por usar tu Banco Virtual!!");
                    break;
                default:
                    System.out.println("Esa opción no es válida!!");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Bienvenido al Banco Virtual ---");
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        Persona persona = new Persona(nombre, apellido, edad);

        double saldoInicial = 1000.0;
        System.out.println("Se ha creado tu cuenta con un saldo inicial de 1000€");


        BancoVirtual cuenta = new BancoVirtual(persona, saldoInicial);
        cuenta.menu();
        sc.close();
    }
}