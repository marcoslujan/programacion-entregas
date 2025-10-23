public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String ISBN;
    private int numerodePaginas;
    private boolean disponible;

    public Libro() {
    }

    public Libro(int id, String titulo, String autor, int numerodePaginas, String ISNB) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numerodePaginas = numerodePaginas;
        this.ISBN = ISBN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getNumerodePaginas() {
        return numerodePaginas;
    }

    public void setNumerodePaginas(int numerodePaginas) {
        this.numerodePaginas = numerodePaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", numerodePaginas=" + numerodePaginas +
                ", disponible=" + disponible +
                '}';
    }
}
