//package proyectos_practicos;
//
//import clase.Personaje;
//
//public class MainJuego {
//    private static MyScanner sc = new MyScanner();
//
//    public static void main(String[] args) {
//
//        Personaje pj1 = new Personaje(1000, 100, 200);
//        Personaje pj2 = new Personaje(1000, 100, 200);
//
//        System.out.println("Que va a hacer el pj1: ");
//        System.out.println("1. Atacar");
//        System.out.println("2. Defender");
//        int opcion1 = sc.pedirNumero("Opcion: ");
//        System.out.println("Que va a hacer el pj2: ");
//        System.out.println("1. Atacar");
//        System.out.println("2. Defender");
//        int opcion2 = sc.pedirNumero( "Opcion:");
//
//        if (opcion1 == 1 && opcion2 == 2) {
//            int ataque = pj1.getAtaque();
//            int defensa = pj2.getDefensa();
//            pj2.setDefensa(defensa - ataque);
//        } else if (opcion1 == 2 && opcion2 == 1) {
//            int ataque = pj2.getAtaque();
//            int defensa = pj1.getDefensa();
//            pj1.setDefensa(defensa - ataque);
//        } else if (opcion1 == 1 && opcion2 == 1) {
//            int vida1 = pj2.getVida();
//            int ataque1 = pj1.getAtaque();
//            pj2.setVida(vida1 - ataque1);
//            int vida2 = pj1.getVida();
//            int ataque2 = pj2.getAtaque();
//            pj1.setVida(vida2 - ataque2);
//        }
//    }
//}


package proyectos_practicos;

import clase.Personaje;

public class MainJuego {
    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        Personaje pj1 = new Personaje(100, 100, 50, "Guerrero 1");
        Personaje pj2 = new Personaje(100, 100, 50, "Guerrero 2"); // Constructor sin nombre

        System.out.println("=== COMBATE ===");

        boolean juegosigue = true;

        while (juegosigue) {
            System.out.println("Turno de " + pj1.getNombre() + ":");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.pedirNumero("Opción: ");

            System.out.println("Turno de " + pj2.getNombre() + ":");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.pedirNumero("Opción: ");

            resolverTurno(pj1, pj2, opcion1, opcion2);

            if (pj1.getVida() <= 0 || pj2.getVida() <= 0) {
                juegosigue = false;
                System.out.println("\n=== FIN DEL COMBATE ===");
                if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
                    System.out.println("¡EMPATE! Ambos personajes han caído.");
                } else if (pj1.getVida() <= 0) {
                    System.out.println("¡" + pj2.getNombre() + " es el VENCEDOR!");
                } else {
                    System.out.println("¡" + pj1.getNombre() + " es el VENCEDOR!");
                }
            }
        }
    }

    private static void resolverTurno(Personaje pj1, Personaje pj2, int opcion1, int opcion2) {
        if (opcion1 == 1 && opcion2 == 2) {
            int ataque = pj1.getAtaque();
            int defensa = pj2.getDefensa();
            int danio = Math.max(0, ataque - defensa );
            pj2.setVida(pj2.getVida() - danio);
            System.out.println(pj1.getNombre() + " ataca a " + pj2.getNombre() + " causando " + danio + " de daño.");

        } else if (opcion1 == 2 && opcion2 == 1) {
            int ataque = pj2.getAtaque();
            int defensa = pj1.getDefensa();
            int danio = Math.max(0, ataque - defensa);
            pj1.setVida(pj1.getVida() - danio);
            System.out.println(pj2.getNombre() + " ataca a " + pj1.getNombre() + " causando " + danio + " de daño.");

        } else if (opcion1 == 1 && opcion2 == 1) {
            int danio1 = pj1.getAtaque();
            int danio2 = pj2.getAtaque();
            pj2.setVida(pj2.getVida() - danio1);
            pj1.setVida(pj1.getVida() - danio2);
            System.out.println("¡AMBOS ATACAN!");
            System.out.println(pj1.getNombre() + " causa " + danio1 + " de daño.");
            System.out.println(pj2.getNombre() + " causa " + danio2 + " de daño.");

        } else if (opcion1 == 2 && opcion2 == 2) {
            System.out.println("Ambos personajes se defienden. No hay daño.");
        }
    }
}