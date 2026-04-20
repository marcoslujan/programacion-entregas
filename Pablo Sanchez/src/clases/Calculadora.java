//package clases;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Calculadora {
//
//    public Calculadora() {
//    }
//        private void mostrarMenu () {
//            System.out.println("\n--- Calculadora ---");
//            System.out.println("1. Sumar");
//            System.out.println("2. Restar");
//            System.out.println("3. Multiplicar");
//            System.out.println("0. Salir");
//            System.out.print("Elige una opción (0-3): ");
//        }
//        public void menu(){
//            Scanner sc = new Scanner(System.in);
//            int opcion;
//            do {
//                mostrarMenu();
//
//                while (!sc.hasNextInt()) {
//                    System.out.println("No no no, tas confundio, intentalo otra vez");
//                    sc.next();
//                    mostrarMenu();
//                }
//                opcion = sc.nextInt();
//                if (opcion == 0) {
//                    System.out.println("¿Ya has terminado?, ahora empieza a sumar con los dedos macho, que ya eres mayor.");
//                    break;
//                }
//                if (opcion >= 1 && opcion <= 3) {
//                    int num1 = comprobar(sc);
//                    NumeroPar(num1);
//                    int num2 = comprobar(sc);
//                    NumeroPar(num2);
//                    switch (opcion) {
//                        case 1:
//                            System.out.println("Toma graciosín, tu suma es : " + suma(num1, num2));
//                            break;
//                        case 2:
//                            System.out.println("Aquí tienes la resta sin usar tus dedos, el resultado es: " + resta(num1, num2));
//                            break;
//                        case 3:
//                            System.out.println("La multiplicación es: " + multiplicacion(num1, num2) + " ,Ya te he ahorrado estudiarte las tablas bombón");
//                            break;
//                    }
//                } else {
//                    System.out.println("Te he dicho entre 0 y 3, empezamos mal....");
//                }
//            } while (opcion != 0);
//            sc.close();
//        }
//        private static void NumeroPar ( int num){
//            if (num % 2 == 0) {
//                System.out.println("Su numerin es " + num + " par champions.");
//            } else {
//                System.out.println("Su numerin es " + num + " impar champions.");
//            }
//        }
//        private static int suma ( int num1, int num2){
//            return num1 + num2;
//        }
//        private static int resta ( int num1, int num2){
//            return num1 - num2;
//        }
//        private static int multiplicacion ( int num1, int num2){
//            return num1 * num2;
//        }
//        private static int comprobar (Scanner sc){
//            int numero = -1;
//            boolean valido = false;
//            while (!valido) {
//                System.out.print("Ingrese un número: ");
//                try {
//                    numero = sc.nextInt();
//                    valido = true;
//                } catch (InputMismatchException e) {
//                    System.out.println("Pero vamos a ver embobao, que eso no es un número.");
//                    sc.next();
//                }
//            }
//            return numero;
//        }
//}

//
//            Persona persona = new Persona();
//            MyScanner sc = new MyScanner();
//
//            System.out.println();
//            persona.setNombre (sc.pedirSoloTexto("Introduzca su nombre: "));
//
//            System.out.println();
//            persona.setApellido(sc.pedirSoloTexto("Hola " + persona.getNombre() + " Introduzca su apellido: "));
//
//            int edad = sc.pedirNumero("Ahora " + persona.getNombre() + " " + persona.getApellido() + " introduzca su edad: ");
//            persona.setEdad(edad);
//            persona.setNombre("Briseida");
//            System.out.println("Ahora te llamas " + persona.getNombre() + " tienes un 9,21 de media y tu edad es mayor.");
//
//            Direccion direccion = new Direccion();
//            direccion.setCalle(sc.pedirSoloTexto("Introduzca su calle: "));
//            direccion.setPortal(sc.pedirNumero("Introduzca su portal es: "));
//            direccion.setPiso(sc.pedirNumero("Introduzca su piso es: "));
//            direccion.setLetra(sc.pedirLetra("Su letra es: "));
//

//        Calculadora calculadora = new Calculadora();
//        calculadora.menu();
//        persona persona = new Persona("Juan", "Gutierrez", 25);
//        System.out.println("Nombre: " + persona.getNombre());
//        persona.setNombre("Pepe");
//        System.out.println("Nombre: " + persona.getNombre());

//ASI ES COMO SE LLAMA A UNA CLASE PARA PODER HACERLA EN OTRO PROGRAMA SIN TENER QUE VOLVER A HACER EL CODIGO
//            ArrayList<Persona> personas = new ArrayList<Persona>();
//            personas.add(persona);
//            for (int i=0;i<personas.size();i++){
//                System.out.println(personas.get(0).toString());
//            }
//        }

