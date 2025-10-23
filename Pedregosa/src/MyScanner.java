import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner sc;

    public MyScanner(){
        sc = new Scanner(System.in);
    }

    public int pedirNumero(String mns){
        int n = -1;
        boolean flag = true;
        while(flag) {
            try{
                System.out.print(mns);
                n = sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Error no es numero");
                sc.nextLine();
            }
        }
        return n;
    }

    public String pedirSoloTexto(String texto){
        String input;
        boolean valido;
        do{
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
            if(!valido){
                System.out.println("Solo letras, simbolos ni números. Try again");
            }
        }while (!valido);
        return input;
    }

    public char pedirLetra(String texto){
        String input;
        boolean valido;
        do{
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]");
            if(!valido){
                System.out.println("mas bobo que una sepia pela', solo una letra");
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
