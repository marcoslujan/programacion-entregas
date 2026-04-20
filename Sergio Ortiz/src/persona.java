import java.util.Scanner;

class persona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir los datos al usuario
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        System.out.print("Introduce el dinero que tienes en tu cuenta: ");
        double dinero = sc.nextDouble();

        // Mostrar el resultado
        System.out.println("\nHola " + nombre + " " + apellido);
        System.out.println("Tienes $" + dinero + " en tu cuenta.");

        sc.close();
    }
}