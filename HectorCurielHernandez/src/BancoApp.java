import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Pedimos los datos de la persona al inicio ---
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu apellido: ");
        String apellido = sc.nextLine();

        int edad = 0;
        boolean edadValida = false;
        while (!edadValida) {
            try {
                System.out.print("Introduce tu edad: ");
                edad = Integer.parseInt(sc.nextLine());
                if (edad <= 0) {
                    System.out.println("⚠️ La edad debe ser mayor que 0.");
                } else {
                    edadValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Debes introducir un número válido.");
            }
        }

        Persona persona = new Persona(nombre, apellido, edad);
        System.out.println("\nBienvenido/a, " + persona.getNombre() + " " + persona.getApellido() + "!");
        System.out.println("Tu saldo inicial es de " + persona.getDinero_en_banco() + "€.\n");

        int opcion = 0;

        do {
            System.out.println("--- MENÚ DEL BANCO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: " + persona.getDinero_en_banco() + "€");
                        break;

                    case 2:
                        System.out.print("Introduce la cantidad a ingresar: ");
                        int ingreso = Integer.parseInt(sc.nextLine());
                        ingresarDinero(persona, ingreso);
                        System.out.println("✅ Ingreso realizado. Nuevo saldo: " + persona.getDinero_en_banco() + "€");
                        break;

                    case 3:
                        System.out.print("Introduce la cantidad a retirar: ");
                        int retiro = Integer.parseInt(sc.nextLine());
                        retirarDinero(persona, retiro);
                        System.out.println("✅ Retiro realizado. Nuevo saldo: " + persona.getDinero_en_banco() + "€");
                        break;

                    case 4:
                        System.out.println("👋 Gracias por usar el banco. ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("⚠️ Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Debes introducir un número válido.");
            } catch (MyException e) {
                System.out.println("⚠️ " + e.getMessage());
            }

        } while (opcion != 4);
    }

    public static void ingresarDinero(Persona persona, int cantidad) throws MyException {
        if (cantidad <= 0) {
            throw new MyException("No puedes ingresar una cantidad negativa o cero.");
        }
        persona.setDinero_en_banco(persona.getDinero_en_banco() + cantidad);
    }

    public static void retirarDinero(Persona persona, int cantidad) throws MyException {
        if (cantidad <= 0) {
            throw new MyException("No puedes retirar una cantidad negativa o cero.");
        }
        if (cantidad > persona.getDinero_en_banco()) {
            throw new MyException("Saldo insuficiente para retirar esa cantidad.");
        }
        persona.setDinero_en_banco(persona.getDinero_en_banco() - cantidad);
    }
}
