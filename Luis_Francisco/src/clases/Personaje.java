package clases;

public class Personaje {

    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;


    //Juego por turnos, que sean uno y dos, que te pregunte todo el rato hasta que te ponga la opcion correcta, juego de 20 turnos máximo

    public Personaje() {}

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje(String nombre, int vida, int defensa, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
