import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(1, "Biblioteca Prometeo");

        int opcion;
        do {
            System.out.println("\n📚===== MENÚ BIBLIOTECA =====");
            System.out.println("1.🆕 Agregar libro");
            System.out.println("2.👁️ Mostrar todos los libros");
            System.out.println("3.🤝 Prestar libro");
            System.out.println("4.🔙 Devolver libro");
            System.out.println("5.❌ Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ingrese el número de páginas: ");
                    int paginas = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = sc.nextLine();

                    Libro nuevo = new Libro(biblioteca.getId(), titulo, autor, paginas, isbn);
                    biblioteca.addLibro(nuevo);
                    System.out.println("✅ Libro agregado correctamente.");
                }
                case 2 -> {
                    System.out.println("\n📖 Lista de libros en la biblioteca:");
                    if (biblioteca.getLibros().isEmpty()) {
                        System.out.println("No hay libros registrados.");
                    } else {
                        for (Libro l : biblioteca.getLibros()) {
                            System.out.println("----------------------------------");
                            System.out.println("ID: " + l.getId());
                            System.out.println("Título: " + l.getTitulo());
                            System.out.println("Autor: " + l.getAutor());
                            System.out.println("Número de páginas: " + l.getNumeroPaginas());
                            System.out.println("ISBN: " + l.getISBN());
                            System.out.println("Disponible: " + (l.isDisponible() ? "Sí" : "No"));
                        }
                        System.out.println("----------------------------------");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el ID del libro a prestar: ");
                    int idPrestar = sc.nextInt();
                    sc.nextLine();
                    Libro libroPrestar = buscarLibro(biblioteca, idPrestar);
                    if (libroPrestar != null) {
                        if (libroPrestar.isDisponible()) {
                            biblioteca.prestarLibro(libroPrestar);
                            System.out.println("📕 El libro \"" + libroPrestar.getTitulo() + "\" ha sido prestado.");
                        } else {
                            System.out.println("⚠️ El libro ya está prestado.");
                        }
                    } else {
                        System.out.println("❌ No se encontró un libro con ese ID.");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el ID del libro a devolver: ");
                    int idDevolver = sc.nextInt();
                    sc.nextLine();
                    Libro libroDevolver = buscarLibro(biblioteca, idDevolver);
                    if (libroDevolver != null) {
                        if (!libroDevolver.isDisponible()) {
                            biblioteca.devolverLibro(libroDevolver);
                            System.out.println("📗 El libro \"" + libroDevolver.getTitulo() + "\" ha sido devuelto.");
                        } else {
                            System.out.println("⚠️ El libro ya estaba disponible.");
                        }
                    } else {
                        System.out.println("❌ No se encontró un libro con ese ID.");
                    }
                }
                case 5 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("⚠️ Opción no válida, intente de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }

    private static Libro buscarLibro(Biblioteca biblioteca, int id) {
        for (Libro l : biblioteca.getLibros()) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
}
