package Banquillo;

public class Banco {
    private static MyScanner scanner = new MyScanner();
    public static void main(String[] args) throws MyException {
        int base = 500;

        int sacar = scanner.pedirNumero("cuanto quieres retirar");

        if (sacar > base) {
            throw new MyException("no tienes suficiente dinero");
        }
        System.out.println("ya tienes tu dinero");
    }
}