package Banco;
import Clases.Direccion;

public class Persona {

    private String nombre; //creamos la variable privada "nombre"
    private String apellido; //creamos la variable privada "apellido"
    private int edad; //creamos la variable privada "edad"
    private Direccion direccion;
    private int dinero_en_banco;

    public Persona() {//se crea al constructor "persona"
        this.dinero_en_banco = 1000;
    }

    public Persona(String nombre, String apellido, int edad) { //creamos los argumentos del constructor
        this.nombre = nombre; //damos valor al "nombre"
        this.apellido = apellido; //damos valor al "apellido"
        this.edad = edad; //damos valor a la "edad"
        this.dinero_en_banco = 1000;
    }

    //a partir de aqui creamos los getters y los setters
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){

        this.apellido = apellido;
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){

        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getDinero_en_banco() {
        return dinero_en_banco;
    }

    public void setDinero_en_banco(int dinero_en_banco) {
        this.dinero_en_banco = dinero_en_banco;
    }

    public String toString(){
        return "Persona{" +
                "nombre: " + nombre +  '\'' +
                ", edad: " + edad +
                '}';
    }
}
