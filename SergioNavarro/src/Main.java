import clases.Libro;
import clases.MyScanner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Listas de libros (biblioteca y prestados)
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Libro> prestados = new ArrayList<>();

    public static void main(String[] args) {

        // Crear algunos libros al inicio
        libros.add(new Libro(1, "La Biblia", "Desconocido", 1200, "0001"));
        libros.add(new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes", 863, "0002"));
        libros.add(new Libro(3, "El Principito", "Antoine de Saint-Exupéry", 96, "0003"));

        // Menú principal
        boolean seguir = true;
        while (seguir) {
            System.out.println("\nMENÚ BIBLIOTECA");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Pedir libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Ver libros prestados");
            System.out.println("0. Salir");

            int opcion = comprobarNumero("Elige una opción:");

            switch (opcion) {
                case 1:
                    mostrarLibros();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    mostrarPrestados();
                    break;
                case 0:
                    System.out.println("Saliendo de la biblioteca...");
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }

    // Mostrar libros disponibles
    public static void mostrarLibros() {
        System.out.println("\n📖 Libros disponibles:");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro l : libros) {
                System.out.println("- " + l.getTitulo() + " (ISBN: " + l.getISBN() + ")");
            }
        }
    }

    // Mostrar libros prestados
    public static void mostrarPrestados() {
        System.out.println("\nLibros prestados:");
        if (prestados.isEmpty()) {
            System.out.println("No hay libros prestados.");
        } else {
            for (Libro l : prestados) {
                System.out.println("- " + l.getTitulo() + " (ISBN: " + l.getISBN() + ")");
            }
        }
    }

    // Pedir libro (por ISBN)
    public static void prestarLibro() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros para prestar.");
            return;
        }

        MyScanner sc = new MyScanner();
        String isbn = sc.pideTexto("\nIntroduce el ISBN del libro que quieres pedir: ");

        boolean encontrado = false;

        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            if (l.getISBN().equals(isbn)) {  // Comparación simple
                encontrado = true;
                prestados.add(l);     // Mover a lista de prestados
                libros.remove(i);     // Quitar de biblioteca
                System.out.println("Has pedido prestado: " + l.getTitulo());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    // Devolver libro (por ISBN)
    public static void devolverLibro() {
        if (prestados.isEmpty()) {
            System.out.println("No hay libros para devolver.");
            return;
        }

        MyScanner sc = new MyScanner();
        String isbn = sc.pideTexto("\nIntroduce el ISBN del libro que quieres devolver: ");

        boolean encontrado = false;

        for (int i = 0; i < prestados.size(); i++) {
            Libro l = prestados.get(i);
            if (l.getISBN().equals(isbn)) {
                encontrado = true;
                libros.add(l);          // Vuelve a la biblioteca
                prestados.remove(i);    // Deja de estar prestado
                System.out.println("Has devuelto: " + l.getTitulo());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ese libro en la lista de prestados.");
        }
    }

    // Comprobar que el usuario introduce un número
    public static int comprobarNumero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println(mensaje);
                n = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número. Intenta de nuevo.");
                sc.nextLine();
            }
        }
        return n;
    }
}