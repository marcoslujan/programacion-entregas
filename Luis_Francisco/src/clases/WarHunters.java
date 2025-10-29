package clases;

public class WarHunters {

    public static void menuWarHunters() {
        MyScanner sc = new MyScanner();
        System.out.println("Ha iniciado el juego de 2 jugadores,🥷WarHunters🥷");
        System.out.println("Los 2 jugadores empiezan con 1000 de vida, 100 de ataque y 100 de defensa");
        System.out.println("Cosas a tener en cuenta:\n- El juego termina cuando uno de los dos jugadores muere, o cuando llegan a 20 rondas\n- Los ataques críticos pueden ser implementados en futuras versiones del juego");
        String nombre1, nombre2;
        boolean jugarDeNuevo = true, mismosNombres, flag2, flag3;

        nombre1 = sc.pideTexto("Introduza el nombre del jugador numero 1: ");
        nombre2 = sc.pideTexto("Introduza el nombre del jugador numero 2: ");
        Personaje personaje = new Personaje(nombre1,1000,100,100);
        Personaje personaje2 = new Personaje(nombre2,1000,100,100);
        int opcion, opcion2, rondas;
        boolean flag;

        do{
            rondas = 1;
            personaje.setVida(1000);
            personaje.setDefensa(100);
            personaje2.setVida(1000);
            personaje2.setDefensa(100);
            do {
                System.out.println("Ronda " + rondas);
                do {
                    flag = true;
                    System.out.println("Que va a hacer " + personaje.getNombre() + "?\n1.Atacar\n2.Defender");
                    opcion = sc.pedirNumero("Opcion: ");
                    if (opcion != 1 && opcion != 2) {
                        System.out.println("Introduzca una opción válida");
                        flag = false;
                    }
                } while (!flag);
                do {
                    flag = true;
                    System.out.println("Que va a hacer " + personaje2.getNombre() + "?\n1.Atacar\n2.Defender");
                    opcion2 = sc.pedirNumero("Opcion: ");
                    if (opcion2 != 1 && opcion2 != 2) {
                        System.out.println("Introduzca una opción válida");
                        flag = false;
                    }
                } while (!flag);

                InteraccionPersonajes.Interaccion(personaje, personaje2, opcion, opcion2);

                rondas++;
            } while (rondas != 21 && personaje.getVida() > 0 && personaje2.getVida() > 0);

            //Mensaje de felicidades al ganador
            if (personaje.getVida() == 0) {
                System.out.println("Felicidades " + personaje2.getNombre() + ", has ganado 🎉🎉🎉🎊🎊🎊!!!!!!");
            } else if (personaje2.getVida() == 0) {
                System.out.println("Felicidaes " + personaje.getNombre() + ", has ganado 🎉🎉🎉🎊🎊🎊!!!!!!");
            } else if (personaje.getVida() == personaje2.getVida()) {
                System.out.println("Ha sido un empate, más suerte la próxima !!!");
            }
            do {
                flag2 = true;
                int opcionJugar = sc.pedirNumero("Quereis volver a jugar ??\n1-Sí\n2-No\nOpción :");
                if (opcionJugar == 1) {
                    flag2 = false;
                } else if (opcionJugar == 2) {
                    jugarDeNuevo = false;
                    flag2 = false;
                } else {
                    System.out.println("Opcion no valida");
                }
            } while (flag2);
        } while (jugarDeNuevo);
    }
}
