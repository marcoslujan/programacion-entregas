package carlossuquilanda.src;

import clases.Biblioteca;
import clases.Libro;
import clases.MyScanner;

public class Main {
    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner();
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro();
        boolean flag = false;

        while (!flag) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("📚 BIENVENIDO A LA GRAN BIBLIOTECA DIGITAL DE LIBROS 📚");
            System.out.println("------------------------------------------------------------------");
            System.out.println(" 1.MOSTRAR LIBROS");
            System.out.println(" 2.AÑADIR LIBROS");
            System.out.println(" 3.PRESTAR LIBROS");
            System.out.println(" 4.DEVOLVER LIBROS");
            System.out.println(" 5.SALIR");
            System.out.println("------------------------------------------------------------------");
            int opcion= MyScanner.pedirNumero("👉 Elige una opción: ");

            switch (opcion) {
                case 1:
                    if(biblioteca.getLibros().isEmpty()) {
                        System.out.println("\n📭 NO HAY LIBROS DISPONIBLES 📭");
                    } else {
                        System.out.println("\n📚 LIBROS DISPONIBLES 📚: ");
                        for (Libro l : biblioteca.getLibros()) {
                            System.out.println(l);
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n🔎PARA REGISTRAR UN LIBRO ESCRIBA LOS SIGUIENTES DATOS🔍: ");
                    int id = MyScanner.pedirNumero("ID DEL LIBRO: ");
                    String titulo = myScanner.pideTexto("TÍTULO DEL LIBRO: ");
                    String autor = myScanner.pedirSoloTexto("AUTOR DEL LIBRO: ");
                    int paginas = MyScanner.pedirNumero("NUMERO DE PÁGINAS: ");
                    String ISBN = myScanner.pideTexto("ISBN DEL LIBRO: ");

                    Libro nuevoLibro = new Libro(id, titulo, autor, paginas, ISBN);
                    biblioteca.addLibro(nuevoLibro);
                    System.out.println("\n✅LIBRO AÑADIDO CORRECTAMENTE");
                    break;

                case 3:
                    if(biblioteca.getLibros().isEmpty()) {
                        System.out.println("\n🚧NO HAY LIBROS DISPONIBLES🚧");
                    } else {
                        int idPrestar = MyScanner.pedirNumero("ID DEL LIBRO: ");
                        Libro encontrado = null;
                        for (Libro l : biblioteca.getLibros()) {
                            if (l.getId() == idPrestar) {
                                encontrado = l;
                            }
                        }
                        if (encontrado == null) {
                            System.out.println("❌LIBRO NO ENCONTRADO ❌");
                        } else if (!encontrado.isDisponible()) {
                            System.out.println("📘 EL LIBRO YA HA SIDO PRESTADO 📘");
                        }else{
                            System.out.println("✅EL LIBRO HA SIDO PRESTADO CORRECTAMENTE✅");
                        }
                    }
                    break;

                case 4:
                    if (biblioteca.getLibros().isEmpty()) {
                        System.out.println("📚 NO HAY LIBROS PRESTADOS 📚");
                    }else {
                        int idDevolver = MyScanner.pedirNumero("ID DEL LIBRO A DEVOLVER: ");
                        Libro encontrado = null;
                        for (Libro l : biblioteca.getLibros()) {
                            if (l.getId() == idDevolver) {
                                encontrado = l;
                            }
                        }
                        if (encontrado == null) {
                            System.out.println("❌ LIBRO NO ENCONTRADO ❌");
                        }else if (encontrado.isDisponible()) {
                            System.out.println("👌 EL LIBRO YA HA SIDO DEVUELTO 👌");
                        }else{
                            biblioteca.devolverLibro(encontrado);
                            System.out.println("👌 LIBRO ENCONTRADO 👌");
                            System.out.println("✅ EL LIBRO HA SIDO DEVUELTO CORRECTAMENTE ✅");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n HA SALIDO DE LA BIBLIOTECA CORRECATMENTE, ¡VUELVA PRONTO! 😊");
                    flag= true;

            }

            if (!flag) {
                System.out.println("\n PULSE ENTER PARA VOLVER AL MENU ");
                new java.util.Scanner(System.in).nextLine();
            }



        }



    }

}

