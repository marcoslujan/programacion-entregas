import clases.Personaje;
import clases.Juegostats;
import java.util.Random;

public class JuegoMain {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        Random random = new Random();

        System.out.println("=== CREACIÓN DE PERSONAJES ===");
        String nombre1 = sc.pedirSoloTexto("Introduce el nombre del primer personaje: ");
        String nombre2 = sc.pedirSoloTexto("Introduce el nombre del segundo personaje: ");

        Personaje pj1 = generarPersonajeEquilibrado(random);
        Personaje pj2 = generarComplementario(pj1, random);

        System.out.println("\n--- ESTADÍSTICAS INICIALES ---");
        mostrarEstadisticas(nombre1, pj1);
        mostrarEstadisticas(nombre2, pj2);

        System.out.println("\n=== COMBATE A 20 TURNOS ===");
        int turno = 1;

        while (pj1.getVida() > 0 && pj2.getVida() > 0 && turno <= 20) {
            System.out.println("\n=== TURNO " + turno + " ===");

            int opcion1;
            while (true) {
                System.out.println(nombre1 + " (Vida: " + pj1.getVida() + ", Escudo: " + pj1.getEscudo() + ")");
                System.out.println("1. Atacar");
                System.out.println("2. Defender");
                opcion1 = sc.pedirNumero("Opción: ");

                switch (opcion1) {
                    case 1, 2:
                        break;
                    default:
                        System.out.println("Tienes que poner 1 o 2");
                        continue;
                }
                break;
            }

            int opcion2;
            while (true) {
                System.out.println(nombre2 + " (Vida: " + pj2.getVida() + ", Escudo: " + pj2.getEscudo() + ")");
                System.out.println("1. Atacar");
                System.out.println("2. Defender");
                opcion2 = sc.pedirNumero("Opción: ");

                switch (opcion2) {
                    case 1, 2:
                        break;
                    default:
                        System.out.println("Tienes que poner 1 o 2");
                        continue;
                }
                break;
            }

            boolean pj1Defiende = opcion1 == 2;
            boolean pj2Defiende = opcion2 == 2;

            if (opcion1 == 1 && opcion2 == 2) {
                atacar(pj1, pj2, pj2Defiende, nombre1, nombre2);
            } else if (opcion1 == 2 && opcion2 == 1) {
                atacar(pj2, pj1, pj1Defiende, nombre2, nombre1);
            } else if (opcion1 == 1 && opcion2 == 1) {
                atacar(pj1, pj2, pj2Defiende, nombre1, nombre2);
                if (pj2.getVida() > 0) {
                    atacar(pj2, pj1, pj1Defiende, nombre2, nombre1);
                }
            } else {
                System.out.println("Ambos se defienden. Nadie recibe daño.");
            }

            System.out.println("\nResultado del turno");
            mostrarEstadisticas(nombre1, pj1);
            mostrarEstadisticas(nombre2, pj2);

            turno++;
        }

        System.out.println("\n=== FIN DEL COMBATE ===");
        if (pj1.getVida() <= 0 && pj2.getVida() <= 0) {
            System.out.println("Empate: ambos han caído.");
        } else if (pj1.getVida() <= 0) {
            System.out.println(nombre2 + " gana el combate.");
        } else if (pj2.getVida() <= 0) {
            System.out.println(nombre1 + " gana el combate.");
        } else {
            System.out.println("Se acabaron los turnos...");
            if (pj1.getVida() > pj2.getVida()) {
                System.out.println(nombre1 + " gana por tener más vida.");
            } else if (pj2.getVida() > pj1.getVida()) {
                System.out.println(nombre2 + " gana por tener más vida.");
            } else {
                System.out.println("Empate: ambos tienen la misma vida.");
            }
        }
    }

    private static void atacar(Personaje atacante, Personaje defensor, boolean defensorDefiende, String nombreAtacante, String nombreDefensor) {
        if (Juegostats.esquiva(defensor)) {
            System.out.println("¡" + nombreDefensor + " esquiva el ataque!");
            return;
        }

        int daño = atacante.getAtaque();
        if (Juegostats.esCritico(atacante)) {
            daño = (int)(daño * 1.25);
            System.out.println("¡Golpe crítico de " + nombreAtacante + "!");
        }

        String resumen = Juegostats.aplicarDaño(defensor, daño, defensorDefiende);
        System.out.println(nombreAtacante + " inflige " + daño + " de daño a " + nombreDefensor + ". " + resumen);
    }

    private static void mostrarEstadisticas(String nombre, Personaje pj) {
        System.out.println(nombre + " -> Vida: " + pj.getVida() + " | Ataque: " + pj.getAtaque() + " | Escudo: " + pj.getEscudo());
    }

    private static Personaje generarPersonajeEquilibrado(Random random) {
        int vida = random.nextInt(800, 1201);
        int ataque = random.nextInt(80, 121);
        int escudo = random.nextInt(150, 251);
        return new Personaje(vida, ataque, escudo, true, true);
    }

    private static Personaje generarComplementario(Personaje pj, Random random) {
        int vida1 = pj.getVida();
        int vida2, ataque2, escudo2;

        if (vida1 > 1000) {
            vida2 = random.nextInt(800, 951);
            ataque2 = random.nextInt(120, 181);
            escudo2 = random.nextInt(200, 301);
        } else if (vida1 < 900) {
            vida2 = random.nextInt(1100, 1201);
            ataque2 = random.nextInt(80, 121);
            escudo2 = random.nextInt(150, 201);
        } else {
            vida2 = random.nextInt(900, 1101);
            ataque2 = random.nextInt(100, 160);
            escudo2 = random.nextInt(160, 260);
        }

        return new Personaje(vida2, ataque2, escudo2, true, true);
    }
}