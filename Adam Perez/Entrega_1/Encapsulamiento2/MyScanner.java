package Encapsulamiento2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner() {
        sc = new Scanner(System.in);
    }

    public int pedirNumero (String mensaje) {
        int n = -1;
        boolean valido = true;
        while (valido) {
            try {
                System.out.print(mensaje);
                n = sc.nextInt();
                sc.nextLine();
                valido = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero");
                sc.nextLine();
            }
        }
        return n;
    }

    public String pedirSoloTexto (String mensaje) {
        String input;
        boolean valido;
        do {
            System.out.print(mensaje);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
            if (!valido) {
                System.out.println("Eso no es un texto, tas tonto?");
            }
        } while (!valido);
    return input;
    }

    public char pedirLetra (String mensaje) {
        String input;
        boolean valido;
        do {
            System.out.println(mensaje);
            input = sc.nextLine();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]");
            if (!valido) {
                System.out.println("Eso no es una letra, pellizcas vidrio?");
            }
        } while (!valido);
        return input.charAt(0);
    }

    public String pideTexto(String mensaje) {
        String texto;
        do {
            System.out.println(mensaje);
            texto = sc.nextLine();
            if (texto.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }
}
