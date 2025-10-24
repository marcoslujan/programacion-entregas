package clases;

public class InteraccionPersonajes {

    public static void Interaccion(Personaje personaje, Personaje personaje2, int opcion, int opcion2){
        MyScanner sc = new MyScanner();

        //Ya han metido las opciones en este punto

        if (opcion == 1 && opcion2 == 1) {
            int ataque, vida, ataque2, vida2;
            ataque = personaje.getAtaque();
            vida = personaje.getVida();
            ataque2 = personaje2.getAtaque();
            vida2 = personaje2.getVida();
            personaje.setVida(vida-ataque2);
            personaje2.setVida(vida2-ataque);
        }else if (opcion == 1 && opcion2 == 2) {
            if (personaje2.getDefensa() != 0) {
                int ataque, defensa;
                ataque = personaje.getAtaque();
                defensa = personaje2.getDefensa();
                personaje2.setDefensa(defensa-ataque);
            }else {
                int  ataque, vida;
                ataque = personaje.getAtaque();
                vida = personaje2.getVida();
                personaje2.setVida(vida-ataque);
            }
        }else if (opcion == 2 && opcion2 == 1) {
            if (personaje.getDefensa() != 0) {
                int ataque, defensa;
                ataque = personaje2.getAtaque();
                defensa = personaje.getDefensa();
                personaje.setDefensa(defensa-ataque);
            }else {
                int  ataque, vida;
                ataque = personaje2.getAtaque();
                vida = personaje.getVida();
                personaje.setVida(vida-ataque);
            }
        }else if (opcion == 2 && opcion2 == 2) {
            System.out.println("La tensión se huele en el ambiente, uno de los jugadores va a tener que atacar en el siguiente turno");
        }
        System.out.println("Estadisticas actuales:");
        System.out.println("- "+personaje.getNombre()+": vida: "+personaje.getVida()+" defensa: "+personaje.getDefensa());
        System.out.println("- "+personaje2.getNombre()+": vida: "+personaje2.getVida()+" defensa: "+personaje2.getDefensa());
    }

}
