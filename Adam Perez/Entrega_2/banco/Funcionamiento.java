package banco;

import exceptions.Pobreza;

public class Funcionamiento {
    private static MyScanner sc = new MyScanner();
    Persona persona = new Persona();

    public void menu () throws Pobreza {
        boolean exit = true;
        while (exit) {
            int opcion = sc.pedirNumero("Bienvenido a Tu Banquito\n\n" +
                "Que operación desea realizar:\n" +
                "----1. Retirar dinero ----\n" +
                "----2. Ingresar dinero ----\n" +
                "----3. Salir del menú ----\n" +
                "----4. Mostar saldo ----");

            switch (opcion) {
                case 1:
                    noMoney();
                    System.out.println("Su balance es: " + persona.getDinero_en_banco() + "\n");
                    break;
                case 2:
                    ingresarDinero();
                    System.out.println("Su balance es: " + persona.getDinero_en_banco() + "\n");
                    break;
                case 3:
                    System.out.println("Muchas gracias, que tengas un hermoso día\n");
                    exit = false;
                    break;
                case 4:
                    System.out.println("Tu saldo actual es: " + persona.getDinero_en_banco() + "\n");
                    break;
                default:
                    System.out.println("No es una opcion valida" + "\n");
                    break;
            }
        }



    }

    public void noMoney () throws Pobreza {
        try {
            int base = persona.getDinero_en_banco();
            int sacar = sc.pedirNumero("Cuanto desea retirar: ");

            if (sacar > persona.getDinero_en_banco()) {
                throw new Pobreza("No tienes suficientes sentimientos para que nickita niocole te haga caso\n");
            } else {
                System.out.println("Has retirado " + sacar + "\n");
               persona.setDinero_en_banco(base - sacar);
            }


        } catch (Pobreza e) {
            System.out.println(e.getMessage());
        }
    }

    public int ingresarDinero () {
        int base = persona.getDinero_en_banco();
        int cantidad =  sc.pedirNumero("Cuanto desea ingresar: ");
        persona.setDinero_en_banco(base + cantidad);
        return persona.getDinero_en_banco();
    }

    public void identificacion () {
        persona.setNombre(sc.pedirSoloTexto("Tu nombre: "));
        persona.setApellido(sc.pedirSoloTexto("Apellido: "));
        persona.setEdad(sc.pedirNumero("Edad: "));
        System.out.println("Bienvenido " +  persona.getNombre() + " " + persona.getApellido() + "\n");
    }
}
