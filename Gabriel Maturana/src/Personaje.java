public class Personaje {

    private int vida;
    private int ataque;
    private int defensa;
    private int superataque;

    public Personaje(int vida, int ataque, int defensa,  int superataque) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.superataque = superataque;
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

    public int getSuperataque(){return superataque;}

    public void setSuperataque(int superataque){this.superataque = superataque;}
}
