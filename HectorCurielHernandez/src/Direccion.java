public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Direccion() {
        this.calle = "";
        this.ciudad = "";
        this.codigoPostal = "";
    }

    public Direccion(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        if ((calle == null || calle.isEmpty()) &&
                (ciudad == null || ciudad.isEmpty()) &&
                (codigoPostal == null || codigoPostal.isEmpty())) {
            return "\tDireccion: no especificada";
        }
        return "\tDireccion:\n" +
                "\t\tCalle: " + calle + "\n" +
                "\t\tCiudad: " + ciudad + "\n" +
                "\t\tCódigo postal: " + codigoPostal;
    }
}
