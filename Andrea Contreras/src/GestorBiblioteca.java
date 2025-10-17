import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestorBiblioteca {
    private static List<Libro>listaLibro = new ArrayList<>();
    private static List<Libro>listaPrestados = new ArrayList<>();

    public static void main(String[] args) {
        ComprobarBiblioteca();

    }

    public static void ComprobarBiblioteca(){
        MyScanner myscanner = new MyScanner();
        Biblioteca b = new Biblioteca();
        String nombre = myscanner.pedirSoloTexto("\nIntroduce el nombre de la biblioteca: ");
        b.setNombre(nombre);
        int id = myscanner.pedirNumero("\nIntroduce el id de la biblioteca: ");
        b.setId(id);

        System.out.println("Nombre: " + b.getNombre());
        System.out.println("Id: " + b.getId());

        listaLibro.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", "hdgr", 496));

        AccionesUsuario();

    }

    public static void AccionesUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.println("\nMenu de acciones: ");


        while(flag){
            System.out.println(" Elige una acción: \nListaLibro -> 1,  \nAñadirLibro -> 2, \nDevolverLibro -> 3, \nPrestarLibro -> 4, \nListaPrestados -> 5, \nSalir -> 0");
            String accion = sc.nextLine();
            switch (accion){
                case "2":
                    AñadirLibro();
                break;

                case "3":
                    if(listaPrestados.isEmpty()){
                        System.out.println("No hay libros prestados");
                        break;
                    }else {
                        DevolverLibro();
                        break;
                    }

                case "4":
                    PrestarLibro();
                break;

                case "1":

                    if(!listaLibro.isEmpty()){
                        ListaLibro();
                        break;
                    }else {
                        System.out.println("No hay libros");
                        break;
                    }

                case "5":

                    if(listaPrestados.isEmpty()){
                        System.out.println("No hay libros prestados");
                        break;
                    }else {
                        ListaPrestados();
                        break;
                    }

                default:
                    flag = false;
                break;
            }
        }

    }

    public static void ListaLibro() {
        System.out.println("\nLista de Libros que hay:");

        for(Libro libro : listaLibro){
            System.out.println(libro);
        }

    }

    public static void AñadirLibro(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el id del libro: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("\nIntroduce el titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.println("\nIntroduce el autor del libro: ");
        String autor = sc.nextLine();

        System.out.println("\nIntroduce el isbn del libro: ");
        String isbn = sc.nextLine();

        System.out.println("\nIntroduce el paginas del libro: ");
        int numeroPaginas = sc.nextInt();
        sc.nextLine();

        Libro nuevoLibro = new Libro(id, titulo, autor, isbn, numeroPaginas);
        listaLibro.add(nuevoLibro);
        System.out.println("\nLibro añadido correctamente");

    }

    public static void DevolverLibro(){
        Scanner sc = new Scanner(System.in);

        ListaPrestados();

        System.out.println("\nIntroduce el id del libro: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("\nIntroduce el titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.println("\nIntroduce el autor del libro: ");
        String autor = sc.nextLine();

        System.out.println("\nIntroduce el isbn del libro: ");
        String isbn = sc.nextLine();

        System.out.println("\nIntroduce el paginas del libro: ");
        int paginas = sc.nextInt();
        sc.nextLine();

        Libro nuevoLibro = new Libro(id,titulo, autor, isbn, paginas);
        listaLibro.add(nuevoLibro);
        listaPrestados.removeLast();

        System.out.println("\nLibro devuelto correctamente");

    }

    public static void PrestarLibro(){
        Scanner sc = new Scanner(System.in);

        ListaLibro();

        System.out.println("\nIntroduce el id del libro: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("\nIntroduce el titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.println("\nIntroduce el autor del libro: ");
        String autor = sc.nextLine();

        System.out.println("\nIntroduce el isbn del libro: ");
        String isbn = sc.nextLine();

        System.out.println("\nIntroduce el paginas del libro: ");
        int paginas = sc.nextInt();
        sc.nextLine();

        Libro nuevolibro = new Libro(id, titulo, autor, isbn, paginas);
        listaLibro.removeLast();
        listaPrestados.add(nuevolibro);

        System.out.println("\nLibro prestado correctamente");

    }

    public static void ListaPrestados(){
        System.out.println("\nLista de Libros que hay prestados:");

        for(Libro libro : listaPrestados){
            System.out.println(libro);
        }

        System.out.println("\nVolver al menú");


    }


}
