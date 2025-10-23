package clases;

public class GestionBanco {

    public static void menuBanco() {
        //Inicio las variables que voy a necesitar
        Persona persona = new Persona();
        Direccion direccion = new Direccion();
        MyScanner sc = new MyScanner();
        boolean flag = true;

        //Cojo los datos por consola de el usuario
        System.out.println("Bienvenido a su banco de confianza !!!");
        System.out.println("Introduza sus datos para poder empezar las gestiones !!!");
        persona.setNombre(sc.pedirSoloTexto("Introduza su nombre: "));
        persona.setApellido(sc.pedirSoloTexto("Introduza su apellido: "));
        persona.setEdad(sc.pedirNumero("Introduzca su edad: "));
        persona.setDireccion(direccion);
        persona.getDireccion().setCalle(sc.pedirSoloTexto("Introduza su calle: "));
        persona.getDireccion().setPortal(sc.pedirNumero("Introduza su portal: "));
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
                    int meter = sc.pedirNumero("Introduze la cantidad a introducir en su cuenta: ");
                    persona.setDinero_en_banco(persona.getDinero_en_banco() + meter);
                    break;
                case 2:
                    try {
                        int sacar = sc.pedirNumero("Inserte la cantidad a retirar: ");
                        if (sacar > persona.getDinero_en_banco()) {
                            throw new exceptions.NoDineroException("Actualmente no dispone de tanto dinero en el banco");
                        }else {
                            persona.setDinero_en_banco(persona.getDinero_en_banco() - sacar);
                        }
                    }catch (exceptions.NoDineroException e){
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
