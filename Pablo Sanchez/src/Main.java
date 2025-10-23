//import clases.*;
//import clases.Persona;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//

import clases.ControlBiblioteca;
import clases.Libro;

public class Main {
    public static void main(String[] args) {
        ControlBiblioteca gestion = new ControlBiblioteca();

        Libro l1 = new Libro(1, "El Quijote", "Miguel de Cervantes", 863, "987654321");
        Libro l2 = new Libro(2, "1984", "George Orwell", 328, "012345678");
        Libro l3 = new Libro(3, "Cien años de soledad", "Gabriel García Márquez", 471, "123456789");
        Libro l4 = new Libro(4, "Marco va al parque", "Adam Perez", 75, "789789789");
        Libro l5 = new Libro(5, "Adam va al zoo", "Pablo Sánchez", 175, "123123123");

        gestion.añadirLibroInicial(l1);
        gestion.añadirLibroInicial(l2);
        gestion.añadirLibroInicial(l3);
        gestion.añadirLibroInicial(l4);
        gestion.añadirLibroInicial(l5);

        gestion.menu();
    }

}





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

