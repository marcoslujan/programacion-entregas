package clases;

import java.util.ArrayList;

public class GestionBiblioteca {

    public static void menuBibliotecas(ArrayList<Biblioteca> bibliotecas, ArrayList<Libro> libros) {
        System.out.println("Ha accedido al menu de bibliotecas !!!");
        MyScanner sc = new MyScanner();
        boolean salir = true;
        int opcion,n;
        while (salir) {
            if (bibliotecas.isEmpty()) {
                System.out.println("Actualmente no hay bibliotecas, introduzca el nombre de su primera biblioteca");
                anyadirBiblioteca(bibliotecas, libros);
            }
            n = bibliotecas.size();
            System.out.println("1- Gestionar una biblioteca ya existente\n2- Añadir biblioteca\n3- Salir\n"+"Actualmente hay "+n+" bibliotecas");
            opcion = sc.pedirNumero("Introduzca la opcion deseada: ");
            switch (opcion) {
                case 1:
                    menuLibros(libros);
                    break;
                case 2:
                    anyadirBiblioteca(bibliotecas, libros);
                    break;
                case 3:
                    salir = false;
                    break;
                default:
                    System.out.println("Esa no es una opción");
                    break;
            }
        }
    }

    public static void menuLibros(ArrayList<Libro> libros) {
        System.out.println("Ha accedido al menu de gestion de libros");
        MyScanner sc = new MyScanner();
        boolean salir = true;
        int opcion = -1, n;
        while (salir) {
            if (libros.isEmpty()) {
                System.out.println("Actualmente no hay libros, introduzca su primer libro");
                anyadirLibro(libros);
            }
            n = libros.size();
            System.out.println("1- Añadir un libro\n2- Prestar un libro\n3- Devolver un libro\n4- Mostrar libros\n5- Salir");
            System.out.println("Actualmente hay "+n+" libros");
            opcion = sc.pedirNumero("Introduzca la opcion deseada: ");
            switch (opcion) {
                case 1:
                    anyadirLibro(libros);
                    break;
                case 2:
                    prestarLibro(libros);
                    break;
                case 3:
                    devolverLibro(libros);
                    break;
                case 4:
                    mostrarLibro(libros);
                    break;
                case 5:
                    salir = false;
                    break;
                default:
                    System.out.println("Esa no es una opción");
                    break;
            }
        }
    }

    public static void anyadirBiblioteca(ArrayList<Biblioteca> bibliotecas, ArrayList<Libro> libros) {
        MyScanner sc = new MyScanner();
        int indice = (bibliotecas.size());
        bibliotecas.add(indice, new Biblioteca());
        String nombre = sc.pedirSoloTexto("Introduzca el nombre del biblioteca: ");
        bibliotecas.get(indice).setNombre(nombre);
    }

    public static void anyadirLibro(ArrayList<Libro> libros) {
        Libro libro = new Libro();
        libros.add(libro);
        int indice = (libros.size()-1);
        anyadirIdLibro(libros, indice);
        anyadirTituloLibro(libros, indice);
        anyadirAutorLibro(libros, indice);
        anyadirNumeroPaginasLibro(libros, indice);
        anyadirISBNLibro(libros, indice);
    }

    public static void anyadirIdLibro(ArrayList<Libro> libros, int indice) {
        MyScanner sc = new MyScanner();
        int id,n;
        boolean flag;
        do {
            flag = true;
            id = sc.pedirNumero("Introduzca el id del libro: ");
            for (n = 0; n < libros.size(); n++) {
                if (libros.get(n).getId() == id) {
                    System.out.println("Id ya existente");
                    flag = false;
                    break;
                }
            }
        }while (!flag);
        libros.get(indice).setId(id);
    }

    public static void anyadirTituloLibro(ArrayList<Libro> libros, int indice) {
        MyScanner sc = new MyScanner();
        String titulo = sc.pideTexto("Introduzca el titulo del libro: ");
        libros.get(indice).setTitulo(titulo);
    }

    public static void anyadirAutorLibro(ArrayList<Libro> libros, int indice) {
        MyScanner sc = new MyScanner();
        String autor = sc.pedirSoloTexto("Introduzca el autor: ");
        libros.get(indice).setAutor(autor);
    }

