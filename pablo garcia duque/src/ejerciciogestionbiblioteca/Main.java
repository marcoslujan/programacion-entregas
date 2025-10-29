package ejerciciogestionbiblioteca;

import biblioteca.Biblioteca;
import clases.MyScanner;
import libro.Libro;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static MyScanner mysc = new MyScanner();
    private static Scanner sc = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();


    public static void main(String[] args) {
        // Llamamos a crear la biblioteca, igual que llamaríamos a crear el Scanner

        // Llamamos al método principal, el de la biblioteca
        iniciarBiblioteca(biblioteca);
        // Cuando se cierra el método, lanzamos un mensaje de despedida.
        System.out.println("¡Gracias por pasarte por la biblioteca! ¡Hasta pronto!");
    }

    private static void iniciarBiblioteca(Biblioteca biblioteca) {
        // Nombramos la biblioteca y establecemos su ID
        biblioteca.setId(1);
        System.out.println("Cómo se llama tu biblioteca?");
        biblioteca.setNombre(mysc.pideTexto(""));
        while (true) {
            // Hacemos un menú con las posibles opciones que tiene el usuario dentro de un while
            // para que no salga del menú hasta que inpute un 0
            System.out.println("¡Bienvenido a " + biblioteca.getNombre() + "!");
            System.out.println("\n=== GESTOR DE BIBLIOTECA ===");
            System.out.println("1) Ver libros");
            System.out.println("2) Sacar libro (tomar prestado)");
            System.out.println("3) Devolver libro");
            System.out.println("4) Añadir libro");
            System.out.println("0) Salir");
            int opcion = mysc.pedirNumero("Introduce una opción del 1 al 4, o elije 0 para salir.");
            if (opcion < 0 || opcion > 4) {
                System.out.println("¡Esa no es una opción válida! ¡Prueba de nuevo!");
                continue;
            }
            switch (opcion) {
                case 0: {
                    return;
                }
                case 1:
                    mostrarLibros(biblioteca);
                    break;
                case 2:
                    prestarLibro(biblioteca);
                    break;
                case 3:
                    devolverLibro(biblioteca);
                    break;
                case 4:
                    anadirLibros(biblioteca);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarLibros(Biblioteca biblio) {
        ArrayList<Libro> lista = biblio.getLibros();
        // Comprobamos si la lista está vacía
        if (lista.isEmpty()) {
            System.out.println("¡Todavía no hay libros!\n");
            return;
        }
        int size = lista.size();
        // Si no está vacía, mostramos la lista de libros
        System.out.println("\n Listado de libros: ");
        for (int i = 0; i < size; i++) {
            System.out.println(lista.get(i));
        }

    }

    private static void anadirLibros(Biblioteca biblio) {

        System.out.println("\n*** AÑADIR LIBRO ***");
        // Creamos un par de libros para rellenar la biblioteca e importamos los setters de Libro para meter más libros (l)
        Libro libro1 = new Libro(1, "El Quijote", "Miguel de Cervantes", 500, "409583454");
        Libro libro2 = new Libro(1, "Asdasd", "Pepito", 600, "958094850");
        Libro l = new Libro();
        l.setId(mysc.pedirNumero("Introduce el id del libro: "));
        l.setTitulo(mysc.pedirSoloTexto("Introduce el titulo del libro: "));
        l.setAutor(mysc.pideTexto("Introduce el autor del libro: "));
        l.setNumeroPaginas(mysc.pedirNumero("Introduce el numero de paginas del libro: "));
        l.setISBN(mysc.pideTexto("Introduce el ISBN del libro: "));
        l.setDisponible(true);
        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);
        biblioteca.addLibro(l);
        System.out.println("¡Gracias por añadir un libro nuevo! La biblioteca ahora tiene esta pinta: ");
        mostrarLibros(biblio);

    }

    private static void prestarLibro(Biblioteca biblio) {
        System.out.println("\n*** TOMAR LIBRO PRESTADO ***");
        String titulo = mysc.pideTexto("Introduce el título del libro que deseas tomar prestado: ").trim();

        ArrayList<Libro> libros = biblio.getLibros();
        boolean encontrado = false;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    System.out.println("Has tomado prestado el libro: " + libro.getTitulo());
                } else {
                    System.out.println("El libro '" + libro.getTitulo() + "' no está disponible actualmente.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado un libro con ese título.");
        }
    }
    private static void devolverLibro(Biblioteca biblio) {
        System.out.println("\n*** DEVOLVER LIBRO ***");
        String titulo = mysc.pideTexto("Introduce el título del libro que deseas devolver: ").trim();
        ArrayList<Libro> libros = biblio.getLibros();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                if (!libro.isDisponible()) {
                    libro.setDisponible(true);
                    System.out.println("Has devuelto el siguiente libro correctamente: " + libro.getTitulo());

                } else {
                    System.out.println("El libro '" + libro.getTitulo() + "' ya estaba disponible. ¿Estás seguro de que lo tenías prestado?");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado un libro con ese título.");
        }
    }
}