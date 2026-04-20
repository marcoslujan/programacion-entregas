package clases;

public class Direccion {
    private String calle;
    private int portal;
    private int piso;
    private int letra;

    public Direccion() {
    }

    public Direccion(String calle, int portal, int piso, int letra) {
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

    public int getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
}
