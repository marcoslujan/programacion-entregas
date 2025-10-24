import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBiblioteca {

    private static List<Libro> miLista = new ArrayList<>();
    private static List<Libro> prestados = new ArrayList<>();

    public static void main(String[] args) {
        menuBiblioteca();
    }

    public static void menuBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        Miscanner miscanner = new Miscanner();
        String nombre = miscanner.pedirsoloTexto("Introduce el nombre de la biblioteca: ");
        biblioteca.setNombre(nombre);

        int id = miscanner.pedirNumero("Introduce el id de la biblioteca: ");
        biblioteca.setId(id);

        System.out.println("\nDatos de la biblioteca");
        System.out.println("Nombre: " + biblioteca.getNombre());
        System.out.println("ID: " + biblioteca.getId());
        miLista.add(new Libro("El Quijote", "Miguel de Cervantes", "adfs", 1424));
        accionesUsuario();
    }

    public static void accionesUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.println("\nMenú de acciones\n");
        while(flag){
            System.out.println("Elige una acción: \nAñadir libro -> 1 \nPrestar libro -> 2  \nDevolver libro -> 3  \nVer libros biblioteca -> 4 " + "\nVer libros prestados -> 5"+ "\nSalir -> Otro");
            String accion = sc.next();
            switch (accion){
                case "1":
                    anadirLibro();
                    break;

                case "2":
                    prestarLibro();
                    break;

                case "3":
                    if (prestados.isEmpty()){
                        System.out.println("No hay libros prestados\n Seleccione otra opcin\n");
                        break;
                    } else {
                    devolverLibro();
                    break;
                    }

                case "4":
                    listaLibros();
                    break;

                case "5":
                    if (prestados.isEmpty()){
                        System.out.println("No hay libros prestados. \nVolviendo al menú\n");
                        break;
                    } else {
                    listaprestados();
                    break;
                    }

                default:
                    flag = false;
                    break;
            }
        }
    }

    private static void listaprestados() {

        System.out.println("\nLibros prestados\n");

        for (Libro libro : prestados) {
            System.out.println(libro);
        }

        System.out.println("\nVolviendo al menú \n");
    }

    public static void listaLibros() {

        System.out.println("\nLibros en la biblioteca\n");

        for (Libro libro : miLista) {
            System.out.println(libro);
        }

        System.out.println("\nVolviendo al menú \n");
    }


    public static void anadirLibro() {
        Miscanner miscanner = new Miscanner();

        String titulo = miscanner.pedirsoloTexto("\nIntroduce el título del libro: ");
        String autor = miscanner.pedirsoloTexto("\nIntroduce el autor del libro: ");
        String isbn = miscanner.pedirsoloTexto("\nIntroduce el isbn del libro: ");
        int numeroPaginas = miscanner.pedirNumero("\nIntroduce el numero de paginas del libro: ");

        Libro nuevoLibro = new Libro(titulo, autor, isbn, numeroPaginas);
        miLista.add(nuevoLibro);

        System.out.println("\nLibro añadido correctamente\n");
    }


    public static void devolverLibro(){
        Miscanner miscanner = new Miscanner();

        String titulo = miscanner.pedirsoloTexto("\nIntroduce el título del libro: ");
        String autor = miscanner.pedirsoloTexto("\nIntroduce el autor del libro: ");
        String isbn = miscanner.pedirsoloTexto("\nIntroduce el isbn del libro: ");
        int numeroPaginas = miscanner.pedirNumero("\nIntroduce el numero de paginas del libro: ");

        Libro nuevoLibro = new Libro(titulo, autor, isbn, numeroPaginas);
        miLista.add(nuevoLibro);
        prestados.removeLast();
    }

    public static void prestarLibro(){
        Miscanner miscanner = new Miscanner();

        String titulo = miscanner.pedirsoloTexto("\nIntroduce el título del libro: ");
        String autor = miscanner.pedirsoloTexto("\nIntroduce el autor del libro: ");
        String isbn = miscanner.pedirsoloTexto("\nIntroduce el isbn del libro: ");
        int numeroPaginas = miscanner.pedirNumero("\nIntroduce el numero de paginas del libro: ");

        Libro nuevoLibro = new Libro(titulo, autor, isbn, numeroPaginas);
        prestados.add(nuevoLibro);
        miLista.removeLast();
    }
}