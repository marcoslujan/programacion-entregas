package proyecto_final;

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
            System.out.println("Vida del Personaje1: " + pj1.getVida());
            System.out.println("Vida del Personaje2: " + pj2.getVida());

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

        if(opcion1 == 1 && opcion2 == 2) {
            int ataque = pj1.getAtaque();
            int defensa = pj2.getDefensa();
            pj2.setDefensa(defensa - ataque);
            System.out.println("Personaje1 ataca a Personaje2 que se defiende del ataque. Nadie pierde vida.");

        } else if(opcion1 == 2 && opcion2 == 1) {
            int ataque = pj2.getAtaque();
            int defensa = pj1.getDefensa();
            pj1.setDefensa(defensa - ataque);
            System.out.println("Personaje2 ataca a Personaje1 que se defiende del ataque. Nadie pierde vida.");

        } else if(opcion1 == 1 && opcion2 == 1) {
            int vida1 = pj2.getVida();
            int ataque1 = pj1.getAtaque();
            pj2.setVida(vida1 - ataque1);
            int vida2 = pj1.getVida();
            int ataque2 = pj2.getAtaque();
            pj1.setVida(vida2 - ataque2);
            System.out.println("Los dos atacais. Ambos sufris daño");

        }else if(opcion1 == 2 && opcion2 == 2) {
            System.out.println("Los dos defendeis. Ninguno sufre daño");
        }
    }
}

