package logica;

public class Pelea {
    MyScanner scanner = new MyScanner();
    Personaje personaje = new Personaje();

    Personaje pj1 = new Personaje(1000, 300, 1000);
    Personaje pj2 = new Personaje(1500, 150, 1500);

    public Pelea() {
    }

    public void pelea () {

        int ronda = scanner.pedirNumero("Cuantas rondas quieres que dure la batalla (hasta 20): ");
        int ataque1 = pj1.getAtaque();
        int ataque2 = pj2.getAtaque();

        if (ronda <= 20) {

            for (int i = 1; i <= ronda; i++) {
                int defensa1 = pj1.getDefensa();
                int defensa2 = pj2.getDefensa();
                int vida1 = pj1.getVida();
                int vida2 = pj2.getVida();

                int opcion1 = scanner.pedirNumero("Que va a hacer el personaje1 (1. atacar, 2. defender): \n");
                int opcion2 = scanner.pedirNumero("Que va a hacer el personaje2 (1. atacar, 2. defender): \n");

                if (opcion1 < 1 || opcion1 > 2 && opcion2 < 1 || opcion2 > 2) {
                    System.out.println("Opcion invalida");
                }

                if (opcion1 == 1 && defensa1 > 0 && opcion2 == 1 && defensa2 > 0) {
                    System.out.println("Ambos atacan");
                    pj1.setDefensa(defensa1 - ataque2);
                    pj2.setDefensa(defensa2 - ataque1);
                    System.out.println("Ahora están así: " + pj1.getVida() + " de vida " + pj1.getDefensa() + " de defensa " + " y "
                            + pj2.getVida() + " de vida " + pj2.getDefensa() + " de defensa\n");

                } else if (opcion1 == 1 && opcion2 == 2 && defensa2 > 0 && vida2 > 0) {
                    System.out.println("Personaje 1 ataca");
                    pj2.setDefensa(defensa2 - ataque1);
                    System.out.println("Ahora están así: " + pj1.getVida() + " de vida " + pj1.getDefensa() + " de defensa " + " y "
                            + pj2.getVida() + " de vida " + pj2.getDefensa() + " de defensa\n");

                } else if (opcion1 == 2 && defensa1 > 0 && vida1 > 0 && opcion2 == 1) {
                    System.out.println("Personaje 2 ataca");
                    pj1.setDefensa(defensa1 - ataque2);
                    System.out.println("Ahora están así: " + pj1.getVida() + " de vida " + pj1.getDefensa() + " de defensa " + " y "
                            + pj2.getVida() + " de vida " + pj2.getDefensa() + " de defensa\n");

                } else if (opcion1 == 2 && opcion2 == 2) {
                    System.out.println("Ninguno ataca");

                } else if (defensa1 <= 0 && vida1 > 0 && opcion1 == 2 && opcion2 == 1) {
                    System.out.println("Personaje 2 ataca");
                    pj1.setVida(vida1 - ataque2);
                    System.out.println("Ahora están así: " + pj1.getVida() + " de vida " + pj1.getDefensa() + " de defensa " + " y "
                            + pj2.getVida() + " de vida " + pj2.getDefensa() + " de defensa\n");

                } else if (opcion1 == 1 && opcion2 == 2 && defensa2 <= 0 && vida2 > 0) {
                    System.out.println("Personaje 1 ataca");
                    pj2.setVida(vida2 - ataque1);
                    System.out.println("Ahora están así: " + pj1.getVida() + " de vida " + pj1.getDefensa() + " de defensa " + " y "
                            + pj2.getVida() + " de vida " + pj2.getDefensa() + " de defensa\n");

                }

               if (pj1.getVida() <= 0 && pj2.getVida() > 0) {
                    System.out.println("Personaje 2 gana");
                    break;

               } else if (pj2.getVida() <= 0 && pj1.getVida() > 0) {
                    System.out.println("Personaje 1 gana");
                    break;

               } else if (i == ronda && pj1.getVida() > 0 && pj2.getVida() > 0) {
                    System.out.println("Acaba el combate, empate");
                    break;

               }
            }

        } else {
            System.out.println("Excediste el numero de rondas\n");
        }
    }
}
