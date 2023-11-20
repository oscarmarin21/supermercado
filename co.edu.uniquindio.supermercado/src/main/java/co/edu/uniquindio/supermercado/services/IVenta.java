package co.edu.uniquindio.supermercado.services;

import co.edu.uniquindio.supermercado.model.DetalleVenta;
import co.edu.uniquindio.supermercado.model.Supermercado;

public interface IVenta {
    DetalleVenta crearDetalleVenta(String idDetalle, int cantidad, String idVenta, String idProducto, Supermercado supermercado);
}
