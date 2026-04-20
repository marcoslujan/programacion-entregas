import juego.Personaje;

import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personaje pj1 = new Personaje(1000, 200, 100);
        Personaje pj2 = new Personaje(1000, 200, 100);

        int turno = 1;


        do {
            System.out.println("\n TURNO " + turno + " ");
            System.out.println("Vida PJ1: " + pj1.getVida() + "  Vida PJ2: " + pj2.getVida());


            System.out.println("\n Qué va a hacer el PJ1?");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.nextInt();

            System.out.println("\n Qué va a hacer el PJ2?");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.nextInt();


            int defensaOriginalPJ1 = pj1.getDefensa();
            int defensaOriginalPJ2 = pj2.getDefensa();

            if (opcion1 == 2) {
                pj1.setDefensa(pj1.getDefensa() + 50);
                System.out.println("PJ1 se defiende (+50 defensa temporal).");
            }
            if (opcion2 == 2) {
                pj2.setDefensa(pj2.getDefensa() + 50);
                System.out.println("PJ2 se defiende (+50 defensa temporal).");
            }

            if (opcion1 == 1) {
                int daño = pj1.getAtaque() - (pj2.getDefensa() / 2);
                if (daño < 0) daño = 0;
                pj2.setVida(pj2.getVida() - daño);
                System.out.println("PJ1 ataca e inflige " + daño + " de daño a PJ2.");
            }

            if (opcion2 == 1) {
                int daño = pj2.getAtaque() - (pj1.getDefensa() / 2);
                if (daño < 0) daño = 0;
                pj1.setVida(pj1.getVida() - daño);
                System.out.println("PJ2 ataca e inflige " + daño + " de daño a PJ1.");
            }

            pj1.setDefensa(defensaOriginalPJ1);
            pj2.setDefensa(defensaOriginalPJ2);

            turno++;

        } while (turno <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0);

        System.out.println("\n=== FIN DEL JUEGO ===");
        System.out.println("Vida final PJ1: " + pj1.getVida());
        System.out.println("Vida final PJ2: " + pj2.getVida());

        if (pj1.getVida() > pj2.getVida()) {
            System.out.println("Gana PJ1");
        } else if (pj2.getVida() > pj1.getVida()) {
            System.out.println(" Gana PJ2");
        } else {
            System.out.println("Empate");
        }

        sc.close();
    }
}

