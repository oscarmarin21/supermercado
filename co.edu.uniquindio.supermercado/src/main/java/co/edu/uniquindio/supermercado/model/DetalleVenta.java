package co.edu.uniquindio.supermercado.model;

public class DetalleVenta {
    private String idDetalle;
    private int cantidad;
    private Producto productoAsociado;
    private Venta ownedByVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(String idDetalle, int cantidad) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
    }

    public String getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductoAsociado() {
        return productoAsociado;
    }

    public void setProductoAsociado(Producto productoAsociado) {
        this.productoAsociado = productoAsociado;
    }

    public Venta getOwnedByVenta() {
        return ownedByVenta;
    }

    public void setOwnedByVenta(Venta ownedByVenta) {
        this.ownedByVenta = ownedByVenta;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalle='" + idDetalle + '\'' +
                ", cantidad=" + cantidad +
                ", productoAsociado=" + productoAsociado +
                ", ownedByVenta=" + ownedByVenta +
                '}';
    }
}
