package carlossuquilanda.src.clases;

import clases.Libro;

import java.util.ArrayList;

public class Biblioteca {

    private int id;
    private String nombre;
    private ArrayList<clases.Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public Biblioteca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<clases.Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<clases.Libro> libros) {
        this.libros = libros;
    }

    public void addLibro(clases.Libro libro) {
        this.libros.add(libro);
    }

    public void prestarLibro(clases.Libro libro) {
        libro.setDisponible(false);
    }

    public void devolverLibro(Libro libro) {
        libro.setDisponible(true);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", libros=" + libros +
                '}';
    }
}
