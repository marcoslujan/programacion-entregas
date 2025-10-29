
public class Buscalibro {

    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        int idBiblioteca = (1);

        String nombre = sc.pideTexto("Introduce el nombre de la biblioteca: ");
        Biblioteca biblioteca = new Biblioteca(idBiblioteca, nombre);
        System.out.println("Biblioteca creada con ID: " + biblioteca.getId());
        Libro libro1 = new Libro(1, "El Quijote", "Miguel de Cervantes", 863, "9788491050291");
        Libro libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez", 471, "9788497592207");
        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);
        int opcion;
        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar libros disponibles");
            System.out.println("3. Añadir nuevo libro");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Salir");
            opcion = sc.pedirNumero("Ingrese una opcion: ");
            switch (opcion) {
                case 1:
                    mostrarTodosLosLibros(biblioteca);
                    break;
                case 2:
                    mostrarLibrosDisponibles(biblioteca);
                    break;
                case 3:
                    agregarLibro(biblioteca);
                    break;
                case 4:
                    prestarLibro(biblioteca);
                    break;
                case 5:
                    devolverLibro(biblioteca);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarTodosLosLibros(Biblioteca biblioteca) {

        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("\n--- TODOS LOS LIBROS ---");
            for (Libro libro : biblioteca.getLibros()) {
                System.out.println(libro);
            }
        }
    }

    private static void mostrarLibrosDisponibles(Biblioteca biblioteca) {

        boolean hayDisponibles = false;
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.isDisponible()) {
                System.out.println(libro);
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles.");
        }
    }

    private static void agregarLibro(Biblioteca biblioteca) {

        String titulo = sc.pideTexto("Introduce el título del libro: ");
        String autor = sc.pedirSoloTexto("Introduce el autor: ");
        int numPaginas = sc.pedirNumero("Introduce el número de páginas: ");
        String isbn = sc.pideTexto("Introduce el ISBN: ");

        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getTitulo().equals(titulo) || libro.getISBN().equals(isbn)) {
                System.out.println("No se puede añadir el libro, ya existe un libro con el mismo título o ISBN.");
                return;
            }
        }
        int idLibro = biblioteca.getLibros().size() + 1;
        Libro nuevo = new Libro(idLibro, titulo, autor, numPaginas, isbn);
        biblioteca.addLibro(nuevo);
        System.out.println("Libro añadido correctamente: " + nuevo);
    }

    private static void prestarLibro(Biblioteca biblioteca) {

        boolean hayDisponibles = false;
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.isDisponible()) {
                hayDisponibles = true;
                break;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No se puede prestar ningún libro: todos están prestados.");
            return;
        }
        int id = sc.pedirNumero("Introduce el ID del libro a prestar: ");
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getId() == id && libro.isDisponible()) {
                biblioteca.prestarLibro(libro);
                System.out.println("Libro prestado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un libro disponible con ese ID.");
    }

    private static void devolverLibro(Biblioteca biblioteca) {

        boolean hayPrestados = false;
        for (Libro libro : biblioteca.getLibros()) {
            if (!libro.isDisponible()) {
                hayPrestados = true;
                break;
            }
        }
        if (!hayPrestados) {
            System.out.println("No se puede devolver ningún libro: todos están disponibles.");
            return;
        }
        int id = sc.pedirNumero("Introduce el ID del libro a devolver: ");
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getId() == id && !libro.isDisponible()) {
                biblioteca.devolverLibro(libro);
                System.out.println("Libro devuelto correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un libro prestado con ese ID.");
    }
}