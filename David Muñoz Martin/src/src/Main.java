package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Biblioteca miBiblioteca = new Biblioteca(1, "Biblioteca Central");
        miBiblioteca.addLibro(new Libro(1, "El hombre en el castillo", "Philip K. Dick", 320, "978-84-376-0494-7"));
        miBiblioteca.addLibro(new Libro(2, "Los renglones torcidos de Dios", "Torcuato Luca de Tena", 416, "978-84-376-0810-5"));
        miBiblioteca.addLibro(new Libro(3, "La conjura de los necios", "John Kennedy Toole", 480, "978-84-339-6312-3"));


        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Mostrar número de libros");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.print("ID del libro: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Número de páginas: ");
                    int paginas = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    Libro nuevoLibro = new Libro(id, titulo, autor, paginas, isbn);
                    miBiblioteca.addLibro(nuevoLibro);
                    System.out.println("Libro añadido correctamente.");
                    break;

                case 2:

                    System.out.print("Introduce el ID del libro a prestar: ");
                    int idPrestar = sc.nextInt();
                    sc.nextLine();
                    Libro libroAPrestar = null;
                    for (Libro l : miBiblioteca.getLibros()) {
                        if (l.getId() == idPrestar) {
                            libroAPrestar = l;
                            break;
                        }
                    }
                    if (libroAPrestar != null && libroAPrestar.isDisponible()) {
                        miBiblioteca.prestarLibro(libroAPrestar);
                        System.out.println("Libro prestado correctamente.");
                    } else if (libroAPrestar != null) {
                        System.out.println("El libro ya está prestado.");
                    } else {
                        System.out.println("No se encontró el libro.");
                    }
                    break;

                case 3:

                    System.out.print("Introduce el ID del libro a devolver: ");
                    int idDevolver = sc.nextInt();
                    sc.nextLine();
                    Libro libroADevolver = null;
                    for (Libro l : miBiblioteca.getLibros()) {
                        if (l.getId() == idDevolver) {
                            libroADevolver = l;
                            break;
                        }
                    }
                    if (libroADevolver != null && !libroADevolver.isDisponible()) {
                        miBiblioteca.devolverLibro(libroADevolver);
                        System.out.println("Libro devuelto correctamente.");
                    } else if (libroADevolver != null) {
                        System.out.println("El libro ya estaba disponible.");
                    } else {
                        System.out.println("No se encontró el libro.");
                    }
                    break;

                case 4:

                    System.out.println("\n=== Libros en la biblioteca ===");
                    for (Libro l : miBiblioteca.getLibros()) {
                        System.out.println("ID: " + l.getId() +
                                ", Título: " + l.getTitulo() +
                                ", Autor: " + l.getAutor() +
                                ", Páginas: " + l.getNumeroPaginas() +
                                ", ISBN: " + l.getISBN() +
                                ", Disponible: " + l.isDisponible());
                    }
                    break;

                case 5:

                    System.out.println("Número de libros en la biblioteca: " + miBiblioteca.getLibros().size());
                    break;

                case 6:
                    salir = true;
                    System.out.println("¡Saliendo del programa!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
