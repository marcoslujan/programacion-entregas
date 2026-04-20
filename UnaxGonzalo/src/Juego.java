import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje pj1 = new Personaje();
        Personaje pj2 = new Personaje();

        int turnos = 1;

        System.out.println("=== BATALLA COMIENZA ===");

        while (turnos <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            System.out.println("\n--- TURNO " + turnos + " ---");

            int opcion1 = pedirOpcion(sc, 1);
            int opcion2 = pedirOpcion(sc, 2);

            // Decide al azar que jugador va primero
            boolean pj1Primero = Math.random() < 0.5;

            if (pj1Primero) {
                System.out.println("Jugador 1 actúa primero.");
                ejecutarTurno(pj1, pj2, opcion1, opcion2);
            } else {
                System.out.println("Jugador 2 actúa primero.");
                ejecutarTurno(pj2, pj1, opcion2, opcion1);
            }

            // Reset defensa
            pj1.resetDefensa(pj1.getDefensa());
            pj2.resetDefensa(pj2.getDefensa());

            System.out.println("\nVida PJ1: " + pj1.getVida());
            System.out.println("Vida PJ2: " + pj2.getVida());

            if (pj1.getVida() == 0 || pj2.getVida() == 0) break;

            turnos++;
        }

        System.out.println("\n=== FIN DE LA BATALLA ===");
        if (pj1.getVida() > pj2.getVida()) {
            System.out.println("Gana el jugador 1.");
        } else if (pj2.getVida() > pj1.getVida()) {
            System.out.println("Gana el jugador 2.");
        } else {
            System.out.println("Empate.");
        }

        sc.close();
    }

    // 1 o 2,
    private static int pedirOpcion(Scanner sc, int jugador) {
        int opcion = 0;
        while (true) {
            System.out.println("\nJugador " + jugador + ": 1.Atacar  2.Defender");
            System.out.print("Opción: ");
            String entrada = sc.nextLine();

            if (entrada.equals("1") || entrada.equals("2")) {
                opcion = Integer.parseInt(entrada);
                break;
            } else {
                System.out.println("Entrada inválida. Debe ser 1 o 2.");
            }
        }
        return opcion;
    }

    private static void ejecutarTurno(Personaje primero, Personaje segundo, int opcionPrimero, int opcionSegundo) {
        if (opcionPrimero == 1) {
            primero.atacar(segundo, 0.3);
        } else {
            primero.defender();
        }

        if (segundo.getVida() > 0) {
            if (opcionSegundo == 1) {
                segundo.atacar(primero, 0.3);
            } else {
                segundo.defender();
            }
        }
    }
}
