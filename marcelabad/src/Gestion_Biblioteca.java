import java.util.ArrayList;


public class Gestion_Biblioteca {
    private static MyScanner sc = new MyScanner();
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        biblioteca.setNombre(sc.pedirSoloMns("Introduce el Nombre del biblioteca "));
        Libro libro1 = new Libro(1, "El Quijote", "Cervantes", 500, "FACAFF15122");
        Libro libro2 = new Libro(2, "La Celestina", "Miguel de Rojas", 400, "ACABBB14133");
        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);
        boolean flag = true;
        int n = -1;
        do {
            System.out.println("MENU DE LA BILBIOTECA");
            System.out.println("1.Añadir Libro");
            System.out.println("2.Mostrar Libro");
            System.out.println("3.Prestar Libro");
            System.out.println("4.Devolver Libro");
            System.out.println("0.Salir");
            n = sc.pedirNumero("Que operación quieres realizar: ");
            switch (n) {
                case 1:
                    añadirLibro();
                    break;
                case 2:
                    mostrarLibro();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 0:
                    System.out.println("Saliendo de la biblioteca");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (flag);
    }

    public static void añadirLibro() {

        Libro libro3 = new Libro();
        libro3.setId(sc.pedirNumero("Introduce el Id del libro "));
        libro3.setTitulo(sc.pedirSoloMns("Introduce el Titulo del libro "));
        libro3.setAutor(sc.pedirSoloMns("Introduce el Autor del libro "));
        libro3.setNumeroPaginas(sc.pedirNumero("Introduce el Numero de Paginas del libro "));
        libro3.setISBN(sc.pideTexto("Introduce el ISBN "));
        biblioteca.addLibro(libro3);

    }

    public static void mostrarLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        int size = libros.size();
        for (int i = 0; i < size; i++) {
            System.out.println(libros.get(i));
        }
    }

    public static void prestarLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("Libros disponibles para prestar:");
        boolean algunoDisponible = false;
        for (Libro l : libros) {
            if (l.isDisponible()) {
                System.out.println(l);
                algunoDisponible = true;
            }
        }
        if (!algunoDisponible) {
            System.out.println("No hay libros disponibles para prestar.");
            return;
        }
        int idLibro = sc.pedirNumero("Escribe el ID del libro que quieres prestar: ");
        Libro libroSeleccionado = null;
        for (Libro l : libros) {
            if (l.getId() == idLibro) {
                libroSeleccionado = l;
                break;
            }
        }
        if (libroSeleccionado == null) {
            System.out.println("No se encontró un libro con ese ID.");
        } else if (!libroSeleccionado.isDisponible()) {
            System.out.println("Ese libro ya está prestado.");
        } else {
            biblioteca.prestarLibro(libroSeleccionado);
            System.out.println("El libro '" + libroSeleccionado.getTitulo() + "' ha sido prestado correctamente.");
        }
    }

    public static void devolverLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("Libros actualmente prestados:");
        boolean algunoPrestado = false;
        for (Libro l : libros) {
            if (!l.isDisponible()) {
                System.out.println(l);
                algunoPrestado = true;
            }
        }
        if (!algunoPrestado) {
            System.out.println("No hay libros para devolver.");
            return;
        }
        int idLibro = sc.pedirNumero("Escribe el ID del libro que quieres devolver: ");
        Libro libroSeleccionado = null;
        for (Libro l : libros) {
            if (l.getId() == idLibro) {
                libroSeleccionado = l;
                break;
            }
        }
        if (libroSeleccionado == null) {
            System.out.println("No se encontró un libro con ese ID.");
        } else if (libroSeleccionado.isDisponible()) {
            System.out.println("Ese libro ya está disponible, no se puede devolver.");
        } else {
            biblioteca.devolverLibro(libroSeleccionado);
            System.out.println("El libro '" + libroSeleccionado.getTitulo() + "' ha sido devuelto correctamente.");
        }
    }
}
