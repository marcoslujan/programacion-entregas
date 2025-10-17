import java.util.ArrayList;
import java.util.Scanner;

class MyScanner {
    private Scanner sc = new Scanner(System.in);

    public String nextLine() {
        return sc.nextLine();
    }

    public int nextInt() {
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
}

class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        prestado = true;
    }

    public void devolver() {
        prestado = false;
    }

    public String toString() {
        return "[" + isbn + "] " + titulo + " - " + autor +
                (prestado ? " (Prestado)" : " (Disponible)");
    }
}

public class Biblioteca {
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n||| Biblioteca |||");
            System.out.println("1. Lista libros");
            System.out.println("2. Añadir libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> listarLibros();
                case 2 -> anadirLibro();
                case 3 -> prestarLibro();
                case 4 -> devolverLibro();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Esa opción no es válida");
            }
        } while (opcion != 5);
    }

    private static void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + ". " + libros.get(i));
        }
    }

    private static void anadirLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        libros.add(new Libro(titulo, autor, isbn));
        System.out.println("Libro añadido correctamente.");
    }

    private static void prestarLibro() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        Libro l = buscarLibro("prestar");
        if (l == null) {
            System.out.println("No se encontró ningún libro con esos datos.");
            return;
        }

        if (l.isPrestado()) {
            System.out.println("El libro ya está prestado.");
        } else {
            l.prestar();
            System.out.println("Libro prestado correctamente.");
        }
    }

    private static void devolverLibro() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        Libro l = buscarLibro("devolver");
        if (l == null) {
            System.out.println("No se encontró ningún libro con esos datos.");
            return;
        }

        if (!l.isPrestado()) {
            System.out.println("El libro no estaba prestado.");
        } else {
            l.devolver();
            System.out.println("Libro devuelto correctamente.");
        }
    }

    private static Libro buscarLibro(String accion) {
        System.out.println("Buscar libro para " + accion + " por:");
        System.out.println("1. ISBN");
        System.out.println("2. Título");
        System.out.println("3. Autor");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce el ISBN: ");
                String isbn = sc.nextLine();
                for (Libro l : libros) {
                    if (l.getIsbn().equalsIgnoreCase(isbn)) {
                        return l;
                    }
                }
            }
            case 2 -> {
                System.out.print("Introduce el título: ");
                String titulo = sc.nextLine();
                for (Libro l : libros) {
                    if (l.getTitulo().equalsIgnoreCase(titulo)) {
                        return l;
                    }
                }
            }
            case 3 -> {
                System.out.print("Introduce el autor: ");
                String autor = sc.nextLine();
                for (Libro l : libros) {
                    if (l.getAutor().equalsIgnoreCase(autor)) {
                        return l;
                    }
                }
            }
            default -> System.out.println("Opción no válida.");
        }

        return null;
    }
}
