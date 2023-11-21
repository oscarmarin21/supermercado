package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.services.IVenta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Venta implements IVenta {
    private String idVenta;
    private String fechaVenta;
    private double totalVenta;
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

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
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
                detalle +
                "} = " + totalVenta;
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
        if (producto.getCantidad()<cantidad){
            JOptionPane.showMessageDialog(null, "Super la cantidad de productos en existencia");
            return false;
        }
        DetalleVenta detalle = new DetalleVenta(idDetalle, cantidad);

        detalle.setProductoAsociado(producto);
        detalle.setOwnedByVenta(venta);

        getListaDetalleVenta().add(detalle);

        producto.setCantidad(producto.getCantidad()-cantidad);
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

    @Override
    public double calcularTotal(String idVenta) {
        double total = 0;
        for (DetalleVenta detalle:getListaDetalleVenta()) {
            if (detalle.getOwnedByVenta().getIdVenta().equalsIgnoreCase(idVenta)){
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
        for (DetalleVenta detalle:listaDetalleVenta) {
            if (Integer.parseInt(detalle.getIdDetalle())>Integer.parseInt(mayorId)){
                mayorId = detalle.getIdDetalle();
            }
        }
        return  mayorId;
    }
}
