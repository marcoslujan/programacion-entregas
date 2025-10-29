import clases.MyScanner;
import clases.Personaje;

public class MainJuego {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);

        int ronda = 1;

        boolean pj1Carga = false;
        boolean pj2Carga = false;

        boolean pj1AtaqueRapidoPendiente = false;
        boolean pj2AtaqueRapidoPendiente = false;

        while (pj1.getVida() > 0 && pj2.getVida() > 0 && ronda <= 20) {
            System.out.println("\n----- Ronda " + ronda++ + " -----");
            System.out.println("Turno jugador 1: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Ataque rápido (60 daño, se suma el siguiente turno)");
            System.out.println("4. Ataque cargado (carga este turno, 210 daño el siguiente)");
            int opcion1 = sc.pedirNumero("Opción: ");

            System.out.println("Turno jugador 2: ");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Ataque rápido");
            System.out.println("4. Ataque cargado");
            int opcion2 = sc.pedirNumero("Opción: ");

            // ATAQUE NORMAL Y DEFENSA
            if (opcion1 == 1 && opcion2 == 2) {
                int daño = pj1.getAtaque();
                if (pj2Carga) daño *= 0.8; // 20% menos daño si carga
                pj2.setVida(pj2.getVida() - (daño - pj2.getDefensa() / 10));
                System.out.println("Pj1 ataca, Pj2 se defiende");

            } else if (opcion1 == 2 && opcion2 == 1) {
                int daño = pj2.getAtaque();
                if (pj1Carga) daño *= 0.8;
                pj1.setVida(pj1.getVida() - (daño - pj1.getDefensa() / 10));
                System.out.println("Pj2 ataca, Pj1 se defiende");

            } else if (opcion1 == 1 && opcion2 == 1) {
                int daño1 = pj1.getAtaque();
                int daño2 = pj2.getAtaque();
                if (pj1Carga) daño2 *= 0.8;
                if (pj2Carga) daño1 *= 0.8;
                pj2.setVida(pj2.getVida() - daño1);
                pj1.setVida(pj1.getVida() - daño2);
                System.out.println("Ambos atacan");

            } else if (opcion1 == 2 && opcion2 == 2) {
                if (pj1.getVida() < 1000) pj1.setVida(pj1.getVida() + 50);
                if (pj2.getVida() < 1000) pj2.setVida(pj2.getVida() + 50);
                System.out.println("Se miran intensamente (❤️+50 vida por descansar)");

                // ATAQUE RÁPIDO
            } else if (opcion1 == 3 && opcion2 != 3) {
                int daño = 60;
                if (pj2Carga) daño *= 0.8;
                pj2.setVida(pj2.getVida() - daño);
                pj1AtaqueRapidoPendiente = true;
                System.out.println("Pj1 hace ataque rápido (60 daño)");

            } else if (opcion2 == 3 && opcion1 != 3) {
                int daño = 60;
                if (pj1Carga) daño *= 0.8;
                pj1.setVida(pj1.getVida() - daño);
                pj2AtaqueRapidoPendiente = true;
                System.out.println("Pj2 hace ataque rápido (60 daño)");

            } else if (opcion1 == 3 && opcion2 == 3) {
                int daño = 60;
                pj1.setVida(pj1.getVida() - daño);
                pj2.setVida(pj2.getVida() - daño);
                pj1AtaqueRapidoPendiente = true;
                pj2AtaqueRapidoPendiente = true;
                System.out.println("Ambos hacen ataque rápido (60 daño cada uno)");

                // ATAQUE CARGADO
            } else if (opcion1 == 4 && opcion2 != 4) {
                if (pj1Carga) {
                    System.out.println("¡Pj1 lanza ataque cargado! (-210 vida)");
                    pj2.setVida(pj2.getVida() - 210);
                    pj1Carga = false;
                } else {
                    System.out.println("Pj1 comienza a cargar (20% menos daño si recibe ataque)");
                    pj1Carga = true;
                }

            } else if (opcion2 == 4 && opcion1 != 4) {
                if (pj2Carga) {
                    System.out.println("¡Pj2 lanza ataque cargado! (-210 vida)");
                    pj1.setVida(pj1.getVida() - 210);
                    pj2Carga = false;
                } else {
                    System.out.println("Pj2 comienza a cargar (20% menos daño si recibe ataque)");
                    pj2Carga = true;
                }

            } else if (opcion1 == 4 && opcion2 == 4) {
                if (pj1Carga && pj2Carga) {
                    System.out.println("¡Ambos lanzan ataque cargado! (-210 vida cada uno)");
                    pj1.setVida(pj1.getVida() - 210);
                    pj2.setVida(pj2.getVida() - 210);
                    pj1Carga = false;
                    pj2Carga = false;
                }
                // Si solo están comenzando a cargar
                else {
                    System.out.println("Ambos comienzan a cargar (20% menos daño si reciben ataque)");
                    pj1Carga = true;
                    pj2Carga = true;
                }
            }

            // ATAQUE RÁPIDO PENDIENTE
            if (pj1AtaqueRapidoPendiente) {
                int daño = 60;
                if (pj2Carga) daño *= 0.8;
                pj2.setVida(pj2.getVida() - daño);
                pj1AtaqueRapidoPendiente = false;
                System.out.println("Pj1 hace su segundo golpe rápido (-60)");
            }
            if (pj2AtaqueRapidoPendiente) {
                int daño = 60;
                if (pj1Carga) daño *= 0.8;
                pj1.setVida(pj1.getVida() - daño);
                pj2AtaqueRapidoPendiente = false;
                System.out.println("Pj2 hace su segundo golpe rápido (-60)");
            }

            System.out.println("❤️Vida Pj1: " + pj1.getVida() + "\n❤️Vida Pj2: " + pj2.getVida());
        }

        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println("\nEmpate, ambos han caído.");
        } else if (pj1.getVida() <= 0) {
            System.out.println("\n¡Pj2 gana!");
        } else if (pj2.getVida() <= 0) {
            System.out.println("\n¡Pj1 gana!");
        } else {
            System.out.println("\nFin del tiempo (20 rondas).");
        }
    }
}
