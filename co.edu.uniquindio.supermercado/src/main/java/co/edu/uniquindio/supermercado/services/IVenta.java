package co.edu.uniquindio.supermercado.services;

import co.edu.uniquindio.supermercado.model.DetalleVenta;
import co.edu.uniquindio.supermercado.model.Supermercado;

public interface IVenta {
    boolean crearDetalleVenta(String idDetalle, int cantidad, String idVenta, String idProducto, Supermercado supermercado);
    boolean eliminarDetalleVenta(String idVenta);
    double calcularTotal(String idVenta);
}
