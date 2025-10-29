import java.util.ArrayList;

public class Biblioteca {
    private int id;
    private String nombre;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public Biblioteca(int id, ArrayList<Libro> libros, String nombre) {
        this.id = id;
        this.libros = new ArrayList<Libro>(libros);
        this.nombre = nombre;

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

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void prestarLibro(Libro libro) {
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
