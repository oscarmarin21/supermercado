package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.services.IVenta;

import java.util.ArrayList;
import java.util.List;

public class Venta implements IVenta {
    private String idVenta;
    private String fechaVenta;
    private Cliente clienteAsociado;
    private Empleado empleadoAsociado;
    private Supermercado ownedBySupermercado;
    private List<DetalleVenta> listaDetalleVenta = new ArrayList<>();


    public Venta() {
    }

    public Venta(String idVenta, String fechaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;

    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getClienteAsociado() {   return clienteAsociado; }

    public void setClienteAsociado(Cliente clienteAsociado) {   this.clienteAsociado = clienteAsociado; }

    public Empleado getEmpleadoAsociado() { return empleadoAsociado;    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {    this.empleadoAsociado = empleadoAsociado;   }

    public List<DetalleVenta> getListaDetalleVenta() { return listaDetalleVenta;  }

    public void setListaDetalleVenta(List<DetalleVenta> listaDetalleVenta) {  this.listaDetalleVenta = listaDetalleVenta;   }

    public Supermercado getOwnedBySupermercado() {  return ownedBySupermercado; }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {  this.ownedBySupermercado = ownedBySupermercado; }

    @Override
    public String toString() {
        String detalle = "";
        for (DetalleVenta detalleV: listaDetalleVenta) {
            detalle += detalleV.getProductoAsociado().getNombre() + " = " + detalleV.getCantidad() + "/UNID\n";
        }
        return "Venta{" +
                "idVenta='" + idVenta +
                ", fechaVenta='" + fechaVenta +
                ", clienteAsociado=" + clienteAsociado.getNombres() +
                ", empleadoAsociado=" + empleadoAsociado.getNombres() +
                ", ownedBySupermercado=" + ownedBySupermercado.getNombre() + "\n" +
                "  Detalle=" + detalle +
                '}';
    }

    /**
     * Metodo para crear detalle de Venta
     * @param idDetalle
     * @param cantidad
     * @param idVenta
     * @param idProducto
     * @param supermercado
     * @return boolean
     */
    @Override
    public boolean crearDetalleVenta(String idDetalle, int cantidad, String idVenta, String idProducto, Supermercado supermercado) {
        Venta venta = supermercado.obtenerVenta(idVenta);
        Producto producto = supermercado.obtenerProducto(idProducto);

        if (venta == null || producto == null){
            return false;
        }

        DetalleVenta detalle = new DetalleVenta(idDetalle, cantidad);

        detalle.setProductoAsociado(producto);
        detalle.setOwnedByVenta(venta);

        getListaDetalleVenta().add(detalle);

        return true;
    }

    @Override
    public boolean eliminarDetalleVenta(String idVenta) {
        int tamanioLista = getListaDetalleVenta().size();
        boolean eliminar = false;
        for (int i = 0; i < tamanioLista; i++) {
            DetalleVenta detalle = getListaDetalleVenta().get(i);
            if (detalle.getOwnedByVenta().getIdVenta().equalsIgnoreCase(idVenta)) {
                getListaDetalleVenta().remove(i);
                eliminar = true;
            }
        }
        return eliminar;
    }

    /**
     * Metodo para obtener el mayor Id del Detalle de venta
     * @return String
     */
    public String obtenerMayorIdDetalle(){
        String mayorId = "000";
        for (DetalleVenta detalle:listaDetalleVenta) {
            if (Integer.parseInt(detalle.getIdDetalle())>Integer.parseInt(mayorId)){
                mayorId = detalle.getIdDetalle();
            }
        }
        return  mayorId;
    }
}
