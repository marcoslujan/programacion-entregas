import Clases.Biblioteca;
import Clases.Libro;
import Clases.MyScanner;

import java.util.ArrayList;

public class MenuBiblioteca {

    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        bibliotecaStart(biblioteca);
    }

    private static void bibliotecaStart(Biblioteca biblioteca) {
        System.out.println("Bienvenido a bibliotecas Pedregosa");

        biblioteca.setId(sc.pedirNumero("por favor, introduce el ID de su biblioteca: "));
        biblioteca.setNombre(sc.pideTexto("Very good  then, now el nombre de su biblioteca: "));

        System.out.println("Excelente \"" + biblioteca.getNombre() + "\" de ID: " + biblioteca.getId() + ")");

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = sc.pedirNumero("Ahora, elige: ");

            switch (opcion) {
                case 1:
                    mostrarLibros(biblioteca);
                    break;
                case 2:
                    anadirLibro(biblioteca);
                    break;
                case 3:
                    prestarLibro(biblioteca);
                    break;
                case 4:
                    devolverLibro(biblioteca);
                    break;
                case 0:
                    salir = true;
                    System.out.println("pues bueno, ya nos veremos de nuevo, supongo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n Menú de la biblioteca ");
        System.out.println("1. Mostrar libros");
        System.out.println("2. Añadir libro");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("0. Salir");
    }

    private static void mostrarLibros(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();

        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca, patan");
            return;
        }

        System.out.println("\nLos Libros:");
        for (Libro libro : libros) {
            System.out.println("ID: " + libro.getId() + " Título: " + libro.getTitulo() +
                    " Autor: " + libro.getAutor() +
                    " Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
        }
    }

    private static void anadirLibro(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();

        int id = sc.pedirNumero("Introduce el ID del libro: ");

        for (Libro l : libros) {
            if (l.getId() == id) {
                System.out.println("Este ID ya existe, por ende, este libro ya reside en la bibliotuca");
                return;
            }
        }

        String titulo = sc.pideTexto("Introduce el título del libro: ");
        String autor = sc.pideTexto("Ahora, introduce el autor del libro: ");
        int paginas = sc.pedirNumero("Y, cuantas paginas tiene: ");
        String isbn = sc.pideTexto("Introduce el ISBN/codigo del libro: ");

        Libro nuevoLibro = new Libro(id, titulo, autor, paginas, isbn);
        nuevoLibro.setDisponible(true);

        biblioteca.addLibro(nuevoLibro);
        System.out.println("El libro: " + titulo + "se añadio a la biblioteca");
    }

    private static void prestarLibro(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();
        ArrayList<Libro> disponibles = new ArrayList<>();

        for (Libro l : libros) {
            if (l.isDisponible()) {
                disponibles.add(l);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hay libros disponibles para prestar, o nos los han robado");
            return;
        }

        System.out.println("\n Libros disponibles para prestar: ");
        for (Libro l : disponibles) {
            System.out.println("ID: " + l.getId() + " | " + l.getTitulo());
        }

        int id = sc.pedirNumero("Introduce el ID del libro que quieres que te prestemos: ");

        for (Libro l : disponibles) {
            if (l.getId() == id) {
                biblioteca.prestarLibro(l);
                System.out.println("Aqui tienes el libro solicitado: \"" + l.getTitulo() + "\" es un mierdon, te lo puedes quedar.");
                return;
            }
        }
        System.out.println("No se encontró ningún libro con ese ID disponible.");
    }

    private static void devolverLibro(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();
        ArrayList<Libro> prestados = new ArrayList<>();

        for (Libro l : libros) {
            if (!l.isDisponible()) {
                prestados.add(l);
            }
        }

        if (prestados.isEmpty()) {
            System.out.println("No hay libros prestados para devolver.");
            return;
        }

        System.out.println("\n Libros prestados: ");
        for (Libro l : prestados) {
            System.out.println("ID: " + l.getId() + " | " + l.getTitulo());
        }

        int id = sc.pedirNumero("Que libro vas a devolver?, bribon?; mete su ID: ");

        for (Libro l : prestados) {
            if (l.getId() == id) {
                biblioteca.devolverLibro(l);
                System.out.println("Has devuelto el libro \"" + l.getTitulo() + "\", sinceramnete, se me habia olvidado que faltaba");
                return;
            }
        }
        System.out.println("No se encontró ningún libro con ese ID prestado.");
    }
}