package Banco;

public class GestionBanco {
    private MyScanner sc;
    private Persona persona;

    public GestionBanco() {
        sc = new MyScanner();
    }
    public static void main(String[] args) {
        GestionBanco gb = new GestionBanco();
        gb.iniciar();
    }

    public void iniciar() {
        System.out.println("=== BIENVENIDO AL BANCO ===");

        String nombre = sc.pedirSoloTexto("Introduce tu nombre:");
        String apellido = sc.pedirSoloTexto("Introduce tu apellido:");
        int edad = sc.pedirNumero("Introduce tu edad:");

        persona = new Persona(nombre, apellido, edad);

        mostrarMenu();
    }

    private void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ BANCO ---");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Salir");
            opcion = sc.pedirNumero("Elige una opción:");

            switch (opcion) {
                case 1:
                    ingresarDinero();
                    break;
                case 2:
                    sacarDinero();
                    break;
                case 3:
                    mostrarSaldo();
                    break;
                case 4:
                    System.out.println("Gracias por usar el banco. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    private void ingresarDinero() {
        double cantidad = sc.pedirDecimal("¿Cuánto dinero deseas ingresar?: ");
        persona.setDinero_en_banco((int)(persona.getDinero_en_banco() + cantidad));
        System.out.println("Ingreso realizado con éxito. Saldo actual: " + persona.getDinero_en_banco() + "€");
    }

    private void sacarDinero() {
        double cantidad = sc.pedirDecimal("¿Cuánto dinero deseas retirar?: ");
        try {
            retirar(cantidad);
            System.out.println("Has retirado " + cantidad + "€. Saldo restante: " + persona.getDinero_en_banco() + "€");
        } catch (SaldoInsuficienteException e) {
            System.out.println("⚠️ ERROR: " + e.getMessage());
        }
    }

    private void mostrarSaldo() {
        System.out.println("Tu saldo actual es: " + persona.getDinero_en_banco() + "€");
    }

    private void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > persona.getDinero_en_banco()) {
            throw new SaldoInsuficienteException("Men, no te creas por encima de tus posibilidades. No puedes retirar más de " + persona.getDinero_en_banco() + "€.");
        }
        persona.setDinero_en_banco((int)(persona.getDinero_en_banco() - cantidad));
    }


}