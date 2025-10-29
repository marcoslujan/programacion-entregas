public class MainJuego {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);
        boolean flag = true;

        int opcion1;
        int opcion2;
        int turno = 0;

        while ((pj1.getVida() > 0 && pj2.getVida() > 0) && turno <= 19) {

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

            if (opcion1 == 1 && opcion2 == 2) {

                atacar(pj1, pj2);
            } else if (opcion1 == 2 && opcion2 == 1) {

                atacar(pj2, pj1);
            } else if (opcion1 == 1 && opcion2 == 1) {

                atacar(pj1, pj2);
                atacar(pj2, pj1);
            } else {

            }

            System.out.println("Vida pj1= " + pj1.getVida() + " Defensa pj1= " + pj1.getDefensa());
            System.out.println("Vida pj2= " + pj2.getVida() + " Defensa pj2= " + pj2.getDefensa());
            turno++;
            System.out.println("Llevamos " + turno + " turnos");
        }

        System.out.println("Se terminó el juego");
        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println("Empate, ambos murieron.");
        } else if (pj1.getVida() <= 0) {
            System.out.println("¡El jugador 2 gana!");
        } else if (pj2.getVida() <= 0) {
            System.out.println("¡El jugador 1 gana!");
        }
    }


    private static void atacar(Personaje atacante, Personaje defensor) {
        int ataque = atacante.getAtaque();
        int defensa = defensor.getDefensa();

        if (defensa > 0) {

            if (ataque >= defensa) {
                int dañoRestante = ataque - defensa;
                defensor.setDefensa(0);
                defensor.setVida(defensor.getVida() - dañoRestante);
                System.out.println("La defensa del defensor se rompió. Recibe " + dañoRestante + " de daño a la vida.");
            } else {
                defensor.setDefensa(defensa - ataque);
                System.out.println("El defensor bloquea parte del ataque. Su defensa baja a " + defensor.getDefensa());
            }
        } else {

            defensor.setVida(defensor.getVida() - ataque);
            System.out.println("El defensor no tiene defensa. Recibe " + ataque + " de daño a la vida.");
        }
    }
}

