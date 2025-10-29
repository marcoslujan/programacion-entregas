import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Myscanner {
    private static Scanner sc;

    public Myscanner(InputStream in) {
        sc = new Scanner(System.in);
    }

    public int pedirNumero(String mns) {
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.print(mns);
                n = sc.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un numero");
                sc.nextLine();
            }
        }
        return n;
    }

    public String pedirSoloTexto(String mns) {
        String input;
        boolean valido;
        do {
            System.out.println(mns);
            input = sc.nextLine();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
            if (!valido) {
                System.out.println("Error: Por favor ingrese una letra");
            }

        } while (!valido);
        return input;
    }

    public char pedirletra(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
            if (!valido) {
                System.out.println("Error: Por favor ingrese una letra");
            }
        } while (!valido);
        return input.charAt(0);
    }

    public void close() {
    }
}