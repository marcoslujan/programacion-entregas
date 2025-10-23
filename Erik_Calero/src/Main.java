public class Main {
    public static void main(String[] args) {
        Myscanner sc = new Myscanner();

        String nombreBiblioteca = sc.pedirSoloTexto("Ingrese el nombre de la biblioteca: ");
        Biblioteca biblioteca = new Biblioteca(1, nombreBiblioteca);

        int opcion;
        do {
            System.out.println("\n -------- MENÚ DE BIBLIOTECA -------");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Añadir libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            opcion = sc.pedirNumero("Selecione la opcion :");
           // sc.pedirSoloTexto(""); // Limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarLibros(biblioteca);
                    break;

                case 2:
                    agregarLibro(biblioteca, sc);
                    break;

                case 3:
                    prestarLibro(biblioteca, sc);
                    break;

                case 4:
                    devolverLibro(biblioteca, sc);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    private static void mostrarLibros(Biblioteca biblioteca) {
        System.out.println("\n Libros en la biblioteca:");
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : biblioteca.getLibros()) {
                System.out.println(libro.infoBasica());
            }
        }
    }

    private static void agregarLibro(Biblioteca biblioteca, Myscanner sc) {
        System.out.print("Ingrese ID del libro: ");
        int id = sc.pedirNumero("ingrese id del libro ");

        String titulo = sc.pedirSoloTexto("Ingrese titulo del libro: ");

        String autor = sc.pedirSoloTexto("Ingrese autor: ");

        int paginas = sc.pedirNumero("ingrese numero de paginas");

        String isbn = sc.pedirSoloTexto("Ingrese ISBN: ");

        Libro nuevo = new Libro(id, titulo, autor, paginas, isbn);
        biblioteca.addLibro(nuevo);
        System.out.println(" se ha añadido el libro ");
    }

    private static void prestarLibro(Biblioteca biblioteca, Myscanner sc) {
        String titulo = sc.pedirSoloTexto("Ingrese titulo del libro a prestar: ");

        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro == null) {
            System.out.println(" Libro no encontrado.");
        } else if (!libro.isDisponible()) {
            System.out.println(" El libro ya está prestado.");
        } else {
            biblioteca.prestarLibro(libro);
            System.out.println(" Libro prestado correctamente.");
        }
    }

    private static void devolverLibro(Biblioteca biblioteca, Myscanner sc) {
        String titulo = sc.pedirSoloTexto("Ingrese titulo del libro a devolver: ");

        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro == null) {
            System.out.println(" Libro no encontrado");
        } else if (libro.isDisponible()) {
            System.out.println(" El libro ya está disponible");
        } else {
            biblioteca.devolverLibro(libro);
            System.out.println(" Libro devuelto correctamente");
        }
    }
}
