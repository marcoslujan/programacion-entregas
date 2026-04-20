public class Banco {

    private static MyScanner sc = new MyScanner();
    private static Persona persona = new Persona();

    public static void main(String[] args) throws clases.Banco_Exception {

        persona.setNombre(sc.pedirSoloMns("Introduce el nombre de la persona "));
        persona.setApellido(sc.pideTexto("Introduce el apellido de la persona "));
        persona.setEdad(sc.pedirNumero("Introduce el edad de la persona "));

        boolean flag = true;
        int n = -1;
        do {
            System.out.println("MENU DEL BANCO");
            System.out.println("1.Sacar dinero");
            System.out.println("2.Meter dinero");
            System.out.println("0.Salir");
            n = sc.pedirNumero("Que operación quieres realizar: ");
            switch (n) {
                case 1:
                    sacarDinero();
                    break;
                case 2:
                    meterDinero();
                    break;
                case 0:
                    System.out.println("Saliendo del banco");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (flag);
    }
    public static void sacarDinero() throws clases.Banco_Exception {
        try{
            int sacar = sc.pedirNumero("Inserte la cantidad a retirar: ");
            int base = persona.getDinero_en_banco();
            if (sacar > base) {
                throw new MyException("❌No tiene tanto dinero❌");
            }

            persona.setDinero_en_banco(base - sacar);  ;
            System.out.println("Ha depositado " + sacar + " $");
            System.out.println("En total tiene " + persona.getDinero_en_banco());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public static void meterDinero() throws clases.Banco_Exception {

        int meter = sc.pedirNumero("Inserte la cantidad a dipositar: ");
        int base = persona.getDinero_en_banco();

        persona.setDinero_en_banco(base + meter);  ;
        System.out.println("Ha depositado " + meter + " $");
        System.out.println("En total tiene " + persona.getDinero_en_banco());
    }

}






