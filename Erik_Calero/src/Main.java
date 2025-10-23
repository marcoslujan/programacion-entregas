public class Main {
    public static void main(String[] args) {
            MyScanner sc = new MyScanner();

        System.out.println("=== REGISTRO DE PERSONA ===");

        // Pedir datos por teclado
        String nombre = sc.pedirSoloTexto("Ingrese el nombre:");
        String apellido = sc.pedirSoloTexto("Ingrese el apellido:");
        int edad = sc.pedirNumero("Ingrese la edad:");

        // Crear la persona con los datos ingresados
        Persona persona = new Persona(nombre, apellido, edad);

        System.out.println("\n REGISTRO DE PERSONA :");
        System.out.println(persona);


        int opcion;
            do {
                System.out.println("         MENÚ BANCO");
                System.out.println("-------------------------");
                System.out.println("1) Mostrar saldo");
                System.out.println("2) Meter dinero");
                System.out.println("3) Sacar dinero");
                System.out.println("4) Salir");
                System.out.println("-------------------------");
                opcion = sc.pedirNumero("ingrese opcion:");
                switch (opcion) {
                    case 1 :
                        persona.mostrarSaldo();
                        break;
                    case 2 :
                        int cantidad = sc.pedirNumero("ingrese cantidad a ingresar: :");
                        persona.meterDinero(cantidad);
                    break;
                    case 3 :
                        System.out.print("Cantidad a sacar: ");
                        int cantidad1 = sc.pedirNumero("Ingrese cantidad a sacar ");
                        persona.sacarDinero(cantidad1);
                    break;
                    case 4 :
                        System.out.println("Gracias por usar el banco. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println(" Opción no válida.");
                }

                System.out.println(); // Línea en blanco
            } while (opcion != 4);

            sc.close();
        }

}
