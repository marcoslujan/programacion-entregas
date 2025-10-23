package clases;

import MyScanner;
import Pobreza;

public class FuncBanco {

    private static MyScanner scanner = new MyScanner();
    Persona persona = new Persona();

    public void usuario(){
        persona.setNombre(scanner.pedirSoloTexto("Nombre del persona: "));
        persona.setApellido(scanner.pedirSoloTexto("Apellido del persona: "));
        persona.setEdad(scanner.pedirNumero("Edad del persona: "));
        System.out.println("Bienvenido al Banco: "+persona.getNombre()+" "+persona.getApellido());
    }

    public void menu() throws Pobreza {
        boolean exit = true;

        while (exit) {
            int opcion = scanner.pedirNumero("Ingrese opcion: \n" +
                    "-----1. Mostrar Saldo-----\n"+
                    "-----2. Sacar dinero-----\n"+
                    "-----3. Meter dinero-----\n"+
                    "-----4. Salir-----");
        switch (opcion) {
            case 1:
                System.out.println("Tienes: "+persona.getDinero_en_banco());
                break;
            case 2:
                sacarDinero();
                break;
            case 3:
                meterDinero();
                break;
            case 4:
                exit = false;
                System.out.println("Hasta luego " + persona.getNombre() +" "+ persona.getApellido());
                break;
            default:
                System.out.println("No es una opcion valida");
        }
    }
}
    public void sacarDinero () throws Pobreza {
        try {
            int sacar= scanner.pedirNumero("Cuanto dinero quieres sacar?");

            if(sacar> persona.getDinero_en_banco()){
                throw new Pobreza("No hay suficientes fondos");
            }
            System.out.println("Dinero retirado con exito!!");
        } catch (Pobreza e) {
            System.out.println(e.getMessage());
        } finally {
        menu();
        }
    }

    public void meterDinero() throws Pobreza {
        int dineroAñadido= scanner.pedirNumero("Cuanto dinero quieres meter");
        persona.setDinero_en_banco(persona.getDinero_en_banco()+dineroAñadido);
        System.out.println("Dinero ingressado con exito!!");
        menu();
    }

}
