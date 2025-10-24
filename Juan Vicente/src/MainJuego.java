import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);

        int ronda = 1;
        boolean juegoActivo = true;

        System.out.println("=== ¡Comienza la batalla! ===");

        while (ronda <= 20 && juegoActivo) {
            System.out.println("\n--- RONDA " + ronda + " ---");

            System.out.println("Qué va a hacer el pj1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.nextInt();

            System.out.println("Qué va a hacer el pj2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.nextInt();

            if (opcion1 == 1 && opcion2 == 2) {
                int danio = (int) (pj1.getAtaque() * 0.3);
                pj2.setVida(pj2.getVida() - danio);
                System.out.println("pj1 ataca y pj2 se defiende. Daño reducido: " + danio);

            } else if (opcion1 == 2 && opcion2 == 1) {
                int danio = (int) (pj2.getAtaque() * 0.3);
                pj1.setVida(pj1.getVida() - danio);
                System.out.println("pj2 ataca y pj1 se defiende. Daño reducido: " + danio);

            } else if (opcion1 == 1 && opcion2 == 1) {
                int danio1 = pj1.getAtaque();
                int danio2 = pj2.getAtaque();
                pj1.setVida(pj1.getVida() - danio2);
                pj2.setVida(pj2.getVida() - danio1);
                System.out.println("¡Ambos atacan! pj1 recibe " + danio2 + " y pj2 recibe " + danio1);

            } else if (opcion1 == 2 && opcion2 == 2) {
                System.out.println("Ambos se defienden. Nadie recibe daño.");
            }

            System.out.println("\nVida actual:");
            System.out.println("pj1 -> " + pj1.getVida());
            System.out.println("pj2 -> " + pj2.getVida());

            if (pj1.getVida() <= 0 || pj2.getVida() <= 0) {
                juegoActivo = false;
                break;
            }
            ronda++;
        }

        System.out.println("\n=== FIN DEL JUEGO ===");
        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println("¡Ambos han caído! Es un empate.");
        } else if (pj1.getVida() <= 0) {
            System.out.println("pj2 gana la batalla.");
        } else if (pj2.getVida() <= 0) {
            System.out.println("pj1 gana la batalla.");
        } else {
            System.out.println("Se alcanzaron las 20 rondas.");
            if (pj1.getVida() > pj2.getVida()) {
                System.out.println("pj1 gana por tener más vida.");
            } else if (pj2.getVida() > pj1.getVida()) {
                System.out.println("pj2 gana por tener más vida.");
            } else {
                System.out.println("Empate técnico.");
            }
        }
        sc.close();
    }
}