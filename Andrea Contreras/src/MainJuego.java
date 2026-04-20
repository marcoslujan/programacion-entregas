public class MainJuego {
    public static void main(String[] args) {
        menupersonaje();
    }

    public static void menupersonaje (){
        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);

        accionesjugador(pj1, pj2);
    }

    public static void accionesjugador(Personaje pj1, Personaje pj2){
        MyScanner myscanner = new MyScanner();

        boolean flag = true;

        while (flag) {

            int opcion1 = myscanner.pedirNumero("Que va a hacer el pj1: \nAtacar -> 1, \nDefender -> 2");
            int opcion2 = myscanner.pedirNumero("Que va a hacer el pj2: \nAtacar -> 1, \nDefender -> 2");

            switch (opcion1) {
                case 1:
                    if (opcion1 == 1 && opcion2 == 2) {
                        int ataque = pj1.getAtaque();
                        int defensa = pj2.getDefensa();
                        pj2.setDefensa(defensa - ataque);
                        int turno1 =  pj1.getTurno();
                        int turno2 =  pj2.getTurno();
                        int nuevoTurno1 = turno1 + 1;
                        int nuevoTurno2 = turno2 + 1;
                        pj1.setTurno(nuevoTurno1);
                        pj2.setTurno(nuevoTurno2);
                        System.out.println("El jugador 1 tiene: " +pj1.getVida());
                        System.out.println("El jugador 2 tiene: " +pj2.getVida());
                        System.out.println( "Turno: " + nuevoTurno1);
                        break;
                    } else
                    if (opcion1 == 1 && opcion2 == 1) {
                        int vida1 =  pj2.getVida();
                        int ataque1 = pj1.getAtaque();
                        pj2.setVida(vida1 - ataque1);
                        int vida2 =  pj1.getVida();
                        int ataque2 = pj2.getAtaque();
                        pj1.setVida(vida2 - ataque2);
                        int turno1 =  pj1.getTurno();
                        int turno2 =  pj2.getTurno();
                        int nuevoTurno1 = turno1 + 1;
                        int nuevoTurno2 = turno2 + 1;
                        pj1.setTurno(nuevoTurno1);
                        pj2.setTurno(nuevoTurno2);
                        System.out.println("El jugador 1 tiene: " +pj1.getVida());
                        System.out.println("El jugador 2 tiene: " +pj2.getVida());
                        System.out.println( "Turno: "+ nuevoTurno1);
                        break;
                    }
                    case 2:
                        if (opcion1 == 2 && opcion2 == 1) {
                            int ataque = pj2.getAtaque();
                            int defensa = pj1.getDefensa();
                            pj1.setDefensa(defensa - ataque);
                            int turno1 =  pj1.getTurno();
                            int turno2 =  pj2.getTurno();
                            int nuevoTurno1 = turno1 + 1;
                            int nuevoTurno2 = turno2 + 1;
                            pj1.setTurno(nuevoTurno1);
                            pj2.setTurno(nuevoTurno2);
                            System.out.println("El jugador 1 tiene: " +pj1.getVida());
                            System.out.println("El jugador 2 tiene: " +pj2.getVida());
                            System.out.println("Turno: " + nuevoTurno1);
                            break;
                        }
                    default:
                        System.out.println("Opcion no valida");
                        break;

            }
            if (pj1.getVida() ==0){
                System.out.println("Jugador 1 eliminado");
                flag = false;
                break;
            }else if (pj2.getVida() ==0){
                System.out.println("Jugador 2 eliminado");
                flag = false;
                break;
            } else if (pj1.getTurno()==20||pj2.getTurno()==20) {
                System.out.println("Se acabo la partida");
                flag = false;
                break;
            }

        }
    }
}
