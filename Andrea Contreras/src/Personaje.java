public class Personaje {

    private int vida;
    private int ataque;
    private int defensa;
    private int turno;

    public Personaje(int vida, int ataque, int defensa, int turno) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.turno = 0;
    }

    public Personaje(int vida, int ataque, int defensa) {
        this.vida = vida;
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

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
