package Biblioteca;

import Clases.MyScanner;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(1, "Halo" );
        Libro libro1 = new Libro(1, "Juego de Tronos", "George RR Martin", 800, "EYES5678");
        Libro libro2 = new Libro(2, "El señor de los anillos", "Tolkien", 1800, "FACE1234");
        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);


        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n=== Menu de biblioteca ===");
            System.out.println("1. Añadir Libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Mostrar Libros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una Opcion: ");

          try {
              opcion = sc.nextInt();
              switch (opcion) {
                  case 1:
                      System.out.print("id: ");
                      int id = sc.nextInt();
                      sc.nextLine();

                      System.out.print("Titulo: ");
                      String titulo = sc.nextLine();

                      System.out.print("Autor: ");
                      String autor = sc.nextLine();

                      System.out.print("ISBN: ");
                      String isbn = sc.nextLine();

                      System.out.print("Número de páginas: ");
                      int numeroPaginas = sc.nextInt();


                      Libro nuevoLibro = new Libro(id, titulo, autor,  numeroPaginas, isbn);
                      biblioteca.addLibro(nuevoLibro);
                      System.out.println("Libro añadido correctamente");

                      break;
                  case 2:
                      System.out.print("Introduzca el Id del libro a prestar: ");
                      int idPrestar = sc.nextInt();
                      sc.nextLine();
                      Libro libroPrestar = null;
                      for (Libro libro : biblioteca.getLibros()) {
                          if (libro.getId() == idPrestar) {
                              libroPrestar = libro;
                              break;
                          }
                      }
                      if (libroPrestar != null) {
                          if (libroPrestar.isDisponible()) {
                              biblioteca.prestarLibro(libroPrestar);
                              System.out.println("Libro prestado correctamente");
                          } else {
                              System.out.println("Libro ya prestado");
                          }
                      } else {
                          System.out.println("Libro no encontrado");
                      }
                      break;


                  case 3:
                      System.out.print("Introduzca el Id del libro a devolver: ");
                      int idDevolver = sc.nextInt();
                      sc.nextLine();

                      Libro libroDevolver = null;
                      for (Libro libro : biblioteca.getLibros()) {
                          if (libro.getId() == idDevolver) {
                              libroDevolver = libro;
                              break;
                          }
                      }
                      if (libroDevolver != null) {
                          biblioteca.devolverLibro(libroDevolver);
                          System.out.println("Libro devuelto correctamente");
                      } else {
                          System.out.println("Libro no encontrado");
                      }
                      break;
                  case 4:
                      biblioteca.mostrarLibro();
                      break;
                  case 5:
                      System.out.println("Saliendo");
                      break;
                  default:
                      System.out.println("Opcion invalida");
                      break;
              }
          } catch (Exception e) {
              System.out.println("Entrada invalida");
              sc.nextLine();
          }
        } while (opcion != 5);
        sc.close();

    }
}