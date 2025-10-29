package src.src.Main;

import clases.Personaje;
import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al juego de pelea de personajes");
        System.out.println("Introduce el nombre del PJ1: ");
        String nombre1 = sc.nextLine();
        System.out.println("Introduce el nombre del PJ2: ");
        String nombre2 = sc.nextLine();

        Personaje pj1 = new Personaje(nombre1, 1000, 100, 20);
        Personaje pj2 = new Personaje(nombre2, 1000, 100, 20);

        int turno = 1;
        while (turno <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            System.out.println("\n--- Turno " + turno + " ---");

            System.out.println(pj1.getNombre() + " - ¿Qué va a hacer?: ");
            int opcion1 = sc.nextInt();
            System.out.println("1. Atacar");
            System.out.println("2. Defender");

            System.out.println(pj2.getNombre() + " - ¿Qué va a hacer?: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.nextInt();

            if (opcion1 == 1 && opcion2 == 2) {
                int danio = pj2.recibirAtaque(pj1.getAtaque());
                System.out.println(pj1.getNombre() + " ataca y causa " + danio + " de daño a " + pj2.getNombre());
                System.out.println(pj2.getNombre() + " - Vida restante: " + pj2.getVida());
            } else if (opcion1 == 2 && opcion2 == 1) {
                int danio = pj1.recibirAtaque(pj2.getAtaque());
                System.out.println(pj2.getNombre() + " ataca y causa " + danio + " de daño a " + pj1.getNombre());
                System.out.println(pj1.getNombre() + " - Vida restante: " + pj1.getVida());
            } else if (opcion1 == 1 && opcion2 == 1) {
                int danioA = pj2.recibirAtaque(pj1.getAtaque());
                System.out.println(pj1.getNombre() + " ataca y causa " + danioA + " de daño a " + pj2.getNombre());
                System.out.println(pj2.getNombre() + " - Vida restante: " + pj2.getVida());

                int danioB = pj1.recibirAtaque(pj2.getAtaque());
                System.out.println(pj2.getNombre() + " ataca y causa " + danioB + " de daño a " + pj1.getNombre());
                System.out.println(pj1.getNombre() + " - Vida restante: " + pj1.getVida());
            } else {
                System.out.println("Ambos se defienden, nadie recibe daño.");
            }

            turno++;
        }

        System.out.println("\n--- Fin del combate ---");
        if (pj1.getVida() > pj2.getVida()) {
            System.out.println(pj1.getNombre() + " ha ganado!");
        } else if (pj2.getVida() > pj1.getVida()) {
            System.out.println(pj2.getNombre() + " ha ganado!");
        } else {
            System.out.println("El combate ha terminado en empate!");
        }
    }
}
