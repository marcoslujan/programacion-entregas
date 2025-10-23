import java.util.Scanner;

public class Direccion {
    Scanner sc = new Scanner(System.in);
    private String calle;
    private String portal;
    private int piso;
    private char letra;

    public Direccion() {
    }

    public Direccion(String calle, String portal, int piso, char letra) {
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

    public char getLetra() {
        return letra;
    }

    public void setLetra() {
        this.letra = letra;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String pedirsoloTexto(String texto){
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑäëïöüÄËÏÖÜ ]+");
            if(!valido){
                System.out.println("Solo se permiten letras, sin numeros ni simbolos, intentalo de nuevo.");
            }
        } while(!valido);
        return input;
    }

    public char pedirLetra(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑäëïöüÄËÏÖÜ ]");
            if(!valido){
                System.out.println("Solo se permiten letras, sin numeros ni simbolos, intentalo de nuevo.");
            }
        }  while(!valido);
        return input.charAt(0);
    }
}
