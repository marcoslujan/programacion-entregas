package clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner() {
        sc = new Scanner(System.in);
    }
    public int pedirNumero(String mns) {
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                n = sc.nextInt();
                sc.nextLine();
                if (n < 0) {
                    System.out.println("Los números negativos no son válidos! Ingrresa una edad real");
                } else
                    flag = false;
            }  catch (InputMismatchException e) {
                System.out.println("Eso no es un número! Prueba de nuevo");
                sc.nextLine();
            }
        }
        return n;
    }
    public char pedirLetra(String mns) {
        String input;
        boolean valido;
        do {
            System.out.println(mns);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-Z]+");
            if (!valido) {
                System.out.println("Error: Solo se permiten letras (sin número ni simbolos). Intentalo de nuevo");
            }
        } while (!valido);
        return input.charAt(0);
    }

    public String pedirSoloTexto(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑÆ ]+");
            if (!valido) {
                System.out.println("Error: Solo se permiten letras (sin número ni simbolos). Intentalo de nuevo");
            }
        }  while (!valido);
        return input;
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
