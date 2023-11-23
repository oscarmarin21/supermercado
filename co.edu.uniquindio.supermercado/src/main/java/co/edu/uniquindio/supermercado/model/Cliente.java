package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private TipoIdentificacion tipoIdentificacion;
    private Supermercado ownedBySupermercado;
    private List<Venta> listaVentasAsociadas;

    public Cliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        super(numIdentificacion,nombres,apellidos);
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Supermercado getOwnedBySupermercado() {
        return ownedBySupermercado;
    }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {
        this.ownedBySupermercado = ownedBySupermercado;
    }

    public List<Venta> getListaVentasAsociadas() {
        return listaVentasAsociadas;
    }

    public void setListaVentasAsociadas(List<Venta> listaVentasAsociadas) {
        this.listaVentasAsociadas = listaVentasAsociadas;
    }

    @Override
    public String toString() {
        return
                super.toString()+ "," +
                "tipoIdentificacion=" + tipoIdentificacion +
                ", ownedBySupermercado=" + ownedBySupermercado;
    }
}
