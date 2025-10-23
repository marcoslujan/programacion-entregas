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
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Esto no es un numero!");
                sc.next();
            }
        }
        return n;
    }
    public String pedirsolotexto(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáàéíóúÁÁÉÍÓÚñÑ ]+");
            if (!valido) {
                System.out.println("Error: solo se permite letras (sin numero ni simbolos). Intentalo de nuevo.");
            }
        }   while (!valido);
        return input;

    }

    public char pedrletra(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáàéíóúÁÁÉÍÓÚñÑ ]");
            if (!valido) {
                System.out.println("ERROR: solo se permite introducir una letra. Intentalo de nuevo.");
            }
        }while (!valido);


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

    public void cerrar() {
        sc.close();
    }

}