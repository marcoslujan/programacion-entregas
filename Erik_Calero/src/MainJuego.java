import clases.Personaje;

public class MainJuego {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner( );
        int turno = 1;
        Personaje pj1 = new Personaje(1000, 200, 100);
        Personaje pj2 = new Personaje(1000, 150, 80);

        do {
            System.out.println("=========== TURNO " + turno + " ===========");
            System.out.println("Estado actual:");
            System.out.println("PJ1 → Vida: " + pj1.getVida() + " | Ataque: " + pj1.getAtaque() + " | Defensa: " + pj1.getDefensa());
            System.out.println("PJ2 → Vida: " + pj2.getVida() + " | Ataque: " + pj2.getAtaque() + " | Defensa: " + pj2.getDefensa());
            System.out.println("-------------------------------------------");
            System.out.println("Que va a hacer el pj1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion1 = sc.pedirNumero("Opcion: ");
            System.out.println("Que va a hacer el pj2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            int opcion2 = sc.pedirNumero("Opcion: ");


            if (opcion1 == 1 && opcion2 == 2) {
                int ataque = pj1.getAtaque();
                int defensa = pj2.getDefensa();
                int daño = ataque - (defensa / 2);
                if (daño < 0) daño = 0;
                pj2.setVida(pj2.getVida() - daño);
                System.out.println("PJ1 ataca a PJ2 causando " + daño + " puntos de daño.");
            } else if (opcion1 == 2 && opcion2 == 1) {
                int ataque = pj2.getAtaque();
                int defensa = pj1.getDefensa();
                int daño = (ataque * 3 / 2) - (defensa / 2);
                if (daño < 1) daño = (int)(Math.random() * 20) + 10;
                pj1.setVida(pj1.getVida() - daño);
                System.out.println("PJ2 ataca a PJ1 causando " + daño + " puntos de daño.");
            } else if (opcion1 == 1 && opcion2 == 1) {
                int ataque1 = pj1.getAtaque() + (int)(Math.random() * 20) - 10; //
                int ataque2 = pj2.getAtaque() + (int)(Math.random() * 20) - 10;
                pj2.setVida(pj2.getVida() - ataque1);
                pj1.setVida(pj1.getVida() - ataque2);
                System.out.println(" Ambos atacan ");
                System.out.println("PJ1 recibe " + ataque2 + " puntos de daño.");
                System.out.println("PJ2 recibe " + ataque1 + " puntos de daño.");
            }
            turno++;
        }while(turno <= 20 && pj1.getVida() > 0 && pj2.getVida() > 0);
        }

}
