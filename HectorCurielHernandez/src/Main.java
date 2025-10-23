
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String nombreBiblioteca;
        while (true) {
            System.out.print("Introduce el nombre de la biblioteca: ");
            nombreBiblioteca = sc.nextLine();

            if (nombreBiblioteca.matches(".*\\d.*")) {
                System.out.println("❌ El nombre no puede contener números. Inténtalo de nuevo.");
            } else {
                break;
            }
        }

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNombre(nombreBiblioteca);

        int opcion;

        do {
            System.out.println("\n=== 📚 MENÚ DE LA BIBLIOTECA " + biblioteca.getNombre().toUpperCase() + " ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro (por ID)");
            System.out.println("6. Mostrar estadísticas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    boolean existe = false;
                    for (Libro libro : biblioteca.getLibros()) {
                        if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("⚠️ El libro \"" + titulo + "\" ya está registrado.");
                    } else {
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Número de páginas: ");
                        int paginas = sc.nextInt();
                        sc.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();

                        int nuevoId = biblioteca.getLibros().size() + 1;
                        Libro nuevoLibro = new Libro(nuevoId, titulo, autor, paginas, isbn);
                        biblioteca.addLibro(nuevoLibro);
                        System.out.println("✅ Libro agregado correctamente con ID " + nuevoId + ".");
                    }
                }

                case 2 -> {
                    if (biblioteca.getLibros().isEmpty()) {
                        System.out.println("📭 No hay libros en la biblioteca.");
                    } else {
                        System.out.println("\n📚 Lista de libros:");
                        for (Libro libro : biblioteca.getLibros()) {
                            System.out.println(libro);
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Introduce el título a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    for (Libro libro : biblioteca.getLibros()) {
                        if (libro.getTitulo().equalsIgnoreCase(buscar)) {
                            System.out.println("📖 " + libro);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("❌ No se encontró ningún libro con ese título.");
                    }
                }

                case 4 -> {
                    System.out.print("Introduce el título del libro a prestar: ");
                    String tituloPrestar = sc.nextLine();
                    boolean prestado = false;
                    for (Libro libro : biblioteca.getLibros()) {
                        if (libro.getTitulo().equalsIgnoreCase(tituloPrestar)) {
                            if (libro.isDisponible()) {
                                biblioteca.prestarLibro(libro);
                                System.out.println("✅ Has prestado el libro: " + libro.getTitulo());
                            } else {
                                System.out.println("⚠️ Ese libro ya está prestado.");
                            }
                            prestado = true;
                            break;
                        }
                    }
                    if (!prestado) {
                        System.out.println("❌ No se encontró ningún libro con ese título.");
                    }
                }

                case 5 -> {
                    System.out.print("Introduce el ID del libro a devolver: ");
                    int idDevolver = sc.nextInt();
                    sc.nextLine();
                    boolean devuelto = false;

                    for (Libro libro : biblioteca.getLibros()) {
                        if (libro.getId() == idDevolver) {
                            if (!libro.isDisponible()) {
                                biblioteca.devolverLibro(libro);
                                System.out.println("✅ Has devuelto el libro: " + libro.getTitulo());
                            } else {
                                System.out.println("⚠️ Ese libro no estaba prestado.");
                            }
                            devuelto = true;
                            break;
                        }
                    }

                    if (!devuelto) {
                        System.out.println("❌ No se encontró ningún libro con el ID " + idDevolver + ".");
                    }
                }

                case 6 -> {
                    int total = biblioteca.getLibros().size();
                    int prestados = 0;
                    for (Libro libro : biblioteca.getLibros()) {
                        if (!libro.isDisponible()) prestados++;
                    }
                    System.out.println("\n📊 Estadísticas:");
                    System.out.println("Total de libros: " + total);
                    System.out.println("Prestados: " + prestados);
                    System.out.println("Disponibles: " + (total - prestados));
                }

                case 0 -> System.out.println("👋 Saliendo del programa...");

                default -> System.out.println("❌ Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
