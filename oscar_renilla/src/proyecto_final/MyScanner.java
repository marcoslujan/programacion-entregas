package proyecto_final;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner(InputStream in) {
        sc = new Scanner(System.in);
    }

    public static int comprobar_Numero(String mns) {
        int n= -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                n= sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número!");
                sc.nextLine();
            }
        }
        return n;
    }


    public static String comprobar_SoloTexto(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜçÇñÑ ]+");        // Con el + se puede hacer una cadena (introducir mas de uno de los de la lsita)
            if (!valido){
                System.out.println("ERROR: Solo se permiten letras (sin números ni símbolos). Intentalo de nuevo");
            }
        } while (!valido);
        return input;
    }

    public String comprobarCorreo(String correo) {
        String input;
        boolean valido;
        do {
            System.out.println(correo);
            input = sc.nextLine().trim();
            valido = input.matches("[@.]+");
            if (!valido){
                System.out.println("Correo invalido, no contiene @ ni .");
            }
        } while (!valido);
        return input;
    }

    public static char comprobar_Letra(String texto){
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜçÇñÑ ]");          // Sin el + solo se puede intruducir uno de los de la lsita
            if (!valido){
                System.out.println("ERROR: Solo se permite introducir una letra. Intentalo de nuevo");
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
