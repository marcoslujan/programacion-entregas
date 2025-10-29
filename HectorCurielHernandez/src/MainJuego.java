import clases.Personaje;

import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del Jugador 1: ");
        String nombre1 = sc.nextLine();

        System.out.print("Nombre del Jugador 2: ");
        String nombre2 = sc.nextLine();

        Personaje pj1 = new Personaje(1000, 100, 200, 200, 400);
        Personaje pj2 = new Personaje(1000, 100, 200, 200, 400);

        int turno = 1;

        System.out.println("\n--- COMIENZA EL COMBATE ENTRE " + nombre1 + " Y " + nombre2 + " ---\n");

        while (turno <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            System.out.println("=== TURNO " + turno + " ===");

            boolean especial = (turno % 5 == 0);

            System.out.println("\nTurno de " + nombre1);
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            if (especial) {
                System.out.println("3. Ataque Especial");
                System.out.println("4. Defensa Especial");
            }
            System.out.print("Elige opción: ");
            int opcion1 = sc.nextInt();

            System.out.println("\nTurno de " + nombre2);
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            if (especial) {
                System.out.println("3. Ataque Especial");
                System.out.println("4. Defensa Especial");
            }
            System.out.print("Elige opción: ");
            int opcion2 = sc.nextInt();

            int daño1 = 0;
            int daño2 = 0;


            if (opcion1 == 1) daño1 = pj1.getAtaque();
            else if (especial && opcion1 == 3) daño1 = pj1.getAtaqueEspecial();


            if (opcion2 == 1) daño2 = pj2.getAtaque();
            else if (especial && opcion2 == 3) daño2 = pj2.getAtaqueEspecial();


            if (opcion2 == 2) daño1 -= pj2.getDefensa();
            else if (especial && opcion2 == 4) daño1 -= pj2.getDefensaEspecial();


            if (opcion1 == 2) daño2 -= pj1.getDefensa();
            else if (especial && opcion1 == 4) daño2 -= pj1.getDefensaEspecial();


            if (daño1 > 0) pj2.setVida(pj2.getVida() - daño1);
            if (daño2 > 0) pj1.setVida(pj1.getVida() - daño2);

            System.out.println("\n" + nombre1 + " hace " + Math.max(0, daño1) + " de daño a " + nombre2);
            System.out.println(nombre2 + " hace " + Math.max(0, daño2) + " de daño a " + nombre1);

            System.out.println("\nVida de " + nombre1 + ": " + pj1.getVida());
            System.out.println("Vida de " + nombre2 + ": " + pj2.getVida());
            System.out.println("---------------------------");

            if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
                System.out.println(" ¡Empate! Ambos han caído.");
                break;
            } else if (pj1.getVida() <= 0) {
                System.out.println("🏆 " + nombre2 + " ha ganado el combate!");
                break;
            } else if (pj2.getVida() <= 0) {
                System.out.println("🏆 " + nombre1 + " ha ganado el combate!");
                break;
            }

            turno++;
        }

        if (turno > 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            System.out.println(" ¡Empate tras 20 turnos!");
        }

        sc.close();
    }
}




