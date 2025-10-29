package carlossuquilanda.src;

import clases.MyScanner;
import clases.Personaje;
public class Batalla {
    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner();
        System.out.println(" ");
        System.out.println("----------- ⚔️ BIENVENIDO AL CAMPO DE BATALLA ⚔️ -----------");
        String Name1 = myScanner.pideTexto("🔵 JUGADOR 1: ¿COMO DESEA LLAMAR A SU PERSONAJE?: ");
        Personaje JUGADOR1 = new Personaje(1000, 100, 200, 0);
        String Name2 = myScanner.pideTexto("🔴 JUGADOR 2: ¿COMO DESEA LLAMAR A SU PERSONAJE?: ");
        Personaje JUGADOR2 = new Personaje(1000, 100, 200, 0);
        System.out.println("-------------------------------------------------------------");
        System.out.println("----------------------- ⚜️ REGLAS ⚜️ -----------------------");
        System.out.println("1. CADA JUGADOR TIENE:");
        System.out.println("\t💓 VIDA: " + JUGADOR1.getVida());
        System.out.println("\t⚔️ ATAQUE: " + JUGADOR1.getAtaque());
        System.out.println("\t🛡️ DEFENSA: " + JUGADOR1.getDefensa());
        System.out.println("\t🕺BAILE: (SOLO SIRVE PARA BURLAR AL RIVAL)");
        System.out.println("\n2. EL JUEGO VA POR TURNOS, PRIMERO EL PEROSNAJE AZUL Y LUEGO EL ROJO");
        System.out.println("\n3. DIVIERTETE");
        String confrimacion = myScanner.pedirSoloTexto("\n👉 PULSE CUALQUIER TECLA PARA CONTINUAR PARA CONTINUAR: ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------- 🪖⚔️🤺💣 QUE COMIENCE LA BATALLA 💣🪖⚔️🤺 --------");

        for (int i = 1; i<21; i++) {
            System.out.println("\nRONDA " + i);

            System.out.println("🔵 TURNO DEL JUGADOR 1 🔵");
            System.out.println("ELIJA MOVIMIENTO");
            System.out.println("\t1. ATACAR");
            System.out.println("\t2. DEFENDER");
            System.out.println("\t3. BAILAR");
            int opcion1 = myScanner.pedirNumero("\n👉 ");

            System.out.println("\n🔴 TURNO DEL JUGADOR 2 🔴");
            System.out.println("ELIJA MOVIMIENTO");
            System.out.println("\t1. ATACAR");
            System.out.println("\t2. DEFENDER");
            System.out.println("\t3. BAILAR");
            int opcion2 = myScanner.pedirNumero("\n👉 ");

            if (opcion1 == 1 && opcion2 == 1) {
                int vida1 =  JUGADOR2.getVida();
                int ataque1 = JUGADOR1.getAtaque();
                JUGADOR2.setVida(vida1 - ataque1);
                int vida2 =  JUGADOR1.getVida();
                int ataque2 = JUGADOR2.getAtaque();
                JUGADOR1.setVida(vida2 - ataque2);
                System.out.println("\n🔥 WOW, ATAQUE DE TITANES 🔥");

            }else if (opcion1 == 2 && opcion2 == 1) {
                int ataque = JUGADOR2.getAtaque();
                int defensa = JUGADOR1.getDefensa();
                JUGADOR1.setDefensa(defensa - ataque);
                System.out.println("\n🔥 WOW, BUENA JUGADA 🔥");

            }else if (opcion1 == 2 && opcion2 == 2) {
                int ataque = JUGADOR2.getAtaque();
                int defensa = JUGADOR1.getDefensa();
                JUGADOR1.setDefensa(defensa - ataque);
                System.out.println("\n🔥 WOW, mirada de titanes 🔥");

            }else if (opcion1 == 1 && opcion2 == 2) {
                int ataque = JUGADOR1.getAtaque();
                int defensa = JUGADOR2.getDefensa();
                JUGADOR2.setDefensa(defensa - ataque);
                System.out.println("\n🔥 WOW, BUENA JUGADA 🔥");

            }else if (opcion1 == 3 && opcion2 == 3) {
                System.out.println("\n💃 MENUDOS MOVIMIENTOS DE BAILE 💃");

            }else if (opcion1 == 3 && opcion2 == 1) {
                int vida1 = JUGADOR1.getVida();
                int ataque2 = JUGADOR2.getAtaque();
                JUGADOR1.setVida(vida1 - ataque2);
                System.out.println("\n🕺WOW, COMO SE MUEVE EL JUGADOR 1, PERO EL JUGADOR 2 NO TIENE PIEDAD");

            }else if (opcion1 == 1 && opcion2 == 3) {
                int vida2 = JUGADOR2.getVida();
                int ataque1 = JUGADOR1.getAtaque();
                JUGADOR2.setVida(vida2 - ataque1);
                System.out.println("\n🕺WOW, COMO SE MUEVE EL JUGADOR 2, PERO EL JUGADOR 1 NO TIENE PIEDAD");

            }else if (opcion1 == 3 && opcion2 == 2) {
                System.out.println("\n🕺WOW, EL JUGADOR 2 SE TIENE QUE DEFENDER FRENTE A LOS INCREIBLES MOVIMIENTOS DEL JUGAOR 1");

            }else if (opcion1 == 2 && opcion2 == 3) {
                System.out.println("\n🕺WOW, EL JUGADOR 1 SE TIENE QUE DEFENDER FRENTE A LOS INCREIBLES MOVIMIENTOS DEL JUGAOR 2");
            }

            System.out.println("\nVIDA DE " + Name1 + " : " + JUGADOR1.getVida());
            System.out.println("VIDA DE " + Name2 + " : " + JUGADOR2.getVida());
            System.out.println("\nRONDA FINALIZADA\n");
            String confrimacion2 = myScanner.pedirSoloTexto("👉 PULSE CUALQUIER TECLA PARA CONTINUAR: \n");
        }
        System.out.println("FIN DEL JUEGO, RONDAS ,MAXIMAS ALCANZADAS");

    }
}
