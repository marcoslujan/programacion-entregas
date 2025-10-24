import clases.Biblioteca;
import clases.Libro;
import clases.MyScannerBiblioteca;

import java.util.ArrayList;

public class GestionBiblioteca {

    private static MyScannerBiblioteca mscB = new MyScannerBiblioteca();

    public static void main (String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        ArrayList<Libro> libros = biblioteca.getLibros();
        menuBiblioteca(biblioteca);
    }

    private static void menuBiblioteca(Biblioteca biblioteca) {
        biblioteca.setId(mscB.pedirNumero("Ingrese el número de identificación de la biblioteca: "));
        biblioteca.setNombre(mscB.pideTexto("Introduzca el nombre de la biblioteca: "));
        System.out.println("Bienvenido a la biblioteca " + biblioteca.getNombre() + " ¿que desea?");
        boolean exit = true;
        while (exit) {

            System.out.println("---Menu Biblioteca--- ");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Añadir libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("0. Salir");

            int opcion = mscB.pedirNumero("Elige una opcion: ") ;
            if(opcion != 0){
                switch(opcion){
                    case 1:
                        mostrarLibro(biblioteca);
                        break;
                    case 2:
                        addLibro(biblioteca);
                        break;
                    case 3:
                        prestarLibro(biblioteca);
                        break;
                    case 4:
                        devolverLibro(biblioteca);
                        break;

                    default:

                }
            }else {
                System.out.println("Gracias por visitarnos, que tenga un buen día");
                exit = false;
            }

        }

    }
    private static void mostrarLibro( Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();

        if(libros.isEmpty()){
            System.out.println("\n No se encontró ningún libro");

        } else {
            System.out.println("\n Te mostramos nuestros libros:  ");
            for (Libro libro : libros) {
                System.out.println("ID: " + libro.getId() + " | Título: " + libro.getTitulo() +
                        " | Autor: " + libro.getAutor() + " | Numero Paginas: " + libro.getNumeroPaginas() + " | ISBN: " + libro.getISBN() +
                        " | ¿Disponibilidad? " + libro.isDisponible() + "\n");
            }
        }
    }
    private static void addLibro( Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();

        int id = mscB.pedirNumero("Ingrese el ID del libro: ");
        for(Libro l : libros){
            if(l.getId() == id){
                System.out.println("Este libro ya existe, por favor ingrese otro");
            }return;
        }

        String titulo = mscB.pideTexto("Ingrese el titulo del libro: ");
        String autor = mscB.pideTexto("Ingrese el autor del libro: ");
        int paginas = mscB.pedirNumero("Ingrese el número de paginas del libro: ");
        String isbn = mscB.pideTexto("Ingrese el ISBN del libro: ");

        Libro nuevoLibro = new Libro(id, titulo, autor, paginas, isbn);
        nuevoLibro.setDisponible(true);
        biblioteca.addLibro(nuevoLibro);
        System.out.println("El libro: " + titulo + " ha sido añadido correctamente a la biblioteca!" );
    }
    private static void prestarLibro(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getLibros();
        ArrayList<Libro> disponibles = new ArrayList<>();
        for(Libro l : libros){
            if(l.isDisponible()){
                disponibles.add(l);
            } else if (disponibles.isEmpty()) {
                System.out.println("No tenemos libros disponibles para prestar.");
            }

        }

        System.out.println("\n Estos son los libros disponibles para prestar: ");
        for (Libro l : disponibles){
            System.out.println("ID: " + l.getId() + " | Título: " + l.getTitulo());
        }

        int id = mscB.pedirNumero("Ingrese el ID del libro a escoger para prestar: ");
        for (Libro l : libros){
            if (l.getId() == id) {
                System.out.println("Aquí tienes el libro " + l.getTitulo() + ", esperamos que te guste y que lo devuelvas en un plazo de máximo dos meses.");
            }else if (l.getId() != id){
                System.out.println("No se encontró ningún libro con ese ID");
            }
        }
    }
    private static void devolverLibro(Biblioteca biblioteca){
        ArrayList<Libro> libros = biblioteca.getLibros();
        ArrayList<Libro> prestados = new ArrayList<>();

        for (Libro l : libros) {
            if (l.isDisponible()) {
                prestados.add(l);
            } else if (prestados.isEmpty()) {
                System.out.println("No hay libros prestados para devolver.");
            }
        }

        System.out.println("\n Libros prestados: ");
        for (Libro l : prestados) {
            System.out.println("ID: " + l.getId() + " | Título: " + l.getTitulo());
        }
        int id = mscB.pedirNumero("Introduzca el ID del libro que desea devolver: ");

        for (Libro l : prestados) {
            if (l.getId() == id) {
                biblioteca.devolverLibro(l);
                System.out.println("Has devuelto el libro " + l.getTitulo() + "muchas gracias por haberlo devuelto a tiempo, sinceramente no confiábamos en ti");
                return;
            }
        }
        System.out.println("No se encontró ningún libro con ese ID prestado.");
    }
}






