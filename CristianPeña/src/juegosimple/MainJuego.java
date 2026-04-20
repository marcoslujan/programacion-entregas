package juegosimple;

import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje personaje1 = new Personaje("Jugador 1", 10, 100, 30, 20);
        Personaje personaje2 = new Personaje("Jugador 2", 10, 100, 30, 20);

        int turno = 1;
        System.out.println("===== Juego Simple por turnos =====");

        boolean personaje1Max = false;
        boolean personaje2Max = false;

        while (personaje1.getVida() > 0 && personaje2.getVida() > 0 && turno <= 20) {
            System.out.println("-- Turno " + turno + " ---");
            System.out.println("--- Turno del " + personaje1.getNickname() + " ---");
            System.out.println("1- Atacar");
            System.out.println("2- Defender");
            System.out.println("3- Ataque pesado (una sola vez)");
            System.out.print("-- Elige una opción: ");
            int opcion1 = sc.nextInt();

            System.out.println("--- Turno del " + personaje2.getNickname() + " ---");
            System.out.println("1- Atacar");
            System.out.println("2- Defender");
            System.out.println("3- Ataque pesado (una sola vez)");
            System.out.print("-- Elige una opción: ");
            int opcion2 = sc.nextInt();

            if (opcion1 == 1 && opcion2 == 2) {
                int daño = personaje1.getAtaque();
                personaje2.setDefensa(personaje2.getDefensa() - daño);
                System.out.println(personaje1.getNickname() + " ataca y reduce defensa de " +
                        personaje2.getNickname() + " en " + daño);
            } else if (opcion1 == 2 && opcion2 == 1) {
                int daño = personaje2.getAtaque();
                personaje1.setDefensa(personaje1.getDefensa() - daño);
                System.out.println(personaje2.getNickname() + " ataca y reduce defensa de " +
                        personaje1.getNickname() + " en " + daño);
            } else if (opcion1 == 1 && opcion2 == 1) {
                int daño1 = personaje1.getAtaque();
                int daño2 = personaje2.getAtaque();
                personaje2.setVida(personaje2.getVida() - daño1);
                personaje1.setVida(personaje1.getVida() - daño2);
                System.out.println(personaje1.getNickname() + " inflige " + daño1 + " de daño a " +
                        personaje2.getNickname());
                System.out.println(personaje2.getNickname() + " inflige " + daño2 + " de daño a " +
                        personaje1.getNickname());
            } else if (opcion1 == 2 && opcion2 == 2) {
                System.out.println("Ambos jugadores se defienden. No ocurre nada.");
            }

            if (opcion1 == 3) {
                if (!personaje1Max) {
                    int daño = personaje1.getAtaqueMax();
                    personaje2.setVida(personaje2.getVida() - daño);
                    personaje1Max = true;
                    System.out.println(personaje1.getNickname() + " usa un ataque pesado e inflige " + daño + " de daño al jugador 2 ");
                } else {
                    System.out.println(personaje1.getNickname() + " ya usó su ataque pesado.");
                }
            }

            if (opcion2 == 3) {
                if (!personaje2Max) {
                    int daño = personaje2.getAtaqueMax();
                    personaje1.setVida(personaje1.getVida() - daño);
                    personaje2Max = true;
                    System.out.println(personaje2.getNickname() + " usa un ataque pesado e inflige " + daño + " de daño al jugador 1 !");
                } else {
                    System.out.println(personaje2.getNickname() + " ya usó su ataque pesado.");
                }
            }

            System.out.println("Estadísticas después del turno" + turno + ":");
            System.out.println(personaje1.getNickname() + " -> Vida: " + personaje1.getVida() +
                    ", Defensa: " + personaje1.getDefensa());
            System.out.println(personaje2.getNickname() + " -> Vida: " + personaje2.getVida() +
                    ", Defensa: " + personaje2.getDefensa());

            turno++;
        }

        System.out.println("===== FIN DEL JUEGO =====");
        if (personaje1.getVida() <= 0 && personaje2.getVida() <= 0) System.out.println("Empate");
        else if (personaje1.getVida() > 0) System.out.println(personaje1.getNickname() + " gana!");
        else System.out.println(personaje2.getNickname() + " gana!");
    }
}
