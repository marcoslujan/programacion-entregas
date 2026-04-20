import java.util.InputMismatchException;
import java.util.Scanner;

public class Myscanner {
    private static Scanner sc;

    public Myscanner() {
        sc = new Scanner(System.in);
    }

    public int pedirNumero(String mns) {
        int i = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                i = sc.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println(" no es un  numero");
                sc.nextLine();
            }
        }
        return i;
    }
    public String pedirSoloTexto(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+");
            if (!valido) {
                System.out.println("solo se permiten letras");
            }
        }while (!valido);
        return input;
    }

    public void close() {
        if (sc != null) {
            sc.close();
        }
    }
}