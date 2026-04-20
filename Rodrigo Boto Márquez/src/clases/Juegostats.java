package clases;
import java.util.Random;

public class Juegostats {
    private static Random random = new Random();

    public static boolean esCritico(Personaje atacante) {
        return atacante.getCritico() && random.nextInt(4) == 0;
    }

    public static boolean esquiva(Personaje defensor) {
        return defensor.getEsquive() && random.nextInt(5) == 0;
    }

    public static String aplicarDaño(Personaje defensor, int daño, boolean defensorDefiende) {
        if (defensorDefiende) {
            int escudoActual = defensor.getEscudo();
            int absorbido = Math.min(escudoActual, daño);
            defensor.setEscudo(escudoActual - absorbido);

            int restante = daño - absorbido;
            if (restante > 0) {
                defensor.setVida(defensor.getVida() - restante);
            }

            return "Daño total: " + daño + " (absorvido por escudo: " + absorbido + ", daño a vida: " + restante + ")";
        } else {
            defensor.setVida(defensor.getVida() - daño);
            return "Daño total: " + daño + " (daño a vida: " + daño + ")";
        }
    }
}