package clases;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    public Calculadora(){

    }

    public void menu(){

        boolean flag = true;


        // Modos solo del 1 al 4
        while (flag) {
            int j = comprobar("Introduce un número para el modo\n1.Sumar\n2.Restar\n3.Multiplicar\n4.Todo\n0.Salir\n\nModo:");
            if (j < 0 || j > 4) {
                System.out.println("Modo no válido. Debe ser un número entre 1 y 4.\n");
            } else {

                int num1 = -1;
                int num2 = -1;
                // Comprobación de los números
                if (j != 0) {
                    num1 = comprobar("Introduce el primer número de la operación: ");
                    num2 = comprobar("Introduce el segundo número de la operación: ");
                }

                // Modo
                switch (j) {
                    case 1:
                        System.out.println("Has elegido Suma");
                        System.out.println("La suma de (" + num1 + " + " + num2 + ") es: " + suma(num1, num2));
                        break;
                    case 2:
                        System.out.println("Has elegido Resta");
                        System.out.println("La resta de (" + num1 + " - " + num2 + ") es: " + resta(num1, num2));
                        break;
                    case 3:
                        System.out.println("Has elegido Multiplicar");
                        System.out.println("La multiplicación de (" + num1 + " * " + num2 + ") es: " + multiplicacion(num1, num2));
                        break;
                    case 4:
                        System.out.println("Has elegido Todo");
                        System.out.println("La suma de (" + num1 + " + " + num2 + ") es: " + suma(num1, num2));
                        System.out.println("La resta de (" + num1 + " - " + num2 + ") es: " + resta(num1, num2));
                        System.out.println("La multiplicación de (" + num1 + " * " + num2 + ") es: " + multiplicacion(num1, num2));
                        break;
                    case 0:
                        System.out.println("Has salido de la aplicación");
                        flag = false;
                        break;
                    default:
                        System.out.println("Modo no válido");
                        break;

                }
            }

        }

    }

    // Operaciones
    public static int suma(int a, int b) {
        return a + b;
    }

    public static int resta(int a, int b) {
        return a - b;
    }

    public static int multiplicacion(int a, int b) {
        return a * b;
    }

    // Comprobar si es texto
    public static int comprobar(String mns) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                n = sc.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número.\nPrueba de nuevo.");
                sc.nextLine();
            }
        }
        return n;
    }
}