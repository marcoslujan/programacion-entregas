import banco.Funcionamiento;
import exceptions.Pobreza;

public class Main {
    public static void main(String[] args) throws Pobreza {
        Funcionamiento f = new Funcionamiento();
        f.identificacion();
        f.menu();
    }
}
