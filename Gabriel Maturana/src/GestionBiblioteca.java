
public class GestionBiblioteca {

    static Biblioteca biblioteca = new Biblioteca();
    static MyScanner scanner = new MyScanner();

    public static void main(String[] args) {
        String nombreBiblioteca = scanner.pedirSoloTexto("Ingrese el nombre de la biblioteca: ");
        biblioteca.setNombre(nombreBiblioteca);
        System.out.println("Bienvenido a " + nombreBiblioteca);

        int opcion;
        do {
            System.out.println("\n--- Gestión de Biblioteca ---");
            System.out.println("1. Añadir Libros");
            System.out.println("2. Mostrar Libros");
            System.out.println("3. Prestar Libros");
            System.out.println("4. Devolver Libros");
            System.out.println("5. Salir");
            opcion = scanner.pedirNumero("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar la biblioteca!");
                    break;
                default:
                    System.out.println(" Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }


    public static void crearLibro() {
        Libro libro = new Libro();

        libro.setId(scanner.pedirNumero("Ingrese el ID del libro: "));
        libro.setTitulo(scanner.pideTexto("Ingrese el título del libro: "));
        libro.setAutor(scanner.pideTexto("Ingrese el autor: "));
        libro.setNumeroPaginas(scanner.pedirNumero("Ingrese el número de páginas: "));
        libro.setISBN(scanner.pideTexto("Ingrese el ISBN: "));
        libro.setDisponible(true);

        biblioteca.addLibro(libro);
        System.out.println(" Libro agregado correctamente.");
    }


    public static void mostrarLibros() {
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println(" No hay libros registrados en la biblioteca.");
        } else {
            System.out.println("\n Lista de libros en la biblioteca:");
            for (Libro libro : biblioteca.getLibros()) {
                System.out.println("-----------------------------------");
                System.out.println("ID: " + libro.getId());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Páginas: " + libro.getNumeroPaginas());
                System.out.println("ISBN: " + libro.getISBN());
                System.out.println("Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
            }
            System.out.println("-----------------------------------");
        }
    }

    public static void prestarLibro() {

        boolean hayDisponibles = false;
        System.out.println("\n Libros disponibles para prestar:");
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.isDisponible()) {
                hayDisponibles = true;
                System.out.println("-----------------------------------");
                System.out.println("ID: " + libro.getId());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Páginas: " + libro.getNumeroPaginas());
                System.out.println("ISBN: " + libro.getISBN());
            }
        }


        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles para prestar.");
            return;
        }


        int idLibro = scanner.pedirNumero("Ingrese el ID del libro que desea prestar: ");
        Libro libroEncontrado = null;


        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getId() == idLibro && libro.isDisponible()) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado == null) {
            System.out.println("No se encontró un libro disponible con ese ID.");
        } else {

            biblioteca.prestarLibro(libroEncontrado);
            System.out.println(" Has prestado el libro: " + libroEncontrado.getTitulo());
        }
    }

    public static void devolverLibro() {
        boolean hayPrestados = false;
        System.out.println("\n Libros actualmente prestados:");
        for (Libro libro : biblioteca.getLibros()) {
            if (!libro.isDisponible()) {
                hayPrestados = true;
                System.out.println("-----------------------------------");
                System.out.println("ID: " + libro.getId());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Páginas: " + libro.getNumeroPaginas());
                System.out.println("ISBN: " + libro.getISBN());
            }
        }

        if (!hayPrestados) {
            System.out.println("No hay libros prestados para devolver.");
            return;
        }


        int idLibro = scanner.pedirNumero("Ingrese el ID del libro que desea devolver: ");
        Libro libroEncontrado = null;


        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getId() == idLibro && !libro.isDisponible()) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado == null) {
            System.out.println(" No se encontró un libro prestado con ese ID.");
        } else {

            biblioteca.devolverLibro(libroEncontrado);
            System.out.println(" Has devuelto el libro: " + libroEncontrado.getTitulo());
        }
    }

}



