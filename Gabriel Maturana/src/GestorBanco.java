public class GestorBanco {

    public static void main(String[] args) {
        MyScanner input = new MyScanner();


        String nombre = input.pedirSoloTexto("Introduce tu nombre:");
        String apellido = input.pedirSoloTexto("Introduce tu apellido:");
        int edad = input.pedirNumero("Introduce tu edad:");


        PersonaW cliente = new PersonaW(nombre, apellido, edad);


        System.out.println("\nBienvenido/a al Banco, " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Tu saldo inicial es de $" + cliente.getDinero_en_banco() + "\n");


        int opcion;
        do {
            System.out.println(" MENÚ DEL BANCO ");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Meter dinero");
            System.out.println("3. Salir");
            opcion = input.pedirNumero("Elige una opción:");

            switch (opcion) {
                case 1:
                    int retiro = input.pedirNumero("¿Cuánto dinero deseas sacar?");
                    if (retiro <= cliente.getDinero_en_banco() && retiro > 0) {
                        cliente.setDinero_en_banco(cliente.getDinero_en_banco() - retiro);
                        System.out.println("Has retirado $" + retiro + ". Saldo actual: $" + cliente.getDinero_en_banco());
                    } else {
                        System.out.println("Cantidad inválida o saldo insuficiente.");
                    }
                    break;

                case 2:
                    int deposito = input.pedirNumero("¿Cuánto dinero quieres depositar?");
                    if (deposito > 0) {
                        cliente.setDinero_en_banco(cliente.getDinero_en_banco() + deposito);
                        System.out.println("Has depositado $" + deposito + ". Saldo actual: $" + cliente.getDinero_en_banco());
                    } else {
                        System.out.println("Cantidad inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Gracias por usar el Banco. Hasta luego, " + cliente.getNombre());
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();
        } while (opcion != 3);
    }
}
