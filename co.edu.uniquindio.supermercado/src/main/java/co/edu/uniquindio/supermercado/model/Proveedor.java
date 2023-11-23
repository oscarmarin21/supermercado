package co.edu.uniquindio.supermercado.model;

import java.util.List;

public class Proveedor {
    private String numIdentificacion;
    private String nombre;
    private String telefono;
    private Supermercado ownedBySupermercado;
    private List<CompraInsumos> listaCompraInsumosAsociados;

    public Proveedor() {
    }

    public Proveedor(String numIdentificacion, String nombre, String telefono) {
        this.numIdentificacion = numIdentificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Supermercado getOwnedBySupermercado() {
        return ownedBySupermercado;
    }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {
        this.ownedBySupermercado = ownedBySupermercado;
    }

    public List<CompraInsumos> getListaCompraInsumosAsociados() {
        return listaCompraInsumosAsociados;
    }

    public void setListaCompraInsumosAsociados(List<CompraInsumos> listaCompraInsumosAsociados) {
        this.listaCompraInsumosAsociados = listaCompraInsumosAsociados;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "numIdentificacion='" + numIdentificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
