package Juego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner() {
        sc = new Scanner(System.in);
    }

    public int pedirNumero(String mensaje) {
        int num = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
                sc.nextLine();
                flag = false;

            } catch (InputMismatchException e) {
                System.out.println("eso no es un numero");
                sc.nextLine();
            }
        }
        return num;
    }
        public String pedirSoloTexto(String texto){
            String input;
            boolean valido;
            do {
                System.out.print(texto);

                input = sc.nextLine().trim();
                valido = input.matches("[a-zA-ZáéíóúAÉÍÓÚ ]+");
                if (!valido) {
                    System.out.println("solo se permiten letras");
                }

            } while (!valido);
            return input;
        }

        public char pedirLetra(String texto){
        String input;
        boolean valido;
        do {
            System.out.print(texto);
            input = sc.next().trim();
            valido = input.matches("[A-Z]");
            if (!valido) {
                System.out.println("solo se permite una letra");
            }
        }while(!valido);
        return input.charAt(0);
        }
    }