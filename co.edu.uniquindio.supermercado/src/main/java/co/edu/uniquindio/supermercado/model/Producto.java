package co.edu.uniquindio.supermercado.model;

public class Producto {
    private String idProducto;
    private String nombre;
    private String marca;
    private String fechaVencimiento;
    private int cantidad;
    private double precio;

    public Producto(String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
}
