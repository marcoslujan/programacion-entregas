package clases;

public class GestionBiblioteca {

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(System.in);
        int idBiblioteca = 0;
        String nombreBiblioteca = MyScanner.comprobar_SoloTexto("Introduce el nombre de la biblioteca:");
        Biblioteca biblioteca = new Biblioteca(idBiblioteca, nombreBiblioteca);

        boolean salir = false;

        // Menu de la biblioteca
        while (!salir) {
            System.out.println("\n------ MENÚ DE " + biblioteca.getNombre().toUpperCase() + " ------");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Añadir libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = MyScanner.comprobar_Numero("");

            // Funciones de las opciones con control de errores de numeros no validos
            switch (opcion) {
                case 1:
                    mostrarLibros(biblioteca);
                    break;
                case 2:
                    añadirLibro(biblioteca);
                    break;
                case 3:
                    prestarLibro(biblioteca);
                    break;
                case 4:
                    devolverLibro(biblioteca);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Metodo para mostrar los libros
    private static void mostrarLibros(Biblioteca biblioteca) {
        System.out.println("\nLISTA DE LIBROS:");
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < biblioteca.getLibros().size(); i++) {
                Libro l = biblioteca.getLibros().get(i);
                String estado;
                if (l.isDisponible()) {
                    estado = "Disponible";
                } else {
                    estado = "No disponible";
                }
                System.out.printf("ID: %d | %s | %s | ISBN: %s | %s%n",
                        l.getId(), l.getTitulo(), l.getAutor(), l.getISBN(), estado);
            }
        }
    }

    // Metodo para añadir libros a la biblioteca con control de errores de numero y texto
    private static void añadirLibro(Biblioteca biblioteca) {
        System.out.println("\nAÑADIR LIBRO:");

        int id = MyScanner.comprobar_Numero("Introduce el ID del libro:");

        // Control de ID unicos
        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            Libro l = biblioteca.getLibros().get(i);
            if (l.getId() == id) {
                System.out.println("Ya existe un libro con ese ID. No se puede añadir otro igual.");
                return;
            }
        }

        String titulo = MyScanner.comprobar_SoloTexto("Introduce el título del libro:");
        String autor = MyScanner.comprobar_SoloTexto("Introduce el autor:");
        int paginas = MyScanner.comprobar_Numero("Introduce el número de páginas:");

        // Control de id de solo letras y en mayusculas
        String isbn;
        do {
            System.out.print("Introduce el ISBN (solo letras): ");
            isbn = new java.util.Scanner(System.in).nextLine().toUpperCase().trim();
            if (!isbn.matches("[a-zA-Z]+")) {
                System.out.println("ISBN incorrecto. Solo se permiten letras. Intentalo de nuevo.");
            }
        } while (!isbn.matches("[a-zA-Z]+"));

        Libro libro = new Libro(id, titulo, autor, paginas, isbn, true);
        biblioteca.addLibro(libro);

        System.out.println("Libro añadido correctamente.");
    }

    // Metodo para prestar los libros con control de errores de numero
    private static void prestarLibro(Biblioteca biblioteca) {
        System.out.println("\nPRESTAR LIBRO:");
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        int id = MyScanner.comprobar_Numero("Introduce el ID del libro a prestar:");

        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            Libro l = biblioteca.getLibros().get(i);
            if (l.getId() == id) {
                if (l.isDisponible()) {
                    biblioteca.prestarLibro(l);
                    System.out.println("Libro prestado correctamente.");
                } else {
                    System.out.println("El libro ya está prestado.");
                }
                return;
            }
        }
        System.out.println("No se encontró ningún libro con ese ID.");
    }

    // Metodo para devolver libros con control de errores de numero
    private static void devolverLibro(Biblioteca biblioteca) {
        System.out.println("\nDEVOLVER LIBRO:");
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        int id = MyScanner.comprobar_Numero("Introduce el ID del libro a devolver:");

        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            Libro l = biblioteca.getLibros().get(i);
            if (l.getId() == id) {
                if (!l.isDisponible()) {
                    biblioteca.devolverLibro(l);
                    System.out.println("Libro devuelto correctamente.");
                } else {
                    System.out.println("El libro ya está disponible.");
                }
                return;
            }
        }

        System.out.println("No se encontró ningún libro con ese ID.");
    }
}
