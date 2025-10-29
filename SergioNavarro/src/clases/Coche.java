package clases;

public class Coche {

    private String marca;
    private String modelo;
    private String velocidad;

    public Coche(String marca, String velocidad, String modelo) {
        this.marca = marca;
        this.velocidad = velocidad;
        this.modelo = modelo;
    }

    public Coche() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public void acelerar(int velocidad) {
        setVelocidad(this.getVelocidad() + velocidad);
    }

    public void frenar(int velocidad) {
        setVelocidad(this.getVelocidad() + (- velocidad));
    }

}
