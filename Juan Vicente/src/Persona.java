import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion direccion;
    private int banco;
    private double saldo;
    private double saldoInicial;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.banco = 0;
        this.saldo = 0;
        this.saldoInicial = 0;
    }

    public Persona(){
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre: '" + nombre + '\'' +
                ", Apellido: " + apellido + '\'' +
                ", Edad: " + edad +
                "}";
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }
}