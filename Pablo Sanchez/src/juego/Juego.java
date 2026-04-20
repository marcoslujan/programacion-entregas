package juego;

    public class Juego {
        private MyScanner sc;
        private Pelea pelea;
        private Personaje marco;
        private Personaje adam;

        public Juego() {
            sc = new MyScanner();
            pelea = new Pelea();
            marco = new Personaje(1000, 100, 200);
            adam = new Personaje(1000, 100, 200);
        }

        public void iniciarPelea() {
            System.out.println("=== ¡COMIENZA LA PELEA! ===");
            System.out.println("Ambos personajes comienzan con 1000 de vida y 200 de defensa.");
            System.out.println("------------------------------------------");

            for (int ronda = 1; ronda <= 20; ronda++) {
                System.out.println("\n===== RONDA " + ronda + " =====");

                int opcionMarco = pedirOpcion("Marco");
                int opcionAdam = pedirOpcion("Adam");

                if (opcionMarco == 1 && opcionAdam == 1) {
                    System.out.println("¡Ambos atacan a la vez!");
                    marco.recibirDanio(adam.getAtaque());
                    adam.recibirDanio(marco.getAtaque());

                } else if (opcionMarco == 1 && opcionAdam == 2) {
                    System.out.println("Marco ataca y Adam se defiende");
                    adam.recibirDanio(marco.getAtaque());

                } else if (opcionMarco == 2 && opcionAdam == 1) {
                    System.out.println("Adam ataca y Marco se defiende");
                    marco.recibirDanio(adam.getAtaque());

                } else {
                    System.out.println("Ambos se defienden y no pasa nada");
                }

                mostrarEstado();

                if (marco.getVida() <= 0 || adam.getVida() <= 0) {
                    System.out.println("\n¡Uno de los personajes ha caído!");
                    break;
                }
            }

            mostrarResultadoFinal();
        }

        private int pedirOpcion(String jugador) {
            System.out.println("\nTurno de " + jugador + ":");
            pelea.opcionPelea();
            int opcion = sc.pedirNumero("Opción: ");
            while (opcion < 1 || opcion > 2) {
                System.out.println("Opción no válida, inténtalo de nuevo.");
                opcion = sc.pedirNumero("Opción: ");
            }
            return opcion;
        }

        private void mostrarEstado() {
            System.out.println("\n--- ESTADO ACTUAL ---");
            System.out.println("Marco → Vida: " + marco.getVida() + " | Defensa: " + marco.getDefensa());
            System.out.println("Adam → Vida: " + adam.getVida() + " | Defensa: " + adam.getDefensa());
            System.out.println("-----------------------");
        }

        private void mostrarResultadoFinal() {
            System.out.println("\n===== FIN DE LA PELEA =====");
            if (marco.getVida() <= 0 && adam.getVida() <= 0) {
                System.out.println("¡Empate! Ambos murieron a la vez.");
            } else if (marco.getVida() <= 0) {
                System.out.println("¡Gana Adam!");
            } else if (adam.getVida() <= 0) {
                System.out.println("¡Gana Marco!");
            } else {
                System.out.println("Se han completado las 20 rondas.");
                if (marco.getVida() > adam.getVida()) {
                    System.out.println("¡Gana Marco por tener más vida!");
                } else if (adam.getVida() > marco.getVida()) {
                    System.out.println("¡Gana Adam por tener más vida!");
                } else {
                    System.out.println("¡Empate, os podéis ir a comer!");
                }
            }
        }
    }

