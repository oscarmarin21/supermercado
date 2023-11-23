package co.edu.uniquindio.supermercado.model;

import java.util.List;

public class Producto {
    private String idProducto;
    private String nombre;
    private String marca;
    private String fechaVencimiento;
    private int cantidad;
    private double precio;
    private double precioDeCompra;
    Supermercado ownedBySupermercado;
    private List<DetalleVenta> listaDetalleVentasAsociadas;
    private List<DetalleCopraInsumos> listaDetalleComprasInsumos;

    public Producto() {
    }

    public Producto(String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio, double precioDeCompra) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioDeCompra = precioDeCompra;
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

    public Supermercado getOwnedBySupermercado() {
        return ownedBySupermercado;
    }

    public double getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(double precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {
        this.ownedBySupermercado = ownedBySupermercado;
    }

    public List<DetalleVenta> getListaDetalleVentasAsociadas() {
        return listaDetalleVentasAsociadas;
    }

    public void setListaDetalleVentasAsociadas(List<DetalleVenta> listaDetalleVentasAsociadas) {
        this.listaDetalleVentasAsociadas = listaDetalleVentasAsociadas;
    }

    public List<DetalleCopraInsumos> getListaDetalleComprasInsumos() {
        return listaDetalleComprasInsumos;
    }

    public void setListaDetalleComprasInsumos(List<DetalleCopraInsumos> listaDetalleComprasInsumos) {
        this.listaDetalleComprasInsumos = listaDetalleComprasInsumos;
    }

    @Override
    public String toString() {
        return "Producto{" +
                " idProducto='" + idProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", precio de compra=" + precioDeCompra +
                '}';
    }
}
