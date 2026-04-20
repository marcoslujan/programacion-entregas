public class Personaje {

    private int vida;
    private int ataque;
    private int defensa;
    private int turno;
    public Personaje(int vida, int ataque, int defensa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }
    public Personaje(int vida, int turno, int defensa, int ataque) {
        this.vida = vida;
        this.turno = 0;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
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

    @Override
    public String toString() {
        return "Personaje{" + "vida=" + vida + ", ataque=" + ataque
                + ", defensa=" + defensa + ", turno=" + turno + '}';
    }
}
