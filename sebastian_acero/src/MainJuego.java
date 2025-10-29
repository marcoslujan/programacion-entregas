import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);

        int turno = 0;

        System.out.print("Nombre del pj1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Nombre del pj2: ");
        String nombre2 = sc.nextLine();


        while ((pj1.getVida() > 0 && pj2.getVida() > 0) && turno < 20) {
            System.out.println("\n--- TURNO " + turno + " ---");
            System.out.println("\n--- ¡FIGHT! ---");

            System.out.println("Que va a hacer el pj1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.nextInt();
            System.out.println("Que va a hacer el pj2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.nextInt();


            if (opcion1 == 1 && opcion2 == 2) {
                int ataque = pj1.getAtaque();
                int defensa = pj2.getDefensa();
                pj2.setDefensa(defensa - ataque);

                if (pj2.getDefensa() < 0) {
                    int daño = -pj2.getDefensa();
                    pj2.setVida(pj2.getVida() - daño);
                    pj2.setDefensa(0);
                    System.out.println("La defensa fue superada. " + nombre2 + " recibió " + daño + " de daño.");
                } else {
                    System.out.println("La defensa de " + nombre2 + " ahora es: " + pj2.getDefensa());
                }
                System.out.println("Tienen "+turno+ " turnos");
                turno++;


            } else if (opcion1 == 2 && opcion2 == 1) {
                int ataque = pj2.getAtaque();
                int defensa = pj1.getDefensa();
                pj1.setDefensa(defensa - ataque);

                if (pj1.getDefensa() < 0) {
                    int daño = -pj1.getDefensa();
                    pj1.setVida(pj1.getVida() - daño);
                    pj1.setDefensa(0);
                    System.out.println("La defensa fue superada. " + nombre1 + " recibió " + daño + " de daño.");
                } else {
                    System.out.println("La defensa de " + nombre1 + " ahora es: " + pj1.getDefensa());
                }
                System.out.println("Tienen "+turno+ " turnos");
                turno++;


            } else if (opcion1 == 1 && opcion2 == 1) {
                int vida1 = pj2.getVida();
                int ataque1 = pj1.getAtaque();
                pj2.setVida(vida1 - ataque1);
                int vida2 = pj1.getVida();
                int ataque2 = pj2.getAtaque();
                pj1.setVida(vida2 - ataque2);
                System.out.println("Tienen "+turno+ " turnos");
                turno++;
            }

            System.out.println(nombre1 +": "  + pj1.getVida());
            System.out.println(nombre2 +": " + pj2.getVida());

            System.out.println("Tienen "+turno+ " turnos");
            turno++;


            if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
                System.out.println("¡Empate! Ambos personajes han caído.");
            } else if (pj1.getVida() <= 0) {
                System.out.println("¡"+ nombre2+" gana!");
            } else if (pj2.getVida() <= 0) {
                System.out.println("¡"+ nombre1+ " gana!");
            } else {
                System.out.println("¡Ambos siguen vivos! La batalla continúa.");

            }

        }

        System.out.println("Se terminaron los turno, gracias por jugar");

    }
}
