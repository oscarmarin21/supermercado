package co.edu.uniquindio.supermercado.model;

public class Proveedor {
    String numIdentificacion;
    String nombre;
    String telefono;

    public Proveedor() {
    }

    public Proveedor(String numIdentificacion, String nombre, String telefono) {
        this.numIdentificacion = numIdentificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

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

    @Override
    public String toString() {
        return "Proveedor{" +
                "numIdentificacion='" + numIdentificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
