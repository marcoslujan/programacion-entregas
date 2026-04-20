package Banco;

import Clases.MyScanner;
import Clases.Persona;
import Clases.exceptions.MyException;

public class MenuBanco {

    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) throws MyException {
        Persona persona = new Persona();
        bancoStart(persona);
    }

    private static void bancoStart(Persona persona) throws MyException {
        System.out.println("Bienvenido a bancos Pedregosa");

        persona.setNombre(sc.pideTexto("por favor, introduce su nombre: "));
        persona.setApellido(sc.pideTexto("por favor, introduce su apellido: "));
        persona.setEdad(sc.pedirNumero("y cuantos años tiene: "));

        System.out.println("Excelente \"" + persona.getNombre() + " " + persona.getApellido());

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = sc.pedirNumero("Ahora, elige: ");

            switch (opcion) {
                case 1:
                    mostrarDinero(persona);
                    break;
                case 2:
                    sacarDinero(persona);
                    break;
                case 3:
                    meterDinero(persona);
                    break;
                case 0:
                    salir = true;
                    System.out.println("pues bueno, ya nos veremos de nuevo, supongo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo, patan.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n Menú del banco ");
        System.out.println("1. Saldo");
        System.out.println("2. Sacar");
        System.out.println("3. Meter");
        System.out.println("0. Salir");
    }

    private static void mostrarDinero(Persona persona) {

        System.out.println("\nLos Dineros:");
        System.out.println("tienes: " + persona.getDinero_en_banco());
    }

    private static void sacarDinero(Persona persona) throws MyException {

        try{
            int base = persona.getDinero_en_banco();
            int sacar = sc.pedirNumero("mete la cantidad a retirar: ");

            if (sacar > base) {
                throw new MyException("No tienes dineros... Putos Pobres.");
            }

            System.out.println("Sacando " + sacar + " a su monedero");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Peruano");
        }
    }

    private static int meterDinero(Persona persona) {

        int base = persona.getDinero_en_banco();
        int newDinero = sc.pedirNumero("cuanto dinero quieres ingresar?");
        persona.setDinero_en_banco(base + newDinero);
        System.out.println("Tienes " + persona.getDinero_en_banco() + " en el banco");
        return persona.getDinero_en_banco();
    }
}