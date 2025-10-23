import Excepciones.ExcepcionBanco;

import java.util.Scanner;

public class GestorBanco {

    public static void main(String[] args) throws ExcepcionBanco {
        ComprobarBanco();

    }

    public static void ComprobarBanco() throws ExcepcionBanco {

        MyScanner myscanner = new MyScanner();
        Persona persona  = new Persona();
        String nombre = myscanner.pedirSoloTexto("\nIntroduce el nombre: ");
        persona.setNombre(nombre);
        String apellido = myscanner.pedirSoloTexto("\nIntroduce el apellido: ");
        persona.setApellido(apellido);
        int edad = myscanner.pedirNumero("\nIntroduce edad: ");
        persona.setEdad(edad);
        int saldo = persona.getDinero_en_banco();

        System.out.println("Nombre: " + persona.getNombre() + "\nApellido: " + persona.getApellido() + "\nEdad: " + persona.getEdad() + "\nSaldo: " + saldo);

        AccionesUsuario(persona);

    }

    public static void AccionesUsuario(Persona persona) throws ExcepcionBanco {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.println("\nMenu de acciones: ");


        while(flag){
            System.out.println(" Elige una acción: \nSacarDinero -> 1,  \nMeterDinero -> 2, \nVerSaldo -> 3, \nSalir -> 0");
            String accion = sc.nextLine();
            switch (accion){
                case "1":
                    SacarDinero(persona);
                break;
                case "2":
                    MeterDinero(persona);
                break;
                case "3":
                    VerSaldo(persona);
                break;
                default:
                    System.out.println("Salir del programa ");
                    flag = false;
                break;
            }
        }

    }

    public static void SacarDinero(Persona persona) throws ExcepcionBanco {
        MyScanner myscanner = new MyScanner();
        System.out.println("\nSaldo actual: " + persona.getDinero_en_banco());
        int RetirarDinero = myscanner.pedirNumero("Cantidad que vas a retirar: ");
        if(RetirarDinero > persona.getDinero_en_banco()){
            ExcepcionBanco excepcion = new ExcepcionBanco("Saldo insuficiente");
            throw excepcion;
        }else {
            int nuevodinero = persona.getDinero_en_banco() - RetirarDinero;
            persona.setDinero_en_banco(nuevodinero);
        }

    }

    public static void MeterDinero(Persona persona){
        MyScanner myscanner = new MyScanner();
        System.out.println("Saldo actual: " + persona.getDinero_en_banco());
        int AñadirDinero = myscanner.pedirNumero("Cantidad que vas a Ingresar: ");
        int nuevoSaldo = AñadirDinero +  persona.getDinero_en_banco();
        persona.setDinero_en_banco(nuevoSaldo);
    }

    public static void VerSaldo(Persona persona){
        System.out.println("Saldo actual: " + persona.getDinero_en_banco());
    }
}
