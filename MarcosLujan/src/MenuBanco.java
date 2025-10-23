import clases.MyScanner;
import clases.Persona;
import exceptions.MyException;

public class MenuBanco {
    private static final MyScanner sc = new MyScanner();
    static Persona persona = new Persona();

    public static void main(String[] args) throws MyException {
        datosPersona();
        menuBanco();
    }
    public static  void datosPersona() {
    persona.setNombre(sc.pedirSoloTexto("Introduzca su nombre: "));
    persona.setApellido(sc.pedirSoloTexto("Introduzca su apellido: "));
    persona.setEdad(sc.pedirNumero("Introduzca su edad: "));
    }

    public static void menuBanco() throws MyException {

        boolean continuar = true;
        while (continuar) {
            System.out.println("****** MENU BANCO ******");
            System.out.println("\t1. Mostrar saldo: ");
            System.out.println("\t2. Ingresar dinero: ");
            System.out.println("\t3. Sacar dinero: ");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Opción: ");
            switch (opcion) {
                case 1:
                    System.out.println("\nTu puto dinero es: " + persona.getDinero_en_banco() + " €");
                    break;
                case 2:
                    ingresarDinero();
                    break;
                case 3:
                    sacarDinero();
                    break;
                case 0:
                    System.out.println("Usted es un salido....");
                    System.out.println("...digo ha salido");
                    continuar = false;
                    break;
                default:
                    System.out.println("ERROR OPCIÓN NO VÁLIDA, POR FAVOR PRUEBE OTRA VEZ");
                    break;
            }

        }
    }

    public static int ingresarDinero(){
        int base = persona.getDinero_en_banco();
        int cantidad = sc.pedirNumero("Ingrese su cantidad de dinero: ");
        persona.setDinero_en_banco(base + cantidad);
        return persona.getDinero_en_banco();
    }

    public static void sacarDinero() throws MyException {

        try {
            int base = persona.getDinero_en_banco();

            int sacar = sc.pedirNumero("Ingrese la cantidad de dinero que desea sacar: ");

            if (sacar > base) {
                throw new MyException("❌: No tiene suficiente dinero.");
            }else {
                System.out.println("Has sacado " + sacar + " € correctamente");
                persona.setDinero_en_banco(base - sacar);
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
