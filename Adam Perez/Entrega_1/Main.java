import Encapsulamiento.Persona;
import Encapsulamiento.Direccion;
import Encapsulamiento2.MyScanner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        Persona persona = new Persona();

        //Empezamos el lio

        System.out.println("Bienvenido\n");
        persona.setNombre(sc.pedirSoloTexto("Pon tu putisimo nombre: "));
        persona.setApellido(sc.pedirSoloTexto("Pon tu triplehijueputa apellido: "));
        int edad = sc.pedirNumero("Ahora falta tu mierdera edad: ");
        persona.setEdad(edad);

        System.out.println("Vale " + persona.getNombre() + " (gilipollas) " + persona.getApellido() + " de edad " + persona.getEdad());
        persona.setNombre("Pepe");

        System.out.println("\nAhora te llamas " + persona.getNombre() + " y te jodes\n");

        //Empezamos el lio2

        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista.add(persona);
        System.out.println(lista.get(0));

        //Añadimos direccion

        Direccion direccion = new Direccion();
        direccion.setCalle(sc.pedirSoloTexto("Tu maldita calle: "));
        direccion.setPortal(sc.pedirNumero("Dame tu fucking portal: "));
        direccion.setPiso(sc.pedirNumero("Dame tu piso lambon: "));
        direccion.setLetra(sc.pedirLetra("Ponme la letra, como pongas más de una te asesino: "));

        System.out.println("asi que vives en " + direccion.getCalle() + " " + direccion.getPortal() + " " + direccion.getPiso() + " " + direccion.getLetra());
    }
}
