package src.src.Main;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
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

    public int getDefensa() {
        return defensa;
    }


    public int recibirAtaque(int ataque) {
        int danio = ataque - defensa;
        if (danio < 0) danio = 0;
        vida -= danio;
        if (vida < 0) vida = 0;
        return danio;
    }
}
