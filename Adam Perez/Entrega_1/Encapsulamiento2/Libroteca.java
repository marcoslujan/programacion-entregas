package Encapsulamiento2;

import java.util.ArrayList;
import java.util.Scanner;

public class Libroteca {
    private int ultID = 0;

    MyScanner sc = new MyScanner();
    Biblioteca biblioteca = new Biblioteca();
    ArrayList<Libro> libros = biblioteca.getLibros();

    public Libroteca() {

    }

    public void meterNombre() {
        biblioteca.setNombre(sc.pideTexto("Biblioteca inicializada.\n" +
                "Elige un nombre para la biblioteca: "));
    }

    public void sistemaBiblio() {

        boolean servicio = true;
        while (servicio) {
            int opcion = elegirOpcion();
            switch (opcion) {
                case 1:
                    mostrar();
                    break;
                case 2:
                    añadir();
                    break;
                case 3:
                    pedirPrestado();
                    break;
                case 4:
                    devolver();
                    break;
                case 5:
                    System.out.println("Gracias bombon");
                    servicio = false;
                    break;
                default:
                    System.out.println("Esa opción no existe, bobo");
            }
        }

    }

    public int elegirOpcion () {
        return sc.pedirNumero("Bienvenido a " + biblioteca.getNombre() +"\n" +
                            "\n----- Que operacion deseas realizar -----\n" +
                                "1-- Para mostar los libros disponibles\n" +
                                "2-- Para añadir un libro\n" +
                                "3-- Para pedir prestado un libro\n" +
                                "4-- Para devolver un libro\n" +
                                "5-- Para salir del menú\n\n");
    }


    public void mostrar () {
        boolean flag = true;
        while (flag) {
            if (libros.size() == 0) {
                System.out.println("No hay libros disponibles\n");
                int eleccion = sc.pedirNumero("Si deseas agregar un libro introduce 1. \n" +
                                                    "Si deseas volver al menu introduce 2. \n" +
                                                    "Dime: ");
                if (eleccion == 1) {
                    añadir();
                    flag = false;
                } else if (eleccion == 2) {
                    flag = false;
                } else {
                    System.out.println("Opcion invalida\n");
                }

            } else {
                for (int i = 0; i < libros.size(); i++) {
                    System.out.println("\n" + libros.get(i) + "\n");
                }
                flag = false;
            }
        }
    }

    public void añadir () {
        int numLibros = sc.pedirNumero("Cuantos libros deseas agregar?");
        for (int i = 0; i < numLibros; i++) {
            Libro libro = new Libro();
            libro.setId(ultID++);
            libro.setTitulo(sc.pideTexto("Titulo del libro: "));
            libro.setAutor(sc.pedirSoloTexto("Autor del libro: "));
            libro.setISBN(sc.pideTexto("ISBN del libro: "));
            libro.setNumeroPaginas(sc.pedirNumero("Numero de paginas del libro: "));
            libro.setDisponible(true);
            biblioteca.addLibro(libro);
        }
    }

    public void pedirPrestado () {
        if(libros.size() == 0) {
            mostrar();
        } else {
            for (int i = 0; i < libros.size(); i++) {
                if (libros.get(i).isDisponible()) {
                    System.out.println(libros.get(i));
                }
            }

            int eleccion = sc.pedirNumero("Cual libro quieres pedir prestado? (Por numero de ID)\n");
            boolean found = true;
            for (int i = 0; i < libros.size(); i++) {
                if (libros.get(i).getId() == eleccion && libros.get(i).isDisponible()) {
                    biblioteca.prestarLibro(libros.get(i));
                    found = false;
                    break;
                }
            }
            if (!found) {
                System.out.println("No hay libro disponible con ese ID");
            }
        }
    }

    public void devolver () {
        if(libros.size() == 0) {
            mostrar();
        } else {
            for (int i = 0; i < libros.size(); i++) {
                if (!libros.get(i).isDisponible()) {
                    System.out.println(libros.get(i));
                }
            }

            int eleccion = sc.pedirNumero("Cual libro quieres regresar? Bombon (Por numero de ID)\n");
            boolean found = false;
            for (int i = 0; i < libros.size(); i++) {
                if (libros.get(i).getId() == eleccion && !libros.get(i).isDisponible()) {
                    biblioteca.devolverLibro(libros.get(i));
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No se encuentra ese ID");
            }
        }
    }
}
