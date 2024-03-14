public class Estudiante {
    private String nombre;
    private String telefono;
    private String email;
    private String postalZip;
    private String pais;

    // Constructor predeterminado
    public Estudiante() {
        // Puedes inicializar los atributos con valores predeterminados si lo deseas
        this.nombre = "";
        this.telefono = "";
        this.email = "";
        this.postalZip = "";
        this.pais = "";
    }

    // Getters y setters (si es necesario)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
