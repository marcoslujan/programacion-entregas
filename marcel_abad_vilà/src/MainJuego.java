public class MainJuego {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);
        boolean flag = true;

        int opcion1;
        int opcion2;
        int turno= 1;
        while ((pj1.getVida()>0 && pj2.getVida()>0) && turno<=19){
        do {
            System.out.println("Qué va a hacer el pj1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            opcion1 = sc.pedirNumero("Opción 1: ");

            if (opcion1 != 1 && opcion1 != 2) {
                System.out.println("Error: solo puedes introducir 1 o 2.");
            }
        } while (opcion1 != 1 && opcion1 != 2);

        do {
            System.out.println("Qué va a hacer el pj2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            opcion2 = sc.pedirNumero("Opción 2: ");

            if (opcion2 != 1 && opcion2 != 2) {
                System.out.println("Error: solo puedes introducir 1 o 2.");
            }
        } while (opcion2 != 1 && opcion2 != 2);

        do {
            if (opcion1 == 1 && opcion2 == 2) {
                int ataque = pj1.getAtaque();
                int defensa = pj2.getDefensa();
                pj2.setDefensa(defensa - ataque);
                System.out.println("Vida pj1= " + pj1.getVida() + " Vida pj2= " + pj2.getVida());
                turno++;
                System.out.println("Llevamos " + turno + " turnos");

            } else if (opcion1 == 2 && opcion2 == 1) {
                int ataque = pj2.getAtaque();
                int defensa = pj1.getDefensa();
                pj1.setDefensa(defensa - ataque);
                System.out.println("Vida pj1= " + pj1.getVida() + " Vida pj2= " + pj2.getVida());
                turno++;
                System.out.println("Llevamos " + turno + " turnos");
            } else if (opcion1 == 1 && opcion2 == 1) {
                int vida1 = pj2.getVida();
                int ataque1 = pj1.getAtaque();
                pj2.setVida(vida1 - ataque1);
                int vida2 = pj1.getVida();
                int ataque2 = pj2.getAtaque();
                pj1.setVida(vida2 - ataque2);
                System.out.println("Vida pj1= " + pj1.getVida() + " Vida pj2= " + pj2.getVida());
                turno++;
                System.out.println("Llevamos " + turno + " turnos");
            } else if (opcion1 == 2 && opcion2 == 2) {
                int vida1 = pj2.getVida();
                int defensa = pj1.getDefensa();
                int vida2 = pj1.getVida();
                int defensa2 = pj2.getDefensa();
                System.out.println("Vida pj1= " + pj1.getVida() + " Vida pj2= " + pj2.getVida());
                turno++;
                System.out.println("Llevamos " + turno + " turnos");
            }
            flag = false;
        } while (flag);
    }
        System.out.println("Se terminó el juego");

    }
}


