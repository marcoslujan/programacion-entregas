import java.util.ArrayList;

public class Biblioteca {
    private int id;
    private  String nombre;
    private ArrayList<Libro> libros;

    public Biblioteca() {

    }

    public Biblioteca(int id,String nombre, ArrayList<Libro> libros) {
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

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void prestarLibro(Libro libros) {
        libros.setDisponible(false);
    }

    public void devolverLibro(Libro libros) {
        libros.setDisponible(true);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", libros=" + libros +
                '}';
    }
}
