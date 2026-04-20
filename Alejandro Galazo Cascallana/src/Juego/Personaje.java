package Juego;

public class Personaje {

    private String nombre;
    private String elemento;
    private int vida;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, String elemento, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.elemento = elemento.toLowerCase();
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getElemento() { return elemento; }
    public void setElemento(String elemento) { this.elemento = elemento.toLowerCase(); }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = Math.max(0, vida); }

    public int getAtaque() {
        if (Math.random() < 0.5) { // 50% crítico
            return ataque * 2;
        }
        return ataque;
    }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = Math.max(0, defensa); }
}
