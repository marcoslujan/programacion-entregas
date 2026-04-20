package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlBiblioteca {
    private Biblioteca biblioteca;
    private static int contadorLibros = 1;
    private Libro libro;


    public ControlBiblioteca() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre de la biblioteca en mayúsculas: ");
        String nombreBiblioteca = sc.nextLine();
        biblioteca = new Biblioteca(1, nombreBiblioteca);
    }


    public void añadirLibroInicial(Libro libro) {
        this.libro = libro;
        biblioteca.addLibro(libro);
    }

    private void mostrarMenu() {
        System.out.println("\n ****** GESTIÓN DE LA BIBLIOTECA " + biblioteca.getNombre() + " ******");
        System.out.println("1. Añadir libro");
        System.out.println("2. Prestar libro");
        System.out.println("3. Devolver libro");
        System.out.println("4. Mostrar libro");
        System.out.println("0. Salir");
        System.out.println("¿Dígame qué necesita usted?");
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            mostrarMenu();
            while (!sc.hasNextLine()) {
                System.out.println("Que te he dicho un número pesao, que eres un pesao.");
                sc.nextLine();
                mostrarMenu();
            }
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> añadirLibro(sc);
                case 2 -> prestarLibro(sc);
                case 3 -> devolverLibro(sc);
                case 4 -> mostrarLibros();
                case 0 -> System.out.println("Saliendo de la biblioteca... ¡Hasta luego!");
                default -> System.out.println("Opción incorrecta. Inténtalo otra vez.");

            }
        } while (option != 0);
        sc.close();
    }

    private void añadirLibro(Scanner sc) {
        System.out.print("Introduce el título del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Introduce el autor: ");
        String autor = sc.nextLine();
        System.out.print("Introduce el número de páginas: ");
        int paginas = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el ISBN: ");
        String isbn = sc.nextLine();
        Libro nuevo = new Libro(contadorLibros++, titulo, autor, paginas, isbn);
        biblioteca.addLibro(nuevo);
        System.out.println("Libro añadido correctamente: " + nuevo);
    }

    private void prestarLibro(Scanner sc) {
        ArrayList<Libro> disponibles = new ArrayList<>();

        for (Libro l : biblioteca.getLibros()) {
            if (l.isDisponible()) {
                disponibles.add(l);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hay libros disponibles para prestar.");
            return;
        }

        System.out.println("Libros disponibles para prestar:");
        for (Libro l : disponibles) {
            System.out.println(l.getId() + ". " + l.getTitulo() + " - " + l.getAutor());
        }

        System.out.print("Introduce el ID del libro a prestar: ");
        int id = sc.nextInt();

        for (Libro l : biblioteca.getLibros()) {
            if (l.getId() == id && l.isDisponible()) {
                biblioteca.prestarLibro(l);
                System.out.println("Has prestado el libro: " + l.getTitulo());
                return;
            }
        }

        System.out.println("El ID es inválido o el libro ya ha sido prestado.");
    }

    private void devolverLibro(Scanner sc) {
            ArrayList<Libro> prestados = new ArrayList<>();

            for (Libro l : biblioteca.getLibros()) {
                if (!l.isDisponible()) {
                    prestados.add(l);
                }
            }

            if (prestados.isEmpty()) {
                System.out.println("No hay libros para devolver.");
                return;
            }

            System.out.println("Libros actualmente prestados:");
            for (Libro l : prestados) {
                System.out.println(l.getId() + ". " + l.getTitulo() + " - " + l.getAutor());
            }

            System.out.print("Introduce el ID del libro a devolver: ");
            int id = sc.nextInt();

            for (Libro l : biblioteca.getLibros()) {
                if (l.getId() == id && !l.isDisponible()) {
                    biblioteca.devolverLibro(l);
                    System.out.println("Has devuelto el libro: " + l.getTitulo());
                    return;
                }
            }

            System.out.println("ID no válido o el libro ya estaba disponible.");
        }
    private void mostrarLibros() {
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return;
        }
        System.out.println("Listado de libros:");
        for (Libro l : biblioteca.getLibros()) {
            System.out.println(l);
        }
    }

}

