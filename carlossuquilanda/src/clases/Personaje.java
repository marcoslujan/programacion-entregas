package carlossuquilanda.src.clases;

public class Personaje {

    private int vida;
    private int ataque;
    private int defensa;
    private int baile;

    public Personaje(int vida, int ataque, int defensa,int baile) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.baile = baile;
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

    public void setDefensa(int defensa) { this.defensa = defensa; }


    public int getBaile() {return baile;}

    public void setBaile(int baile) {this.baile = baile;}
}
