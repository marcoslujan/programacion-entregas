package clase;

import java.util.ArrayList;

public class GestionBiblioteca {
    private static MyScanner scanner = new MyScanner();

    public static void main(String[] args) {
        clase.Biblioteca biblioteca = new clase.Biblioteca(1, "Biblioteca Central");

        clase.Libro libro1 = new clase.Libro(1, "El Quijote", "Cervantes", 500, "FACAAF");
        clase.Libro libro2 = new clase.Libro(2, "Ejemplo", "Yo", 50, "AESSAF");
        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== GESTIÓN DE BIBLIOTECA ===");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar libros disponibles");
            System.out.println("3. Mostrar libros prestados");
            System.out.println("4. Añadir libro");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Salir");

            int n = scanner.pedirNumero("Seleccione una opción:");
            switch (n) {
                case 1:
                    mostrarTodosLosLibros(biblioteca);
                    break;
                case 2:
                    mostrarLibrosDisponibles(biblioteca);
                    break;
                case 3:
                    mostrarLibrosPrestados(biblioteca);
                    break;
                case 4:
                    añadirLibro(biblioteca);
                    break;
                case 5:
                    prestarLibro(biblioteca);
                    break;
                case 6:
                    devolverLibro(biblioteca);
                    break;
                case 7:
                    System.out.println("¡Hasta pronto!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intentelo nuevamente.");
            }
        }
    }

    public static void mostrarTodosLosLibros(clase.Biblioteca biblioteca) {
        ArrayList<clase.Libro> libros = biblioteca.getLibros();
        if (libros.isEmpty()) {
            System.out.println("\nNo hay libros en la biblioteca.");
        } else {
            System.out.println("\n=== TODOS LOS LIBROS ===");
            for (int i = 0; i < libros.size(); i++) {
                clase.Libro libro = libros.get(i);
                String estado = libro.isDisponible() ? "DISPONIBLE" : "PRESTADO";
                System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + estado);
            }
        }
    }

    public static void mostrarLibrosDisponibles(clase.Biblioteca biblioteca) {
        ArrayList<clase.Libro> libros = biblioteca.getLibros();
        boolean hayDisponibles = false;

        System.out.println("\n=== LIBROS DISPONIBLES ===");
        for (int i = 0; i < libros.size(); i++) {
            clase.Libro libro = libros.get(i);
            if (libro.isDisponible()) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getNumeroPaginas() + " páginas");
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles en este momento.");
        }
    }

    public static void mostrarLibrosPrestados(clase.Biblioteca biblioteca) {
        ArrayList<clase.Libro> libros = biblioteca.getLibros();
        boolean hayPrestados = false;

        System.out.println("\n=== LIBROS PRESTADOS ===");
        for (int i = 0; i < libros.size(); i++) {
            clase.Libro libro = libros.get(i);
            if (!libro.isDisponible()) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor());
                hayPrestados = true;
            }
        }

        if (!hayPrestados) {
            System.out.println("No hay libros prestados en este momento.");
        }
    }

    public static void añadirLibro(clase.Biblioteca biblioteca) {
        System.out.println("\n=== AÑADIR NUEVO LIBRO ===");

        clase.Libro nuevoLibro = new clase.Libro();
        nuevoLibro.setId(scanner.pedirNumero("Inserte el ID del libro: "));
        nuevoLibro.setTitulo(scanner.pideTexto("Introduce el título del libro: "));
        nuevoLibro.setAutor(scanner.pedirSoloTexto("Introduce el autor del libro: "));
        nuevoLibro.setNumeroPaginas(scanner.pedirNumero("Introduce el número de páginas del libro: "));

        String isbn = scanner.pedirSoloTexto("Introduce el ISBN del libro (solo letras): ");
        nuevoLibro.setISBN(isbn);

        biblioteca.addLibro(nuevoLibro);
        System.out.println("¡clase.Libro añadido correctamente!");
    }

    public static void prestarLibro(clase.Biblioteca biblioteca) {
        ArrayList<clase.Libro> libros = biblioteca.getLibros();
        ArrayList<clase.Libro> disponibles = new ArrayList<>();

        System.out.println("\n=== PRESTAR LIBRO ===");
        for (int i = 0; i < libros.size(); i++) {
            clase.Libro libro = libros.get(i);
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hay libros disponibles para prestar.");
            return;
        }

        System.out.println("Libros disponibles:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).getTitulo() + " - " + disponibles.get(i).getAutor());
        }

        int seleccion = scanner.pedirNumero("Seleccione el número del libro a prestar: ");

        if (seleccion < 1 || seleccion > disponibles.size()) {
            System.out.println("Selección no válida.");
        } else {
            clase.Libro libroAPrestar = disponibles.get(seleccion - 1);
            biblioteca.prestarLibro(libroAPrestar);
            System.out.println("¡clase.Libro '" + libroAPrestar.getTitulo() + "' prestado correctamente!");
        }
    }

    public static void devolverLibro(clase.Biblioteca biblioteca) {
        ArrayList<clase.Libro> libros = biblioteca.getLibros();
        ArrayList<clase.Libro> prestados = new ArrayList<>();

        System.out.println("\n=== DEVOLVER LIBRO ===");
        for (int i = 0; i < libros.size(); i++) {
            clase.Libro libro = libros.get(i);
            if (!libro.isDisponible()) {
                prestados.add(libro);
            }
        }

        if (prestados.isEmpty()) {
            System.out.println("No hay libros prestados para devolver.");
            return;
        }

        System.out.println("Libros prestados:");
        for (int i = 0; i < prestados.size(); i++) {
            System.out.println((i + 1) + ". " + prestados.get(i).getTitulo() + " - " + prestados.get(i).getAutor());
        }

        int seleccion = scanner.pedirNumero("Seleccione el número del libro a devolver: ");

        if (seleccion < 1 || seleccion > prestados.size()) {
            System.out.println("Selección no válida.");
        } else {
            clase.Libro libroADevolver = prestados.get(seleccion - 1);
            biblioteca.devolverLibro(libroADevolver);
            System.out.println("¡clase.Libro '" + libroADevolver.getTitulo() + "' devuelto correctamente!");
        }
    }
}
