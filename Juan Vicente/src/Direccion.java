import java.util.Scanner;

public class Direccion {

    Scanner sc = new Scanner(System.in);

    private String calle;
    private int portal;
    private int piso;
    private char letra;

    public Direccion() {
    }

    public Direccion(String calle, int portal, int piso, char letra) {
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.letra = letra;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getPortal() {
        return portal;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String pedirSoloTexto(String texto) {
        String input;
        boolean valido;
        do{
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚñÑ]+");
            if(valido){
                System.out.println("Solo se permiten letras, no numeros o simbolos");
            }
        }while (!valido);
        return input;
    }

    public char pedirLetra(String texto) {
        String input;
        boolean valido;
        do{
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚñÑ]+");
            if(!valido){
                System.out.println("ERROR: solo se permite introducir una letra. Inténtalo de nuevo: ");
            }
        } while (!valido);

        return input.charAt(0);
    }
}