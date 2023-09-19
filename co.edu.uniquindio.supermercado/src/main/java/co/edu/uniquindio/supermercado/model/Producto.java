package co.edu.uniquindio.supermercado.model;

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;
    private String serial;

    public Producto(String nombre, int cantidad, double precio, String serial) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.serial = serial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
