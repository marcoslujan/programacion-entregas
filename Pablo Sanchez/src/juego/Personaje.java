package juego;

public class Personaje {
    private int vida;
    private int ataque;
    private int defensa;

    public Personaje(){

    }

    public Personaje(int vida, int ataque, int defensa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    // Aplica daño con defensa degradable
    public void recibirDanio(int danio) {
        if (defensa > 0) {
            defensa -= danio;
            if (defensa < 0) {
                vida += defensa; // defensa es negativa → resta a la vida
                defensa = 0;
            }
        } else {
            vida -= danio;
        }

        if (vida < 0) vida = 0;
    }
}


