import clases.Personaje;

import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = sc.nextLine();

        Personaje pj1 = new Personaje(1000, 100, 200, 200, 400);
        Personaje pj2 = new Personaje(1000, 100, 200, 200, 400);

        System.out.println("\n--- COMIENZA LA BATALLA ENTRE " + nombre1 + " Y " + nombre2 + " ---\n");

        for (int turno = 1; turno <= 20; turno++) {
            boolean especial = (turno % 3 == 0);
            System.out.println("----- TURNO " + turno + (especial ? " (ESPECIAL)" : "") + " -----");

            int opcion1 = pedirOpcion(sc, nombre1, especial);
            int opcion2 = pedirOpcion(sc, nombre2, especial);

            int daño1 = obtenerAtaque(pj1, opcion1, especial);
            int daño2 = obtenerAtaque(pj2, opcion2, especial);

            int defensa1 = obtenerDefensa(pj1, opcion1, especial);
            int defensa2 = obtenerDefensa(pj2, opcion2, especial);

            if (opcion1 <= 2 && opcion2 <= 2) {
                if (opcion1 == 1 && opcion2 == 2) pj2.setVida(pj2.getVida() - Math.max(daño1 - defensa2 / 4, 0));
                else if (opcion2 == 1 && opcion1 == 2) pj1.setVida(pj1.getVida() - Math.max(daño2 - defensa1 / 4, 0));
                else if (opcion1 == 1 && opcion2 == 1) {
                    pj1.setVida(pj1.getVida() - daño2);
                    pj2.setVida(pj2.getVida() - daño1);
                }
            } else {
                if (opcion1 == 3 && opcion2 == 4) pj2.setVida(pj2.getVida() - Math.max(daño1 - defensa2 / 2, 0));
                else if (opcion2 == 3 && opcion1 == 4) pj1.setVida(pj1.getVida() - Math.max(daño2 - defensa1 / 2, 0));
                else if (opcion1 == 3 && opcion2 == 3) {
                    pj1.setVida(pj1.getVida() - daño2);
                    pj2.setVida(pj2.getVida() - daño1);
                }
            }

            System.out.println(nombre1 + " tiene " + pj1.getVida() + " de vida.");
            System.out.println(nombre2 + " tiene " + pj2.getVida() + " de vida.\n");


            if (pj1.getVida() <= 0 && pj2.getVida() <= 0) { System.out.println("¡Empate! Ambos han caído."); break; }
            if (pj1.getVida() <= 0) { System.out.println(nombre2 + " gana la batalla."); break; }
            if (pj2.getVida() <= 0) { System.out.println(nombre1 + " gana la batalla."); break; }

            if (turno == 20) {
                if (pj1.getVida() > pj2.getVida()) System.out.println("Gana " + nombre1 + " por tener más vida.");
                else if (pj2.getVida() > pj1.getVida()) System.out.println("Gana " + nombre2 + " por tener más vida.");
                else System.out.println("¡Empate! Ambos terminan con la misma vida.");
            }
        }

        System.out.println("\n--- FIN DE LA PARTIDA ---");
        sc.close();
    }

    private static int pedirOpcion(Scanner sc, String nombre, boolean especial) {
        System.out.println(nombre + ", elige acción:");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        if (especial) {
            System.out.println("3. Puño Mortífero");
            System.out.println("4. Guardia Whittaker");
        }
        System.out.print("Opción: ");
        while (!sc.hasNextInt()) { sc.next(); System.out.print("Introduce un número válido: "); }
        return sc.nextInt();
    }

    private static int obtenerAtaque(Personaje pj, int opcion, boolean especial) {
        if (especial && opcion == 3) return pj.getAtaqueEspecial();
        if (opcion == 1) return pj.getAtaque();
        return 0;
    }

    private static int obtenerDefensa(Personaje pj, int opcion, boolean especial) {
        if (especial && opcion == 4) return pj.getDefensaEspecial();
        if (opcion == 2) return pj.getDefensa();
        return 0;
    }
}
