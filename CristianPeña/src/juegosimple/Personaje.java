package juegosimple;

public class Personaje {
    private String nickname;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueMax;

    public Personaje(String nickname, int ataque, int vida, int defensa, int ataqueMax) {
        this.nickname = nickname;
        this.ataque = ataque;
        this.vida = vida;
        this.defensa = defensa;
        this.ataqueMax = ataqueMax;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getAtaqueMax() {
        return ataqueMax;
    }

    public void setAtaqueMax(int ataqueMax) {
        this.ataqueMax = ataqueMax;
    }
}