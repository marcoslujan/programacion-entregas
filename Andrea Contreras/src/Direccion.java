import java.util.Scanner;

public class Direccion {
    Scanner sc = new Scanner(System.in);
    private String calle;
    private int portal;
    private int piso;
    private char letra;

    public Direccion (){
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
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+");
            if(!valido){
                System.out.println("Solo se permiten letras no numeros ni simbolos");
            }
        }while (!valido);
        return input;

    }
    public char pedirLetra(String letra) {
        String input;
        boolean valido;
        do{
            System.out.println(letra);
            input =sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+");
            if(!valido){
                System.out.println("Error: Solo se permiten introduccir una letra");
            }
        }while (!valido);
        return input.charAt(0);
    }
}
