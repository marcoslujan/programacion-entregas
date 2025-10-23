
import clases.Persona;
import exception.MyException;
import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona persona = new Persona();
        int dinero_en_banco;
        int opcion;
        do {
            System.out.println("------Menú de banco------ ");
            System.out.println("1- Sacar dinero ");
            System.out.println("2- Meter dinero ");
            System.out.println("3- Salir ");
            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                   try {
                       System.out.print("Intruduzca la cantidad a retirar: ");
                       int cantidad = sc.nextInt();
                       if (cantidad > persona.getDinero_en_banco()){
                           throw new MyException(" No tiene fondos suficientes ");
                       }
                       persona.setDinero_en_banco(persona.getDinero_en_banco() - cantidad);
                       System.out.println("Ha sacado " + cantidad + " euros correctamente");
                       System.out.println("Su saldo actual es de " + persona.getDinero_en_banco() + " euros");
                   } catch (MyException e) {
                       System.out.println(e.getMessage());
                   }
                    break;
                    case 2:
                        System.out.println("Introduzca la cantidad a depositar: ");
                        int depositar = sc.nextInt();
                        persona.setDinero_en_banco(persona.getDinero_en_banco() + depositar);
                        System.out.println("Ha ingresado " + depositar + " euros correctamente");
                        System.out.println("Su saldo es de " + persona.getDinero_en_banco() + " euros" );
                        break;
                        case 3:
                            System.out.println("Saliendo ");
                            break;
                            default:
                                System.out.println("Opción invalida. Por favor seleccione una opción válida:  ");
                                break;
            }
        }while (opcion != 3);
        sc.close();
    }
}
