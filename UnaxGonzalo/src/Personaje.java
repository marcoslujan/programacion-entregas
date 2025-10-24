public class Personaje {

    private int vida;
    private int ataque;
    private int defensa;

    public Personaje() {
        this.vida = 100;
        this.ataque = 100;
        this.defensa = 200;
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

    public void atacar(Personaje enemigo) {
        int danhoBase = (ataque / 2) + (int)(Math.random() * (ataque / 2));
        int danho = danhoBase - (enemigo.getDefensa() / 4);
        if (danho < 5) danho = 5;
        enemigo.setVida(Math.max(0, enemigo.getVida() - danho));
        System.out.println("Ataque normal causa " + danho + " de daño.");
    }

    public void atacar(Personaje enemigo, double probCritico) {
        double random = Math.random();
        int danhoBase = (ataque / 2) + (int)(Math.random() * (ataque / 2));
        int danho = danhoBase - (enemigo.getDefensa() / 4);
        if (random < probCritico) {
            danho *= 2;
            System.out.println("Golpe crítico!");
        }
        if (danho < 5) danho = 5;
        enemigo.setVida(Math.max(0, enemigo.getVida() - danho));
        System.out.println("Ataque causa " + danho + " de daño.");
    }

    public void defender() {
        this.defensa += 50;
        System.out.println("Defensa aumentada temporalmente en 50 puntos.");
    }

    public void resetDefensa(int defensaBase) {
        this.defensa = defensaBase;
    }
}
//A12