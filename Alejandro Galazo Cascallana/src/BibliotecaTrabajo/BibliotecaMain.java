package BibliotecaTrabajo;

import java.util.ArrayList;


public class BibliotecaMain {

    public static void main(String[] args) {
        MyScanner teclado = new MyScanner();

        String nombreBiblioteca = teclado.pideTexto("Introduce el nombre de la biblioteca:");
        Biblioteca biblioteca = new Biblioteca(1, nombreBiblioteca);

        int nextId = 1;
        int opcion;

        do {
            System.out.println("\n***** Menú de la biblioteca " + biblioteca.getNombre() + " *****");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros en la biblioteca");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Eliminar libro por título");
            System.out.println("0. Salir");
            opcion = teclado.pedirNumero("Selecciona una opción:");

            switch (opcion) {
                case 1 -> {
                    agregarLibro(teclado, biblioteca, nextId);
                    nextId++;
                }
                case 2 -> mostrarLibros(biblioteca);
                case 3 -> prestarLibro(teclado, biblioteca);
                case 4 -> devolverLibro(teclado, biblioteca);
                case 5 -> eliminarLibro(teclado, biblioteca);
                case 0 -> System.out.println("Sayonara bby");
                default -> System.out.println("Opción no válida. Número entre 0 y 5.");
            }

        } while (opcion != 0);
    }


    public static void agregarLibro(MyScanner teclado, Biblioteca biblioteca, int id) {
        String titulo = teclado.pideTexto("Introduce el título del libro:");
        String autor = teclado.pedirSoloTexto("Introduce el autor del libro:");
        int numPaginas = teclado.pedirNumero("Introduce el número de páginas:");
        String isbn = teclado.pideTexto("Introduce el ISBN del libro:");

        Libro libro = new Libro(id, titulo, autor, numPaginas, isbn);
        biblioteca.addLibro(libro);

    }

    public static void mostrarLibros(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        System.out.println("\n LIBROS EN LA BIBLIOTECA:");
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                System.out.println("  Título: " + libro.getTitulo() + "\n  Autor: " + libro.getAutor() + "\n  Páginas: " + libro.getNumeroPaginas() + "\n  ISBN: " + libro.getISBN());
            }
        }
    }

    public static void prestarLibro(MyScanner teclado, Biblioteca biblioteca) {
        String titulo = teclado.pideTexto("Introduce el título del libro que quieres pedir:");
        Libro libroEncontrado = buscarLibroPorTitulo(biblioteca, titulo);

        if (libroEncontrado == null) {
            System.out.println("No se encontró ningún libro con ese título.");
            return;
        }

        if (!libroEncontrado.isDisponible()) {
            System.out.println("El libro no está disponible actualmente.");
            return;
        }

        char respuesta = teclado.pedirLetra("El libro está disponible. ¿Deseas adquirirlo? (s/n):");
        if (Character.toLowerCase(respuesta) == 's') {
            biblioteca.prestarLibro(libroEncontrado);
            System.out.println("Has tomado prestado el libro: " + libroEncontrado.getTitulo());
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    public static void devolverLibro(MyScanner teclado, Biblioteca biblioteca) {
        String titulo = teclado.pideTexto("Introduce el título del libro que deseas devolver:");
        Libro libroEncontrado = buscarLibroPorTitulo(biblioteca, titulo);

        if (libroEncontrado == null) {
            System.out.println("Ese libro no pertenece a la biblioteca.");
            return;
        }

        if (libroEncontrado.isDisponible()) {
            System.out.println("El libro ya estaba disponible.");
            return;
        }

        biblioteca.devolverLibro(libroEncontrado);
        System.out.println("Has devuelto el libro correctamente: " + libroEncontrado.getTitulo());
    }

    public static void eliminarLibro(MyScanner teclado, Biblioteca biblioteca) {
        String titulo = teclado.pideTexto("Introduce el título del libro que deseas eliminar:");
        String autor = teclado.pedirSoloTexto("Introduce el autor del libro:");

        ArrayList<Libro> libros = biblioteca.getLibros();
        Libro libroAEliminar = null;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)
                    && libro.getAutor().equalsIgnoreCase(autor)) {
                libroAEliminar = libro;
                break;
            }
        }

        if (libroAEliminar != null) {
            libros.remove(libroAEliminar);
            System.out.println("BibliotecaTrabajo.Libro eliminado" + libroAEliminar.getTitulo());
        } else {
            System.out.println("No se encontró un libro con ese título y autor, comprueba que esté bien escrito, sino no lo tenemos");
        }
    }

    public static Libro buscarLibroPorTitulo(Biblioteca biblioteca, String titulo) {
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}