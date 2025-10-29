//package clase;
//
//public class Personaje {
//
//    private int vida;
//    private int ataque;
//    private int defensa;
//
//    public Personaje(int vida, int ataque, int defensa) {
//        this.vida = vida;
//        this.ataque = ataque;
//        this.defensa = defensa;
//    }
//
//    public int getVida() {
//        return vida;
//    }
//
//    public void setVida(int vida) {
//        this.vida = vida;
//    }
//
//    public int getAtaque() {
//        return ataque;
//    }
//
//    public void setAtaque(int ataque) {
//        this.ataque = ataque;
//    }
//
//    public int getDefensa() {
//        return defensa;
//    }
//
//    public void setDefensa(int defensa) {
//        this.defensa = defensa;
//    }
//}

package clase;

public class Personaje {
    private int vida;
    private int ataque;
    private int defensa;
    private String nombre;

    public Personaje(int vida, int ataque, int defensa, String nombre) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nombre = nombre;
    }

    public Personaje(int vida, int ataque, int defensa) {
        this(vida, ataque, defensa, "Personaje");
    }

    public Personaje(String nombre) {
        this(100, 50, 30, nombre);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = Math.max(0, vida); // La vida no puede ser negativa
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = Math.max(0, ataque); // El ataque no puede ser negativo
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = Math.max(0, defensa); // La defensa no puede ser negativa
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}