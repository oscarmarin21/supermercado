package co.edu.uniquindio.supermercado.model;

public class DetalleCopraInsumos {

    private String idDetalle;
    private int cantidad;
    private Producto productoAsociado;
    private CompraInsumos ownedByCompraInsumos;

    public DetalleCopraInsumos() {
    }

    public DetalleCopraInsumos(String idDetalle, int cantidad) {
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

    public CompraInsumos getOwnedByCompraInsumos() {
        return ownedByCompraInsumos;
    }

    public void setOwnedByCompraInsumos(CompraInsumos ownedByCompraInsumos) {
        this.ownedByCompraInsumos = ownedByCompraInsumos;
    }

    @Override
    public String toString() {
        return "DetalleCopraInsumos{" +
                "idDetalle='" + idDetalle + '\'' +
                ", cantidad=" + cantidad +
                ", productoAsociado=" + productoAsociado +
                ", ownedByCompraInsumos=" + ownedByCompraInsumos +
                '}';
    }
}
