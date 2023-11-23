package co.edu.uniquindio.supermercado.dto;

public record ProductoDto(String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio, double precioDeCompra) {
}
