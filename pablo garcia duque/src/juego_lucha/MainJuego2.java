package juego_lucha;

import clases.MyScanner;

public class MainJuego2 {
    private static final MyScanner sc = new MyScanner();
    public static void main(String[] args) {

        jugarJuego();
    }

    private static void jugarJuego () {
        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);
        int turno = 0;

        while (turno < 20 && pj1.getVida() > 0 && pj2.getVida() > 0)
        {
            System.out.println("Que va a hacer el pj1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.pedirNumero("Introduce opción: ");
            System.out.println("Que va a hacer el pj2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.pedirNumero("Introduce opción: ");

            if (opcion1 == 1 && opcion2 == 2) {
                turno++;
                if (pj2.getDefensa() != 0) {
                    int ataque = pj1.getAtaque();
                    int defensa = pj2.getDefensa();
                    pj2.setDefensa(defensa - ataque);
                    System.out.println("Jugador 1 elige ataque y jugador 2 elige defenderse. La armadura del jugador 2 se reduce a " + pj2.getDefensa() + " . Jugador 1 tiene " + pj1.getVida()
                            + " de vida y Jugador 2 tiene " + pj2.getVida() + " de vida. Vais por el turno " + turno);
                } else {
                    int ataque = pj1.getAtaque();
                    int vida = pj2.getVida();
                    pj2.setVida(vida - ataque);
                    System.out.println("Jugador 1 elige ataque y jugador 2 elige defenderse. Jugador 1 tiene " + pj1.getVida()
                            + " de vida y Jugador 2 tiene " + pj2.getVida() + " de vida. Vais por el turno " + turno);
                }

            } else if (opcion1 == 2 && opcion2 == 1) {
                turno++;
                if (pj1.getDefensa() != 0) {
                    int ataque = pj2.getAtaque();
                    int defensa = pj1.getDefensa();
                    pj1.setDefensa(defensa - ataque);
                    System.out.println("Jugador 1 elige defenderse y Jugador elige atacar. La armadura del jugador 1 se reduce a " + pj1.getDefensa() + " . Jugador 1 tiene " + pj1.getVida()
                            + " de vida y Jugador 2 tiene " + pj2.getVida() + " de vida. Vais por el turno " + turno);
                } else {
                    int ataque = pj2.getAtaque();
                    int vida = pj1.getVida();
                    pj2.setVida(vida - ataque);
                    System.out.println("Jugador 2 elige ataque y jugador 1 elige defenderse. Jugador 2 tiene " + pj2.getVida()
                            + " de vida y Jugador 1 tiene " + pj1.getVida() + " de vida. Vais por el turno " + turno);
                }

            } else if (opcion1 == 1 && opcion2 == 1) {
                turno++;
                int vida1 = pj2.getVida();
                int ataque1 = pj1.getAtaque();
                pj2.setVida(vida1 - ataque1);
                int vida2 = pj1.getVida();
                int ataque2 = pj2.getAtaque();
                pj1.setVida(vida2 - ataque2);
                System.out.println("¡Ambos jugadores eligen atacar! Jugador 1 tiene " + pj1.getVida()
                        + " de vida y Jugador 2 tiene " + pj2.getVida() + " de vida. Vais por el turno " + turno);

            } else {
                turno++;
                System.out.println("Os miráis fijamente... Jugador 1 tiene " + pj1.getVida() + " de vida y Jugador 2 tiene " + pj2.getVida()
                        + " de vida. Vais por el turno " + turno);
            }
        }

        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println("¡El juego ha terminado! ¡Habéis empatado!");
        }
        else if (pj1.getVida() <= 0) {
            System.out.println("¡El juego ha terminado! ¡El jugador 2 ha ganado!");
        }
        else if (pj2.getVida() <= 0) {
            System.out.println("¡El juego ha terminado! ¡El jugador 1 ha ganado!");
        }
        else if (turno >= 19) {
            System.out.println("¡La partida ha finalizado! ¡Os habéis quedado sin tiempo!");
        }
    }
}
// Hacer nuevos constructores y que no termine el juego hasta que pasen 20 turnos o un personaje se quede sin vida
