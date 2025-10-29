package clases;

public class Personaje {

    private int vida;
    private int ataque;
    private int escudo; // antes defensa
    private boolean esquive;
    private boolean critico;

    public Personaje(int vida, int ataque, int escudo, boolean esquive, boolean critico) {
        this.vida = vida;
        this.ataque = ataque;
        this.escudo = escudo;
        this.esquive = esquive;
        this.critico = critico;
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

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public boolean getEsquive() {
        return esquive;
    }

    public void setEsquive(boolean esquive) {
        this.esquive = esquive;
    }

    public boolean getCritico() {
        return critico;
    }

    public void setCritico(boolean critico) {
        this.critico = critico;
    }
}

