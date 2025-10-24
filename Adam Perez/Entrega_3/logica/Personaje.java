package logica;

public class Personaje {
    MyScanner scanner = new MyScanner();

    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;

    public Personaje() {
    }

    public Personaje(int vida, int ataque, int defensa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public Personaje(int vida, int ataque, int defensa, double velocidad) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = (int) velocidad;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
