package clases;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion direccion;
    private int dinero_en_banco;

    public int getDinero_en_banco() {
        return dinero_en_banco;
    }

    public void setDinero_en_banco(int dinero_en_banco) {
        this.dinero_en_banco = dinero_en_banco;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(String nombre, String apellido, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.dinero_en_banco = 1000;
    }

    public Persona() {
        this.dinero_en_banco = 1000;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion=" + direccion +
                '}';
    }
}
