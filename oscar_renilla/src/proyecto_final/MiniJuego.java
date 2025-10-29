package Programacion;

import clases.Personaje;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MiniJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);

        System.out.println("Bienvenido a este minijuego!!!");
        System.out.println("Es un juego de 20 rondas o hasta que uno pierda");
        System.out.println("Los dos empezais con las misma vida, ataque y escudo");
        System.out.println("¡¡¡EMPEZAMOS!!!");

        int turno = 1;
        while (turno <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0) {
            System.out.println("\nTurno: " + turno);

            int opcion1 = opciones(sc, "PJ1");
            int opcion2 = opciones(sc, "PJ2");

            turnos(pj1, pj2, opcion1, opcion2);

            System.out.println("\nTurno: " + turno);
            System.out.println("Personaje1: Vida = " + pj1.getVida() + "; Defensa: " + pj1.getDefensa());
            System.out.println("Personaje2: Vida = " + pj2.getVida() + "; Defensa: " + pj2.getDefensa());

            if (pj1.getVida() <= 0 || pj2.getVida() <= 0) {
                break;
            }
            turno++;
        }
        System.out.println("\nFin del juego");
        if (pj1.getVida() > pj2.getVida()) {
            System.out.println("\nGana el Personaje1 con " + pj1.getVida() + " de vida restante");
        } else if (pj2.getVida() > pj1.getVida()) {
            System.out.println("\nGana el Personaje2 con " + pj2.getVida() + " de vida restante");
        } else {
            System.out.println("\nEmpate!");
        }
        sc.close();
    }

    public static int opciones(Scanner sc, String nombrePJ) {
        int opcion = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println(nombrePJ + " Elige que va a hacer tu personaje: ");
                System.out.println("1. Atacar");
                System.out.println("2. Defender");
                opcion = sc.nextInt();

                if (opcion == 1 || opcion == 2) {
                    valido = true;
                } else {
                    System.out.println("Opción incorrecta. Selecciona 1 o 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor escribe un numero entre 1 y 2.");
                sc.nextLine();
            }
        }
        return opcion;
    }

    public static void turnos(Personaje pj1, Personaje pj2, int opcion1, int opcion2) {

        if (opcion1 == 1 && opcion2 == 1) { // Ambos atacan
            atacar(pj1, pj2);
            atacar(pj2, pj1);
            System.out.println("Los dos atacan y se golpean mutuamente");
        }
        else if (opcion1 == 1 && opcion2 == 2) { // PJ1 ataca, PJ2 defiende
            System.out.println("Personaje1 ataca y Personaje2 se defiende!");
            defender(pj2, pj1.getAtaque());
        }
        else if (opcion1 == 2 && opcion2 == 1) { // PJ2 ataca, PJ1 defiende
            System.out.println("Personaje2 ataca y Personaje1 se defiende!");
            defender(pj1, pj2.getAtaque());
        }
        else {
            System.out.println("Los dos se defienden, nadie recibe daño.");
        }
    }

    public static void atacar(Personaje atacante, Personaje defensor) {
        int daño = atacante.getAtaque();

        if (defensor.getDefensa() > 0) {
            int nuevaDefensa = defensor.getDefensa() - daño;

            if (nuevaDefensa >= 0) {
                defensor.setDefensa(nuevaDefensa);
                System.out.println(daño + " puntos de defensa destruidos. (Defensa restante: " + defensor.getDefensa() + ")");
            } else {
                int dañoRestante = Math.abs(nuevaDefensa);
                defensor.setDefensa(0);
                defensor.setVida(Math.max(defensor.getVida() - dañoRestante, 0));
                System.out.println("La defensa cayó a 0. El ataque hace " + dañoRestante + " de daño a la vida.");
            }
        } else {
            defensor.setVida(Math.max(defensor.getVida() - daño, 0));
            System.out.println("Sin defensa. Ataque directo de " + daño + " puntos a la vida.");
        }
    }

    public static void defender(Personaje defensor, int ataque) {
        if (defensor.getDefensa() > 0) {
            int nuevaDefensa = defensor.getDefensa() - ataque;
            if (nuevaDefensa >= 0) {
                defensor.setDefensa(nuevaDefensa);
                System.out.println("El ataque reduce la defensa en " + ataque + " puntos.");
            } else {
                // Parte del daño pasa a la vida
                int dañoRestante = Math.abs(nuevaDefensa);
                defensor.setDefensa(0);
                defensor.setVida(Math.max(defensor.getVida() - dañoRestante, 0));
                System.out.println("La defensa se rompe. El ataque hace " + dañoRestante + " de daño a la vida.");
            }
        } else {
            defensor.setVida(Math.max(defensor.getVida() - ataque, 0));
            System.out.println("Sin defensa. Recibe " + ataque + " de daño a la vida.");
        }
    }
}

