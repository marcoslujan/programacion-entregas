public class MainException {

    private static Miscanner miscanner = new Miscanner();
    public static void main(String[] args) throws ExcepcionBanco {
        int base = 500;
        int sacar = miscanner.pedirNumero("Inserte la cantidad a retirar: ");

        if (sacar > base ) {
            throw new ExcepcionBanco("No dispone de tanto saldo.");
        }
        System.out.println("Ya tiene su dinero.");
    }
}