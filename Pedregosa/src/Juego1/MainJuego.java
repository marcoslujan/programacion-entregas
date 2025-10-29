package Juego1;

import Clases.Scanners.MyScanner;

public class MainJuego {
    private static final MyScanner sc = new MyScanner();

    static Personaje pj1 = new Personaje(1000, 100, 200);
    static Personaje pj2 = new Personaje(1000, 100, 200);

    public static void main(String[] args) {
        nombres();
        combateStart();
    }

    public static void nombres() {
        pj1.setNombre(sc.pideTexto("Nombre del primer combatiente: "));
        pj2.setNombre(sc.pideTexto("Nombre del segundo combatiente: "));
    }

    public static void combateStart() {
        int turnos = 0;

        while (turnos < 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {

            System.out.println("\n Turno " + (turnos + 1));

            System.out.println("Qué va a hacer " + pj1.getNombre() + ": ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.pedirNumero("Elige: ");

            System.out.println("Qué va a hacer " + pj2.getNombre() + ": ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.pedirNumero("Elige: ");


            if (opcion1 == 1 && opcion2 == 2) {
                ataque_defensa(pj1, pj2);
            } else if (opcion1 == 2 && opcion2 == 1) {
                ataque_defensa(pj2, pj1);
            } else if (opcion1 == 1 && opcion2 == 1) {
                doble_ataque(pj1, pj2);
            } else {
                System.out.println("Los dos combatientes se miran intensamente a los ojos, se nota la tensión entre ellos, no se sabe cual");
            }

            Estados();
            turnos++;
        }

        System.out.println("\nSe acabo el combate, cada uno a su casa, mañana igual a la misma hora");

        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println("los dos han muerto, vaya patanes");

        } else if (pj1.getVida() <= 0) {
            System.out.println(pj2.getNombre() + " ha ganado la continda, un aplauso");

        } else if (pj2.getVida() <= 0) {
            System.out.println(pj1.getNombre() + " ha ganado la continda, un aplauso");

        } else {
            System.out.println("20 turnos han sucedido y ninguno ha vencido, hemos perdido el tiempo");
            System.out.println("Vida final de " + pj1.getNombre() + ": " + pj1.getVida());
            System.out.println("Vida final de " + pj2.getNombre() + ": " + pj2.getVida());
            System.out.println("Empate, ya me jodería");
        }
    }

    public static void ataque_defensa(Personaje atacante, Personaje defensor) {
        int ataque = atacante.getAtaque();

        if (defensor.getDefensa() > 0) {
            int newDefensa = defensor.getDefensa() - ataque;

            if (newDefensa < 0) {

                int dañoDeMas = -newDefensa;
                defensor.setDefensa(0);
                defensor.setVida(Math.max(defensor.getVida() - dañoDeMas, 0));
                System.out.println(atacante.getNombre() + " rompe la defensa de " + defensor.getNombre() + " y le causa " + dañoDeMas + " de daño a la vida.");
            } else {

                defensor.setDefensa(newDefensa);
                System.out.println(atacante.getNombre() + " ataca, y " + defensor.getNombre() + " reduce su defensa a " + defensor.getDefensa());
            }

        } else {

            int nuevaVida = Math.max(defensor.getVida() - ataque, 0);
            defensor.setVida(nuevaVida);
            System.out.println(atacante.getNombre() + " ataca directamente a " + defensor.getNombre() + ", causando " + ataque + " de daño. Vida restante: " + defensor.getVida());
        }
    }

    public static void doble_ataque(Personaje p1, Personaje p2) {
        p1.setVida(Math.max(p1.getVida() - p2.getAtaque(), 0));
        p2.setVida(Math.max(p2.getVida() - p1.getAtaque(), 0));
        System.out.println(pj1.getNombre() + " ataca a " + pj2.getNombre());
        System.out.println(p1.getNombre() + " se queda con " + p1.getVida() + " de vida.");
        System.out.println(p2.getNombre() + " se queda con " + p2.getVida() + " de vida.");
    }

    public static void Estados() {
        System.out.println("\nEstado actual:");
        System.out.println(pj1.getNombre() + " tiene la siguiente vida: " + pj1.getVida() + " y la siguiente defensa: " + pj1.getDefensa());
        System.out.println(pj2.getNombre() + " tiene la siguiente vida: " + pj2.getVida() + " y la siguiente defensa: " + pj2.getDefensa());
    }
}



