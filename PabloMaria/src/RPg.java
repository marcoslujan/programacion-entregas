public class RPg {
    public static void main(String[] args) {
        menuRPG();
    }

    public static void menuRPG() {
        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);
        accionesJugador(pj1, pj2);
    }

    public static void accionesJugador(Personaje pj1, Personaje pj2) {
        Miscanner miscanner = new Miscanner();
        boolean flag = true;
        while(flag){
            int opcion1 = miscanner.pedirNumero("Que va a hacer el pj1: \n1. Atacar \n2. Defender");
            int opcion2 = miscanner.pedirNumero("Que va a hacer el pj2: \n1. Atacar \n2. Defender");
            switch (opcion1){
                case 1:
                    if (opcion1 == 1 && opcion2 == 2) {
                        int ataque = pj1.getAtaque();
                        int defensa = pj2.getDefensa();
                        pj2.setDefensa(defensa - ataque);
                        int contador1 = pj1.getTurno();
                        int contador2 = pj2.getTurno();
                        int nuevo_turno1 = contador1 + 1;
                        pj1.setTurno(nuevo_turno1);
                        int nuevo_turno2 = contador2 + 1;
                        pj2.setTurno(nuevo_turno2);
                        System.out.println("El jugador 1 tiene: " + pj1.getVida() + "puntos de vida.");
                        System.out.println("El jugador 2 tiene: " + pj2.getVida() + "puntos de vida.");
                        System.out.println("Turno " + nuevo_turno1 + " terminado");
                        break;

                    } else if (opcion1 == 1 && opcion2 == 1) {
                        int vida1 =  pj2.getVida();
                        int ataque1 = pj1.getAtaque();
                        pj2.setVida(vida1 - ataque1);
                        int vida2 =  pj1.getVida();
                        int ataque2 = pj2.getAtaque();
                        pj1.setVida(vida2 - ataque2);
                        int contador1 = pj1.getTurno();
                        int contador2 = pj2.getTurno();
                        int nuevo_turno1 = contador1 + 1;
                        pj1.setTurno(nuevo_turno1);
                        int nuevo_turno2 = contador2 + 1;
                        pj2.setTurno(nuevo_turno2);
                        System.out.println("El jugador 1 tiene: " + pj1.getVida() + "puntos de vida.");
                        System.out.println("El jugador 2 tiene: " + pj2.getVida() + "puntos de vida.");
                        System.out.println("Turno " + nuevo_turno1 + " terminado");
                        break;
                    }
                case 2:
                    if (opcion1 == 2 && opcion2 == 1) {

                        int ataque = pj2.getAtaque();
                        int defensa = pj1.getDefensa();
                        pj1.setDefensa(defensa - ataque);
                        int contador1 = pj1.getTurno();
                        int contador2 = pj2.getTurno();
                        int nuevo_turno1 = contador1 + 1;
                        pj1.setTurno(nuevo_turno1);
                        int nuevo_turno2 = contador2 + 1;
                        pj2.setTurno(nuevo_turno2);
                        System.out.println("El jugador 1 tiene: " + pj1.getVida() + "puntos de vida.");
                        System.out.println("El jugador 2 tiene: " + pj2.getVida() + "puntos de vida.");
                        System.out.println("Turno " + nuevo_turno1 + " terminado");
                        break;

                    } else if (opcion1 == 2 && opcion2 == 2) {
                        int contador1 = pj1.getTurno();
                        int contador2 = pj2.getTurno();
                        int nuevo_turno1 = contador1 + 1;
                        pj1.setTurno(nuevo_turno1);
                        int nuevo_turno2 = contador2 + 1;
                        pj2.setTurno(nuevo_turno2);
                        System.out.println("El jugador 1 tiene: " + pj1.getVida() + "puntos de vida.");
                        System.out.println("El jugador 2 tiene: " + pj2.getVida() + "puntos de vida.");
                        System.out.println("Nada ocurre....");
                        System.out.println("Turno " + nuevo_turno1 + " terminado");
                        break;
                    }
                default:
                    break;
            }

             if (pj1.getVida() == 0) {
                System.out.println("Jugador 1 eliminado \nJugador 2 gana");
                flag = false;
                break;

            } else if (pj2.getVida() == 0) {
                System.out.println("Jugador 2 eliminado \nJugador 1 gana");
                flag = false;
                break;

            } else if (pj1.getTurno() == 20 || pj2.getTurno() == 20) {
                System.out.println("Se acabó el tiempo");
                flag = false;
                break;
            }
        }
    }
}