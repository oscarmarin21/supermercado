package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.services.ICompraInsumos;

import java.util.ArrayList;
import java.util.List;

public class CompraInsumos implements ICompraInsumos {
    private String idCompra;
    private String fechaCompra;
    private double totalCompra;
    private Empleado empleadoAsociado;
    private Proveedor proveedor;
    private Supermercado ownedBySupermercado;
    private List<DetalleCopraInsumos> listaDetalleCompra = new ArrayList<>();

    public CompraInsumos() {
    }

    public CompraInsumos(String idCompra, String fechaCompra) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public Supermercado getOwnedBySupermercado() {
        return ownedBySupermercado;
    }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {
        this.ownedBySupermercado = ownedBySupermercado;
    }

    public List<DetalleCopraInsumos> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCopraInsumos> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "CompraInsumos{" +
                "idCompra='" + idCompra + '\'' +
                ", fechaCompra='" + fechaCompra + '\'' +
                ", totalCompra=" + totalCompra +
                ", empleadoAsociado=" + empleadoAsociado +
                ", proveedor=" + proveedor +
                ", ownedBySupermercado=" + ownedBySupermercado +
                ", listaDetalleCompra=" + listaDetalleCompra +
                '}';
    }

    @Override
    public boolean crearDetalleCompraInsumos(String idDetalle, int cantidad, String idCompra, String idProducto, Supermercado supermercado) {
        CompraInsumos compra = supermercado.obtenerCompraInsumos(idCompra);
        Producto producto = supermercado.obtenerProducto(idProducto);

        if (compra == null || producto == null){
            return false;
        }

        DetalleCopraInsumos detalle = new DetalleCopraInsumos(idDetalle, cantidad);

        detalle.setProductoAsociado(producto);
        detalle.setOwnedByCompraInsumos(compra);

        getListaDetalleCompra().add(detalle);

        return true;
    }

    @Override
    public boolean eliminarDetalleCompraInsumos(String idVenta) {

        int tamanioLista = getListaDetalleCompra().size();
        boolean eliminar = false;

        for (int i = 0; i < tamanioLista; i++) {
            DetalleCopraInsumos detalle = getListaDetalleCompra().get(i);
            if (detalle.getOwnedByCompraInsumos().getIdCompra().equalsIgnoreCase(idVenta)) {
                getListaDetalleCompra().remove(i);
                eliminar = true;
            }
        }
        return eliminar;
    }

    @Override
    public double calcularTotal(String idCompra) {

        double total = 0;
        for (DetalleCopraInsumos detalle:getListaDetalleCompra()) {
            if (detalle.getOwnedByCompraInsumos().getIdCompra().equalsIgnoreCase(idCompra)){
                total += detalle.getProductoAsociado().getPrecio()*detalle.getCantidad();
            }
        }
        return total;
    }

    /**
     * Metodo para obtener el mayor Id del Detalle de venta
     * @return String
     */
    public String obtenerMayorIdDetalle(){
        String mayorId = "000";
        for (DetalleCopraInsumos detalle:listaDetalleCompra) {
            if (Integer.parseInt(detalle.getIdDetalle())>Integer.parseInt(mayorId)){
                mayorId = detalle.getIdDetalle();
            }
        }
        return  mayorId;
    }
}
