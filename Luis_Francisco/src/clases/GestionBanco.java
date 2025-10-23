package clases;

import exceptions.NoDineroException;

public class GestionBanco {

    public static void menuBanco() {
        //Inicio las variables que voy a necesitar
        Persona persona = new Persona();
        Direccion direccion = new Direccion();
        MyScanner sc = new MyScanner();
        boolean flag = true, flag2, flag3, continuar;
        int edad, portal;

        //Cojo los datos por consola de el usuario
        System.out.println("Bienvenido a su banco de confianza !!!");
        System.out.println("Introduza sus datos para poder empezar las gestiones !!!");
        persona.setNombre(sc.pedirSoloTexto("Introduza su nombre: "));
        persona.setApellido(sc.pedirSoloTexto("Introduza su apellido: "));
        do {
            continuar = true;
            edad = sc.pedirNumero("Introduza su edad: ");
            if (edad <= 18) {
                System.out.println("Tiene que ser mayor de 18 para poder tener una cuenta bancaria.");
                continuar = false;
            }
        }while(continuar);
        persona.setEdad(edad);
        persona.setDireccion(direccion);
        persona.getDireccion().setCalle(sc.pedirSoloTexto("Introduza su calle: "));
        do {
            continuar = true;
            portal = sc.pedirNumero("Introduza el numero de su portal: ");
            if (portal <= 0) {
                System.out.println("El numero de su portal tiene que ser mayor a 0.");
                continuar = false;
            }
        }while(continuar);
        persona.getDireccion().setPortal(portal);
        persona.getDireccion().setPiso(sc.pedirNumero("Introduza su piso: "));
        persona.getDireccion().setLetra(sc.pedirLetra("Introduza su letra: "));

        System.out.println("Felicidades, ha introducido todos sus datos de manera exitosa, ya podemos empezar con la gestión de su dinero");

        //Bucle una vez ya se han introducido los datos de la persona que no sale del bucle hasta que le da a salir
        //Desde el bucle el usuario puede introducir dinero o sacar dinero, salta mensaje de error si intenta sacar más dinero del que tiene
        while (flag){
            System.out.println("Opciones:\n1- Introducir dinero\n2- Sacar dienro\n3- Salir\nSaldo actual: "+persona.getDinero_en_banco());
            int opcion = sc.pedirNumero("");
            switch (opcion){
                case 1:
                    int meter;
                    do{
                        flag3 = true;
                        meter = sc.pedirNumero("Introduze la cantidad a introducir en su cuenta: ");
                        if (meter <= 0){
                            System.out.println("la cantidad introducida tiene que ser mayor que 0");
                            flag3 = false;
                        }
                    }while (flag3);
                    persona.setDinero_en_banco(persona.getDinero_en_banco() + meter);
                    break;
                case 2:
                    try {
                        int sacar;
                        do {
                            flag2 = false;
                            sacar = sc.pedirNumero("Inserte la cantidad a retirar: ");
                            if (sacar <= 0) {
                                System.out.println("La cantidad tiene que ser mayor a 0 !!!!");
                                flag2 = true;
                            }
                        }while (flag2);
                        if (sacar > persona.getDinero_en_banco()) {
                            throw new NoDineroException("Actualmente no dispone de tanto dinero en el banco");
                        }else {
                            persona.setDinero_en_banco(persona.getDinero_en_banco() - sacar);
                        }
                    }catch (NoDineroException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}
