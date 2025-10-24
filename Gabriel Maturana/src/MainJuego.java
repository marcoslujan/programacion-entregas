import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personaje pj1 = new Personaje(1000, 100, 200, 400);
        Personaje pj2 = new Personaje(1000, 100, 200, 400);

        int ronda = 1;

        while (ronda <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            System.out.println(" RONDA " + ronda + " ");
            System.out.println("Vida PJ1: " + pj1.getVida() + " | Vida PJ2: " + pj2.getVida());

            System.out.println("\nQue va a hacer el pj1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Super Ataque");
            int opcion1 = sc.nextInt();

            System.out.println("\nQue va a hacer el pj2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Super Ataque");
            int opcion2 = sc.nextInt();


            if (opcion1 == 1 && opcion2 == 2) {
                int ataque = pj1.getAtaque();
                int defensa = pj2.getDefensa();
                pj2.setDefensa(defensa - ataque);
            } else if (opcion1 == 2 && opcion2 == 1) {
                int ataque = pj2.getAtaque();
                int defensa = pj1.getDefensa();
                pj1.setDefensa(defensa - ataque);
            } else if (opcion1 == 1 && opcion2 == 1) {
                int vida1 = pj2.getVida();
                int ataque1 = pj1.getAtaque();
                pj2.setVida(vida1 - ataque1);
                int vida2 = pj1.getVida();
                int ataque2 = pj2.getAtaque();
                pj1.setVida(vida2 - ataque2);
            } else if (opcion1 == 3 && opcion2 == 1) {
                int vida3 = pj2.getVida();
                int superataque = pj1.getSuperataque();
                pj2.setVida(vida3 - superataque);
                int vida4 = pj1.getVida();
                int ataque3 = pj2.getAtaque();
                pj1.setVida(vida4 - ataque3);
            } else if (opcion1 == 3 && opcion2 == 2) {
                int superataque = pj1.getSuperataque();
                int defensa = pj2.getDefensa();
                pj2.setDefensa(defensa - superataque);
            } else if (opcion1 == 3 && opcion2 == 3) {
                int vida3 = pj2.getVida();
                int superataque = pj1.getSuperataque();
                pj2.setVida(vida3 - superataque);
                int vida4 = pj1.getVida();
                int superataque2 = pj2.getSuperataque();
                pj1.setVida(vida4 - superataque2);
            } else if (opcion1 == 1 && opcion2 == 3) {
                int vida3 = pj1.getVida();
                int superataque = pj2.getSuperataque();
                pj1.setVida(vida3 - superataque);
                int vida4 = pj2.getVida();
                int ataque3 = pj1.getAtaque();
                pj2.setVida(vida4 - ataque3);
            } else if (opcion1 == 2 && opcion2 == 3) {
                int defensa = pj1.getDefensa();
                int superataque = pj2.getSuperataque();
                pj2.setDefensa(defensa - superataque);
            }

            if (pj1.getVida() <= 0 || pj2.getVida() <= 0) {
                break;
            }

            ronda++;
            System.out.println();
        }


        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println(" Empate");
        } else if (pj1.getVida() <= 0) {
            System.out.println("Jugador 2 gana");
        } else if (pj2.getVida() <= 0) {
            System.out.println("Jugador 1 gana");
        } else {
            System.out.println("Se acabaron las 20 rondas Empate");
            System.out.println("Vida final -> PJ1: " + pj1.getVida() + " | PJ2: " + pj2.getVida());
        }

        sc.close();
    }
}
