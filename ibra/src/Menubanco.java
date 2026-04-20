import clases.Direccion;
import clases.Personabanco;

public class Menubanco {

    private static final Myscanner sc = new Myscanner(System.in);
    private static Personabanco persona;  // Objeto cliente

    public static void main(String[] args) throws Myexception {

        // === REGISTRO DE LA PERSONA ===
        System.out.println("=== REGISTRO DE CLIENTE DEL BANCO ===");

        String nombre = sc.pedirSoloTexto("Ingrese su nombre: ");
        String apellido = sc.pedirSoloTexto("Ingrese su apellido: ");
        int edad = sc.pedirNumero("Ingrese su edad: ");
        String calle = sc.pedirSoloTexto("Ingrese su calle: ");
        int numero = sc.pedirNumero("Ingrese el número de su casa: ");
        String ciudad = sc.pedirSoloTexto("Ingrese su ciudad: ");

        Direccion direccion = new Direccion(calle, numero, ciudad);
        persona = new Personabanco(nombre, apellido, edad, direccion);

        System.out.println("\nCliente registrado correctamente:");
        System.out.println(persona);

        // === MENÚ DEL BANCO ===
        int opcion;
        do {
            System.out.println("\n=== MENÚ DEL BANCO ===");
            System.out.println("Cliente: " + persona.getNombre() + " " + persona.getApellido());
            System.out.println("1. Sacar dinero");
            System.out.println("2. Meter dinero");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Salir");
            opcion = sc.pedirNumero("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> {
                        int cantidad = sc.pedirNumero("Ingrese cantidad a sacar: ");
                        sacarDinero(cantidad);
                    }
                    case 2 -> {
                        int cantidad = sc.pedirNumero("Ingrese cantidad a depositar: ");
                        meterDinero(cantidad);
                    }
                    case 3 -> System.out.println(" Saldo actual: " + persona.getDinero_en_banco());
                    case 4 -> System.out.println(" Gracias, " + persona.getNombre() + ". Hasta luego.");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Myexception e) {
                System.out.println(" Error: " + e.getMessage());
            }

        } while (opcion != 4);
    }

    private static void sacarDinero(int cantidad) throws Myexception {
        int saldo = persona.getDinero_en_banco();
        if (cantidad > saldo) {
            throw new Myexception("No tienes suficiente dinero ");
        }
        persona.setDinero_en_banco(saldo - cantidad);
        System.out.println("Has retirado " + cantidad + " unidades. Nuevo saldo: " + persona.getDinero_en_banco());
    }

    private static void meterDinero(int cantidad) {
        persona.setDinero_en_banco(persona.getDinero_en_banco() + cantidad);
        System.out.println("Has depositado " + cantidad + " unidades. Nuevo saldo: " + persona.getDinero_en_banco());
    }
}
