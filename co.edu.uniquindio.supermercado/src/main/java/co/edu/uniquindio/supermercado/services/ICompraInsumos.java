package co.edu.uniquindio.supermercado.services;

import co.edu.uniquindio.supermercado.model.Supermercado;

public interface ICompraInsumos {
    boolean crearDetalleCompraInsumos(String idDetalle, int cantidad, String idCompra, String idProducto, Supermercado supermercado);
    boolean eliminarDetalleCompraInsumos(String idVenta);
    double calcularTotal(String idVenta);

}
