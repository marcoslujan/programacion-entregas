import java.util.Scanner;

public class Gestionbanco {

        public static void main(String[] args) throws Exception {
            menuBanco();
        }

        public static void menuBanco() throws Exception {
            Personabanco personabanco = new Personabanco();
            Miscanner miscanner = new Miscanner();

            String nombre = miscanner.pedirsoloTexto("Introduzca su nombre: ");
            personabanco.setNombre(nombre);
            String apellido = miscanner.pedirsoloTexto("Introduzca su apellido: ");
            personabanco.setApellido(apellido);
            int edad = miscanner.pedirNumero("Introduzca su edad: ");
            personabanco.setEdad(edad);
            int saldo = personabanco.getDinero_en_banco();
            System.out.println("Nombre del cliente: " + personabanco.getNombre() + " \nApellido: " + personabanco.getApellido() + " \nEdad: " + personabanco.getEdad() + " \nSaldo: " + saldo);

            accionesUsuario(personabanco);
        }

        public static void accionesUsuario(Personabanco personabanco) throws Exception {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            System.out.println("\nMenú de acciones\n");
            while(flag){
                System.out.println("Elige una acción: \nAñadir saldo -> 1 \nRetirar saldo -> 2  \nSalir -> Otro");
                String accion = sc.next();
                switch (accion){
                    case "1":
                        AnadirSaldo(personabanco);
                        break;

                    case "2":
                        retirarSaldo(personabanco);
                        break;

                    default:
                        flag = false;
                        System.out.println("Cerrando el programa...");
                        break;
                }
            }
        }

    private static void AnadirSaldo(Personabanco personabanco) throws Exception {

            Miscanner miscanner = new Miscanner();;
            System.out.println("\nSaldo actual " + Personabanco.getDinero_en_banco());
            int saldoAnadido = miscanner.pedirNumero("Introduzca el dinero que quiere ingresar: ");
            int nuevosaldo = saldoAnadido + Personabanco.getDinero_en_banco();
            personabanco.setDinero_en_banco(nuevosaldo);
            System.out.println("\nSaldo actual: " + nuevosaldo + "\n" + "\nVolviendo al menú\n");
        }

        public static void retirarSaldo(Personabanco personabanco) throws Exception {

            Miscanner miscanner = new Miscanner();
            System.out.println("\nSaldo actual: " + Personabanco.getDinero_en_banco());
            int saldoRetrirado = miscanner.pedirNumero("introduzca el dinero que quiere retirar: ");
            if (saldoRetrirado > Personabanco.getDinero_en_banco()) {
                Exception ExcepcionBanco = new Exception("Operación fuera de saldo");
                throw ExcepcionBanco;
            } else {
                int nuevosaldo = Personabanco.getDinero_en_banco() - saldoRetrirado;
                personabanco.setDinero_en_banco(nuevosaldo);
                System.out.println("\nSaldo actual: " + nuevosaldo + "\nVolviendo al menú");
            }
        }
    }