public class Banco {
    private static MyScanner scanner = new MyScanner();
    private static Persona persona = new Persona();
    int saldo = persona.getDinero_en_banco();


    public static void main(String[] args) throws Clases.exception.MyException {
        persona.setNombre(scanner.pedirsolotexto("introduce el nombre de la persona"));
        persona.setApellido(scanner.pideTexto("introduce el apellido de la persona"));
        persona.setEdad(scanner.pedirNumero("introduce la edad de la persona"));

        boolean flag = true;
        int n = -1;
        do {

            System.out.println("Menu");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Meter dinero");
            System.out.println("3. Salir");
            n = scanner.pedirNumero("Que operación quieres realizar");
            switch (n) {
                case 1:
                    sacardinero();
                    break;
                case 2:

                    meterdinero();
                    break;
                case 3:
                    System.out.println("Saliendo del banco");
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (flag);
    }

    public static void sacardinero() throws Clases.exception.MyException {
        try {
            int sacar = scanner.pedirNumero("Cuanto quieres retirar: ");
            int saldo = persona.getDinero_en_banco();
            if (sacar > saldo) {
                throw new MyException("❌No tiene esa cantidad de dinero❌");
            }


            persona.setDinero_en_banco(saldo -sacar);
            System.out.println("Ha depositado "+sacar +" €");
            System.out.println("Tiene en total "+persona.getDinero_en_banco());



        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void meterdinero() throws Clases.exception.MyException {
        int meter = scanner.pedirNumero("Ingrese dinero");
        int saldo = persona.getDinero_en_banco();
        System.out.println("mi saldo es " + saldo);


        persona.setDinero_en_banco(saldo + meter);
        System.out.println("Ingresó " + meter + " €");
        System.out.println("Saldo en banco: " + persona.getDinero_en_banco());

    }
}