    public static void anyadirNumeroPaginasLibro(ArrayList<Libro> libros, int indice) {
        MyScanner sc = new MyScanner();
        boolean flag;
        int num;
        do {
            flag = true;
            num = sc.pedirNumero("Introduzca el numero de paginas: ");
            if (num <= 0) {
                System.out.println("El numero de paginas debe ser mayor a 0");
                flag = false;
            }
        }while (!flag);
        libros.get(indice).setNumeroPaginas(num);
    }

    public static void anyadirISBNLibro(ArrayList<Libro> libros, int indice) {
        MyScanner sc = new MyScanner();
        String isbn = sc.pideTexto("Introduzca el isbn: ");
        libros.get(indice).setISBN(isbn);
    }

    public static void prestarLibro(ArrayList<Libro> libros) {
        MyScanner sc = new MyScanner();
        int n, opcion, id;
        String nombre;
        boolean flag = true, flag2 = false;
        for  (n = 0; n < libros.size(); n++) {
            if (libros.get(n).isDisponible()) {
                flag2 = true;
                break;
            }
        }
        if (!flag2) {
            System.out.println("No hay ningun libro para prestar");
        }else {
            while (flag) {
                System.out.println("Opciones de libros para prestar: ");
                for (n = 0; n < libros.size(); n++) {
                    if (libros.get(n).isDisponible()) {
                        id = libros.get(n).getId();
                        nombre = libros.get(n).getTitulo();
                        System.out.println("- El libro " + nombre + " con id " + id + " se puede prestar");
                    }
                }
                opcion = sc.pedirNumero("Introduzca el id del libro que quiere coger: ");
                for (n = 0; n < libros.size(); n++) {
                    if (libros.get(n).getId() == opcion) {
                        if (libros.get(n).isDisponible()) {
                            libros.get(n).setDisponible(false);
                            flag = false;
                        }else {
                            System.out.println("Ese libro no puede prestar");
                        }
                    }
                }
                if (flag) {
                    System.out.println("No se ha prestado ningun libro");
                }
            }
            System.out.println("Libro prestado con éxito");
        }
    }

    public static void devolverLibro(ArrayList<Libro> libros) {
        MyScanner sc = new MyScanner();
        int n, opcion, id;
        String nombre;
        boolean flag = true, flag2 = true;
        for  (n = 0; n < libros.size(); n++) {
            if (!libros.get(n).isDisponible()) {
                flag2=false;
                break;
            }
        }
        if (flag2) {
            System.out.println("No se puede devolver ningun libro porque ninguno ha sido prestado");
        }else {
            while (flag) {
                System.out.println("Opciones de libros para devolver: ");
                for (n = 0; n < libros.size(); n++) {
                    if (!libros.get(n).isDisponible()) {
                        id = libros.get(n).getId();
                        nombre = libros.get(n).getTitulo();
                        System.out.println("- El libro " + nombre + " con id " + id + " se puede devoler");
                    }
                }
                opcion = sc.pedirNumero("Introduzca el id del libro que quiere devoler: ");
                for (n = 0; n < libros.size(); n++) {
                    if (libros.get(n).getId() == opcion) {
                        if (!libros.get(n).isDisponible()) {
                            libros.get(n).setDisponible(true);
                            flag = false;
                        }else  {
                            System.out.println("Ese libro no puede devoler, ya se encuentra en la biblioteca");
                        }
                    }
                }
                if (flag) {
                    System.out.println("No se ha devuelto ningun libro");
                }
            }
            System.out.println("Libro devuelto con éxito");
        }
    }

    public static void mostrarLibro(ArrayList<Libro> libros) {
        int n,contador=1;
        System.out.println("Los libros que hay en esta libreria son:");
        System.out.println("------------------------------------------------------------------");
        for (n = 0; n < libros.size(); n++) {
            System.out.println(contador + "- id: " + libros.get(n).getId() + " titulo: " + libros.get(n).getTitulo() + ", autor: " + libros.get(n).getAutor() + ", número de páginas: " + libros.get(n).getNumeroPaginas() + ", ISBN: " + libros.get(n).getISBN());
            contador++;
        }
        System.out.println("------------------------------------------------------------------");
    }
}
