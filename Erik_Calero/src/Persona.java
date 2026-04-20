public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion direccion;
    private int dinero_en_banco;

    public Persona() {
        this.dinero_en_banco = 1000;
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dinero_en_banco = 1000;
    }

    // Métodos para el dinero
    public void meterDinero(int cantidad) {
        if (cantidad > 0) {
            dinero_en_banco += cantidad;
            System.out.println(" Has ingresado " + cantidad + ". Nuevo saldo: " + dinero_en_banco + "");
        } else {
            System.out.println(" La cantidad debe ser positiva.");
        }
    }

    public void sacarDinero(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva.");
        } else if (cantidad > dinero_en_banco) {
            System.out.println("No tienes suficiente saldo.");
        } else {
            dinero_en_banco -= cantidad;
            System.out.println(" Has sacado " + cantidad + "€. Nuevo saldo: " + dinero_en_banco + "€");
        }
    }

    public void mostrarSaldo() {
        System.out.println(" Saldo actual: " + dinero_en_banco + "€");
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "Persona:\n" +
                "\tNombre: '" + nombre + "'\n" +
                "\tApellido: '" + apellido + "'\n" +
                "\tEdad: " + edad + '\n' +
                direccion + '\n';
    }
}
