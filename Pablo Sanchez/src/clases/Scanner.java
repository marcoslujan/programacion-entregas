package clases;

import java.util.InputMismatchException;


public class Scanner {
    static Scanner sc;

    public Scanner(String mns) {
        sc = new Scanner(System.in.toString());
    }

    public int pedirNumero(String mns) {
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                n = sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es número!");
                sc.nextLine();
            }
        }
        return n;
    }

    String nextLine() {

        return null;
    }

    private int nextInt() {
        return 0;
    }

    public String pedirSoloTexto(String texto) {
        String input = "";
        boolean valido;
        do {
            System.out.println(texto);
            sc.nextLine();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ ]+");
            if (!valido) {
                System.out.println("ERROR: solo se permiten letras (sin números ni símbolos). Inténtalo de nuevo.");
            }
        }  while (!valido);
        return input;
    }

    public char pedirLetra(String texto) {
        String input = "";
        boolean valido;
        do {
            System.out.println(texto);
            sc.nextLine();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ ]");
            if (!valido) {
                System.out.println("ERROR: solo se permite introducir una letra. Inténtalo de nuevo.");
            }
        }while (!valido);

        return input.charAt(0);
    }

    public String pideTexto(String mensaje) {
        String texto = "";
        do {
            System.out.println(mensaje);
            sc.nextLine();
            if (texto.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public void close() {
    }
}
//public class MyScanner {
//    public static Scanner sc;
//    public MyScanner() {
//        sc = new Scanner(System.in);
//    }
//    public int pedirNumero(String mns) {
//        int n = -1;
//        boolean flag = true;
//        while (flag) {
//            try {
//                System.out.println(mns);
//                n = sc.nextInt();
//                sc.nextLine();
//                flag = false;
//            } catch (InputMismatchException e) {
//                System.out.println("Error en la introduccion del numero");
//                sc.next();
//            }
//        }
//        return n;
//    }
//    public String pedirSoloTexto(String texto) {
//        String input;
//        boolean valido;
//        do {
//            System.out.println(texto);
//            input = sc.nextLine().trim();
//            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+");
//            if (!valido) {
//                System.out.println("Error en la introduccion del texto");
//            }
//        }while (!valido);
//        return input;
//    }
//    public char pedirLetra(String texto) {
//        String input;
//        boolean valido;
//        do {
//            System.out.println(texto);
//            input = sc.nextLine().trim();
//            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]");
//            if (!valido) {
//                System.out.println("El letra es incorrecto");
//            }
//
//        }while (!valido);
//        return input.charAt(0);
//    }
//
//}
