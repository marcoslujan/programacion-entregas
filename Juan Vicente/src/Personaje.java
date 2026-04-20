public class Personaje {
    private int vida;
    private int ataque;
    private int defensa;

    public Personaje(int vida, int ataque, int defensa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public Personaje() {
        this.vida = 100;
        this.ataque = 10;
        this.defensa = 5;
    }

    public Personaje(int vida, int ataque) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = 5;
    }

    public Personaje(int vida) {
        this.vida = vida;
        this.ataque = 10;
        this.defensa = 5;
    }

    public Personaje(int ataque, int defensa, boolean tipo) {
        this.vida = 100;
        this.ataque = ataque;
        this.defensa = defensa;
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
}