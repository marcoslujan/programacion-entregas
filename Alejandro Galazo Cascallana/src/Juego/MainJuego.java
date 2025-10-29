package Juego;

public class MainJuego {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();

        String nombre1 = sc.pedirSoloTexto("Nombre del Pj1: ");
        String elemento1;
        do {
            elemento1 = sc.pedirSoloTexto("Elemento del Pj1 (agua, fuego, tierra, viento, rayo): ").toLowerCase();
        } while (!elemento1.matches("agua|fuego|tierra|viento|rayo"));

        int vidaBase1 = 1000;
        if (elemento1.equals("agua")) vidaBase1 = (int)(vidaBase1 * 1.5);
        Personaje pj1 = new Personaje(nombre1, elemento1, vidaBase1, 100, 200);

        String nombre2 = sc.pedirSoloTexto("Nombre del Pj2: ");
        String elemento2;
        do {
            elemento2 = sc.pedirSoloTexto("Elemento del Pj2 (agua, fuego, tierra, viento, rayo): ").toLowerCase();
        } while (!elemento2.matches("agua|fuego|tierra|viento|rayo"));

        int vidaBase2 = 1000;
        if (elemento2.equals("agua")) vidaBase2 = (int)(vidaBase2 * 1.5);
        Personaje pj2 = new Personaje(nombre2, elemento2, vidaBase2, 100, 200);

        System.out.println("\n--- Estadísticas iniciales ---");
        mostrarEstadisticas(pj1);
        mostrarEstadisticas(pj2);

        int turnos = 0;
        while (turnos < 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            turnos++;
            System.out.println("\nTurno " + turnos);

            System.out.println("Que va a hacer " + pj1.getNombre() + " (" + pj1.getElemento() + "): ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.pedirNumero("Opción " + pj1.getNombre() + ":");

            System.out.println("Que va a hacer " + pj2.getNombre() + " (" + pj2.getElemento() + "): ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.pedirNumero("Opción " + pj2.getNombre() + ":");

            if (opcion1 == 1) {
                int daño = calcularDanio(pj1, pj2);
                pj2.setVida(pj2.getVida() - daño);
            }
            if (opcion2 == 1) {
                int daño = calcularDanio(pj2, pj1);
                pj1.setVida(pj1.getVida() - daño);
            }

            System.out.println("Estado " + pj1.getNombre() + ": Vida=" + pj1.getVida() + " Defensa=" + pj1.getDefensa());
            System.out.println("Estado " + pj2.getNombre() + ": Vida=" + pj2.getVida() + " Defensa=" + pj2.getDefensa());
        }

        System.out.println("\nEl juego ha terminado tras " + turnos + " turnos.");
        if (pj1.getVida() > pj2.getVida()) {
            System.out.println("Gana " + pj1.getNombre());
        } else if (pj2.getVida() > pj1.getVida()) {
            System.out.println("Gana " + pj2.getNombre());
        } else {
            System.out.println("Empate");
        }
    }

    public static int calcularDanio(Personaje atacante, Personaje defensor) {
        int ataque = atacante.getAtaque();
        int defensa = defensor.getDefensa();
        double dañoBase;

        dañoBase = ataque * (100.0 / (100.0 + defensa));

        switch (atacante.getElemento()) {
            case "fuego":
                dañoBase *= 1.5;
                break;
            case "viento":
                dañoBase = atacante.getAtaque();
                double factor = 0.85 + Math.random() * 0.3;
                dañoBase *= factor;
                break;
            case "rayo":
                dañoBase += 0.10 * defensor.getVida();
                break;
        }

        if (defensor.getElemento().equals("tierra")) {
            dañoBase *= 0.75;
        }

        return Math.max(1, (int)Math.round(dañoBase));
    }

    public static void mostrarEstadisticas(Personaje pj) {
        System.out.println("Nombre: " + pj.getNombre());
        System.out.println("Elemento: " + pj.getElemento());
        System.out.println("Vida: " + pj.getVida());
        System.out.println("Ataque: " + pj.getAtaque());
        System.out.println("Defensa: " + pj.getDefensa());
        System.out.println("-------------------------------");
    }
}
